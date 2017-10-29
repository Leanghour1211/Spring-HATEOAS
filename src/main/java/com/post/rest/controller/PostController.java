/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.rest.controller;

import com.post.rest.model.Comment;
import com.post.rest.model.Post;
import com.post.rest.service.SystemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Leanghour
 */
@RestController
@RequestMapping(value = "/api/posts")
public class PostController {
    @Autowired
    private SystemService systemService;
    
    @GetMapping(value = "")
    public List<Post> getPosts()
    {
        List<Post> ps=systemService.getAllPost();
        
        for(Post p : ps)
        {
            Link selflink=linkTo(methodOn(PostController.class).getPost(p.getPostId())).withSelfRel();
           
            p.removeLinks();
            p.add(selflink);
        }
        return ps;
    }
    
    @GetMapping(value = "/{id}")
    public Post getPost(@PathVariable int id)
    {
        Post post=systemService.getPost(id);
        Link selflink=linkTo(methodOn(PostController.class).getPost(id)).withSelfRel();
        Link userlink=linkTo(methodOn(UserController.class).getUser(post.getUser().getUserId())).withRel("user");
        Link commentslink=linkTo(methodOn(PostController.class).getCommentsOf(id)).withRel("comments");
        post.removeLinks();
        post.add(selflink,userlink,commentslink);
        return post;
    }
    @GetMapping(value = "/{id}/comments")
    public List<Comment> getCommentsOf(@PathVariable int id)
    {
        List<Comment> cs = systemService.getCommentsOf(id);
        
        for(Comment c : cs)
        {
            Link selflink=linkTo(methodOn(CommentController.class).getComment(c.getCommentId())).withSelfRel();
            c.removeLinks();
            c.add(selflink);
        }
        
        return cs;
    }
}
