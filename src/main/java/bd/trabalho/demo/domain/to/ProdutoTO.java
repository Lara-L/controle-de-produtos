package bd.trabalho.demo.domain.to;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoTO {
  @NotNull
  private Long id;

  @NotNull
  private String nome;

  @NotNull
  private int quantidade;

  @NotNull
  private LocalDate dataValidade;

  private Long categoriaId;

  private Long estoqueId;

}
