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
    public ResponseEntity<ClienteDTO> get(@PathVariable("id") Long id) {

        Optional<Cliente> resultado = clienteRepo.findById(id);

        if(resultado.isPresent()) {
            return ResponseEntity.ok(resultado.get().toClienteDTO());
        }

        return ResponseEntity.notFound().build();
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

        Optional<Cliente> resultado = clienteRepo.findById(clienteId);
        if(resultado.isPresent()) {


            resultado.get().atualizar(update);
            Cliente atualizado = clienteRepo.save(resultado.get());

            ClienteDTO retorno = atualizado.toClienteDTO();

            return ResponseEntity.ok(retorno);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity apagar(@PathVariable("id") Long clienteId) {

        Optional<Cliente> resultado = clienteRepo.findById(clienteId);
        if(resultado.isPresent()) {
            clienteRepo.deleteById(clienteId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
