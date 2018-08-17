/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.ApontamentoDAO;
import com.rafaelvalentim.agro.dao.BoletimDAO;
import com.rafaelvalentim.agro.dao.CulturaDAO;
import com.rafaelvalentim.agro.dao.EquipamentoDAO;
import com.rafaelvalentim.agro.dao.OperacaoAgricolaDAO;
import com.rafaelvalentim.agro.dao.OperadorDAO;
import com.rafaelvalentim.agro.dao.ProdutoDAO;
import com.rafaelvalentim.agro.dao.SafraDAO;
import com.rafaelvalentim.agro.dao.TalhaoDAO;
import com.rafaelvalentim.agro.dao.UnidadeProdutivaDAO;
import com.rafaelvalentim.agro.model.Apontamento;
import com.rafaelvalentim.agro.model.Boletim;
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
public class ApontamentoController {
    @Autowired
    private ApontamentoDAO apontamentoDao;
    @Autowired
    private BoletimDAO boletimDao;
    @Autowired
    private SafraDAO safraDao;
    @Autowired
    private UnidadeProdutivaDAO unidadeProdutivaDao;       
    @Autowired
    private CulturaDAO culturaDao;       
    @Autowired
    private TalhaoDAO talhaoDao;       
    @Autowired
    private OperacaoAgricolaDAO operacaoAgricolaDao;       
    @Autowired
    private EquipamentoDAO equipamentoDao;       
    @Autowired
    private OperadorDAO operadorDao;       
    @Autowired
    private ProdutoDAO produtoDao;       

    
    @GetMapping("boletim/apontamentos")
    public ModelAndView listarTodos(Boletim boletim, @RequestParam("unidadeid") Long unidadeid, @RequestParam("safraid") Long safraid) {
        ModelAndView mv = new ModelAndView("apontamentos/ListarApontamentos");
        boletim.setSafra(safraDao.findById(safraid));
        boletim.setUnidadeProdutiva(unidadeProdutivaDao.findById(unidadeid));
        boletimDao.save(boletim);
        mv.addObject("boletins", boletim);                
        return mv;
    }
    
    @GetMapping("apontamentos/detalhar{id}")
    public ModelAndView detalhe(Long id) {
        ModelAndView mv = new ModelAndView("apontamentos/DetalharApontamento");
        mv.addObject("apontamento", apontamentoDao.findById(id));
	return mv;
    }
    
    @GetMapping("apontamentos/adicionar{id}")
        public ModelAndView adicionar(Long id) {       
        ModelAndView mv = new ModelAndView("apontamentos/AdicionarApontamento");
        mv.addObject("boletim", boletimDao.findById(id));
        mv.addObject("culturas", culturaDao.findAll());
        mv.addObject("talhoes", talhaoDao.findAll());
        mv.addObject("operacoesAgricolas", operacaoAgricolaDao.findAll());
        mv.addObject("equipamentos", equipamentoDao.findAll());
        mv.addObject("operadores", operadorDao.findAll());
        mv.addObject("produtos", produtoDao.findAll());
        mv.addObject(new Apontamento());        
	return mv;
    }
        
    @PostMapping("apontamentos/adicionar{id}")
    public String confirmaAdicionar(Apontamento apontamento, 
            @RequestParam("boletimid") Long boletimid,
            @RequestParam("culturaid") Long culturaid,
            @RequestParam("talhaoid") Long talhaoid,
            @RequestParam("operacaoid") Long operacaoid,
            @RequestParam("equipamentoid") Long equipamentoid,
            @RequestParam("equipamentoapoioid") Long equipamentoapoioid,
            @RequestParam("operadorid") Long operadorid,
            @RequestParam("operadorapoioid") Long operadorapoioid,
            @RequestParam("produtoid") Long produtoid) {
        
        apontamento.setBoletim(boletimDao.findById(boletimid));
        apontamento.setCultura(culturaDao.findById(culturaid));
        apontamento.setTalhao(talhaoDao.findById(talhaoid));
        apontamento.setOperacaoAgricola(operacaoAgricolaDao.findById(operacaoid));
        apontamento.setEquipamentoPrincipal(equipamentoDao.findById(equipamentoid));
        apontamento.setEquipamentoApoio(equipamentoDao.findById(equipamentoapoioid));
        apontamento.setOperadorPrincipal(operadorDao.findById(operadorid));
        apontamento.setOperadorAjudante(operadorDao.findById(operadorapoioid));
        apontamento.setProduto(produtoDao.findById(produtoid));
        
        this.apontamentoDao.save(apontamento);
        return "redirect:/apontamentos/adicionar?id="+boletimid;        
    }
    
    @PostMapping("apontamentos/excluir{id}")
    public String confirmaExcluir(Long id) {        
	Apontamento apontamento = apontamentoDao.findById(id);
        this.apontamentoDao.delete(apontamento);
	return "redirect:/boletins";
        
    }
   
}
