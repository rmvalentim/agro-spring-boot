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
public class CustoProduto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    private Long id;
    
    @ManyToOne
    private Produto produto;
    
    @ManyToOne
    private Safra safra;
    private double custoReal;
    private double custoDollar;

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
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
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
     * @return the custoReal
     */
    public double getCustoReal() {
        return custoReal;
    }

    /**
     * @param custoReal the custoReal to set
     */
    public void setCustoReal(double custoReal) {
        this.custoReal = custoReal;
    }

    /**
     * @return the custoDollar
     */
    public double getCustoDollar() {
        return custoDollar;
    }

    /**
     * @param custoDollar the custoDollar to set
     */
    public void setCustoDollar(double custoDollar) {
        this.custoDollar = custoDollar;
    }
    
    
    
}
