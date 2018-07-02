/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelvalentim.festa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 *
 * @author Rafael.Valentim
 */

@Configuration
public class InMemorySecurityConfig {
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
    builder.inMemoryAuthentication().withUser("rafael").password("{noop}rafael123").roles("USER");
    }    
}
