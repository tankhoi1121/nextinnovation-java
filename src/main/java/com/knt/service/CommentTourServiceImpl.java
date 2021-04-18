/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.service;

import com.knt.persistence.CommentTourRepository;
import com.knt.pojo.Commenttour;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bruce_
 */
@Service
public class CommentTourServiceImpl implements CommentTourService {

    @Autowired
    private CommentTourRepository commentTourRepository;

    @Override
    public boolean addComment(Commenttour ct) {
        return false;
    }

    @Override
    public List<Commenttour> getAllCommentByTourId(int tourId) {
        return this.commentTourRepository.getAllCommentByTourId(tourId);
    }

}
