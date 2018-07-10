/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.dao;

import org.springframework.data.repository.CrudRepository;
import com.rafaelvalentim.agro.model.UnidadeMedida;

/**
 *
 * @author Rafael.Valentim
 */
public interface UnidadeMedidaDAO extends CrudRepository<UnidadeMedida, String>{
    UnidadeMedida findById(long Id);
}
