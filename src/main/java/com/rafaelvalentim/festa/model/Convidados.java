/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.festa.model;

import com.rafaelvalentim.festa.model.Convidado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Rafael.Valentim
 */
public interface Convidados extends JpaRepository<Convidado, Long>{
    
}
