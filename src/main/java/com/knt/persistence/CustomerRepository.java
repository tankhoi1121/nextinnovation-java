/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.persistence;

import com.knt.pojo.Customer;

/**
 *
 * @author bruce_
 */
public interface CustomerRepository {

    public boolean addCustomer(Customer cust);

    public Customer getCustomerByEmail(String email);
}