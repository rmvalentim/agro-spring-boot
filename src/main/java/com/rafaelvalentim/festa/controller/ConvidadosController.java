/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.festa.controller;

import com.rafaelvalentim.festa.model.Convidado;
import com.rafaelvalentim.festa.model.Convidados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Rafael.Valentim
 */
@Controller
@RequestMapping("/convidados")
public class ConvidadosController {
    
    @Autowired
    private Convidados convidados;
    
    @GetMapping
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("ListaConvidados");
        modelAndView.addObject("convidados", convidados.findAll());
        modelAndView.addObject(new Convidado());
        return modelAndView;
    }
    
    @PostMapping
    public String salvarConvidado(Convidado convidado){
        this.convidados.save(convidado);
        return "redirect:/convidados";
    }
}
