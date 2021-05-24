package com.digitalinnovationone.buscadorcidadesbrasil.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="pais")
public class Pais implements Serializable {
    @Id
    private Long id;

    @Column(name="nome")
    private String nome;
    @Column(name="sigla")
    private String sigla;
    @Column(name="bacen")
    private Integer bacen;
}
