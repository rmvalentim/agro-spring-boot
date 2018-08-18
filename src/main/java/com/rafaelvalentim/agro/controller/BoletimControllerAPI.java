/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.ApontamentoDAO;
import com.rafaelvalentim.agro.dao.BoletimDAO;
import com.rafaelvalentim.agro.dao.SafraDAO;
import com.rafaelvalentim.agro.dao.UnidadeProdutivaDAO;
import com.rafaelvalentim.agro.model.Apontamento;
import com.rafaelvalentim.agro.model.Boletim;
import java.util.Collection;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rafael
 */

@RestController
public class BoletimControllerAPI {    
    
    @Autowired
    private BoletimDAO boletimDao;
    
    @Autowired
    private ApontamentoDAO apontamentoDao;    

    
    @GetMapping("api/boletins")
    public Collection<Boletim> listarTodosAPI() {        
        return boletimDao.findAll();   
    } 
    
    
   
}
