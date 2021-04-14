/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.persistence;

import com.knt.pojo.Tour;
import com.knt.pojo.Tour_;
import com.knt.pojo.Tourdetails;
import com.knt.pojo.Tourdetails_;
import java.util.Collection;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CollectionJoin;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

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

public class TourRepositoryImpl implements TourRepository {
    
    @Autowired
    private LocalSessionFactoryBean getSessionFactory;
    
    @Transactional
    @Override
    public Tour getTourById(int id) {
        Session session = this.getSessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Tour> cq = cb.createQuery(Tour.class);
        
        Root<Tour> tour = cq.from(Tour.class);
        Predicate filterTourById = cb.equal(tour.get("id"), id);
        cq.where(filterTourById);
        
        TypedQuery<Tour> query = session.createQuery(cq);
        return query.getSingleResult();
    }
    
    @Transactional
    @Override
    public List<Tourdetails> getTourDetailByTourId(int tourId) {
        Session session = this.getSessionFactory.getObject().getCurrentSession();        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery cq = criteriaBuilder.createQuery();
        Root<Tour> root = cq.from(Tour.class);
        CollectionJoin<Tour,Tourdetails> detail = root.join(Tour_.tourdetailsCollection);
        cq.multiselect(detail.get(Tourdetails_.header), detail.get(Tourdetails_.description)).where(criteriaBuilder.equal(detail.get(Tourdetails_.tourId), tourId));
        TypedQuery<Tourdetails> q = session.createQuery(cq);
        List<Tourdetails> res = q.getResultList();
        return res;
    }

    @Transactional
    @Override
    public Tourdetails x(int tourId) {
        Session session = this.getSessionFactory.getObject().getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Tourdetails> root = cq.from(Tourdetails.class);
        cq.select(root).where(cb.equal(root.get(Tourdetails_.tourId), tourId));
        TypedQuery<Tourdetails> q = session.createQuery(cq).setFirstResult(0).setMaxResults(1);
        return q.getSingleResult();
    }
    
}
