package com.example.mongo_db.service;
import com.example.mongo_db.exception.ResourceNotFoundException;
import com.example.mongo_db.model.User;
import com.example.mongo_db.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User createUser(User user) {
        return userRepository.save(user);
    }


    public User getUser(String userId) {
        User user = checkUserExistance(userId);
        return user;
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        if(users==null){
            log.error("The users have not been found");
            throw new ResourceNotFoundException("The users have not been found");
        }
        log.info("Retrieved all users, total count: " + users.size());
        return users;
    }



    public void deleteUser(String userId) {
        checkUserExistance(userId);
        userRepository.deleteById(String.valueOf(userId));
    }


    public User updateUser(String userId, User updatedUser) {
        checkUserExistance(userId);
        updatedUser.setId(userId);
        return userRepository.save(updatedUser);
    }


    private User checkUserExistance(String userId){
        User user =  userRepository.findById(String.valueOf(userId)).orElse(null);
        if(user==null){
            log.error("The user has not been found , userId="+userId);
            throw new ResourceNotFoundException("The user has not been found");
        }
        log.info("Find user by id: " + userId);
        return user;
    }


}
