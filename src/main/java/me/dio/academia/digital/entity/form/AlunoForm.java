package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {
    @NotBlank(message = "O campo não pode estar vazio.")
    @Size(min = 3, max = 70, message = "precisa estar entre {min} e {max } caracteres")
    private String nome;
    @NotBlank(message = "O campo não pode estar vazio.")
    @CPF(message = "cpf inválido")
    private String cpf;
    @NotBlank(message = "O campo não pode estar vazio.")
    @Size(min = 3, max = 70, message = "precisa estar entre {min} e {max} caracteres")
    private String bairro;
    @NotNull(message = "O campo não pode ficar vazio")
    @Past(message = "Data inválida")
    private LocalDate dataDeNascimento;
}
