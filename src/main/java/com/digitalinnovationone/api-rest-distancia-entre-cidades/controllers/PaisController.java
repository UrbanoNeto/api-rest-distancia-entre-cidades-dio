package com.digitalinnovationone.buscadorcidadesbrasil.controllers;

import com.digitalinnovationone.buscadorcidadesbrasil.models.Pais;
import com.digitalinnovationone.buscadorcidadesbrasil.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    PaisService paisServices;

    @GetMapping
    public ResponseEntity<Page<Pais>> buscarTodosPaises
            (@RequestParam(value = "page", defaultValue = "0") Integer page,
             @RequestParam(value = "size", defaultValue = "5") Integer size
    ){
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Pais> list = paisServices.findAll(pageRequest);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> findById(@PathVariable Long id){
        Pais pais = paisServices.findById(id);
        return ResponseEntity.ok().body(pais);
    }

}
