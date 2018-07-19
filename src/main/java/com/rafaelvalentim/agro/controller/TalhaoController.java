/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.TalhaoDAO;
import com.rafaelvalentim.agro.model.Talhao;
import java.util.Date;
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
public class TalhaoController {
    @Autowired
    private TalhaoDAO talhaoDao;
       
    @GetMapping("talhoes")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("talhoes/ListarTalhao");
        mv.addObject("talhoes", talhaoDao.findAll());
        mv.addObject(new Talhao());
        return mv;
    }
    
    @GetMapping("talhoes/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("talhoes/DetalharTalhao");
        mv.addObject("talhao", talhaoDao.findById(id));
	return mv;
    }
 
    @GetMapping("talhoes/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("talhoes/AdicionarTalhao");
        mv.addObject(new Talhao());
	return mv;
    }

    @GetMapping("talhoes/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("talhoes/AtualizarTalhao");
        mv.addObject("talhao", talhaoDao.findById(id));
	return mv;
    }

    @GetMapping("talhoes/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("talhoes/ExcluirTalhao");
        mv.addObject("talhao", talhaoDao.findById(id));
	return mv;
    }

    @PostMapping("talhoes/adicionar{id}")
    public String confirmaAdicionar(Talhao talhao) {
        talhao.setDataCadastro(new Date());
        this.talhaoDao.save(talhao);
        return "redirect:/talhoes";        
    }
   
    @PostMapping("talhoes/atualizar{id}")
    public String confirmaAtualizar(Talhao talhao, Long id) {
        talhao.setId(id);
        talhao.setDataCadastro(new Date());
        this.talhaoDao.save(talhao);
        return "redirect:/talhoes";
    }
 
    @PostMapping("talhoes/excluir{id}")
    public String confirmaExcluir(Long id) {        
	Talhao talhao = talhaoDao.findById(id);
        this.talhaoDao.delete(talhao);
	return "redirect:/talhoes";
        
    }
}
