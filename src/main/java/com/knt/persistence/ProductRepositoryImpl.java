/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.persistence;

import com.knt.pojo.Product;
import com.knt.pojo.Product_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private LocalSessionFactoryBean getSessionFactory;

    @Transactional
    @Override
    public boolean addProduct(Product p) {
        try {
            Session s = this.getSessionFactory.getObject().getCurrentSession();
            s.save(p);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public Product getProductById(int i) {

        Session s = this.getSessionFactory.getObject().getCurrentSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);
        cq.select(root).where(cb.equal(root.get(Product_.tourId), i));
        if (s.createQuery(cq).getSingleResult() == null) {
            return null;
        }
        return s.createQuery(cq).getSingleResult();
    }

}
