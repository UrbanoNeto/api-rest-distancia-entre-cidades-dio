package com.digitalinnovationone.buscadorcidadesbrasil.services;

import com.digitalinnovationone.buscadorcidadesbrasil.models.Estado;
import com.digitalinnovationone.buscadorcidadesbrasil.repositories.EstadoRepository;
import com.digitalinnovationone.buscadorcidadesbrasil.services.exceptions.NaoEncontrado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EstadoService {
    private final EstadoRepository estadoRepository;

    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Transactional(readOnly = true)
    public Page<Estado> findAll(PageRequest page){
        return estadoRepository.findAll(page);
    }

    @Transactional(readOnly = true)
    public Estado findById(Long id){
        Optional<Estado> estado = estadoRepository.findById(id);
        return estado.orElseThrow(() -> new NaoEncontrado(id));
    }
}
