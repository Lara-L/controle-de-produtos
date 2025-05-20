package bd.trabalho.demo.domain.repository;

import java.util.Optional;
import java.util.UUID;

public interface BaseRepository<T> {
  T save(T entity);
  Optional<T> findById(Long id);
}
