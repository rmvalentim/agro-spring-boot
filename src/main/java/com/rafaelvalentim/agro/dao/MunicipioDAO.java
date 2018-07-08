/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.dao;

import com.rafaelvalentim.agro.model.Municipio;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rafael
 */
public interface MunicipioDAO extends CrudRepository<Municipio, String>{
    Municipio findById(long Id);
}
