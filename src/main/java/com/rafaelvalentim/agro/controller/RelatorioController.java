/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import com.rafaelvalentim.agro.dao.RelatorioDAO;
import com.rafaelvalentim.agro.dao.SafraDAO;
import com.rafaelvalentim.agro.model.CustoSafraSintetico;
import com.rafaelvalentim.agro.model.Safra;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rafael
 */


@Controller
public class RelatorioController {
    
    
    RelatorioDAO relatorioDao;
    
    @Autowired
    private SafraDAO safraDao;
    
    @GetMapping("relatorio")
    public ModelAndView selecionaSafra() throws SQLException {      
        ModelAndView mv = new ModelAndView("relatorios/SelecionaSafra");
        mv.addObject("safras", safraDao.findAll());    
        mv.addObject(new Safra());
        
        return mv;
    }
    
    @GetMapping("relatorio_safra{id}")
    public ModelAndView exibeRelatorio(@RequestParam Long safraid) throws SQLException {      
        ModelAndView mv = new ModelAndView("relatorios/Relatorio");
        relatorioDao = new RelatorioDAO();
        CustoSafraSintetico c = relatorioDao.getCustoSafraSintetico(safraid);
        mv.addObject("custo", c);
        
        return mv;
    }
}
