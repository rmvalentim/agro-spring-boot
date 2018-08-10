/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author rafael
 */
@Entity
public class Boletim implements Serializable {
    
private static long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    private Long id;
    
    @ManyToOne
    private UnidadeProdutiva unidadeProdutiva;
    
    @ManyToOne
    private Safra safra;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    
    private String observacao;
    
    @OneToMany
    @JoinColumn(name = "apontamento_id")
    private List<Apontamento> apontamentos = new ArrayList<>();

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

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
     * @return the unidadeProdutiva
     */
    public UnidadeProdutiva getUnidadeProdutiva() {
        return unidadeProdutiva;
    }

    /**
     * @param unidadeProdutiva the unidadeProdutiva to set
     */
    public void setUnidadeProdutiva(UnidadeProdutiva unidadeProdutiva) {
        this.unidadeProdutiva = unidadeProdutiva;
    }

    /**
     * @return the safra
     */
    public Safra getSafra() {
        return safra;
    }

    /**
     * @param safra the safra to set
     */
    public void setSafra(Safra safra) {
        this.safra = safra;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
    
    
    
}
