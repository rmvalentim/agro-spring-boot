/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.CustoEquipamentoDAO;
import com.rafaelvalentim.agro.dao.EquipamentoDAO;
import com.rafaelvalentim.agro.dao.SafraDAO;
import com.rafaelvalentim.agro.model.CustoEquipamento;
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
public class CustoEquipamentoController {
    
    @Autowired
    private CustoEquipamentoDAO custoEquipamentoDAO;
    
    @Autowired
    private EquipamentoDAO equipamentoDAO;
    
    @Autowired
    private SafraDAO safraDAO;
    
    @GetMapping("custos_equipamentos")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("custos_equipamentos/ListarCustoEquipamento");
        mv.addObject("custos_equipamentos", custoEquipamentoDAO.findAll());
        mv.addObject(new CustoEquipamento());
        return mv;
    }
    
    @GetMapping("custos_equipamentos/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("custos_equipamentos/DetalharCustoEquipamento");
        mv.addObject("custoEquipamento", custoEquipamentoDAO.findById(id));
	return mv;
    }
 
    @GetMapping("custos_equipamentos/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("custos_equipamentos/AdicionarCustoEquipamento");
        mv.addObject("equipamentos", equipamentoDAO.findAll());
        mv.addObject("safras", safraDAO.findAll());
        mv.addObject(new CustoEquipamento());
	return mv;
    }

    @GetMapping("custos_equipamentos/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("custos_equipamentos/AtualizarCustoEquipamento");
        mv.addObject("equipamentos", equipamentoDAO.findAll());
        mv.addObject("safras", safraDAO.findAll());
        mv.addObject("custoEquipamento", custoEquipamentoDAO.findById(id));
	return mv;
    }

    @GetMapping("custos_equipamentos/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("custos_equipamentos/ExcluirCustoEquipamento");
        mv.addObject("custoEquipamento", custoEquipamentoDAO.findById(id));
	return mv;
    }

    @PostMapping("custos_equipamentos/adicionar{id}")
    public String confirmaAdicionar(CustoEquipamento custoEquipamento, @RequestParam Long equipamento, @RequestParam Long safra) {
        custoEquipamento.setEquipamento(equipamentoDAO.findById(equipamento));
        custoEquipamento.setSafra(safraDAO.findById(safra));
        this.custoEquipamentoDAO.save(custoEquipamento);
        return "redirect:/custos_equipamentos";        
    }
   
    @PostMapping("custos_equipamentos/atualizar{id}")
    public String confirmaAtualizar(CustoEquipamento custoEquipamento, Long id) {
        custoEquipamento.setId(id);
        this.custoEquipamentoDAO.save(custoEquipamento);
        return "redirect:/custos_equipamentos";
    }
 
    @PostMapping("custos_equipamentos/excluir{id}")
    public String confirmaExcluir(Long id) {        
	CustoEquipamento custoEquipamento = custoEquipamentoDAO.findById(id);
        this.custoEquipamentoDAO.delete(custoEquipamento);
	return "redirect:/custos_equipamentos";
        
    }
}