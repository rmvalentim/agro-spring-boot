/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author rafael
 */

@Entity
public class Estado implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id    
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    private Long id;
    
    @NotEmpty
    private String codigo;
    
    @NotEmpty
    private String descricao;
    
    @OneToMany
    @JoinColumn(name = "estado_id")
    private List<Municipio> municipios = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
