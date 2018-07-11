/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.model.GrupoEquipamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.rafaelvalentim.agro.dao.GrupoEquipamentoDAO;

/**
 *
 * @author rafael
 */
@Controller
public class GrupoEquipamentoController {
    
    @Autowired
    private GrupoEquipamentoDAO grupoEquipamentoDao;
       
    @GetMapping("grupos_equipamentos")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("grupos_equipamentos/ListarGrupoEquipamento");
        mv.addObject("gruposEquipamentos", grupoEquipamentoDao.findAll());
        mv.addObject(new GrupoEquipamento());
        return mv;
    }
    
    @GetMapping("grupos_equipamentos/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("grupos_equipamentos/DetalharGrupoEquipamento");
        mv.addObject("gruposEquipamentos", grupoEquipamentoDao.findById(id));
	return mv;
    }
 
    @GetMapping("grupos_equipamentos/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("grupos_equipamentos/AdicionarGrupoEquipamento");
        mv.addObject(new GrupoEquipamento());
	return mv;
    }

    @GetMapping("grupos_equipamentos/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("grupos_equipamentos/AtualizarGrupoEquipamento");
        mv.addObject("grupoEquipamento", grupoEquipamentoDao.findById(id));
	return mv;
    }

    @GetMapping("grupos_equipamentos/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("grupos_equipamentos/ExcluirGrupoEquipamento");
        mv.addObject("grupoEquipamento", grupoEquipamentoDao.findById(id));
	return mv;
    }

    @PostMapping("grupos_equipamentos/adicionar{id}")
    public String confirmaAdicionar(GrupoEquipamento grupoEquipamento) {
        this.grupoEquipamentoDao.save(grupoEquipamento);
        return "redirect:/grupos_equipamentos";        
    }
   
    @PostMapping("grupos_equipamentos/atualizar{id}")
    public String confirmaAtualizar(GrupoEquipamento grupoEquipamento, Long id) {
        grupoEquipamento.setId(id);
        this.grupoEquipamentoDao.save(grupoEquipamento);
        return "redirect:/grupos_equipamentos";
    }
 
    @PostMapping("grupos_equipamentos/excluir{id}")
    public String confirmaExcluir(Long id) {        
	GrupoEquipamento grupoEquipamento = grupoEquipamentoDao.findById(id);
        this.grupoEquipamentoDao.delete(grupoEquipamento);
	return "redirect:/grupos_equipamentos";
        
    }
}

