package com.prakarti.Blog.project.service;


import com.prakarti.Blog.project.repository.CommentRespository;
import com.prakarti.Blog.project.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class commentServiceImpl implements CommentService{

    @Autowired
    private CommentRespository commentRespository;

    @Override
    public Comment createComment(Comment comment){
        return commentRespository.save(comment);

    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRespository.save(comment);
    }

    @Override
    public Comment deleteComment(String commentId) {
        return commentRespository.deleteByCommentId(commentId);
    }

    @Override
    public List<Comment> getCommentsByBlog(String commentId, Pageable pageable) {
        return commentRespository.findByBlogId(commentId,pageable);
    }

}
