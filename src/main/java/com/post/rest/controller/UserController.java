/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.rest.controller;

import com.post.rest.model.Comment;
import com.post.rest.model.Post;
import com.post.rest.model.User;
import com.post.rest.service.SystemService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Leanghour
 */
@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    @Autowired
    private SystemService systemService;
    @GetMapping(value = "")
    public List<User> getUsers()
    {
        List<User> us=systemService.getAllUser();
        
        for(User u : us)
        {
            Link selflink=linkTo(methodOn(UserController.class).getUser(u.getUserId())).withSelfRel();
            u.removeLinks();
            u.add(selflink);
        }
        
        return us;
    }
    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable int id)
    {
        User user=systemService.getUser(id);
        Link postslink=linkTo(methodOn(UserController.class).getPostsBy(id)).withRel("Posts");
        Link commentslink=linkTo(methodOn(UserController.class).getCommentsBy(id)).withRel("comments");
        user.removeLinks();
        user.add(postslink,commentslink);
        return user;
    }
    @GetMapping(value = "/{id}/posts")
    public List<Post> getPostsBy(@PathVariable int id)
    {
        
        List<Post> ps=systemService.getPostsBy(id);
        
        for(Post p : ps)
        {
            p.removeLinks();
            Link selflink=linkTo(methodOn(PostController.class).getPost(p.getPostId())).withSelfRel();
            p.add(selflink);
        }
        
        return ps;
    }
    @GetMapping(value = "/{id}/comments")
    public List<Comment> getCommentsBy(@PathVariable int id)
    {
        
        List<Comment> cs=systemService.getCommentsBy(id);
        
        for(Comment c : cs)
        {
            c.removeLinks();
            Link selflink=linkTo(methodOn(CommentController.class).getComment(c.getCommentId())).withSelfRel();
            c.add(selflink);
        }
        
        return cs;
    }
}
