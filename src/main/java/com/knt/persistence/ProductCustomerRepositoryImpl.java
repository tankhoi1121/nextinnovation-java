/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.persistence;

import com.knt.pojo.Customer;
import com.knt.pojo.Product;
import com.knt.pojo.ProductCustomer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bruce_
 */
@Repository
public class ProductCustomerRepositoryImpl implements ProductCustomerRepository {

    @Autowired
    private LocalSessionFactoryBean getSessionFactory;

    @Transactional
    @Override
    public boolean addPC(ProductCustomer pc) {
        try {
            Session s = this.getSessionFactory.getObject().getCurrentSession();
            s.save(pc);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
