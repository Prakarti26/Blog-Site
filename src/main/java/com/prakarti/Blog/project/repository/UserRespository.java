package com.prakarti.Blog.project.repository;

import com.prakarti.Blog.project.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends MongoRepository<User,String > {

    User findByUsernameAndPassword(String userName,String password);

    Optional<User> findByUsername(String userName);

    User findByUserIdAndOtp(String userName, Integer otp);



}
