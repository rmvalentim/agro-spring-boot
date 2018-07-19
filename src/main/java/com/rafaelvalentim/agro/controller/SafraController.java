/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.SafraDAO;
import com.rafaelvalentim.agro.model.Safra;
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
public class SafraController {
    @Autowired
    private SafraDAO safraDao;
       
    @GetMapping("safras")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("safras/ListarSafra");
        mv.addObject("safras", safraDao.findAll());
        mv.addObject(new Safra());
        return mv;
    }
    
    @GetMapping("safras/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("safras/DetalharSafra");
        mv.addObject("safra", safraDao.findById(id));
	return mv;
    }
 
    @GetMapping("safras/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("safras/AdicionarSafra");
        mv.addObject(new Safra());
	return mv;
    }

    @GetMapping("safras/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("safras/AtualizarSafra");
        mv.addObject("safra", safraDao.findById(id));
	return mv;
    }

    @GetMapping("safras/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("safras/ExcluirSafra");
        mv.addObject("safra", safraDao.findById(id));
	return mv;
    }

    @PostMapping("safras/adicionar{id}")
    public String confirmaAdicionar(Safra safra) {
        this.safraDao.save(safra);
        return "redirect:/safras";        
    }
   
    @PostMapping("safras/atualizar{id}")
    public String confirmaAtualizar(Safra safra, Long id) {
        safra.setId(id);
        this.safraDao.save(safra);
        return "redirect:/safras";
    }
 
    @PostMapping("safras/excluir{id}")
    public String confirmaExcluir(Long id) {        
	Safra safra = safraDao.findById(id);
        this.safraDao.delete(safra);
	return "redirect:/safras";
        
    }
}
