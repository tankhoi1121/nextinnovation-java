/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.persistence;

import com.knt.pojo.News;
import com.knt.pojo.News_;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
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
public class NewsRepositoryImpl implements NewsRepository {

    @Autowired
    private LocalSessionFactoryBean getSessionFactory;

    @Transactional
    @Override
    public boolean addNews(News news) {
        try {
            Session session = this.getSessionFactory.getObject().getCurrentSession();
            session.save(news);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public boolean editNews(News news) {
        try {
            Session session = this.getSessionFactory.getObject().getCurrentSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaUpdate<News> cu = cb.createCriteriaUpdate(News.class);
            Root<News> root = cu.from(News.class);
            cu.set("content", news.getContent());
            cu.where(cb.equal(root.get(News_.id), news.getId()));
            session.createQuery(cu).executeUpdate();

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public List<News> getAllNews() {
        Session session = this.getSessionFactory.getObject().getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<News> cq = cb.createQuery(News.class);
        Root<News> root = cq.from(News.class);
        cq.select(root);
        return session.createQuery(cq).getResultList();
    }

    @Transactional
    @Override
    public News getNewsBytId(int i) {
        Session session = this.getSessionFactory.getObject().getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<News> cq = cb.createQuery(News.class);
        Root<News> root = cq.from(News.class);
        cq.select(root).where(cb.equal(root.get(News_.id), i));
        return session.createQuery(cq).getSingleResult();
    }
}
