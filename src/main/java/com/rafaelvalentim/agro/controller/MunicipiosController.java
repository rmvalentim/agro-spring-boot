/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.EstadoDAO;
import com.rafaelvalentim.agro.model.Municipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.rafaelvalentim.agro.dao.MunicipioDAO;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author rafael
 */

@Controller
public class MunicipiosController {
        
    @Autowired
    private MunicipioDAO municipioDAO;
    
    @Autowired
    private EstadoDAO estadoDAO;
    
    @GetMapping("municipios")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("municipios/ListarMunicipios");
        mv.addObject("municipios", municipioDAO.findAll());
        mv.addObject(new Municipio());
        return mv;
    }
    
    @GetMapping("municipios/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("municipios/DetalharMunicipio");
        mv.addObject("municipio", municipioDAO.findById(id));
	return mv;
    }
 
    @GetMapping("municipios/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("municipios/AdicionarMunicipio");
        mv.addObject("estados", estadoDAO.findAll());
        mv.addObject(new Municipio());
	return mv;
    }

    @GetMapping("municipios/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("municipios/AtualizarMunicipio");
        mv.addObject("estados", estadoDAO.findAll());
        mv.addObject("municipio", municipioDAO.findById(id));
	return mv;
    }

    @GetMapping("municipios/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("municipios/ExcluirMunicipio");
        mv.addObject("municipio", municipioDAO.findById(id));
	return mv;
    }

    @PostMapping("municipios/adicionar{id}")
    public String confirmaAdicionar(Municipio municipio, @RequestParam Long estado) {
        municipio.setEstado(estadoDAO.findById(estado));
        this.municipioDAO.save(municipio);
        return "redirect:/municipios";        
    }
   
    @PostMapping("municipios/atualizar{id}")
    public String confirmaAtualizar(Municipio municipio, Long id) {
        municipio.setId(id);
        this.municipioDAO.save(municipio);
        return "redirect:/municipios";
    }
 
    @PostMapping("municipios/excluir{id}")
    public String confirmaExcluir(Long id) {        
	Municipio municipio = municipioDAO.findById(id);
        this.municipioDAO.delete(municipio);
	return "redirect:/municipios";
        
    }
}
