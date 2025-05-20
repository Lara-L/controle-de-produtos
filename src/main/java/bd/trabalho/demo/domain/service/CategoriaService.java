package bd.trabalho.demo.domain.service;

import bd.trabalho.demo.domain.entity.Categoria;
import bd.trabalho.demo.domain.repository.CategoriaRepository;
import java.util.Optional;
import java.util.UUID;

public class CategoriaService {

  private final CategoriaRepository categoriaRepository;

  public CategoriaService(CategoriaRepository categoriaRepository) {
    this.categoriaRepository = categoriaRepository;
  }

  public Categoria findById(Long id) {
    Optional<Categoria> categoria = categoriaRepository.findById(id);
    return categoria.get();
  }

  public Categoria cadastrarCategoria(Categoria categoriaTO) {
    Categoria categoria = Categoria.builder().nome(categoriaTO.getNome()).id(categoriaTO.getId()).build();
    return categoriaRepository.save(categoria);
  }
}
