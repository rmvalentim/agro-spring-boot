/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.model;

/**
 *
 * @author rafael
 */
public class CustoSafraSintetico {
    
    private String safra;
    private double custoEquipamentoPrincipalReal;
    private double custoEquipamentoPrincipalDollar;
    private double custoEquipamentoApoioReal;
    private double custoEquipamentoApoioDollar;
    private double custoOperadorPrincipalReal;
    private double custoOperadorPrincipalDollar;
    private double custoOperadorAjudanteReal;
    private double custoOperadorAjudanteDollar;
    private double custoProdutoReal;
    private double custoProdutoDollar;
    
    public double somaReal() {
        return custoEquipamentoPrincipalReal +
                custoEquipamentoApoioReal +
                custoOperadorPrincipalReal +
                custoOperadorAjudanteReal +
                custoProdutoReal;
    }
    
    public double somaDollar() {
        return custoEquipamentoPrincipalDollar +
                custoEquipamentoApoioDollar +
                custoOperadorPrincipalDollar +
                custoOperadorAjudanteDollar +
                custoProdutoDollar;
    }

    /**
     * @return the safra
     */
    public String getSafra() {
        return safra;
    }

    /**
     * @param safra the safra to set
     */
    public void setSafra(String safra) {
        this.safra = safra;
    }

    /**
     * @return the custoEquipamentoPrincipalReal
     */
    public double getCustoEquipamentoPrincipalReal() {
        return custoEquipamentoPrincipalReal;
    }

    /**
     * @param custoEquipamentoPrincipalReal the custoEquipamentoPrincipalReal to set
     */
    public void setCustoEquipamentoPrincipalReal(double custoEquipamentoPrincipalReal) {
        this.custoEquipamentoPrincipalReal = custoEquipamentoPrincipalReal;
    }

    /**
     * @return the custoEquipamentoPrincipalDollar
     */
    public double getCustoEquipamentoPrincipalDollar() {
        return custoEquipamentoPrincipalDollar;
    }

    /**
     * @param custoEquipamentoPrincipalDollar the custoEquipamentoPrincipalDollar to set
     */
    public void setCustoEquipamentoPrincipalDollar(double custoEquipamentoPrincipalDollar) {
        this.custoEquipamentoPrincipalDollar = custoEquipamentoPrincipalDollar;
    }

    /**
     * @return the custoEquipamentoApoioReal
     */
    public double getCustoEquipamentoApoioReal() {
        return custoEquipamentoApoioReal;
    }

    /**
     * @param custoEquipamentoApoioReal the custoEquipamentoApoioReal to set
     */
    public void setCustoEquipamentoApoioReal(double custoEquipamentoApoioReal) {
        this.custoEquipamentoApoioReal = custoEquipamentoApoioReal;
    }

    /**
     * @return the custoEquipamentoApoioDollar
     */
    public double getCustoEquipamentoApoioDollar() {
        return custoEquipamentoApoioDollar;
    }

    /**
     * @param custoEquipamentoApoioDollar the custoEquipamentoApoioDollar to set
     */
    public void setCustoEquipamentoApoioDollar(double custoEquipamentoApoioDollar) {
        this.custoEquipamentoApoioDollar = custoEquipamentoApoioDollar;
    }

    /**
     * @return the custoOperadorPrincipalReal
     */
    public double getCustoOperadorPrincipalReal() {
        return custoOperadorPrincipalReal;
    }

    /**
     * @param custoOperadorPrincipalReal the custoOperadorPrincipalReal to set
     */
    public void setCustoOperadorPrincipalReal(double custoOperadorPrincipalReal) {
        this.custoOperadorPrincipalReal = custoOperadorPrincipalReal;
    }

    /**
     * @return the custoOperadorPrincipalDollar
     */
    public double getCustoOperadorPrincipalDollar() {
        return custoOperadorPrincipalDollar;
    }

    /**
     * @param custoOperadorPrincipalDollar the custoOperadorPrincipalDollar to set
     */
    public void setCustoOperadorPrincipalDollar(double custoOperadorPrincipalDollar) {
        this.custoOperadorPrincipalDollar = custoOperadorPrincipalDollar;
    }

    /**
     * @return the custoOperadorAjudanteReal
     */
    public double getCustoOperadorAjudanteReal() {
        return custoOperadorAjudanteReal;
    }

    /**
     * @param custoOperadorAjudanteReal the custoOperadorAjudanteReal to set
     */
    public void setCustoOperadorAjudanteReal(double custoOperadorAjudanteReal) {
        this.custoOperadorAjudanteReal = custoOperadorAjudanteReal;
    }

    /**
     * @return the custoOperadorAjudanteDollar
     */
    public double getCustoOperadorAjudanteDollar() {
        return custoOperadorAjudanteDollar;
    }

    /**
     * @param custoOperadorAjudanteDollar the custoOperadorAjudanteDollar to set
     */
    public void setCustoOperadorAjudanteDollar(double custoOperadorAjudanteDollar) {
        this.custoOperadorAjudanteDollar = custoOperadorAjudanteDollar;
    }

    /**
     * @return the custoProdutoReal
     */
    public double getCustoProdutoReal() {
        return custoProdutoReal;
    }

    /**
     * @param custoProdutoReal the custoProdutoReal to set
     */
    public void setCustoProdutoReal(double custoProdutoReal) {
        this.custoProdutoReal = custoProdutoReal;
    }

    /**
     * @return the custoProdutoDollar
     */
    public double getCustoProdutoDollar() {
        return custoProdutoDollar;
    }

    /**
     * @param custoProdutoDollar the custoProdutoDollar to set
     */
    public void setCustoProdutoDollar(double custoProdutoDollar) {
        this.custoProdutoDollar = custoProdutoDollar;
    }
    
    
    
}
