/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.dao;

import com.rafaelvalentim.agro.model.Apontamento;
import com.rafaelvalentim.agro.model.Boletim;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rafael
 */
public interface ApontamentoDAO extends JpaRepository<Apontamento, String>{
    Apontamento findById(long Id); 
    Collection<Apontamento> findByBoletimId(long id);
}