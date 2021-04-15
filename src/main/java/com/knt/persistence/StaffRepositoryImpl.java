/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.persistence;

import com.knt.pojo.Staff;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
/**
 *
 * @author NguyenTan.Khoi
 */
@Repository
public class StaffRepositoryImpl implements  StaffRepository{
    @Autowired
    private LocalSessionFactoryBean getSessionFactory;
    
    
    
    @Transactional
    @Override
    public boolean addStaff(Staff staff) {
        try {
            Session session  = this.getSessionFactory.getObject().getCurrentSession();
//            Transaction tx;
//            tx = (Transaction) session.beginTransaction();            
            session.save(staff);
//            tx.commit();           
            
        } catch (Exception e) {
            return false;
        }
       return true;
    }
    
}
