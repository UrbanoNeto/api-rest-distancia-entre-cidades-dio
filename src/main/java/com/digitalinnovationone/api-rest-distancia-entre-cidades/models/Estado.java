package com.digitalinnovationone.buscadorcidadesbrasil.models;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estado")
@TypeDefs({
      @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class Estado implements Serializable {
    @Id
    private Long id;
    private String nome;
    private String uf;
    private Integer ibge;

    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Pais pais;

    @Basic(fetch = FetchType.LAZY)
    @Type(type="jsonb")
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;
}
