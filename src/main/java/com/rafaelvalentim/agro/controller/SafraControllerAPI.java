/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.SafraDAO;
import com.rafaelvalentim.agro.model.Safra;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rafael
 */

@RestController
public class SafraControllerAPI {
    
    @Autowired
    private SafraDAO safraDao;
    
    @GetMapping("api/safras")
    public Collection<Safra> listarTodosAPI() {        
        return safraDao.findAll();   
    }
    
}
