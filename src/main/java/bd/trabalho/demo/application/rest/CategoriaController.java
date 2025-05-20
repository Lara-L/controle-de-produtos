package bd.trabalho.demo.application.rest;

import bd.trabalho.demo.domain.entity.Categoria;
import bd.trabalho.demo.domain.entity.Estoque;
import bd.trabalho.demo.domain.repository.CategoriaRepository;
import bd.trabalho.demo.domain.service.CategoriaService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {

  private final CategoriaService categoriaService;

  public CategoriaController(CategoriaService categoriaService) {
    this.categoriaService = categoriaService;
  }

  @PostMapping(value="/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Categoria> cadastrarCategoria(@RequestBody Categoria categoria) {
    return ResponseEntity.ok(categoriaService.cadastrarCategoria(categoria));
  }

}
