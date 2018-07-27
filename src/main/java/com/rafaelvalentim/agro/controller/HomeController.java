/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Rafael.Valentim
 */
@Controller
public class HomeController {
    
    @GetMapping("/")
    public ModelAndView home(){
    ModelAndView mv = new ModelAndView("Home");
    return mv;
    }
    
    @GetMapping("/layout")
    public ModelAndView layout(){
    ModelAndView mv = new ModelAndView("Layout");
    return mv;
    }
    
    @GetMapping("/content")
    public ModelAndView content(){
    ModelAndView mv = new ModelAndView("Content");
    return mv;
    }
}
