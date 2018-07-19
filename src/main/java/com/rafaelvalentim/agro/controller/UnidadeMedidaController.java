/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.UnidadeMedidaDAO;
import com.rafaelvalentim.agro.model.UnidadeMedida;
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
public class UnidadeMedidaController {
    @Autowired
    private UnidadeMedidaDAO unidadeMedidaDao;
       
    @GetMapping("unidades_medida")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("unidades_medida/ListarUnidadeMedida");
        mv.addObject("unidades_medida", unidadeMedidaDao.findAll());
        mv.addObject(new UnidadeMedida());
        return mv;
    }
    
    @GetMapping("unidades_medida/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("unidades_medida/DetalharUnidadeMedida");
        mv.addObject("unidade_medida", unidadeMedidaDao.findById(id));
	return mv;
    }
 
    @GetMapping("unidades_medida/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("unidades_medida/AdicionarUnidadeMedida");
        mv.addObject(new UnidadeMedida());
	return mv;
    }

    @GetMapping("unidades_medida/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("unidades_medida/AtualizarUnidadeMedida");
        mv.addObject("unidade_medida", unidadeMedidaDao.findById(id));
	return mv;
    }

    @GetMapping("unidades_medida/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("unidades_medida/ExcluirUnidadeMedida");
        mv.addObject("unidade_medida", unidadeMedidaDao.findById(id));
	return mv;
    }

    @PostMapping("unidades_medida/adicionar{id}")
    public String confirmaAdicionar(UnidadeMedida unidade_medida) {
        this.unidadeMedidaDao.save(unidade_medida);
        return "redirect:/unidades_medida";        
    }
   
    @PostMapping("unidades_medida/atualizar{id}")
    public String confirmaAtualizar(UnidadeMedida unidade_medida, Long id) {
        unidade_medida.setId(id);
        this.unidadeMedidaDao.save(unidade_medida);
        return "redirect:/unidades_medida";
    }
 
    @PostMapping("unidades_medida/excluir{id}")
    public String confirmaExcluir(Long id) {        
	UnidadeMedida unidade_medida = unidadeMedidaDao.findById(id);
        this.unidadeMedidaDao.delete(unidade_medida);
	return "redirect:/unidades_medida";
        
    }
}
