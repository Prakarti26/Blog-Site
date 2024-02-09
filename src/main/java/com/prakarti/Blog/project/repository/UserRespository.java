package com.prakarti.Blog.project.jpa;

import com.prakarti.Blog.project.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends MongoRepository<User,String > {

    User findByUserNameAndPassword(String userName,String password);
}
