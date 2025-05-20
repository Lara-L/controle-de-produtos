package bd.trabalho.demo.infra.repository;

import bd.trabalho.demo.domain.entity.Produto;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpringDataProdutoRepository extends JpaRepository<Produto, Long>,
    JpaSpecificationExecutor<Produto> {

  // a) Itens próximos ao vencimento
  @Query("SELECT p.id, p.nome, e.localizacao, SUM(p.quantidade) " +
      "FROM Produto p " +
      "JOIN p.estoque e " +
      "WHERE p.dataValidade < :dataLimite " +
      "GROUP BY p.id, p.nome, e.localizacao")
  List<Object[]> findProdutosProximosVencimento(@Param("dataLimite") LocalDate dataLimite);

  // b)
  @Query("SELECT AVG(CAST(DATE_PART('dia', p.dataSaida - p.dataEntrada) AS double)) " +
      "FROM Produto p WHERE p.id = :produtoId AND p.estoque.id = :estoqueId AND p.dataSaida IS NOT NULL")
  Double findPrazoMedioPermanencia(@Param("produtoId") Long produtoId,
      @Param("estoqueId") Long estoqueId);

  // c) Listagem de produtos no estoque
  @Query("SELECT p FROM Produto p")
  List<Produto> listarProdutosEstoque();

  // d) Produtos com menos de X unidades em um estoque específico
  @Query("SELECT p.id, p.nome, e.localizacao, p.quantidade " +
      "FROM Produto p " +
      "JOIN p.estoque e " +
      "WHERE e.id = :estoqueId AND p.quantidade < :limiteQuantidade")
  List<Object[]> findProdutosComBaixaQuantidade(@Param("estoqueId") Long estoqueId,
      @Param("limiteQuantidade") int limiteQuantidade);

  // e) Data de saída do estoque de um produto
  @Query("SELECT p.dataSaida FROM Produto p WHERE p.id = :produtoId AND p.dataValidade = :dataValidade")
  List<Object[]> findUltimaDataSaida(@Param("produtoId") Long produtoId,
      @Param("dataValidade") LocalDate dataValidade);

}
