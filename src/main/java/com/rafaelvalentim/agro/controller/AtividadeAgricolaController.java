/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.model.AtividadeAgricola;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.rafaelvalentim.agro.dao.AtividadeAgricolaDAO;

/**
 *
 * @author rafael
 */
@Controller
public class AtividadeAgricolaController {
    
    @Autowired
    private AtividadeAgricolaDAO atividadeAgricolaDao;
       
    @GetMapping("atividades_agricolas")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("atividades_agricolas/ListarAtividadeAgricola");
        mv.addObject("atividadesAgricolas", atividadeAgricolaDao.findAll());
        mv.addObject(new AtividadeAgricola());
        return mv;
    }
    
    @GetMapping("atividades_agricolas/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("atividades_agricolas/DetalharAtividadeAgricola");
        mv.addObject("atividadesAgricolas", atividadeAgricolaDao.findById(id));
	return mv;
    }
 
    @GetMapping("atividades_agricolas/adicionar")
    public ModelAndView adicionar() {
        ModelAndView mv = new ModelAndView("atividades_agricolas/AdicionarAtividadeAgricola");
        mv.addObject(new AtividadeAgricola());
	return mv;
    }

    @GetMapping("atividades_agricolas/atualizar{id}")
    public ModelAndView atualizar(Long id) {
        ModelAndView mv = new ModelAndView("atividades_agricolas/AtualizarAtividadeAgricola");
        mv.addObject("atividadeAgricola", atividadeAgricolaDao.findById(id));
	return mv;
    }

    @GetMapping("atividades_agricolas/excluir{id}")
    public ModelAndView excluir(Long id) {
        ModelAndView mv = new ModelAndView("atividades_agricolas/ExcluirAtividadeAgricola");
        mv.addObject("atividadeAgricola", atividadeAgricolaDao.findById(id));
	return mv;
    }

    @PostMapping("atividades_agricolas/adicionar{id}")
    public String confirmaAdicionar(AtividadeAgricola atividadeAgricola) {
        this.atividadeAgricolaDao.save(atividadeAgricola);
        return "redirect:/atividades_agricolas";        
    }
   
    @PostMapping("atividades_agricolas/atualizar{id}")
    public String confirmaAtualizar(AtividadeAgricola atividadeAgricola, Long id) {
        atividadeAgricola.setId(id);
        this.atividadeAgricolaDao.save(atividadeAgricola);
        return "redirect:/atividades_agricolas";
    }
 
    @PostMapping("atividades_agricolas/excluir{id}")
    public String confirmaExcluir(Long id) {        
	AtividadeAgricola atividadeAgricola = atividadeAgricolaDao.findById(id);
        this.atividadeAgricolaDao.delete(atividadeAgricola);
	return "redirect:/atividades_agricolas";
        
    }
}

