/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.UsuarioDAO;
import com.rafaelvalentim.agro.model.Usuario;
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
public class UsuarioController {
    @Autowired
    private UsuarioDAO usuarioDao;
       
    @GetMapping("usuarios")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("usuarios/ListarUsuario");
        mv.addObject("usuarios", usuarioDao.findAll());
        mv.addObject(new Usuario());
        return mv;
    }
    
    @GetMapping("usuarios/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("usuarios/DetalharUsuario");
        mv.addObject("usuario", usuarioDao.findById(id));
	return mv;
    }
 
    @GetMapping("usuarios/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("usuarios/AdicionarUsuario");
        mv.addObject(new Usuario());
	return mv;
    }

    @GetMapping("usuarios/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("usuarios/AtualizarUsuario");
        mv.addObject("usuario", usuarioDao.findById(id));
	return mv;
    }

    @GetMapping("usuarios/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("usuarios/ExcluirUsuario");
        mv.addObject("usuario", usuarioDao.findById(id));
	return mv;
    }

    @PostMapping("usuarios/adicionar{id}")
    public String confirmaAdicionar(Usuario usuario) {
        this.usuarioDao.save(usuario);
        return "redirect:/usuarios";        
    }
   
    @PostMapping("usuarios/atualizar{id}")
    public String confirmaAtualizar(Usuario usuario, Long id) {
        usuario.setId(id);
        this.usuarioDao.save(usuario);
        return "redirect:/usuarios";
    }
 
    @PostMapping("usuarios/excluir{id}")
    public String confirmaExcluir(Long id) {        
	Usuario usuario = usuarioDao.findById(id);
        this.usuarioDao.delete(usuario);
	return "redirect:/usuarios";
        
    }
}