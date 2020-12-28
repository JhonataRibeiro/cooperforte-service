package br.com.desafio.cooperforteservice.dto;

import br.com.desafio.cooperforteservice.enums.TipoTelefoneEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneDTO {
    private Long id;

    @NotNull
    @NotBlank
    private TipoTelefoneEnum tipo;

    @NotNull
    @NotBlank
    private String telefone;
}
