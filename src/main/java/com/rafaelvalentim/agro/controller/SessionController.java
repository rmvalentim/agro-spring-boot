/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.agro.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author rafael
 */
@Controller
public class SessionController {
    @GetMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();        
        return "redirect:/";
    }
}
