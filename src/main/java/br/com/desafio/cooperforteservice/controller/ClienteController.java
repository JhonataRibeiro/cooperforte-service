package br.com.desafio.cooperforteservice.controller;

import br.com.desafio.cooperforteservice.dto.ClienteDTO;
import br.com.desafio.cooperforteservice.entity.Cliente;
import br.com.desafio.cooperforteservice.entity.LogTransacao;
import br.com.desafio.cooperforteservice.enums.OperacaoEnum;
import br.com.desafio.cooperforteservice.service.AutenticacaoService;
import br.com.desafio.cooperforteservice.service.ClienteService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    private AutenticacaoService autenticacaoService;

    //TODO adiciona dtoResponse

    @GetMapping
    public ResponseEntity<List<Cliente>> listar(){
        return ResponseEntity.ok(clienteService.listar());
    }

    @PostMapping
    public ResponseEntity<Cliente> novo(@RequestBody @Valid ClienteDTO clienteDTO){
        Cliente novo = clienteService.novo(clienteDTO);
        return ResponseEntity.ok(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id){
        clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> editar(@PathVariable("id") Long id, @RequestBody @Valid ClienteDTO clienteDTO){
        Cliente cliente = clienteService.editar(id, clienteDTO);
        return ResponseEntity.ok(cliente);
    }



}
