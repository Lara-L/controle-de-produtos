package bd.trabalho.demo.application.rest;

import bd.trabalho.demo.domain.entity.Estoque;
import bd.trabalho.demo.domain.entity.Produto;
import bd.trabalho.demo.domain.service.EstoqueService;
import bd.trabalho.demo.domain.to.ProdutoTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/estoque")
public class EstoqueController {

  private final EstoqueService estoqueService;

  public EstoqueController(EstoqueService estoqueService) {
    this.estoqueService = estoqueService;
  }

  @PostMapping(value="/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Estoque> cadastrarEstoque(@RequestBody Estoque estoque) {
    return ResponseEntity.ok(estoqueService.cadastrarEstoque(estoque));
  }
}
