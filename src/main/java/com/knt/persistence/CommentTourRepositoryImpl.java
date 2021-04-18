/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.persistence;

import com.knt.pojo.Commenttour;
import com.knt.pojo.Commenttour_;
import java.util.List;
import javax.persistence.TypedQuery;
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
public class CommentTourRepositoryImpl implements CommentTourRepository {

    @Autowired
    private LocalSessionFactoryBean getSessionFactory;

    @Transactional
    @Override
    public boolean addComment(Commenttour ct) {
        try {
            Session session = this.getSessionFactory.getObject().getCurrentSession();
            session.save(ct);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public List<Commenttour> getAllCommentByTourId(int tourId) {
        Session session = this.getSessionFactory.getObject().getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Commenttour> query = cb.createQuery(Commenttour.class);
        Root<Commenttour> root = query.from(Commenttour.class);
        query.select(root).where(cb.equal(root.get(Commenttour_.tourId), tourId));
        TypedQuery<Commenttour> q = session.createQuery(query);
        return q.getResultList();
    }

}
