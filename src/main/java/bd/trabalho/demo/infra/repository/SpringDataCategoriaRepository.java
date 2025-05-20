package bd.trabalho.demo.infra.repository;

import bd.trabalho.demo.domain.entity.Categoria;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface SpringDataCategoriaRepository extends JpaRepository<Categoria, Long>,
    JpaSpecificationExecutor<Categoria> {

}
