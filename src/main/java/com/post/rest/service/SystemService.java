/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.rest.service;

import com.post.rest.model.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leanghour
 */
@Service
public class SystemService {
    private List<User> users;
    private List<Comment> comments;
    private List<Post> posts;
    
    public SystemService()
    {
        users=new ArrayList<>();
        posts=new ArrayList<>();
        comments=new ArrayList<>();
        
        User user1=new User(1, "Leanghour","male", "leang.hour.tang@outlook.com");
        User user2=new User(2,"Leangmeng","male","leangmeng.tang@gmail.com");
        User user3=new User(3,"Leangheng","male","leangheng.lh@gmail.com");
        
        users.add(user1);users.add(user2);users.add(user3);
        
        Post post1=new Post(1, "Haloween Day", "Today I went to Halloween at Aeon mall with my friends and bro.", user1);
        Post post2=new Post(2, "Pre Holiday", "I come to Phnom Penh with my bro, Such a fun day of course.", user2);
        Post post3=new Post(3, "My Birthday today", "Thank my beloved brother for the great wish.", user3);
        Post post4=new Post(4, "Halloween Meet Crush", "OMG, She making crazy! How cute she is!!! Fallin in love for her!", user1);
        
        posts.add(post1);posts.add(post2);posts.add(post3);posts.add(post4);
        
        Comment comment1=new Comment(1, "That's good bro", post1, user3);
        Comment comment2=new Comment(2, "Thank for taking with bro", post1, user2);
        Comment comment3=new Comment(3, "That's ok to be with you", post1, user1);
        Comment comment4=new Comment(4, "Really want to go with you", post2, user3);
        Comment comment5=new Comment(5, "Come on bro!", post2, user2);
        Comment comment6=new Comment(6, "Happy birthday to you bro.", post3, user1);
        Comment comment7=new Comment(7, "Happy birthday Big brother", post3, user2);
        Comment comment8=new Comment(8, "Happy birthday to you bro.", post3, user1);
        Comment comment9=new Comment(9, "Wow, so lucky bro", post4, user2);
        Comment comment10=new Comment(10, "Such a lucky man bro", post4, user3);
        
        comments.add(comment1);comments.add(comment2);comments.add(comment3);comments.add(comment4);comments.add(comment5);
        comments.add(comment6);comments.add(comment7);comments.add(comment8);comments.add(comment9);comments.add(comment10);
        
    }
    
    public List<User> getAllUser()
    {
        return users;
    }
    public User getUser(int userId)
    {
        User user = null;
        for(User u : users)
        {
            if(u.getUserId()==userId)
            {
                user=u;break;
            }
        }
        return user;
    }
    public List<Post> getAllPost()
    {
        return posts;
    }
    public Post getPost(int postId)
    {
        Post post=null;
        for(Post p: posts)
        {
            if(p.getPostId()==postId)
            {
                post=p;break;
            }
        }
        return post;
    }
    public List<Post> getPostsBy(int userId)
    {
        List<Post> ps=new ArrayList<Post>();
        for (Post p : posts)
        {
            if(p.getUser().getUserId()==userId)
            {
                ps.add(p);
            }
        }
        return ps;
    }
    public List<Comment> getAllComment()
    {
        return comments;
    }
    
    public Comment getComment( int commentId)
    {
        Comment comment=null;
        for(Comment c : comments)
        {
            if(c.getCommentId()==commentId)
            {
                comment=c;break;
            }
        }
        return comment;
    }
    public List<Comment> getCommentsBy(int userId)
    {
        List<Comment> cs=new ArrayList<Comment>();
        for(Comment c: comments)
        {
            if(c.getUser().getUserId()==userId)
            {
                cs.add(c);
            }
        }
        return cs;
    }
    public List<Comment> getCommentsOf(int postId)
    {
        List<Comment> cs=new ArrayList<Comment>();
        for(Comment c: comments)
        {
            if(c.getPost().getPostId()==postId)
            {
                cs.add(c);
            }
        }
        return cs;
    }
}
