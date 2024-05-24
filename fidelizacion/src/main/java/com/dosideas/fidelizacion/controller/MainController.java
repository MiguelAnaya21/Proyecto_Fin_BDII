/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dosideas.fidelizacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author alopezorozco
 */
@Controller
public class MainController {
    
    @GetMapping("/")
    public String home(){
        return "home";
    }
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }   
}