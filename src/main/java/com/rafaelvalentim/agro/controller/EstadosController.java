/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;



import com.rafaelvalentim.agro.model.Estado;
import com.rafaelvalentim.agro.model.Estados;
import com.rafaelvalentim.agro.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rafael
 */
@Controller
@RequestMapping("/estados")
public class EstadosController {
    
    @Autowired
    private Estados estados;
    
    @Autowired
    private EstadoRepository er;
    
    @GetMapping
    public ModelAndView listarEstados(){
    ModelAndView mv = new ModelAndView("ListagemEstados");
    mv.addObject("estados", estados.findAll());
    mv.addObject(new Estado());
    return mv;
    }
    
    @PostMapping
    public String salvarEstado(Estado estado){
        this.estados.save(estado);
        return "redirect:/estados";
    }
    
    /*
    TODO: Realizar exclusão e edição.
    */
    
    @RequestMapping("/excluirEstado")
    public String excluirEstado(long id){
	Estado estado = er.findById(id);
	er.delete(estado);
	return "redirect:/estados";
    }
}
