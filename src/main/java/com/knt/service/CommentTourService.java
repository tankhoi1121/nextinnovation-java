/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.service;

import com.knt.pojo.Commenttour;
import java.util.List;

/**
 *
 * @author bruce_
 */
public interface CommentTourService {

    public boolean addComment(Commenttour ct);

    public List<Commenttour> getAllCommentByTourId(int tourId);
}
