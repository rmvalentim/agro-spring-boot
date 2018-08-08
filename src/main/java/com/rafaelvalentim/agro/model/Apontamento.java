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
 * @author rafael
 */
@Entity
public class Apontamento implements Serializable {
    
private static long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    private Long id;
    
    @ManyToOne
    private Boletim boletim;
    
    @ManyToOne
    private Cultura cultura;
    
    @ManyToOne
    private Talhao talhao;
    
    @ManyToOne
    private OperacaoAgricola operacaoAgricola;
    
    @ManyToOne
    private Operador operadorPrincipal;
    
    @ManyToOne
    private Operador operadorAjudante;
    
    @ManyToOne
    private Equipamento equipamentoPrincipal;
    
    @ManyToOne
    private Equipamento equipamentoApoio;
    
    @ManyToOne
    private Produto produto;
    
    private double quantidadeProduto;
    
    private double hectaresTrabalhados;

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
     * @return the boletim
     */
    public Boletim getBoletim() {
        return boletim;
    }

    /**
     * @param boletim the boletim to set
     */
    public void setBoletim(Boletim boletim) {
        this.boletim = boletim;
    }

    /**
     * @return the cultura
     */
    public Cultura getCultura() {
        return cultura;
    }

    /**
     * @param cultura the cultura to set
     */
    public void setCultura(Cultura cultura) {
        this.cultura = cultura;
    }

    /**
     * @return the talhao
     */
    public Talhao getTalhao() {
        return talhao;
    }

    /**
     * @param talhao the talhao to set
     */
    public void setTalhao(Talhao talhao) {
        this.talhao = talhao;
    }

    /**
     * @return the operacaoAgricola
     */
    public OperacaoAgricola getOperacaoAgricola() {
        return operacaoAgricola;
    }

    /**
     * @param operacaoAgricola the operacaoAgricola to set
     */
    public void setOperacaoAgricola(OperacaoAgricola operacaoAgricola) {
        this.operacaoAgricola = operacaoAgricola;
    }

    /**
     * @return the operadorPrincipal
     */
    public Operador getOperadorPrincipal() {
        return operadorPrincipal;
    }

    /**
     * @param operadorPrincipal the operadorPrincipal to set
     */
    public void setOperadorPrincipal(Operador operadorPrincipal) {
        this.operadorPrincipal = operadorPrincipal;
    }

    /**
     * @return the operadorAjudante
     */
    public Operador getOperadorAjudante() {
        return operadorAjudante;
    }

    /**
     * @param operadorAjudante the operadorAjudante to set
     */
    public void setOperadorAjudante(Operador operadorAjudante) {
        this.operadorAjudante = operadorAjudante;
    }

    /**
     * @return the equipamentoPrincipal
     */
    public Equipamento getEquipamentoPrincipal() {
        return equipamentoPrincipal;
    }

    /**
     * @param equipamentoPrincipal the equipamentoPrincipal to set
     */
    public void setEquipamentoPrincipal(Equipamento equipamentoPrincipal) {
        this.equipamentoPrincipal = equipamentoPrincipal;
    }

    /**
     * @return the equipamentoApoio
     */
    public Equipamento getEquipamentoApoio() {
        return equipamentoApoio;
    }

    /**
     * @param equipamentoApoio the equipamentoApoio to set
     */
    public void setEquipamentoApoio(Equipamento equipamentoApoio) {
        this.equipamentoApoio = equipamentoApoio;
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
     * @return the quantidadeProduto
     */
    public double getQuantidadeProduto() {
        return quantidadeProduto;
    }

    /**
     * @param quantidadeProduto the quantidadeProduto to set
     */
    public void setQuantidadeProduto(double quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    /**
     * @return the hectaresTrabalhados
     */
    public double getHectaresTrabalhados() {
        return hectaresTrabalhados;
    }

    /**
     * @param hectaresTrabalhados the hectaresTrabalhados to set
     */
    public void setHectaresTrabalhados(double hectaresTrabalhados) {
        this.hectaresTrabalhados = hectaresTrabalhados;
    }
    
    
    
    
    
}
