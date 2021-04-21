/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.service;

import com.knt.persistence.ProductCustomerRepository;
import com.knt.pojo.Customer;
import com.knt.pojo.Product;
import com.knt.pojo.ProductCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bruce_
 */
@Service
public class ProductCustomerServiceImpl implements ProductCustomerService {

    @Autowired
    private ProductCustomerRepository productCustomerRepository;

    @Override
    public boolean addPC(ProductCustomer pc) {
        if (this.productCustomerRepository.addPC(pc)) {
            return true;
        }
        return false;
    }

}
