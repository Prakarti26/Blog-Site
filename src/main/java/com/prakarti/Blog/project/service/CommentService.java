package com.prakarti.Blog.project.service;

import com.prakarti.Blog.project.entity.Comment;

import java.awt.print.Pageable;
import java.util.List;

public interface CommentService {

    Comment createComment(Comment comment);

    Comment updateComment(Comment comment);

    Comment deleteComment(String commentId);

    List<Comment> getCommentsByBlog(String commentId, Pageable pageable);

}
