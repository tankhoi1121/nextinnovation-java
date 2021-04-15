/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.persistence;

import com.knt.pojo.Staff;
import com.knt.pojo.Staff_;
import javax.persistence.TypedQuery;
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
public class StaffRepositoryImpl implements StaffRepository {

    @Autowired
    private LocalSessionFactoryBean getSessionFactory;

    @Transactional
    @Override
    public boolean addStaff(Staff staff) {
        try {
            Session session = this.getSessionFactory.getObject().getCurrentSession();
            Transaction tx;
            tx = (Transaction) session.beginTransaction();
            session.save(staff);
            tx.commit();

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //// De kiem tra lai
    @Transactional
    @Override
    public boolean updateStaff(int staffId, Staff staff) {
        try {
            Session session = this.getSessionFactory.getObject().getCurrentSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaUpdate<Staff> cu = cb.createCriteriaUpdate(Staff.class);
            Root<Staff> root = cu.from(Staff.class);
            Staff _stafflocal = this.getStaffById(staffId);


            if (!_stafflocal.equals(staff)) {
                cu.set("name", staff.getName());
                cu.set("address", staff.getAddress());
                cu.set("phone", staff.getPhone());
                cu.set("email", staff.getEmail());
                cu.set("department", staff.getDepartment());
                cu.set("role", staff.getRole());
                cu.where(cb.equal(root.get(Staff_.id), staffId));
                session.createQuery(cu).executeUpdate();
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public Staff getStaffById(int i) {
        Session session = this.getSessionFactory.getObject().getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Staff> cq = cb.createQuery(Staff.class);
        Root<Staff> root = cq.from(Staff.class);
        cq.select(root).where(cb.equal(root.get(Staff_.id), i));
        TypedQuery<Staff> q = session.createQuery(cq);
        return q.getSingleResult();
    }

}
