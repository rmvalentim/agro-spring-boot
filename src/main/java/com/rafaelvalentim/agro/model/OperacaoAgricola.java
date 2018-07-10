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
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Rafael.Valentim
 */
@Entity
public class OperacaoAgricola implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    private Long id;
    
    private String descricao;
    
    @ManyToOne
    private AtividadeAgricola atividadeAgricola;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the atividadeAgricola
     */
    public AtividadeAgricola getAtividadeAgricola() {
        return atividadeAgricola;
    }

    /**
     * @param atividadeAgricola the atividadeAgricola to set
     */
    public void setAtividadeAgricola(AtividadeAgricola atividadeAgricola) {
        this.atividadeAgricola = atividadeAgricola;
    }
    
    
}
