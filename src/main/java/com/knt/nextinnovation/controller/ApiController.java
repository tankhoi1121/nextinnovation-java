/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.nextinnovation.controller;

import com.knt.pojo.Commenttour;
import com.knt.service.CommentTourService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author bruce_
 */
@Controller
@RequestMapping(value = "/api")
public class ApiController {

    @Autowired
    private CommentTourService commentTourService;

    @GetMapping("/comment_tour")
    public ResponseEntity<List<Commenttour>> getAllComentByTourId(@PathVariable int tourId) {
        return new ResponseEntity<>(this.commentTourService.getAllCommentByTourId(tourId), HttpStatus.OK);
    }
}
