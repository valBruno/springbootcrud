package com.empresa.springbootcrud.controller;

import com.empresa.springbootcrud.model.Cliente;
import com.empresa.springbootcrud.model.dto.ClienteDTO;
import com.empresa.springbootcrud.repository.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepo clienteRepo;

    @RequestMapping("/clientes")
    public List<ClienteDTO> listar() {

        List<Cliente> resultado = clienteRepo.listarCompleto();

        List<ClienteDTO> collect = resultado.stream().map(Cliente::toClienteDTO).collect(Collectors.toList());

        return collect;
    }
}
