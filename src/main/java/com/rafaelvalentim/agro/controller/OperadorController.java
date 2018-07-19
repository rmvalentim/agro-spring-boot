/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.OperadorDAO;
import com.rafaelvalentim.agro.model.Operador;
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
public class OperadorController {
    
    @Autowired
    private OperadorDAO operadorDao;
       
    @GetMapping("operadores")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("operadores/ListarOperador");
        mv.addObject("operadores", operadorDao.findAll());
        mv.addObject(new Operador());
        return mv;
    }
    
    @GetMapping("operadores/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("operadores/DetalharOperador");
        mv.addObject("operador", operadorDao.findById(id));
	return mv;
    }
 
    @GetMapping("operadores/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("operadores/AdicionarOperador");
        mv.addObject(new Operador());
	return mv;
    }

    @GetMapping("operadores/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("operadores/AtualizarOperador");
        mv.addObject("operador", operadorDao.findById(id));
	return mv;
    }

    @GetMapping("operadores/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("operadores/ExcluirOperador");
        mv.addObject("operador", operadorDao.findById(id));
	return mv;
    }

    @PostMapping("operadores/adicionar{id}")
    public String confirmaAdicionar(Operador operador) {
        this.operadorDao.save(operador);
        return "redirect:/operadores";        
    }
   
    @PostMapping("operadores/atualizar{id}")
    public String confirmaAtualizar(Operador operador, Long id) {
        operador.setId(id);
        this.operadorDao.save(operador);
        return "redirect:/operadores";
    }
 
    @PostMapping("operadores/excluir{id}")
    public String confirmaExcluir(Long id) {        
	Operador operador = operadorDao.findById(id);
        this.operadorDao.delete(operador);
	return "redirect:/operadores";
        
    }
}
