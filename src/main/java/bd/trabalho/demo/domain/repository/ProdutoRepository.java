package bd.trabalho.demo.domain.repository;

import bd.trabalho.demo.domain.entity.Produto;
import java.time.LocalDate;
import java.util.List;

public interface ProdutoRepository extends BaseRepository<Produto> {
  List<Object[]> findProdutosProximosVencimento(LocalDate dataLimite);
  Double findPrazoMedioPermanencia(Long produtoId, Long estoqueId);
  List<Produto> listarProdutosEstoque();
  List<Object[]> findProdutosComBaixaQuantidade(Long estoqueId, int limiteQuantidade);
  List<Object[]> findUltimaDataSaida(Long produtoId, LocalDate dataValidade);
}