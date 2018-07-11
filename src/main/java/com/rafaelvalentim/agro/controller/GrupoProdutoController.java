/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.model.GrupoProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.rafaelvalentim.agro.dao.GrupoProdutoDAO;

/**
 *
 * @author rafael
 */
@Controller
public class GrupoProdutoController {
    
    @Autowired
    private GrupoProdutoDAO grupoProdutosDao;
       
    @GetMapping("grupos_produtos")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("grupos_produtos/ListarGrupoProduto");
        mv.addObject("gruposProdutos", grupoProdutosDao.findAll());
        mv.addObject(new GrupoProduto());
        return mv;
    }
    
    @GetMapping("grupos_produtos/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("grupos_produtos/DetalharGrupoProduto");
        mv.addObject("gruposProdutos", grupoProdutosDao.findById(id));
	return mv;
    }
 
    @GetMapping("grupos_produtos/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("grupos_produtos/AdicionarGrupoProduto");
        mv.addObject(new GrupoProduto());
	return mv;
    }

    @GetMapping("grupos_produtos/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("grupos_produtos/AtualizarGrupoProduto");
        mv.addObject("grupoProduto", grupoProdutosDao.findById(id));
	return mv;
    }

    @GetMapping("grupos_produtos/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("grupos_produtos/ExcluirGrupoProduto");
        mv.addObject("grupoProduto", grupoProdutosDao.findById(id));
	return mv;
    }

    @PostMapping("grupos_produtos/adicionar{id}")
    public String confirmaAdicionar(GrupoProduto grupoProdutos) {
        this.grupoProdutosDao.save(grupoProdutos);
        return "redirect:/grupos_produtos";        
    }
   
    @PostMapping("grupos_produtos/atualizar{id}")
    public String confirmaAtualizar(GrupoProduto grupoProdutos, Long id) {
        grupoProdutos.setId(id);
        this.grupoProdutosDao.save(grupoProdutos);
        return "redirect:/grupos_produtos";
    }
 
    @PostMapping("grupos_produtos/excluir{id}")
    public String confirmaExcluir(Long id) {        
	GrupoProduto grupoProdutos = grupoProdutosDao.findById(id);
        this.grupoProdutosDao.delete(grupoProdutos);
	return "redirect:/grupos_produtos";
        
    }
}

