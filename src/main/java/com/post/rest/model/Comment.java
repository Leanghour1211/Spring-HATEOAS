/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.rest.model;

import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Leanghour
 */
public class Comment extends ResourceSupport{
    private int commentId;
    private String comment;
    private Post post;
    private User user;

    public Comment(int commentId, String comment, Post post, User user) {
        this.commentId = commentId;
        this.comment = comment;
        this.post = post;
        this.user = user;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" + "commentId=" + commentId + ", comment=" + comment + ", post=" + post + ", user=" + user + '}';
    }
    
}
