/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.EquipamentoDAO;
import com.rafaelvalentim.agro.dao.GrupoEquipamentoDAO;
import com.rafaelvalentim.agro.model.Equipamento;
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
public class EquipamentoController {
    
    @Autowired
    private EquipamentoDAO equipamentoDAO;
    
    @Autowired
    private GrupoEquipamentoDAO grupoEquipamentoDAO;
    
    @GetMapping("equipamentos")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("equipamentos/ListarEquipamento");
        mv.addObject("equipamentos", equipamentoDAO.findAll());
        mv.addObject(new Equipamento());
        return mv;
    }
    
    @GetMapping("equipamentos/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("equipamentos/DetalharEquipamento");
        mv.addObject("equipamento", equipamentoDAO.findById(id));
	return mv;
    }
 
    @GetMapping("equipamentos/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("equipamentos/AdicionarEquipamento");
        mv.addObject("gruposEquipamentos", grupoEquipamentoDAO.findAll());
        mv.addObject(new Equipamento());
	return mv;
    }

    @GetMapping("equipamentos/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("equipamentos/AtualizarEquipamento");
        mv.addObject("gruposEquipamentos", grupoEquipamentoDAO.findAll());
        mv.addObject("equipamento", equipamentoDAO.findById(id));
	return mv;
    }

    @GetMapping("equipamentos/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("equipamentos/ExcluirEquipamento");
        mv.addObject("equipamento", equipamentoDAO.findById(id));
	return mv;
    }

    @PostMapping("equipamentos/adicionar{id}")
    public String confirmaAdicionar(Equipamento equipamento, @RequestParam Long grupo) {
        equipamento.setGrupoEquipamento(grupoEquipamentoDAO.findById(grupo));
        this.equipamentoDAO.save(equipamento);        
        return "redirect:/equipamentos";        
    }
   
    @PostMapping("equipamentos/atualizar{id}")
    public String confirmaAtualizar(Equipamento equipamento, Long id) {
        equipamento.setId(id);
        this.equipamentoDAO.save(equipamento);
        return "redirect:/equipamentos";
    }
 
    @PostMapping("equipamentos/excluir{id}")
    public String confirmaExcluir(Long id) {        
	Equipamento equipamento = equipamentoDAO.findById(id);
        this.equipamentoDAO.delete(equipamento);
	return "redirect:/equipamentos";
        
    }
}