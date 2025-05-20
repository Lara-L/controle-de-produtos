package bd.trabalho.demo.infra.repository;

import bd.trabalho.demo.domain.entity.Categoria;
import bd.trabalho.demo.domain.entity.Produto;
import bd.trabalho.demo.domain.repository.CategoriaRepository;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class PostgresCategoriaRepository implements CategoriaRepository {
  private final SpringDataCategoriaRepository springCategoriaRepository;

  public PostgresCategoriaRepository(SpringDataCategoriaRepository springCategoriaRepository) {
    this.springCategoriaRepository = springCategoriaRepository;
  }

  @Override
  public Optional<Categoria> findById(Long id) {
    return springCategoriaRepository.findById(id);
  }

  @Override
  public Categoria save(Categoria entity) {
    return springCategoriaRepository.save(entity);
  }
}
