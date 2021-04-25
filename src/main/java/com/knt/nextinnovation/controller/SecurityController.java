/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.nextinnovation.controller;

import com.knt.persistence.ProductRepository;
import com.knt.pojo.Commenttour;
import com.knt.pojo.News;
import com.knt.pojo.Product;
import com.knt.pojo.ProductCustomer;
import com.knt.pojo.ProductCustomer_;
import com.knt.pojo.Staff;
import com.knt.pojo.Tour;
import com.knt.pojo.Tourdetails;
import com.knt.service.CommentTourService;
import com.knt.service.NewsService;
import com.knt.service.ProductCustomerService;
import com.knt.service.StaffService;
import com.knt.service.TourService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

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
import org.hibernate.Session;
import org.json.JSONObject;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.MediaType;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author NguyenTan.Khoi
 */
@Controller
@RequestMapping(value = "/admin")
public class SecurityController {

    @Autowired
    private LocalSessionFactoryBean getSessionFactory;

    @Autowired
    private StaffService staffService;

    @Autowired
    private TourService tourService;

    @Autowired
    private CommentTourService commentTourService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private ProductCustomerService productCustomerService;

    @Autowired
    private ProductRepository productRepository;

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

    @GetMapping("/tour_delete/{id}")
    public String deleteTourById(@PathVariable int id) {
        this.tourService.deleteTour(id);
        return "redirect:http://localhost:8080/nextinnovation/admin/update_tour";
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

    @PostMapping("/add_comment_tour")
    public @ResponseBody
    Commenttour addCommentTour(@RequestBody Commenttour ct) {
        this.commentTourService.addComment(ct);
        Commenttour commenttour = new Commenttour();
        return ct;
    }

    @GetMapping("/add_tour_detail")
    public String addTourDetailsUI() {
        return "add_tour_detail";
    }

    @PostMapping("/add_tour_detail")
    public @ResponseBody
    List<Tourdetails> addTourDetails(@RequestBody List<Tourdetails> tourDetails) {
        this.tourService.addListTourDetails(tourDetails);
        return tourDetails;
    }

    @GetMapping("/add_news")
    public String addNews() {
        return "add_news";
    }

    @PostMapping("/add_news")
    public String addNewsExe(@ModelAttribute("news") News news, Model model) {
        this.newsService.addNews(news);
        return "add_news";
    }

    @GetMapping("/edit_news/{id}")
    public String editNews(@PathVariable int id, Model model) {
        model.addAttribute("newsId", id);
        return "edit_news";
    }

    @PostMapping("/edit_news/{id}")
    public String editNewsExe(@PathVariable int id, @ModelAttribute("news") News news, Model model) {
        model.addAttribute("newsId", id);
        this.newsService.editNews(news);
        return "edit_news";
    }

    @GetMapping("/delete_news")
    public String deleteNews(int newsId) {
        return "confirm_news";
    }

    @GetMapping("all_news")
    public String getAllNews(Model model) {
        model.addAttribute("allnews", this.newsService.getAllNews());
        return "all_news";
    }

    @GetMapping("add_product")
    public String addProductUI(Model model) {
        return "add_product";
    }

    @PostMapping("add_product")
    public String addProductExec(@ModelAttribute("product") Product p, Model model) {
        this.productRepository.addProduct(p);
        return "add_product";
    }

    @GetMapping("statistics_revenue")
    public String StatisticsRevenue() {

        return "statistics_revenue";
    }

    @PostMapping("statistics_revenue")
    public @ResponseBody
    List<Object> StatisticsRevenueExec(@RequestBody String[] o) {

        String[] fromDate = o[0].toString().split("-");
        String[] toDate = o[1].toString().split("-");
        List<Object> list = this.productCustomerService.statRevenue(LocalDate.of(Integer.parseInt(fromDate[0]), Integer.parseInt(fromDate[1]), Integer.parseInt(fromDate[2])), LocalDate.of(Integer.parseInt(toDate[0]), Integer.parseInt(toDate[1]), Integer.parseInt(toDate[2])));

        return list;
    }

    @Transactional
    @GetMapping("test_data")
    public @ResponseBody
    List<Object> test() {

        Session s = this.getSessionFactory.getObject().getCurrentSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<ProductCustomer> root = cq.from(ProductCustomer.class);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        cq.multiselect(cb.function("month", Integer.class, root.get(ProductCustomer_.inputDate)),
                cb.function("year", Integer.class, root.get(ProductCustomer_.inputDate)));
        return s.createQuery(cq).getResultList();
    }

}// End Class
