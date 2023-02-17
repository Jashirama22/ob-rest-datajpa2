package com.example.obrestdatajpa.controladores;

import com.example.obrestdatajpa.entidades.Computadora;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.util.Arrays.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ComputadoraControllerTest {


    List<Object> mediaTypes = new ArrayList<Object>();


    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void hola() {
        ResponseEntity<String> response =
                testRestTemplate.getForEntity("/hola", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


    @Test
    void findAll() {
        ResponseEntity<Computadora[]> response =
                testRestTemplate.getForEntity("/api/computadoras",Computadora[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        //assertEquals(200, response.getStatusCodeValue()); get value es opsoleto y no se como hacerlo de otra forma
        List<Object> computadora = asList(response.getBody());
        System.out.println(computadora.size());
    }

    /*@Test
    void findOneById() {
        ResponseEntity<Computadora> response =
                testRestTemplate.getForEntity("/api/computadoras/1", Computadora.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

     */

    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(java.util.Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                    {
                    "marca": "probando spring boot j",
                    "modelo": "smartTv",
                    "agno": 2000
                }
                """;
        HttpEntity<String> request = new HttpEntity<>(json,headers);

        ResponseEntity<Computadora> response = testRestTemplate.exchange("/api/computadoras", HttpMethod.POST,request,Computadora.class);
        Computadora result = response.getBody();


        assert result != null;
        assertEquals(1L, result.getId());
        assertEquals("probando spring boot j", result.getMarca());

    }
}