package br.com.desafio.cooperforteservice.service.mappers;

import br.com.desafio.cooperforteservice.dto.TelefoneDTO;
import br.com.desafio.cooperforteservice.entity.Telefone;

import java.util.List;
import java.util.stream.Collectors;

public class TelefoneDTOMapper {

    public static List<Telefone> parseParaEntidade(List<TelefoneDTO> telefoneDTOS) {
        List<Telefone> collect = telefoneDTOS.stream().map(telefoneDTO -> Telefone.builder()
                .id(telefoneDTO.getId())
                .telefone(telefoneDTO.getTelefone())
                .tipo(telefoneDTO.getTipo()).build())
                .collect(Collectors.toList());

        return  collect;
    }

}
