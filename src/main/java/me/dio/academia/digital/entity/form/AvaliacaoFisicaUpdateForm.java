package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoFisicaUpdateForm {
  @NotNull(message = "O campo não pode ficar vazio")
  @Positive(message = "O peso do aluno precisa ser positivo")
  @Min(1)
  @Max(700)
  private double peso;
  @NotNull(message = "O campo não pode ficar vazio")
  @Positive(message = "O peso do altura precisa ser positivo")
  @Min(1)
  @Max(300)
  private double altura;
}
