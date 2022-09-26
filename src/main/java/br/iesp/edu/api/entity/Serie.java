package br.iesp.edu.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Serie {

    @Id
    @GeneratedValue
    private Integer id;

    private String titulo;
    private String genero;
    private int ano;
    private String duracao;
    private String relevancia;
    private String sinopse;
}
