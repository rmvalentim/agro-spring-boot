/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.dao;

import com.rafaelvalentim.agro.model.UnidadeProdutiva;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Rafael.Valentim
 */
public interface UnidadeProdutivaDAO extends CrudRepository<UnidadeProdutiva, String>{
    UnidadeProdutiva findById(long Id);
}