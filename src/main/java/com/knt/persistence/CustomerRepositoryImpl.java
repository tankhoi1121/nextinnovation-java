/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.persistence;

import com.knt.pojo.Customer;
import com.knt.pojo.Customer_;
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
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private LocalSessionFactoryBean getSessionFactory;

    @Transactional
    @Override
    public boolean addCustomer(Customer cust) {
        try {
            Session s = this.getSessionFactory.getObject().getCurrentSession();
            s.save(cust);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public Customer getCustomerByEmail(String email) {
        Session s = this.getSessionFactory.getObject().getCurrentSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> root = cq.from(Customer.class);
        cq.select(root).where(cb.equal(root.get(Customer_.email), email));
        return s.createQuery(cq).getSingleResult();
    }

}
