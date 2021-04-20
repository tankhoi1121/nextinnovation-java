/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.service;

import com.knt.pojo.Product;

/**
 *
 * @author bruce_
 */
public interface ProductService {

    public boolean addProduct(Product p);

    public Product getProductById(int tourId);
}
