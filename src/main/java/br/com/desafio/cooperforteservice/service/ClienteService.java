package br.com.desafio.cooperforteservice.service;

import br.com.desafio.cooperforteservice.Usuario;
import br.com.desafio.cooperforteservice.dto.ClienteDTO;
import br.com.desafio.cooperforteservice.entity.Cliente;
import br.com.desafio.cooperforteservice.enums.OperacaoEnum;
import br.com.desafio.cooperforteservice.exception.ClienteNaoEncontradoException;
import br.com.desafio.cooperforteservice.repository.ClienteRepository;
import br.com.desafio.cooperforteservice.service.mappers.ClienteDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;
    private LogService logService;
    private AutenticacaoService autenticacaoService;

    @Transactional()
    public Cliente novo(ClienteDTO clienteDTO) {

        Usuario usuarioLogado = autenticacaoService.obterUsuarioLogado();

        Cliente cliente = ClienteDTOMapper.parseParaEntity(clienteDTO);
        cliente.setUsuarioUltimaAtualizacao(usuarioLogado);
        cliente.setUsuarioCriador(usuarioLogado);

        clienteRepository.save(cliente);

        logService.registrar(OperacaoEnum.CRIACAO, cliente);

        return cliente;
    }

    public List<Cliente> listar() {
        return clienteRepository.findAllByExcluidoFalse();
    }

    @Transactional
    public void excluir(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException("Usuário não encontrado: " + id));
        logService.registrar(OperacaoEnum.DELECAO, cliente);
        cliente.setExcluido(true);
        clienteRepository.save(cliente);
    }

    @Transactional
    public Cliente editar(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException("Usuário não encontrado: " + id));

        ClienteDTOMapper.atualizarEntity(clienteDTO, cliente);
        cliente.setUsuarioUltimaAtualizacao(autenticacaoService.obterUsuarioLogado());
        clienteRepository.save(cliente);

        logService.registrar(OperacaoEnum.ATUALIZACAO, cliente);

        return cliente;
    }
}
