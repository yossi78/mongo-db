package com.example.mongo_db.repository;
import com.example.mongo_db.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // Additional query methods can be defined here if needed
}
