/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Rafael.Valentim
 */

@Entity
public class Convidado implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    private Long id;
    
    private String nome;
    
    private Integer quantidadeAcompanhantes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeAcompanhantes() {
        return quantidadeAcompanhantes;
    }

    public void setQuantidadeAcompanhantes(Integer quantidadeAcompanhantes) {
        this.quantidadeAcompanhantes = quantidadeAcompanhantes;
    }
    
    
}
