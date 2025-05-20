package bd.trabalho.demo.domain.service;

import bd.trabalho.demo.domain.entity.Categoria;
import bd.trabalho.demo.domain.entity.Estoque;
import bd.trabalho.demo.domain.entity.Produto;
import bd.trabalho.demo.domain.repository.ProdutoRepository;
import bd.trabalho.demo.domain.to.ProdutoSaidaTO;
import bd.trabalho.demo.domain.to.ProdutoTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutoService {

  private final ProdutoRepository produtoRepository;
  private final EstoqueService estoqueService;
  private final CategoriaService categoriaService;

  public ProdutoService(ProdutoRepository produtoRepository, EstoqueService estoqueService,
      CategoriaService categoriaService) {
    this.produtoRepository = produtoRepository;
    this.estoqueService = estoqueService;
    this.categoriaService = categoriaService;
  }

  public Produto cadastrarProduto(ProdutoTO produtoTO) {
    Categoria categoria = categoriaService.findById(produtoTO.getCategoriaId());
    Estoque estoque = estoqueService.findById(produtoTO.getEstoqueId());
    Produto produto = Produto.builder().id(produtoTO.getId()).nome(produtoTO.getNome()).quantidade(produtoTO.getQuantidade()).dataValidade(produtoTO.getDataValidade()).categoria(categoria).estoque(estoque).build();

    return produtoRepository.save(produto);
  }

  public Produto atualizarSaidaProduto(ProdutoSaidaTO produtoSaidaTO, Long id) {
    Produto produto = produtoRepository.findById(id).orElse(null);

    produto.setDataSaida(produtoSaidaTO.getDataSaida());

    return produtoRepository.save(produto);
  }

  public List<Map<String, Object>> obterProdutosProximosVencimento(int dias) {
    LocalDate dataLimite = LocalDate.now().plusDays(dias);
    List<Object[]> resultados =  produtoRepository.findProdutosProximosVencimento(dataLimite);

    List<Map<String, Object>> lista = new ArrayList<>();
    for (Object[] resultado : resultados) {
      Map<String, Object> map = new HashMap<>();
      map.put("id", resultado[0]);
      map.put("produto", resultado[1]);
      map.put("estoque", resultado[2]);
      map.put("quantidade", resultado[3]);
      lista.add(map);
    }
    return lista;
  }

  public Double calcularPrazoMedioPermanencia(Long produtoId, Long estoqueId) {
    return produtoRepository.findPrazoMedioPermanencia(produtoId, estoqueId);
  }

  public List<Produto> listarProdutosEstoque() {
    return produtoRepository.listarProdutosEstoque();
  }

  public List<Map<String, Object>> listarProdutosBaixaQuantidade(Long estoqueId, int limiteQuantidade) {
    List<Object[]> resultados =  produtoRepository.findProdutosComBaixaQuantidade(estoqueId, limiteQuantidade);

    List<Map<String, Object>> lista = new ArrayList<>();
    for (Object[] resultado : resultados) {
      Map<String, Object> map = new HashMap<>();
      map.put("id", resultado[0]);
      map.put("produto", resultado[1]);
      map.put("estoque", resultado[2]);
      map.put("quantidade", resultado[3]);
      lista.add(map);
    }
    return lista;
  }

  public List<Map<String, Object>> obterUltimaDataSaida(Long produtoId, LocalDate dataValidade) {
    List<Object[]> resultados =  produtoRepository.findUltimaDataSaida(produtoId, dataValidade);

    List<Map<String, Object>> lista = new ArrayList<>();
    for (Object[] resultado : resultados) {
      Map<String, Object> map = new HashMap<>();
      map.put("data de saída", resultado[0]);
      lista.add(map);
    }
    return lista;
  }

}
