/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.rest.controller;

import com.post.rest.model.Response;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 *
 * @author Leanghour
 */
@RestController
@RequestMapping(value = "/api")
public class startController {
    
    @GetMapping(value = "/")
    public Response startup()
    {
        Response response=new Response();
        
        Link userslink=linkTo(methodOn(UserController.class).getUsers()).withRel("all-users");
        Link postslink=linkTo(methodOn(PostController.class).getPosts()).withRel("all-posts");
        Link commentslink=linkTo(methodOn(CommentController.class).getComments()).withRel("all-comments");
        
        response.add(userslink,postslink,commentslink);
        
        return response;
    }
    
}
