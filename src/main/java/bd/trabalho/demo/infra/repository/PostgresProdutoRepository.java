package bd.trabalho.demo.infra.repository;

import bd.trabalho.demo.domain.entity.Produto;
import bd.trabalho.demo.domain.repository.ProdutoRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class PostgresProdutoRepository implements ProdutoRepository {

  private final SpringDataProdutoRepository springProdutoRepository;

  public PostgresProdutoRepository(SpringDataProdutoRepository springProdutoRepository) {
    this.springProdutoRepository = springProdutoRepository;
  }

  @Override
  public Optional<Produto> findById(Long id) {
    return springProdutoRepository.findById(id);
  }

  @Override
  public Produto save(Produto entity) {
    return springProdutoRepository.save(entity);
  }

  @Override
  public List<Object[]> findProdutosProximosVencimento(LocalDate dataLimite) {
    return springProdutoRepository.findProdutosProximosVencimento(dataLimite);
  }

  @Override
  public List<Produto> listarProdutosEstoque() {
    return springProdutoRepository.listarProdutosEstoque();
  };

  @Override
  public List<Object[]> findProdutosComBaixaQuantidade(Long estoqueId, int limiteQuantidade) {
    return springProdutoRepository.findProdutosComBaixaQuantidade(estoqueId, limiteQuantidade);
  }

  @Override
  public List<Object[]> findUltimaDataSaida(Long produtoId, LocalDate dataValidade) {
    return springProdutoRepository.findUltimaDataSaida(produtoId, dataValidade);
  }

  @Override
  public Double findPrazoMedioPermanencia(Long produtoId, Long estoqueId) {
    return springProdutoRepository.findPrazoMedioPermanencia(produtoId, estoqueId);
  }
}
