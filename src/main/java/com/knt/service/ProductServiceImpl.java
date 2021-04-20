/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.service;

import com.knt.persistence.ProductRepository;
import com.knt.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bruce_
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean addProduct(Product p) {
        if (this.productRepository.addProduct(p)) {
            return true;
        }
        return false;
    }

    @Override
    public Product getProductById(int tourId) {
        return this.productRepository.getProductById(tourId);
    }

}
