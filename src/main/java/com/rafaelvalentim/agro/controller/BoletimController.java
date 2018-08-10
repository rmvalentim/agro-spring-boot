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
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rafael
 */

@Controller
public class BoletimController {    
    
    @Autowired
    private BoletimDAO boletimDao;
    
    @Autowired 
    private UnidadeProdutivaDAO unidadeDAO;
    
    @Autowired 
    private SafraDAO safraDAO;
    
    @GetMapping("boletins")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("boletins/ListarBoletins");
        mv.addObject("boletins", boletimDao.findAll());        
        return mv;
    }   
 
    @GetMapping("boletins/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("boletins/AdicionarBoletim");
        mv.addObject("unidades", unidadeDAO.findAll());
        mv.addObject("safras", safraDAO.findAll());
        mv.addObject(new Boletim());
	return mv;
    }
}
