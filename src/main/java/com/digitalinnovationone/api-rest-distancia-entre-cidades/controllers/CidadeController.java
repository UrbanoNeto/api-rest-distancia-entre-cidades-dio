package com.digitalinnovationone.buscadorcidadesbrasil.controllers;

import com.digitalinnovationone.buscadorcidadesbrasil.dto.DistanciaEntreCidadesDTO;
import com.digitalinnovationone.buscadorcidadesbrasil.models.Cidade;
import com.digitalinnovationone.buscadorcidadesbrasil.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    CidadeService cidadeServices;

    @GetMapping
    public ResponseEntity<Page<Cidade>> buscarTodasCidades
            (@RequestParam(value = "page", defaultValue = "0") Integer page,
             @RequestParam(value = "size", defaultValue = "5") Integer size
    ){
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Cidade> list = cidadeServices.findAll(pageRequest);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> findById(@PathVariable Long id){
        Cidade cidade = cidadeServices.findById(id);
        return ResponseEntity.ok().body(cidade);
    }

    @GetMapping("/distancia/{origemId}/{destinoId}")
    public ResponseEntity<DistanciaEntreCidadesDTO> distanciaEntreCidades(@PathVariable Long origemId, @PathVariable Long destinoId){
        DecimalFormat df = new DecimalFormat("######");
        String distancia = cidadeServices.distanciaEntreCidades(origemId, destinoId) + " mi";
        DistanciaEntreCidadesDTO distanciaDTO = new DistanciaEntreCidadesDTO(origemId, destinoId, distancia);
        return ResponseEntity.ok().body(distanciaDTO);
    }


}
