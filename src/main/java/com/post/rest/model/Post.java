/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.rest.model;

import java.util.List;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Leanghour
 */
public class Post extends ResourceSupport{
    private int postId;
    private String title;
    private String description;
    private User user;
    private List<Comment> comments;

    public Post(int postId, String title, String description, User user) {
        this.postId = postId;
        this.title = title;
        this.description = description;
        this.user = user;
    }
    
    

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" + "postId=" + postId + ", title=" + title + ", description=" + description + ", user=" + user + ", comments=" + comments + '}';
    }
    
}
