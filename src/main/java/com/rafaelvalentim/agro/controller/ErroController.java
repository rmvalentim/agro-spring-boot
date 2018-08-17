/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rafael
 */
@Controller
public class ErroController implements ErrorController{

  @RequestMapping("/error")
  @ResponseBody
  public ModelAndView handleError(HttpServletRequest request) {
      ModelAndView mv = new ModelAndView("erros/Erro");               
      return mv;
  }
    
    @Override
    public String getErrorPath() {
        return "/error";
    }
    
}
