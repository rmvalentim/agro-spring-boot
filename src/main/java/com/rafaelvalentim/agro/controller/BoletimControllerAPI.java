/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.BoletimDAO;
import com.rafaelvalentim.agro.dao.SafraDAO;
import com.rafaelvalentim.agro.dao.UnidadeProdutivaDAO;
import com.rafaelvalentim.agro.model.Boletim;
import com.rafaelvalentim.agro.model.BoletimAPI;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rafael
 */

@RestController
public class BoletimControllerAPI {    
    
    @Autowired
    private BoletimDAO boletimDao;
    
    @Autowired 
    private UnidadeProdutivaDAO unidadeDAO;
    
    @Autowired 
    private SafraDAO safraDAO;

    
    @GetMapping("api/boletins")
    public Collection<Boletim> listarTodosAPI() {        
        return boletimDao.findAll();   
    } 
    
    @PutMapping("api/boletim")
    public Boletim salvarBoletim(@RequestBody BoletimAPI boletimApi) throws ParseException {        
        Boletim boletim = new Boletim();
        boletim.setUnidadeProdutiva(unidadeDAO.findById(boletimApi.getUnidadeProdutivaId()));
        boletim.setSafra(safraDAO.findById(boletimApi.getSafraId()));
                
        Date date = new Date();       
        boletim.setData(date);
        
        boletim.setObservacao(boletimApi.getObservacao());
        
        return boletimDao.save(boletim);   
    } 
    
    
   
}
