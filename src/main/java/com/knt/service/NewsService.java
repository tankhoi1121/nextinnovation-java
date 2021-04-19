/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.service;

import com.knt.pojo.News;
import java.util.List;

/**
 *
 * @author bruce_
 */
public interface NewsService {

    public boolean addNews(News news);

    public boolean editNews(News news);

    public List<News> getAllNews();

    public News getNewsBytId(int id);
}
