package com.digitalinnovationone.buscadorcidadesbrasil.controllers;

import com.digitalinnovationone.buscadorcidadesbrasil.models.Estado;
import com.digitalinnovationone.buscadorcidadesbrasil.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    EstadoService estadoServices;

    @GetMapping
    public ResponseEntity<Page<Estado>> buscarTodosEstados
            (@RequestParam(value = "page", defaultValue = "0") Integer page,
             @RequestParam(value = "size", defaultValue = "5") Integer size
    ){
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Estado> list = estadoServices.findAll(pageRequest);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> findById(@PathVariable Long id){
        Estado estado = estadoServices.findById(id);
        return ResponseEntity.ok().body(estado);
    }

}
