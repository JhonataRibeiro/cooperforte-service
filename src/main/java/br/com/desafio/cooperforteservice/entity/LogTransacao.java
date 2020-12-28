package br.com.desafio.cooperforteservice.entity;

import br.com.desafio.cooperforteservice.Usuario;
import br.com.desafio.cooperforteservice.enums.OperacaoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "transacao")
public class LogTransacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private OperacaoEnum operacao;

    @OneToOne
    @NotNull
    private Usuario autor;

    @NotNull
    private Date data;

    @OneToOne
    @NotNull
    private Cliente cliente;


}
