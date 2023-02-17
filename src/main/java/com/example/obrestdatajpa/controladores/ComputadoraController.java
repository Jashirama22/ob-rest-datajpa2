package com.example.obrestdatajpa.controladores;

import com.example.obrestdatajpa.entidades.Computadora;
import com.example.obrestdatajpa.repositorios.ComputadoraReposity;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ComputadoraController {

    private final Logger log = LoggerFactory.getLogger(ComputadoraController.class);

    //atributo
    private final ComputadoraReposity ComputadoraRepository;

    public ComputadoraController(ComputadoraReposity computadoraRepository) {
        ComputadoraRepository = computadoraRepository;
    }

    //crud de la tabla computadora

    //buscar todas las computadoras
    @GetMapping("/api/computadoras")
    public List<Computadora> findAll(){
        return ComputadoraRepository.findAll();
    }

    // buscar segun su ide

    @GetMapping("/api/computadoras/{id}")
    public ResponseEntity<Object> findOneById(@PathVariable Long id){
        Optional <Computadora> CompuOp= ComputadoraRepository.findById(id);

        if (CompuOp.isPresent())
            return ResponseEntity.ok(CompuOp.get());

        else
            return ResponseEntity.notFound().build();

    }

    //crear nueva compu en base de datos

    @PostMapping("/api/computadoras")
    public ResponseEntity<Object> create(@RequestBody Computadora computadora, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        if(computadora.getId() != null){
            log.warn("trying to create a vomputadora with id");
            return ResponseEntity.badRequest().build();
        }
        Computadora result = ComputadoraRepository.save(computadora);
        return ResponseEntity.ok(result);
    }









    //actualizar compu existente en D.B
    @PutMapping("/api/computadoras")
    public ResponseEntity<Object> update (@RequestBody Computadora computadora){

        if (computadora.getId() == null){
            log.warn("trying to update a non existent computadora");
            return ResponseEntity.badRequest().build();
        }
        if (!ComputadoraRepository.existsById(computadora.getId())){
            log.warn("trying to update a non existent computadora");
            return ResponseEntity.notFound().build();
        }

        Computadora result = ComputadoraRepository.save(computadora);
        return ResponseEntity.ok(result);

    }



    //borrar compu en D.B

    @DeleteMapping("/api/computadoras/{id}")
    public ResponseEntity <Computadora> delete(@PathVariable long id){

        if (!ComputadoraRepository.existsById(id)){
            log.warn("trying to dalete a non existent computadora");
            return ResponseEntity.notFound().build();
        }


        ComputadoraRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/computadoras")
    public ResponseEntity <Computadora> deleteAll(){
        log.info("REST request for delete all computadoras");
        ComputadoraRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }





}
