/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.OperacaoAgricolaDAO;
import com.rafaelvalentim.agro.model.OperacaoAgricola;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rafael
 */
@RestController
public class OperacaoAgricolaControllerAPI {
    
    @Autowired
    private OperacaoAgricolaDAO operacaoAgricolaDao;
    
    @GetMapping("api/operacoes_agricolas")
    public Collection<OperacaoAgricola> listarTodosAPI() {        
        return operacaoAgricolaDao.findAll();   
    }
}
