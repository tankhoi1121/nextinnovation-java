/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.service;

import com.knt.persistence.NewsRepository;
import com.knt.pojo.News;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bruce_
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public boolean addNews(News news) {
        if (this.newsRepository.addNews(news)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean editNews(News news) {
        if (this.newsRepository.editNews(news)) {
            return true;
        }
        return false;
    }

    @Override
    public List<News> getAllNews() {
        return this.newsRepository.getAllNews();
    }

    @Override
    public News getNewsBytId(int i) {
        return this.newsRepository.getNewsBytId(i);
    }

}
