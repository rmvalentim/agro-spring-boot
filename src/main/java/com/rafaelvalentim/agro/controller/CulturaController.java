/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.model.Cultura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.rafaelvalentim.agro.dao.CulturaDAO;
import java.util.Collection;
import java.util.Date;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author rafael
 */
@Controller
public class CulturaController {
    
    @Autowired
    private CulturaDAO culturaDao;
       
    @GetMapping("culturas")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("culturas/ListarCultura");
        mv.addObject("culturas", culturaDao.findAll());
        mv.addObject(new Cultura());
        return mv;
    }
    
    @GetMapping("culturas/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("culturas/DetalharCultura");
        mv.addObject("cultura", culturaDao.findById(id));
	return mv;
    }
 
    @GetMapping("culturas/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("culturas/AdicionarCultura");
        mv.addObject(new Cultura());
	return mv;
    }

    @GetMapping("culturas/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("culturas/AtualizarCultura");
        mv.addObject("cultura", culturaDao.findById(id));
	return mv;
    }

    @GetMapping("culturas/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("culturas/ExcluirCultura");
        mv.addObject("cultura", culturaDao.findById(id));
	return mv;
    }

    @PostMapping("culturas/adicionar{id}")
    public String confirmaAdicionar(Cultura cultura) {
        cultura.setDataCadastro(new Date());
        this.culturaDao.save(cultura);
        return "redirect:/culturas";        
    }
   
    @PostMapping("culturas/atualizar{id}")
    public String confirmaAtualizar(Cultura cultura, Long id) {
        cultura.setId(id);
        cultura.setDataCadastro(new Date());
        this.culturaDao.save(cultura);
        return "redirect:/culturas";
    }
 
    @PostMapping("culturas/excluir{id}")
    public String confirmaExcluir(Long id) {        
	Cultura cultura = culturaDao.findById(id);
        this.culturaDao.delete(cultura);
	return "redirect:/culturas";
        
    }
}

