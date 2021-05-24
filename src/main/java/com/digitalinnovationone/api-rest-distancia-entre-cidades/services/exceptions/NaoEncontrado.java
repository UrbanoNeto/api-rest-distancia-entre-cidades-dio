package com.digitalinnovationone.buscadorcidadesbrasil.services.exceptions;

public class NaoEncontrado extends RuntimeException {
    public NaoEncontrado(Object obj){
        super("Item não encontrado: " + obj);
    }
}
