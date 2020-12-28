package br.com.desafio.cooperforteservice.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ClienteDTO {

    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$")
    private String nome;

    @NotNull
    @Pattern(regexp = "^[0-9]*$")
    private String cpf;

    @Size(min = 1)
    private List<TelefoneDTO> telefones;

    @Size(min = 1)
    private List<EmailDTO> emails;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 8)
    @Pattern(regexp = "^[0-9]*$")
    private String cep;

    @NotNull
    @NotBlank
    private String logradouro;

    @NotNull
    @NotBlank
    private String bairro;

    @NotNull
    @NotBlank
    private String cidade;

    @NotNull
    @NotBlank
    private String uf;

    private String complemento;

}

