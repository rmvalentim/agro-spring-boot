/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.CustoProdutoDAO;
import com.rafaelvalentim.agro.dao.ProdutoDAO;
import com.rafaelvalentim.agro.dao.SafraDAO;
import com.rafaelvalentim.agro.model.CustoProduto;
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
public class CustoProdutoController {
       
    @Autowired
    private CustoProdutoDAO custoProdutoDAO;
    
    @Autowired
    private ProdutoDAO produtoDAO;
    
    @Autowired
    private SafraDAO safraDAO;
    
    @GetMapping("custos_produtos")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("custos_produtos/ListarCustoProduto");
        mv.addObject("custos_produtos", custoProdutoDAO.findAll());
        mv.addObject(new CustoProduto());
        return mv;
    }
    
    @GetMapping("custos_produtos/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("custos_produtos/DetalharCustoProduto");
        mv.addObject("custoProduto", custoProdutoDAO.findById(id));
	return mv;
    }
 
    @GetMapping("custos_produtos/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("custos_produtos/AdicionarCustoProduto");
        mv.addObject("produtos", produtoDAO.findAll());
        mv.addObject("safras", safraDAO.findAll());
        mv.addObject(new CustoProduto());
	return mv;
    }

    @GetMapping("custos_produtos/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("custos_produtos/AtualizarCustoProduto");
        mv.addObject("produtos", produtoDAO.findAll());
        mv.addObject("safras", safraDAO.findAll());
        mv.addObject("custoProduto", custoProdutoDAO.findById(id));
	return mv;
    }

    @GetMapping("custos_produtos/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("custos_produtos/ExcluirCustoProduto");
        mv.addObject("custoProduto", custoProdutoDAO.findById(id));
	return mv;
    }

    @PostMapping("custos_produtos/adicionar{id}")
    public String confirmaAdicionar(CustoProduto custoProduto, @RequestParam Long produtoId, @RequestParam Long safraId) {
        custoProduto.setProduto(produtoDAO.findById(produtoId));
        custoProduto.setSafra(safraDAO.findById(safraId));
        this.custoProdutoDAO.save(custoProduto);
        return "redirect:/custos_produtos";        
    }
   
    @PostMapping("custos_produtos/atualizar{id}")
    public String confirmaAtualizar(CustoProduto custoProduto, Long id, @RequestParam Long produtoId, @RequestParam Long safraId) {
        custoProduto.setId(id);
        custoProduto.setProduto(produtoDAO.findById(produtoId));
        custoProduto.setSafra(safraDAO.findById(safraId));
        this.custoProdutoDAO.save(custoProduto);
        return "redirect:/custos_produtos";
    }
 
    @PostMapping("custos_produtos/excluir{id}")
    public String confirmaExcluir(Long id) {        
	CustoProduto custoProduto = custoProdutoDAO.findById(id);
        this.custoProdutoDAO.delete(custoProduto);
	return "redirect:/custos_produtos";
        
    }
}
