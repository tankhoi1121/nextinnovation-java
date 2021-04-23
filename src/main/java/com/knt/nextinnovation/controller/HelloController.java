package com.knt.nextinnovation.controller;

import com.knt.pojo.Customer;
import com.knt.pojo.Product;
import com.knt.pojo.ProductCustomer;
import com.knt.pojo.Tourdetails;
import com.knt.service.CommentTourService;
import com.knt.service.CustomerService;
import com.knt.service.NewsService;
import com.knt.service.ProductCustomerService;
import com.knt.service.ProductService;
import com.knt.service.TourService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TourService tourService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCustomerService productCustomerService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private CommentTourService commentTourService;

    @GetMapping("/hello")
    public String hello(Model model) {

        model.addAttribute("all_tour", this.tourService.getAllTour());

        return "welcome";
    }

    @GetMapping("/tour/season/{id}")
    public String getTourBySeason(@PathVariable int id, Model model) {
        String season = "";
        switch (id) {
            case 1:
                season = "xuân";
                break;
            case 2:
                season = "hạ";
                break;
            case 3:
                season = "thu";
                break;
            case 4:
                season = "đông";
                break;
            default:
                break;
        }

        if (!season.isEmpty()) {
            if (this.tourService.getTourBySeason(season) == null) {
                model.addAttribute("info", "");
            } else {
                model.addAttribute("info", this.tourService.getTourBySeason(season));
            }

        } else {
            model.addAttribute("info", "");
        }

        return "season";
    }

    @GetMapping("/td/{id}")
    public String tourDetail(@PathVariable int id, Model model) {
        model.addAttribute("tour", this.tourService.getTourById(id) != null ? this.tourService.getTourById(id) : null);

        model.addAttribute("ok", this.tourService.getTourDetailByTourId(id) != null ? this.tourService.getTourDetailByTourId(id) : null);

        model.addAttribute("product", this.productService.getProductById(id) != null ? this.productService.getProductById(id) : null);

        model.addAttribute("allCommentTour", this.commentTourService.getAllCommentByTourId(id) != null ? this.commentTourService.getAllCommentByTourId(id) : "");
        return "detail";
    }

    @GetMapping("/order/{id}")
    public String orderTour(@PathVariable int id, Model model) {
        model.addAttribute("product", this.productService.getProductById(id));
        return "order";
    }

    @PostMapping("/order_confirm")
    public @ResponseBody
    String OrderExec(@RequestBody Object[] list) {
        JSONObject obj = new JSONObject(list[0].toString());

        Customer cust = new Customer();
        cust.setName(obj.getString("name"));
        cust.setAddress(obj.getString("address"));
        cust.setPhone(obj.getString("phone"));
        cust.setEmail(obj.getString("email"));

        this.customerService.addCustomer(cust);
        Customer tempCust = this.customerService.getCustomerByEmail(cust.getEmail());
        JSONObject obj_1 = new JSONObject(list[1].toString());
        Product p = this.productService.getProductById(Integer.parseInt(obj_1.getString("tourId")));

        ProductCustomer pc = new ProductCustomer();

        pc.setProductId(p);
        pc.setCustomerId(tempCust);
        JSONObject obj_2 = new JSONObject(list[2].toString());
        pc.setQty(Integer.parseInt(obj_2.getString("qty")));
        pc.setConfirmStatus("OK");
        pc.setInputDate(new Date());
        if (!this.productCustomerService.addPC(pc)) {
            return null;
        }
        return "Success";
//        return null;
    }

    @GetMapping("/test")
    public String test(Model model) {
        Object[] x = this.tourService.getTourDetailByTourId(15192).toArray();
        model.addAttribute("test", x[0]);

        return "test";
    }

    @GetMapping("/x")
    public String x(Model model) {
        model.addAttribute("x", this.tourService.x(15212));
        return "x";
    }

    @GetMapping("all_news")
    public String getAllNews(Model model) {
        model.addAttribute("allnews", this.newsService.getAllNews());
        return "all_news_1";
    }

    @GetMapping("/news_detail/{id}")
    public String newsDetail(@PathVariable int id, Model model) {
        model.addAttribute("news", this.newsService.getNewsBytId(id));
        return "news_detail";
    }

}//End Class
