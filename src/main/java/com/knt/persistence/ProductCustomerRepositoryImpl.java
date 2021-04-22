/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.persistence;

import com.knt.pojo.Customer;
import com.knt.pojo.Product;
import com.knt.pojo.ProductCustomer;
import com.knt.pojo.ProductCustomer_;
import com.knt.pojo.Product_;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CollectionJoin;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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

    @Transactional
    @Override
    public List<Object> statRevenue(LocalDate fromDate, LocalDate toDate) {
        Session s = this.getSessionFactory.getObject().getCurrentSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Product> root = cq.from(Product.class);
        CollectionJoin<Product, ProductCustomer> pc = root.join(Product_.productCustomerCollection);

        cq.multiselect(cb.prod(cb.sum(pc.get(ProductCustomer_.qty)), root.get(Product_.priceForAdult)).alias("revenue"));

        Predicate p1 = cb.greaterThanOrEqualTo(pc.get(ProductCustomer_.inputDate), convertToDateViaSqlDate(fromDate));
        Predicate p2 = cb.lessThanOrEqualTo(pc.get(ProductCustomer_.inputDate), convertToDateViaSqlDate(toDate));
        cq.having(p1, p2);
        return s.createQuery(cq).getResultList();
    }

    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }
}
