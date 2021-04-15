package com.knt.nextinnovation.controller;

import com.knt.pojo.Tourdetails;
import com.knt.service.TourService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloController {
    @Autowired
    private TourService tourService;
    
    @GetMapping("/hello")
    public String hello(Model model) {

        model.addAttribute("all_tour", this.tourService.getAllTour());

        return "welcome";
    }
    
    @GetMapping("/tour/season/{id}")
    public String getTourBySeason(@PathVariable int id, Model model){
        String season = "";
        switch(id){
            case 1:
                season = "xuân";
                break;
            case 2:
                season = "hạ";
                break;
            case 3:
                season ="thu";
                break;
            case 4:
                season = "đông";
                break;
            default:
                break;
        }
        
        if(!season.isEmpty()){
            model.addAttribute("info", this.tourService.getTourBySeason(season));
        }else{
            model.addAttribute("info", "");
        }
        
        return "season";
    }
    
    
    @GetMapping("/detail")
    public String tourDetail(Model model){
        model.addAttribute("tour", this.tourService.getTourById(15212));
        return "detail";
    }
    
    @GetMapping("/order")
    public String orderTour(){
        return "order";
    }   
    @GetMapping("/test")
    public String test(Model model){
        Object[] x =  this.tourService.getTourDetailByTourId(15192).toArray();
        model.addAttribute("test", x[0]);      
        
        return "test";
    }
    
    @GetMapping("/x")
    public String x (Model model){
        model.addAttribute("x", this.tourService.x(15212));
        return "x";
    }
}
