/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.dao;

import com.rafaelvalentim.agro.model.OperacaoAgricola;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Rafael.Valentim
 */
public interface OperacaoAgricolaDAO extends JpaRepository<OperacaoAgricola, String> {
    OperacaoAgricola findById(long Id);
}
