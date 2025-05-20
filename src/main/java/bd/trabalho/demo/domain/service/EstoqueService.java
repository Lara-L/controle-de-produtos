package bd.trabalho.demo.domain.service;

import bd.trabalho.demo.domain.entity.Categoria;
import bd.trabalho.demo.domain.entity.Estoque;
import bd.trabalho.demo.domain.repository.EstoqueRepository;
import java.util.Optional;

public class EstoqueService {
  private final EstoqueRepository estoqueRepository;

  public EstoqueService(EstoqueRepository estoqueRepository) {
    this.estoqueRepository = estoqueRepository;
  }

  public Estoque findById(Long id) {
    Optional<Estoque> estoque = estoqueRepository.findById(id);
    return estoque.get();
  }

  public Estoque cadastrarEstoque(Estoque estoqueTO) {
    Estoque estoque = Estoque.builder().localizacao(estoqueTO.getLocalizacao()).id(estoqueTO.getId()).build();
    return estoqueRepository.save(estoque);
  }
}
