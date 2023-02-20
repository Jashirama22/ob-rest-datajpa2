package com.example.obrestdatajpa.controladores;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //Crear una clase HelloController que sea un controlador REST.
    // Dentro de la clase crear un método que retorne un saludo.
    // Probar que retorna el saludo desde el navegador y desde Postman.

    //@Value("${app.message}")
    //String message;


    @GetMapping("/hola")
    public String saludar(){
        //System.out.println(message);
        return "hola openB. todo bien ?";
    }



}
