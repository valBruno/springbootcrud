package com.empresa.springbootcrud.controller;

import com.empresa.springbootcrud.enums.TipoTelefoneEnum;
import com.empresa.springbootcrud.model.Telefone;
import com.empresa.springbootcrud.model.dto.ClienteDTO;
import com.empresa.springbootcrud.model.form.ClienteForm;
import com.empresa.springbootcrud.model.form.EnderecoForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WebMvcTest
@AutoConfigureMockMvc
class ClienteControllerTest {

    @Autowired
    private ClienteController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void listar() throws Exception {
        List<ClienteDTO> listar = controller.listar();

        assertNotNull(listar);
        System.out.println(listar);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/clientes")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void cadastrar() {

        ClienteForm form = new ClienteForm();
        form.setCpf("12345678900");
        form.setNome("Nome teste");

        form.setEmail(Arrays.asList("email@mail.com", "email123@email.com"));
        Telefone tel1 = new Telefone(TipoTelefoneEnum.RESIDENCIAL,"6122334455");
        Telefone tel2 = new Telefone(TipoTelefoneEnum.CELULAR,"61998887766");
        form.setTelefone(Arrays.asList(tel1,tel2));

        EnderecoForm endForm = new EnderecoForm("7088866","Rua abc casa 3","Vila Planalto","Brasília","DF");


        form.setEndereco(endForm);

        ResponseEntity<ClienteDTO> resultado = controller.cadastrar(form, UriComponentsBuilder.newInstance());

        assertNotNull(resultado);
        System.out.println(resultado);
    }

    @Test
    void editar() {

        ClienteForm form = new ClienteForm();
        form.setCpf("12345678900");
        form.setNome("DADOOS ALTERADOS");

        form.setEmail(Arrays.asList("email@mail.com", "email123@email.com"));

        Telefone tel1 = new Telefone(TipoTelefoneEnum.RESIDENCIAL,"6122334455");
        Telefone tel2 = new Telefone(TipoTelefoneEnum.CELULAR,"61998887766");
        form.setTelefone(Arrays.asList(tel1,tel2));

        EnderecoForm endForm = new EnderecoForm("7088866","Rua abc casa 3","Vila Planalto","Brasília","DF");

        ClienteDTO editar = controller.editar(1L, form);

        assertNotNull(editar);
        System.out.println(editar);
    }

    @Test
    void apagar() {
        List<ClienteDTO> listar = controller.listar();

        assertNotNull(listar);
        System.out.println(listar);
    }
}