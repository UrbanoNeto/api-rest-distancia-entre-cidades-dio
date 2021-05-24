package com.digitalinnovationone.buscadorcidadesbrasil.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Cidade")
@Table(name = "cidade")
public class Cidade implements Serializable {
    @Id
    private Long id;
    private String nome;
    private String ibge;
    private String latitude;
    private String longitude;

    @ManyToOne
    @JoinColumn(name = "uf", referencedColumnName = "id")
    private Estado uf;
}
