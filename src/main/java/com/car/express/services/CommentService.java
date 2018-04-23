package com.car.express.services;

import com.car.express.models.Comment;

import java.util.List;

/**
 * Created by Neeman on 18/04/2018.
 */
public interface CommentService {

    void add(Comment comment);
    List<Comment> findAll();
    Comment findById(Long id);
}
