package com.empresa.springbootcrud.controller;

import com.empresa.springbootcrud.model.Cliente;
import com.empresa.springbootcrud.model.dto.ClienteDTO;
import com.empresa.springbootcrud.model.form.ClienteForm;
import com.empresa.springbootcrud.repository.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
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
    public List<ClienteDTO> get() {

        List<Cliente> resultado = clienteRepo.listarCompleto();

        List<ClienteDTO> collect = resultado.stream().map(Cliente::toClienteDTO).collect(Collectors.toList());

        return collect;
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> cadastrar(@Valid @RequestBody ClienteForm form, UriComponentsBuilder uriBuilder) {

        Cliente c = form.toCliente();
        Cliente save = clienteRepo.save(c);
        ClienteDTO retorno = save.toClienteDTO();

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(retorno.getId()).toUri();
        return ResponseEntity.created(uri).body(retorno);
    }

    @PutMapping("/{id}")
    public ClienteDTO editar(@PathVariable("id") Long clienteId, @RequestBody ClienteForm form) {

        Cliente c = form.toCliente();
        Optional<Cliente> byId = clienteRepo.findById(clienteId);

        return null;
    }

    @DeleteMapping("/{id}")
    public ClienteDTO apagar(@PathVariable("id") Long clienteId) {
        return null;
    }
}
