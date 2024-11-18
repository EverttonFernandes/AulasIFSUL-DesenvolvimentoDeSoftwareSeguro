package com.example.schoolSecurityAPI.demo.infrastructure.repository;

import com.example.schoolSecurityAPI.demo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findUserById(String id);
}