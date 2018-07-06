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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rafael
 */
@Controller
public class EstadosController {
    
    @Autowired
    private Estados estados;
    
    @Autowired
    private EstadoRepository er;
    
    /*
        
    @PostMapping("/estados")
    public String salvarEstado(Estado estado){
        this.estados.save(estado);
        return "redirect:/estados";
    }
    
    @RequestMapping("/deletarEstado")
    public ModelAndView editarEstado(long id){
        ModelAndView mv = new ModelAndView("EditarEstados");
        mv.addObject("estado", er.findById(id));
	return mv;
    }
       
    @RequestMapping("/deletarEstado")
    public String excluirEstado(long id){
	Estado estado = er.findById(id);
	er.delete(estado);
	return "redirect:/estados";
    }    
    
    */
    
    // Tentativa de ter um padrão
       
    @GetMapping("estados")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("ListarEstados");
        mv.addObject("estados", estados.findAll());
        mv.addObject(new Estado());
        return mv;
    }
    
    @GetMapping("estados/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("DetalharEstado");
        mv.addObject("estado", er.findById(id));
	return mv;
    }
 
    @GetMapping("estados/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("AdicionarEstado");
        mv.addObject(new Estado());
	return mv;
    }

    @GetMapping("estados/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("AtualizarEstado");
        mv.addObject("estado", er.findById(id));
	return mv;
    }

    @GetMapping("estados/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("ExcluirEstado");
        mv.addObject("estado", er.findById(id));
	return mv;
    }

    @PostMapping("estados/adicionar{id}")
    public String confirmaAdicionar(Estado estado) {
        this.estados.save(estado);
        return "redirect:/estados";        
    }
   
    @PostMapping("estados/atualizar{id}")
    public String confirmaAtualizar(Long id) {
        Estado estado = er.findById(id);
        this.estados.save(estado);
        return "redirect:/estados";
    }
 
    @PostMapping("estados/excluir{id}")
    public String confirmaExcluir(Long id) {        
	Estado estado = er.findById(id);
        this.estados.delete(estado);
	return "redirect:/estados";
        
    }
}

