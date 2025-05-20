package bd.trabalho.demo.infra.repository;

import bd.trabalho.demo.domain.entity.Categoria;
import bd.trabalho.demo.domain.entity.Estoque;
import bd.trabalho.demo.domain.repository.EstoqueRepository;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class PostgresEstoqueRepository implements EstoqueRepository {

  private final SpringDataEstoqueRepository springEstoqueRepository;

  public PostgresEstoqueRepository(SpringDataEstoqueRepository springEstoqueRepository) {
    this.springEstoqueRepository = springEstoqueRepository;
  }

  @Override
  public Optional<Estoque> findById(Long id) {
    return springEstoqueRepository.findById(id);
  }

  @Override
  public Estoque save(Estoque entity) {
    return springEstoqueRepository.save(entity);
  }

}
