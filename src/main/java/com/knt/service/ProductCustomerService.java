/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.service;

import com.knt.pojo.Customer;
import com.knt.pojo.Product;
import com.knt.pojo.ProductCustomer;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bruce_
 */
public interface ProductCustomerService {

    public boolean addPC(ProductCustomer pc);

    public List<Object> statRevenue(LocalDate fromDate, LocalDate toDate);
}
