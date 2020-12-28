package br.com.desafio.cooperforteservice.service.mappers;

import br.com.desafio.cooperforteservice.dto.EmailDTO;
import br.com.desafio.cooperforteservice.entity.Email;

import java.util.List;
import java.util.stream.Collectors;

public class EmailDTOMapper {

    public static List<Email> parseParaEntidade(List<EmailDTO> emails) {
        return emails.stream().map(email -> Email.builder()
                .id(email.getId())
                .email(email.getEmail())
                .build())
                .collect(Collectors.toList());
    }

}
