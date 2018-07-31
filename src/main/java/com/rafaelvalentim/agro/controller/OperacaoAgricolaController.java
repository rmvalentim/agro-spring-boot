/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.AtividadeAgricolaDAO;
import com.rafaelvalentim.agro.dao.OperacaoAgricolaDAO;
import com.rafaelvalentim.agro.model.OperacaoAgricola;
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
public class OperacaoAgricolaController {
     @Autowired
    private OperacaoAgricolaDAO operacaoAgricolaDAO;
    
    @Autowired
    private AtividadeAgricolaDAO atividadeAgricolaDAO;
    
    @GetMapping("operacoes_agricolas")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("operacoes_agricolas/ListarOperacaoAgricola");
        mv.addObject("operacoesAgricolas", operacaoAgricolaDAO.findAll());
        mv.addObject(new OperacaoAgricola());
        return mv;
    }
    
    @GetMapping("operacoes_agricolas/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("operacoes_agricolas/DetalharOperacaoAgricola");
        mv.addObject("operacaoAgricola", operacaoAgricolaDAO.findById(id));
	return mv;
    }
 
    @GetMapping("operacoes_agricolas/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("operacoes_agricolas/AdicionarOperacaoAgricola");
        mv.addObject("atividadesAgricolas", atividadeAgricolaDAO.findAll());
        mv.addObject(new OperacaoAgricola());
	return mv;
    }

    @GetMapping("operacoes_agricolas/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("operacoes_agricolas/AtualizarOperacaoAgricola");
        mv.addObject("atividadesAgricolas", atividadeAgricolaDAO.findAll());
        mv.addObject("operacaoAgricola", operacaoAgricolaDAO.findById(id));
	return mv;
    }

    @GetMapping("operacoes_agricolas/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("operacoes_agricolas/ExcluirOperacaoAgricola");
        mv.addObject("operacaoAgricola", operacaoAgricolaDAO.findById(id));
	return mv;
    }

    @PostMapping("operacoes_agricolas/adicionar{id}")
    public String confirmaAdicionar(OperacaoAgricola operacaoAgricola, @RequestParam Long atividadeAgricolaId) {
        operacaoAgricola.setAtividadeAgricola(atividadeAgricolaDAO.findById(atividadeAgricolaId));
        this.operacaoAgricolaDAO.save(operacaoAgricola);
        return "redirect:/operacoes_agricolas";        
    }
   
    @PostMapping("operacoes_agricolas/atualizar{id}")
    public String confirmaAtualizar(OperacaoAgricola operacaoAgricola, Long id, @RequestParam Long atividadeAgricolaid) {
        operacaoAgricola.setId(id);
        this.operacaoAgricolaDAO.save(operacaoAgricola);
        return "redirect:/operacoes_agricolas";
    }
 
    @PostMapping("operacoes_agricolas/excluir{id}")
    public String confirmaExcluir(Long id) {        
	OperacaoAgricola operacaoAgricola = operacaoAgricolaDAO.findById(id);
        this.operacaoAgricolaDAO.delete(operacaoAgricola);
	return "redirect:/operacoes_agricolas";
        
    }
}
