package br.com.desafio.cooperforteservice.service.mappers;

import br.com.desafio.cooperforteservice.dto.ClienteDTO;
import br.com.desafio.cooperforteservice.entity.Cliente;
import br.com.desafio.cooperforteservice.entity.Email;
import br.com.desafio.cooperforteservice.entity.Telefone;

import java.time.LocalDateTime;
import java.util.List;

public class ClienteDTOMapper {

    public static Cliente parseParaEntity(ClienteDTO clienteDTO) {

        return Cliente.builder()
                .id(clienteDTO.getId())
                .nome(clienteDTO.getNome())
                .cpf(clienteDTO.getCpf())
                .uf(clienteDTO.getUf())
                .cidade(clienteDTO.getCidade())
                .logradouro(clienteDTO.getComplemento())
                .complemento(clienteDTO.getComplemento())
                .bairro(clienteDTO.getBairro())
                .cep(clienteDTO.getCep())
                .emails(EmailDTOMapper.parseParaEntidade(clienteDTO.getEmails()))
                .telefones(TelefoneDTOMapper.parseParaEntidade(clienteDTO.getTelefones()))
                .dataCriacao(LocalDateTime.now())
                .dataUltimaAtualizacao(LocalDateTime.now())
                .build();
    }

    public static Cliente atualizarEntity(ClienteDTO clienteDTO, Cliente cliente) {
        List<Email> emails = EmailDTOMapper.parseParaEntidade(clienteDTO.getEmails());
        List<Telefone> telefones = TelefoneDTOMapper.parseParaEntidade(clienteDTO.getTelefones());
        //TODO: Configurar mapper (lib)
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setUf(clienteDTO.getUf());
        cliente.setUf(clienteDTO.getUf());
        cliente.setUf(clienteDTO.getUf());
        cliente.setCidade(clienteDTO.getCidade());
        cliente.setLogradouro(clienteDTO.getLogradouro());
        cliente.setComplemento(clienteDTO.getComplemento());
        cliente.setBairro(clienteDTO.getBairro());
        cliente.setCep(clienteDTO.getCep());
        cliente.getEmails().clear();
        cliente.getEmails().addAll(emails);
        cliente.getTelefones().clear();
        cliente.getTelefones().addAll(telefones);
        cliente.setDataUltimaAtualizacao(LocalDateTime.now());

        return cliente;

    }
}
