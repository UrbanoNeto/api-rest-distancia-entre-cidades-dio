package com.digitalinnovationone.buscadorcidadesbrasil.services;

import com.digitalinnovationone.buscadorcidadesbrasil.models.Pais;
import com.digitalinnovationone.buscadorcidadesbrasil.repositories.PaisRepository;
import com.digitalinnovationone.buscadorcidadesbrasil.services.exceptions.NaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class PaisService {
    @Autowired
    private final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Transactional(readOnly = true)
    public Page<Pais> findAll(PageRequest page){
        return paisRepository.findAll(page);
    }

    @Transactional(readOnly = true)
    public Pais findById(Long id){
        Optional<Pais> pais = paisRepository.findById(id);
        return pais.orElseThrow(() -> new NaoEncontrado(id));
    }
}
