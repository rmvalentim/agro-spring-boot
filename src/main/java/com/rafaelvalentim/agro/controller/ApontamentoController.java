/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.ApontamentoDAO;
import com.rafaelvalentim.agro.model.Apontamento;
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
public class ApontamentoController {
    @Autowired
    private ApontamentoDAO apontamentoDao;
    
    @GetMapping("apontamentos")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("apontamentos/ListarApontamentos");
        //mv.addObject("apontamentos", apontamentoDao.findAll());
        //mv.addObject(new Apontamento());
        return mv;
    }
    
    @GetMapping("apontamentos/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("apontamentos/DetalharApontamento");
        mv.addObject("apontamento", apontamentoDao.findById(id));
	return mv;
    }
 
    @GetMapping("apontamentos/adicionar")
    public ModelAndView adicionar(Boletim boletim) {
        ModelAndView mv = new ModelAndView("apontamentos/AdicionarApontamento");
        mv.addObject(new Apontamento());
	return mv;
    }

    @GetMapping("apontamentos/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("apontamentos/AtualizarApontamento");
        mv.addObject("apontamento", apontamentoDao.findById(id));
	return mv;
    }

    @GetMapping("apontamentos/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("apontamentos/ExcluirApontamento");
        mv.addObject("apontamento", apontamentoDao.findById(id));
	return mv;
    }

    @PostMapping("apontamentos/adicionar{id}")
    public String confirmaAdicionar(Apontamento apontamento) {
        
        this.apontamentoDao.save(apontamento);
        return "redirect:/apontamentos";        
    }
   
    @PostMapping("apontamentos/atualizar{id}")
    public String confirmaAtualizar(Apontamento apontamento, Long id) {
        apontamento.setId(id);
        
        this.apontamentoDao.save(apontamento);
        return "redirect:/apontamentos";
    }
 
    @PostMapping("apontamentos/excluir{id}")
    public String confirmaExcluir(Long id) {        
	Apontamento apontamento = apontamentoDao.findById(id);
        this.apontamentoDao.delete(apontamento);
	return "redirect:/apontamentos";
        
    }
}
