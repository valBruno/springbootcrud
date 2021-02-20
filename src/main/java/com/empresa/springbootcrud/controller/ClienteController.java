package com.empresa.springbootcrud.controller;

import com.empresa.springbootcrud.model.Cliente;
import com.empresa.springbootcrud.model.dto.ClienteDTO;
import com.empresa.springbootcrud.model.form.ClienteForm;
import com.empresa.springbootcrud.model.update.ClienteUpdate;
import com.empresa.springbootcrud.repository.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepo clienteRepo;

    @GetMapping
    public List<ClienteDTO> listar() {

        List<Cliente> resultado = clienteRepo.listarCompleto();

        List<ClienteDTO> collect = resultado.stream().map(Cliente::toClienteDTO).collect(Collectors.toList());

        return collect;
    }

    @GetMapping("/{id}")
    public ClienteDTO get(@PathVariable("id") Long id) {

        Cliente resultado = clienteRepo.getOne(id);

        ClienteDTO retorno = resultado.toClienteDTO();

        return retorno;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteDTO> cadastrar(@Valid @RequestBody ClienteForm form, UriComponentsBuilder uriBuilder) {

        Cliente c = form.toCliente();
        Cliente save = clienteRepo.save(c);
        ClienteDTO retorno = save.toClienteDTO();

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(retorno.getId()).toUri();
        return ResponseEntity.created(uri).body(retorno);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ClienteDTO> editar(@PathVariable("id") Long clienteId, @RequestBody ClienteUpdate update) {

        Cliente resultado = clienteRepo.getOne(clienteId);
        resultado.atualizar(update);
        Cliente atualizado = clienteRepo.save(resultado);

        ClienteDTO retorno = atualizado.toClienteDTO();

        return ResponseEntity.ok(retorno);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity apagar(@PathVariable("id") Long clienteId) {
        clienteRepo.deleteById(clienteId);
        return ResponseEntity.ok().build();
    }
}
