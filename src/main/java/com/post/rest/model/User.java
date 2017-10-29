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
public class User extends ResourceSupport{
    private int userId;
    private String name;
    private String gender;
    private String contact;
    private List<Post> posts;
    private List<Comment> comments;

    public User(int userId, String name, String gender, String contact) {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.contact = contact;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", name=" + name + ", gender=" + gender + ", contact=" + contact + ", posts=" + posts + ", comments=" + comments + '}';
    }
    
}
