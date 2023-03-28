package com.example.demo.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByMail(user.getMail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("Mail taken");
        }

        userOptional = userRepository.findUserByName(user.getName());
        if(userOptional.isPresent()){
            throw new IllegalStateException("Name taken");
        }
        userRepository.saveAndFlush(user);
    }

    public void testUser(User user) {
        Optional<User> userOptional = userRepository.findUserByMailConnection(user.getMail(), user.getPassword());
        if(!userOptional.isPresent()){
            throw new IllegalStateException("Mail taken");
        }

    }
}
