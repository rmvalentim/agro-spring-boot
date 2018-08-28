/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author rafael
 */
public class BoletimAPI {
    
    private long unidadeProdutivaId;
    
    private long safraId;
    
    private String observacao;

    /**
     * @return the unidadeProdutivaId
     */
    public long getUnidadeProdutivaId() {
        return unidadeProdutivaId;
    }

    /**
     * @param unidadeProdutivaId the unidadeProdutivaId to set
     */
    public void setUnidadeProdutivaId(long unidadeProdutivaId) {
        this.unidadeProdutivaId = unidadeProdutivaId;
    }

    /**
     * @return the safraId
     */
    public long getSafraId() {
        return safraId;
    }

    /**
     * @param safraId the safraId to set
     */
    public void setSafraId(long safraId) {
        this.safraId = safraId;
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
