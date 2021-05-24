package com.digitalinnovationone.buscadorcidadesbrasil.controllers.exceptions;

import com.digitalinnovationone.buscadorcidadesbrasil.services.exceptions.ExceptionPersonalizada;
import com.digitalinnovationone.buscadorcidadesbrasil.services.exceptions.NaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NaoEncontrado.class)
    public ResponseEntity<ErroPadrao> recursoNaoEncontrado(NaoEncontrado e, HttpServletRequest requisicao) {
        String error = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;

        ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status.value(), e.getMessage(), error,
                requisicao.getRequestURI());

        return ResponseEntity.status(status).body(erroPadrao);

    }

    @ExceptionHandler(ExceptionPersonalizada.class)
    public ResponseEntity<ErroPadrao> recursoInvalido(ExceptionPersonalizada e, HttpServletRequest requisicao) {
        String error = "Recurso inválido";
        HttpStatus status = HttpStatus.FORBIDDEN;

        ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status.value(), e.getMessage(), error,
                requisicao.getRequestURI());

        return ResponseEntity.status(status).body(erroPadrao);

    }
}
