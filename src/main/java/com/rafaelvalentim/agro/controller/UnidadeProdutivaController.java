/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.MunicipioDAO;
import com.rafaelvalentim.agro.dao.UnidadeProdutivaDAO;
import com.rafaelvalentim.agro.model.UnidadeProdutiva;
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
public class UnidadeProdutivaController {
     @Autowired
    private UnidadeProdutivaDAO unidadeProdutivaDAO;
    
    @Autowired
    private MunicipioDAO municipioDAO;
    
    @GetMapping("unidades_produtivas")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("unidades_produtivas/ListarUnidadeProdutiva");
        mv.addObject("unidadesProdutivas", unidadeProdutivaDAO.findAll());
        mv.addObject(new UnidadeProdutiva());
        return mv;
    }
    
    @GetMapping("unidades_produtivas/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("unidades_produtivas/DetalharUnidadeProdutiva");
        mv.addObject("unidadeProdutiva", unidadeProdutivaDAO.findById(id));
	return mv;
    }
 
    @GetMapping("unidades_produtivas/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("unidades_produtivas/AdicionarUnidadeProdutiva");
        mv.addObject("municipios", municipioDAO.findAll());
        mv.addObject(new UnidadeProdutiva());
	return mv;
    }

    @GetMapping("unidades_produtivas/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("unidades_produtivas/AtualizarUnidadeProdutiva");
        mv.addObject("municipios", municipioDAO.findAll());
        mv.addObject("unidadeProdutiva", unidadeProdutivaDAO.findById(id));
	return mv;
    }

    @GetMapping("unidades_produtivas/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("unidades_produtivas/ExcluirUnidadeProdutiva");
        mv.addObject("unidadeProdutiva", unidadeProdutivaDAO.findById(id));
	return mv;
    }

    @PostMapping("unidades_produtivas/adicionar{id}")
    public String confirmaAdicionar(UnidadeProdutiva unidadeProdutiva, @RequestParam Long municipioId) {
        unidadeProdutiva.setMunicipio(municipioDAO.findById(municipioId));
        this.unidadeProdutivaDAO.save(unidadeProdutiva);
        return "redirect:/unidades_produtivas";        
    }
   
    @PostMapping("unidades_produtivas/atualizar{id}")
    public String confirmaAtualizar(UnidadeProdutiva unidadeProdutiva, Long id, @RequestParam Long municipioid) {
        unidadeProdutiva.setId(id);
        this.unidadeProdutivaDAO.save(unidadeProdutiva);
        return "redirect:/unidades_produtivas";
    }
 
    @PostMapping("unidades_produtivas/excluir{id}")
    public String confirmaExcluir(Long id) {        
	UnidadeProdutiva unidadeProdutiva = unidadeProdutivaDAO.findById(id);
        this.unidadeProdutivaDAO.delete(unidadeProdutiva);
	return "redirect:/unidades_produtivas";
        
    }
}
