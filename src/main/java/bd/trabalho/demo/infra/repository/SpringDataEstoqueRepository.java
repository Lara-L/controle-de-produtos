package bd.trabalho.demo.infra.repository;

import bd.trabalho.demo.domain.entity.Categoria;
import bd.trabalho.demo.domain.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpringDataEstoqueRepository extends JpaRepository<Estoque, Long> {

}
