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
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Rafael.Valentim
 */
@Entity
public class Safra implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    private Long id;
    
    private String descricao;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataInicio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataTermino;
    
    @OneToMany
    @JoinColumn(name = "custo_equipamento_id")
    private List<CustoEquipamento> custosEquipamentos = new ArrayList<>();  
    
    @OneToMany
    @JoinColumn(name = "custo_operador_id")
    private List<CustoOperador> custosOperadores = new ArrayList<>();  
    
    @OneToMany
    @JoinColumn(name = "custo_produto_id")
    private List<CustoProduto> custosProdutos = new ArrayList<>();  
    
    @OneToMany
    @JoinColumn(name = "boletim_id")
    private List<Boletim> boletins = new ArrayList<>();

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
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataTermino
     */
    public Date getDataTermino() {
        return dataTermino;
    }

    /**
     * @param dataTermino the dataTermino to set
     */
    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }
    
    
}
