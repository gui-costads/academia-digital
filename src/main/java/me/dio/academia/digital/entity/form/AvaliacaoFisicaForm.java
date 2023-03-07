package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.Aluno;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoFisicaForm {
  @NotNull(message = "O campo não pode ficar vazio")
  @Positive(message = "O id do aluno precisa ser positivo")
  private Long alunoId;
  @NotNull(message = "O campo não pode ficar vazio")
  @Positive(message = "O peso do aluno precisa ser positivo")
  @Min(1)
  @Max(700)
  private double peso;
  @NotNull(message = "O campo não pode ficar vazio")
  @Positive(message = "O peso do altura precisa ser positivo")
  @Min(1)
  @Max(700)
  private double altura;
}
