package com.prakarti.Blog.project.repository;

import com.prakarti.Blog.project.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CommentRespository extends MongoRepository<Comment,String > {

    Comment deleteByCommentId(String commentId);

    List<Comment> findByBlogId(String blogId, Pageable pageable);

}
