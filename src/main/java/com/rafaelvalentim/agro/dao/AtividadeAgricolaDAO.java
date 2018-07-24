/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.dao;

import com.rafaelvalentim.agro.model.AtividadeAgricola;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Rafael.Valentim
 */
public interface AtividadeAgricolaDAO extends JpaRepository<AtividadeAgricola, String> {
    AtividadeAgricola findById(long Id);
}
