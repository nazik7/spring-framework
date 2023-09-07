package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class EmailCommentNotificationProxy implements CommentNotificationProxy{

    public void sendComment(Comment comment){
        System.out.println("Sending notification for comments: " + comment.getText());
    }
}
