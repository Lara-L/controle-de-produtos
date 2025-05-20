package bd.trabalho.demo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produtos")
public class Produto {

  @Id
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  private String nome;
  private int quantidade;
  private LocalDate dataValidade;

  @ManyToOne
  @JoinColumn(name = "categoria_id")
  private Categoria categoria;

  @ManyToOne
  @JoinColumn(name = "estoque_id")
  private Estoque estoque;

  @Column(name = "data_entrada", nullable = false, updatable = false)
  private LocalDate dataEntrada;

  @Column(name = "data_saida")
  private LocalDate dataSaida;

  @PrePersist
  protected void prePersist() {
    this.dataEntrada = LocalDate.now();
  }
}
