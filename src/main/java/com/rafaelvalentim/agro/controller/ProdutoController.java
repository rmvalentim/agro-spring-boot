/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.GrupoProdutoDAO;
import com.rafaelvalentim.agro.dao.UnidadeMedidaDAO;
import com.rafaelvalentim.agro.dao.ProdutoDAO;
import com.rafaelvalentim.agro.model.GrupoProduto;
import com.rafaelvalentim.agro.model.Produto;
import java.util.Date;
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
public class ProdutoController {
     @Autowired
    private ProdutoDAO produtoDAO;
    
    @Autowired
    private UnidadeMedidaDAO unidadeMedidaDAO;
    
    @Autowired
    private GrupoProdutoDAO grupoProdutoDAO;
    
    @GetMapping("produtos")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("produtos/ListarProdutos");
        mv.addObject("produtos", produtoDAO.findAll());
        mv.addObject(new Produto());
        return mv;
    }
    
    @GetMapping("produtos/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("produtos/DetalharProduto");
        mv.addObject("produto", produtoDAO.findById(id));
	return mv;
    }
 
    @GetMapping("produtos/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("produtos/AdicionarProduto");
        mv.addObject("unidades_medida", unidadeMedidaDAO.findAll());
        mv.addObject("grupos_produto", grupoProdutoDAO.findAll());
        mv.addObject(new Produto());
	return mv;
    }

    @GetMapping("produtos/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("produtos/AtualizarProduto");
        mv.addObject("unidades_medida", unidadeMedidaDAO.findAll());
        mv.addObject("grupos_produto", grupoProdutoDAO.findAll());
        mv.addObject("produto", produtoDAO.findById(id));
	return mv;
    }

    @GetMapping("produtos/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("produtos/ExcluirProduto");
        mv.addObject("produto", produtoDAO.findById(id));
	return mv;
    }

    @PostMapping("produtos/adicionar{id}")
    public String confirmaAdicionar(Produto produto, @RequestParam Long unidademedidaid, @RequestParam Long grupoprodutoid) {
        produto.setUnidadeMedida(unidadeMedidaDAO.findById(unidademedidaid));
        produto.setGrupoProduto(grupoProdutoDAO.findById(grupoprodutoid));
        produto.setDataCadastro(new Date());
        this.produtoDAO.save(produto);
        return "redirect:/produtos";        
    }
   
    @PostMapping("produtos/atualizar{id}")
    public String confirmaAtualizar(Produto produto, Long id) {
        produto.setId(id);
        produto.setDataCadastro(new Date());
        this.produtoDAO.save(produto);
        return "redirect:/produtos";
    }
 
    @PostMapping("produtos/excluir{id}")
    public String confirmaExcluir(Long id) {        
	Produto produto = produtoDAO.findById(id);
        this.produtoDAO.delete(produto);
	return "redirect:/produtos";
        
    }
}
