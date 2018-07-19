/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.rafaelvalentim.agro.dao.EstadoDAO;

/**
 *
 * @author rafael
 */
@Controller
public class EstadoController {
            
    @Autowired
    private EstadoDAO estadoDao;
       
    @GetMapping("estados")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("estados/ListarEstado");
        mv.addObject("estados", estadoDao.findAll());
        mv.addObject(new Estado());
        return mv;
    }
    
    @GetMapping("estados/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("estados/DetalharEstado");
        mv.addObject("estado", estadoDao.findById(id));
	return mv;
    }
 
    @GetMapping("estados/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("estados/AdicionarEstado");
        mv.addObject(new Estado());
	return mv;
    }

    @GetMapping("estados/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("estados/AtualizarEstado");
        mv.addObject("estado", estadoDao.findById(id));
	return mv;
    }

    @GetMapping("estados/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("estados/ExcluirEstado");
        mv.addObject("estado", estadoDao.findById(id));
	return mv;
    }

    @PostMapping("estados/adicionar{id}")
    public String confirmaAdicionar(Estado estado) {
        this.estadoDao.save(estado);
        return "redirect:/estados";        
    }
   
    @PostMapping("estados/atualizar{id}")
    public String confirmaAtualizar(Estado estado, Long id) {
        estado.setId(id);
        this.estadoDao.save(estado);
        return "redirect:/estados";
    }
 
    @PostMapping("estados/excluir{id}")
    public String confirmaExcluir(Long id) {        
	Estado estado = estadoDao.findById(id);
        this.estadoDao.delete(estado);
	return "redirect:/estados";
        
    }
}

