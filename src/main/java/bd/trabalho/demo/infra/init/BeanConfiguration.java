package bd.trabalho.demo.infra.init;

import bd.trabalho.demo.domain.repository.CategoriaRepository;
import bd.trabalho.demo.domain.repository.EstoqueRepository;
import bd.trabalho.demo.domain.repository.ProdutoRepository;
import bd.trabalho.demo.domain.service.CategoriaService;
import bd.trabalho.demo.domain.service.EstoqueService;
import bd.trabalho.demo.domain.service.ProdutoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

  @Bean
  ProdutoService produtoService(ProdutoRepository produtoRepository, EstoqueService estoqueService, CategoriaService categoriaService) {
    return new ProdutoService(produtoRepository, estoqueService, categoriaService);
  };

  @Bean
  EstoqueService estoqueService(EstoqueRepository estoqueRepository) {
    return new EstoqueService(estoqueRepository);
  }

  @Bean
  CategoriaService categoriaService(CategoriaRepository categoriaRepository) {
    return new CategoriaService(categoriaRepository);
  }
}
