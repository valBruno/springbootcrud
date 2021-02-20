package com.empresa.springbootcrud.controller;

import com.empresa.springbootcrud.model.dto.ClienteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClienteControllerTest {

    @Autowired
    private ClienteController controller;

    @Test
    void listar() {
        List<ClienteDTO> listar = controller.listar();

        assertNotNull(listar);
        System.out.println(listar);
    }
}