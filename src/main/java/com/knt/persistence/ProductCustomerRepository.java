/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.persistence;

import com.knt.pojo.Customer;
import com.knt.pojo.Product;
import com.knt.pojo.ProductCustomer;

/**
 *
 * @author bruce_
 */
public interface ProductCustomerRepository {

    public boolean addPC(ProductCustomer pc);
}
