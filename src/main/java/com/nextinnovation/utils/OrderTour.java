/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nextinnovation.utils;

import com.knt.pojo.Customer;
import com.knt.pojo.Product;
import com.knt.service.CustomerService;
import com.knt.service.ProductCustomerService;
import com.knt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author bruce_
 */
public class OrderTour {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductCustomerService productCustomerService;

    public void Order(Customer cust, Product p, int qty) {
        Customer tempCust = this.customerService.getCustomerByEmail(cust.getEmail());
//        this.productCustomerService.addPC(cust, p, qty);
    }

}
