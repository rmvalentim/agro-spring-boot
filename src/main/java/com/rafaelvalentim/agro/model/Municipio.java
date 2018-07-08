 
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
public class Municipio implements Serializable {

    private static long serialVersionUID = 1L;
    
    @Id    
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    private Long id;

    private String descricao;
    
    private String codigoIbge;
    
    @ManyToOne
    private Estado estado;

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
     * @return the codigoIbge
     */
    public String getCodigoIbge() {
        return codigoIbge;
    }

    /**
     * @param codigoIbge the codigoIbge to set
     */
    public void setCodigoIbge(String codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    /**
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
    
}
