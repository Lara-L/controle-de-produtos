package bd.trabalho.demo.application.rest;

import bd.trabalho.demo.domain.entity.Produto;
import bd.trabalho.demo.domain.service.ProdutoService;
import bd.trabalho.demo.domain.to.ProdutoSaidaTO;
import bd.trabalho.demo.domain.to.ProdutoTO;
import io.swagger.v3.oas.annotations.Operation;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoController {

  private final ProdutoService produtoService;

  public ProdutoController(ProdutoService produtoService) {
    this.produtoService = produtoService;
  }

  @PostMapping(value="/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Produto> cadastrarProduto(@RequestBody ProdutoTO produtoTO) {
    return ResponseEntity.ok(produtoService.cadastrarProduto(produtoTO));
  }

  @PutMapping(value="/saidaProduto/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Produto> atualizarSaidaProduto(@RequestBody ProdutoSaidaTO produtoSaidaTO, @PathVariable("id") Long id) {
    return ResponseEntity.ok(produtoService.atualizarSaidaProduto(produtoSaidaTO, id));
  }

  @Operation(summary = "item A", description = "A quantidade de determinado item próximo a expirar o prazo de validade por estoque")
  @GetMapping(value="/proximos-vencimento/{dias}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Map<String, Object>>> obterProdutosProximosVencimento(
      @RequestParam(defaultValue = "7")
      @PathVariable int dias) {
    return ResponseEntity.ok(produtoService.obterProdutosProximosVencimento(dias));
  }

  @Operation(summary = "item B", description = "O prazo médio de permanência no estoque de um determinado item por\n"
      + "estoque;")
  @GetMapping("/prazo-medio{produtoId}")
  public ResponseEntity<Double> getPrazoMedio(@PathVariable("produtoId") Long produtoId,
      @RequestParam Long estoqueId) {
    return ResponseEntity.ok(produtoService.calcularPrazoMedioPermanencia(produtoId, estoqueId));
  }

  @Operation(summary = "item C", description = "A listagem dos itens no estoque mostrando quantidade, nome do produto e data de validade e local de armazenamento")
  @GetMapping(value="/estoque", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Produto>> listarProdutosEstoque() {
    return ResponseEntity.ok(produtoService.listarProdutosEstoque());
  }

  @Operation(summary = "item D", description = "A listagem dos itens, de um determinado estoque, que possuem menos de X unidades (definidas na consulta), independentemente de seu prazo de validade")
  @GetMapping(value="/estoque/{estoqueId}/quantidade/{limiteQuantidade}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Map<String, Object>>> listarProdutosBaixaQuantidade(@PathVariable Long estoqueId, @RequestParam int limiteQuantidade) {
    return ResponseEntity.ok(produtoService.listarProdutosBaixaQuantidade(estoqueId, limiteQuantidade));
  }

  @Operation(summary = "item E", description = "A data de saída do estoque de um produto com um determinado prazo de validade.")
  @GetMapping(value="/saida/{produtoId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Map<String, Object>>> obterUltimaDataSaida(@PathVariable Long produtoId, @RequestParam LocalDate dataValidade) {
    return ResponseEntity.ok(produtoService.obterUltimaDataSaida(produtoId, dataValidade));
  }
}