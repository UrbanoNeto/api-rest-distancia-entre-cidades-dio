package com.digitalinnovationone.buscadorcidadesbrasil.services;

import com.digitalinnovationone.buscadorcidadesbrasil.models.Cidade;
import com.digitalinnovationone.buscadorcidadesbrasil.repositories.CidadeRepository;
import com.digitalinnovationone.buscadorcidadesbrasil.services.exceptions.ExceptionPersonalizada;
import com.digitalinnovationone.buscadorcidadesbrasil.services.exceptions.NaoEncontrado;
import com.digitalinnovationone.buscadorcidadesbrasil.services.utility.CidadeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private final CidadeRepository cidadeRepository;
    @Autowired
    private final CidadeUtility cidadeUtility;

    public CidadeService(CidadeRepository cidadeRepository, CidadeUtility cidadeUtility) {
        this.cidadeRepository = cidadeRepository;
        this.cidadeUtility = cidadeUtility;
    }

    @Transactional(readOnly = true)
    public Page<Cidade> findAll(PageRequest page){
        return cidadeRepository.findAll(page);
    }

    @Transactional(readOnly = true)
    public Cidade findById(Long id){
        Optional<Cidade> estado = cidadeRepository.findById(id);
        return estado.orElseThrow(() -> new NaoEncontrado(id));
    }

    @Transactional(readOnly = true)
    public Double distanciaEntreCidades(Long origemId, Long destinoId){
        if(origemId == destinoId){
            throw new ExceptionPersonalizada("Identificadores são iguais!");
        }
        Cidade origem = findById(origemId);
        Cidade destino = findById(destinoId);
        return cidadeUtility.distanceByCubeInMeters(origem, destino);
    }

}
