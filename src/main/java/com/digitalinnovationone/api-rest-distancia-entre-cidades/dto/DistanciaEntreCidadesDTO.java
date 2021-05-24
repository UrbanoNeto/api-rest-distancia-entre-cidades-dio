package com.digitalinnovationone.buscadorcidadesbrasil.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistanciaEntreCidadesDTO implements Serializable {
    private Long origem;
    private Long destino;
    private String distanciaAproximada;
}
