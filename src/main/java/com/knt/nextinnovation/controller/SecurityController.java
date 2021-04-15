/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.nextinnovation.controller;


import com.knt.pojo.Staff;
import com.knt.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author NguyenTan.Khoi
 */
@Controller
@RequestMapping(value = "/admin")
public class SecurityController {
    
    @Autowired
    private StaffService staffService;
    
    
    @GetMapping("/add_staff")
    public String addStaff(Model model){
        model.addAttribute("message","");
        return "add_staff";
    }
    @PostMapping("/add_staff")
    public String add_Staff_Execute(@ModelAttribute("staff") Staff staff, Model model){
        if(this.staffService.addStaff(staff)){
            model.addAttribute("message", "Add Successfully");
        }else{
            model.addAttribute("message", "Can't add new staff");
        }        
        return "add_staff";
    }
}
