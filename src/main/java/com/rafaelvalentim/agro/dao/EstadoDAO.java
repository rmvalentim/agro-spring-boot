/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.dao;

import com.rafaelvalentim.agro.model.Estado;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rafael
 */
public interface EstadoDAO extends CrudRepository<Estado, String> {
    Estado findById(long Id);
 
}
