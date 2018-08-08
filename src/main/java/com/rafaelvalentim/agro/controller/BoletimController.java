/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.BoletimDAO;
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
    
    @GetMapping("boletins")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("boletins/ListarBoletins");
        //mv.addObject("boletins", boletimDao.findAll());
        //mv.addObject(new Boletim());
        return mv;
    }
    
    @GetMapping("boletins/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("boletins/DetalharBoletim");
        mv.addObject("boletim", boletimDao.findById(id));
	return mv;
    }
 
    @GetMapping("boletins/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("boletins/AdicionarBoletim");
        mv.addObject(new Boletim());
	return mv;
    }

    @GetMapping("boletins/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("boletins/AtualizarBoletim");
        mv.addObject("boletim", boletimDao.findById(id));
	return mv;
    }

    @GetMapping("boletins/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("boletins/ExcluirBoletim");
        mv.addObject("boletim", boletimDao.findById(id));
	return mv;
    }

    @PostMapping("boletins/adicionar{id}")
    public String confirmaAdicionar(Boletim boletim) {
        boletim.setData(new Date());
        this.boletimDao.save(boletim);
        return "redirect:/boletins";        
    }
   
    @PostMapping("boletins/atualizar{id}")
    public String confirmaAtualizar(Boletim boletim, Long id) {
        boletim.setId(id);
        boletim.setData(new Date());
        this.boletimDao.save(boletim);
        return "redirect:/boletins";
    }
 
    @PostMapping("boletins/excluir{id}")
    public String confirmaExcluir(Long id) {        
	Boletim boletim = boletimDao.findById(id);
        this.boletimDao.delete(boletim);
	return "redirect:/boletins";
        
    }
}
