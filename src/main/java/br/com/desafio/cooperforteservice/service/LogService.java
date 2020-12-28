package br.com.desafio.cooperforteservice.service;

import br.com.desafio.cooperforteservice.entity.Cliente;
import br.com.desafio.cooperforteservice.entity.LogTransacao;
import br.com.desafio.cooperforteservice.enums.OperacaoEnum;
import br.com.desafio.cooperforteservice.repository.LogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@AllArgsConstructor
@Service
public class LogService {

    private AutenticacaoService autenticacaoService;
    private LogRepository logRepository;

    public void registrar(OperacaoEnum operacaoEnum, Cliente cliente) {

        LogTransacao log = LogTransacao.builder()
                .operacao(operacaoEnum)
                .data(new Date())
                .cliente(cliente)
                .autor(autenticacaoService
                        .obterUsuarioLogado())
                .build();

        logRepository.save(log);
    }
}
