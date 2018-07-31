/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.CustoOperadorDAO;
import com.rafaelvalentim.agro.dao.OperadorDAO;
import com.rafaelvalentim.agro.dao.SafraDAO;
import com.rafaelvalentim.agro.model.CustoOperador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rafael
 */
@Controller
public class CustoOperadorController {
       
    @Autowired
    private CustoOperadorDAO custoOperadorDAO;
    
    @Autowired
    private OperadorDAO operadorDAO;
    
    @Autowired
    private SafraDAO safraDAO;
    
    @GetMapping("custos_operadores")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("custos_operadores/ListarCustoOperador");
        mv.addObject("custos_operadores", custoOperadorDAO.findAll());
        mv.addObject(new CustoOperador());
        return mv;
    }
    
    @GetMapping("custos_operadores/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("custos_operadores/DetalharCustoOperador");
        mv.addObject("custoOperador", custoOperadorDAO.findById(id));
	return mv;
    }
 
    @GetMapping("custos_operadores/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("custos_operadores/AdicionarCustoOperador");
        mv.addObject("operadores", operadorDAO.findAll());
        mv.addObject("safras", safraDAO.findAll());
        mv.addObject(new CustoOperador());
	return mv;
    }

    @GetMapping("custos_operadores/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("custos_operadores/AtualizarCustoOperador");
        mv.addObject("operadores", operadorDAO.findAll());
        mv.addObject("safras", safraDAO.findAll());
        mv.addObject("custoOperador", custoOperadorDAO.findById(id));
	return mv;
    }

    @GetMapping("custos_operadores/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("custos_operadores/ExcluirCustoOperador");
        mv.addObject("custoOperador", custoOperadorDAO.findById(id));
	return mv;
    }

    @PostMapping("custos_operadores/adicionar{id}")
    public String confirmaAdicionar(CustoOperador custoOperador, @RequestParam Long operadorId, @RequestParam Long safraId) {
        custoOperador.setOperador(operadorDAO.findById(operadorId));
        custoOperador.setSafra(safraDAO.findById(safraId));
        this.custoOperadorDAO.save(custoOperador);
        return "redirect:/custos_operadores";        
    }
   
    @PostMapping("custos_operadores/atualizar{id}")
    public String confirmaAtualizar(CustoOperador custoOperador, Long id, @RequestParam Long operadorId, @RequestParam Long safraId) {
        custoOperador.setId(id);
        custoOperador.setOperador(operadorDAO.findById(operadorId));
        custoOperador.setSafra(safraDAO.findById(safraId));
        this.custoOperadorDAO.save(custoOperador);
        return "redirect:/custos_operadores";
    }
 
    @PostMapping("custos_operadores/excluir{id}")
    public String confirmaExcluir(Long id) {        
	CustoOperador custoOperador = custoOperadorDAO.findById(id);
        this.custoOperadorDAO.delete(custoOperador);
	return "redirect:/custos_operadores";
        
    }
}
