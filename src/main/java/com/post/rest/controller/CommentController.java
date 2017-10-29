/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.rest.controller;

import com.post.rest.model.Comment;
import com.post.rest.service.SystemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Leanghour
 */
@RestController
@RequestMapping(value = "/api/comments")
public class CommentController {
    @Autowired
    private SystemService systemService;
    
    @GetMapping(value = "")
    public List<Comment> getComments()
    {
        List<Comment> cs=systemService.getAllComment();
        
        for(Comment c : cs)
        {
            Link selflink=linkTo(methodOn(CommentController.class).getComment(c.getCommentId())).withSelfRel();
            c.removeLinks();
            c.add(selflink);
        }
        
        return cs;
    }
    
    @GetMapping(value = "/{id}")
    public Comment getComment(@PathVariable int id)
    {
        Comment comment=systemService.getComment(id);
        Link selflink=linkTo(methodOn(CommentController.class).getComment(id)).withSelfRel();
        Link postlink=linkTo(methodOn(PostController.class).getPost(comment.getPost().getPostId())).withRel("post");
        Link userlink=linkTo(methodOn(UserController.class).getUser(comment.getUser().getUserId())).withRel("user");
        comment.removeLinks();
        comment.add(selflink,postlink,userlink);
        
        return comment;
    }
}
