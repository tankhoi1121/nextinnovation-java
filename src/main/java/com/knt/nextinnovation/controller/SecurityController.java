/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.nextinnovation.controller;

import com.knt.pojo.Staff;
import com.knt.pojo.Tour;
import com.knt.service.CommentTourService;
import com.knt.service.StaffService;
import com.knt.service.TourService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * @author NguyenTan.Khoi
 */
@Controller
@RequestMapping(value = "/admin")
public class SecurityController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private TourService tourService;

    @Autowired
    private CommentTourService commentTourService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/add_staff")
    public String addStaff(Model model) {
        model.addAttribute("message", "");
        return "add_staff";
    }

    @PostMapping("/add_staff")
    public String add_Staff_Execute(@Valid @ModelAttribute("staff") Staff staff, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add_staff";
        }
        if (this.staffService.addStaff(staff)) {
            model.addAttribute("message", "Add Successfully");
        } else {
            model.addAttribute("message", "Can't add new staff");
        }
        return "add_staff";
    }

    @GetMapping("/staff/{id}")
    public String getStaffById(@PathVariable int id, Model model) {
        model.addAttribute("staffId", id);
        model.addAttribute("message", "");
        model.addAttribute("info", this.staffService.getStaffById(id));
        return "individual_staff";
    }

    @PostMapping("/staff/{id}")
    public String updateStaffById(@PathVariable int id, @ModelAttribute("staff") Staff staff, Model model) {

        model.addAttribute("info", this.staffService.getStaffById(id));
        if (this.staffService.updateStaff(id, staff)) {
            model.addAttribute("message", "Update Successfully");
        } else {
            model.addAttribute("message", "Can't update staff");
        }
        return "individual_staff";
    }

    @GetMapping("/add_tour")
    public String addTour(Model model) {
        model.addAttribute("message", "");
        return "add_tour";
    }

    @PostMapping("/add_tour")
    public String add_Tour_Execute(@Valid @ModelAttribute("tour") Tour tour, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add_tour";
        }

        if (this.tourService.addTour(tour)) {
            model.addAttribute("message", "Add Successfully");
        } else {
            model.addAttribute("message", "Can't add new tour");
        }

        return "add_tour";
    }

    @GetMapping("/update_tour")
    public String updateTour(Model model) {
        model.addAttribute("allTourId", this.tourService.getAllTour());
        return "update_tour";
    }

    @GetMapping("/tour/{id}")
    public String getTourById(@PathVariable int id, Model model) {
        model.addAttribute("tourId", id);
        model.addAttribute("message", "");
        model.addAttribute("info", this.tourService.getTourById(id));
        return "individual_tour";
    }

    @PostMapping("/tour/{id}")
    public String updateTourById(@PathVariable int id, @Valid @ModelAttribute("tour") Tour tour, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "invidiual_tour";
        }
        model.addAttribute("info", this.tourService.getTourById(id));
        if (this.tourService.updateTour(tour)) {
            model.addAttribute("message", "Update Successfully");
            model.addAttribute("info", null);
        } else {
            model.addAttribute("message", "Can't update tour");
        }
        return "individual_tour";
    }

}// End Class
