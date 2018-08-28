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
import com.rafaelvalentim.agro.model.ApontamentoAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rafael
 */
@RestController
public class ApontamentoControllerAPI {
    
    @Autowired
    ApontamentoDAO apontamentoDao;           
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
    
    @PutMapping("api/apontamento")
    public Apontamento adicionarApontamentoAPI(@RequestBody ApontamentoAPI apontamentoApi) {        
        Apontamento apontamento = new Apontamento();
        apontamento.setBoletim(boletimDao.findById(apontamentoApi.getBoletimId()));
        apontamento.setCultura(culturaDao.findById(apontamentoApi.getCulturaId()));
        apontamento.setTalhao(talhaoDao.findById(apontamentoApi.getTalhaoId()));
        apontamento.setOperacaoAgricola(operacaoAgricolaDao.findById(apontamentoApi.getOperacaoAgricolaId()));
        apontamento.setEquipamentoPrincipal(equipamentoDao.findById(apontamentoApi.getEquipamentoPrincipalId()));
        apontamento.setEquipamentoApoio(equipamentoDao.findById(apontamentoApi.getEquipamentoApoioId()));
        apontamento.setOperadorPrincipal(operadorDao.findById(apontamentoApi.getOperadorPrincipalId()));
        apontamento.setOperadorAjudante(operadorDao.findById(apontamentoApi.getOperadorAjudanteId()));
        apontamento.setProduto(produtoDao.findById(apontamentoApi.getProdutoId()));
        apontamento.setQuantidadeProduto(apontamentoApi.getQuantidadeProduto());
        apontamento.setHectaresTrabalhados(apontamentoApi.getHectaresTrabalhados());
        apontamento.setHorasEquipamentos(apontamentoApi.getHorasEquipamentos());
        apontamento.setHorasOperadores(apontamentoApi.getHorasOperadores());
    
        return apontamentoDao.save(apontamento);
    }
}
