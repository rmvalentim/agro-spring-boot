/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.CulturaDAO;
import com.rafaelvalentim.agro.model.Cultura;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rafael
 */
@RestController
public class CulturaControllerAPI {
    
    @Autowired
    private CulturaDAO culturaDao;
    
    @GetMapping("api/culturas")
    public Collection<Cultura> listarTodosAPI() {        
        return culturaDao.findAll();   
    }
    
}
