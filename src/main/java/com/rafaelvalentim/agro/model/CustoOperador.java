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
public class CustoOperador implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    private Long id;
    
    private Operador operador;
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
     * @return the operador
     */
    public Operador getOperador() {
        return operador;
    }

    /**
     * @param operador the operador to set
     */
    public void setOperador(Operador operador) {
        this.operador = operador;
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
