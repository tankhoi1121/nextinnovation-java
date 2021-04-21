/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.service;

import com.knt.persistence.CustomerRepository;
import com.knt.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bruce_
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean addCustomer(Customer cust) {
        if (this.customerRepository.addCustomer(cust)) {
            return true;
        }
        return false;
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return this.customerRepository.getCustomerByEmail(email);
    }

}
