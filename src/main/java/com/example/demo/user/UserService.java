package com.example.demo.user;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return userRepository.findUserByMail(username)
                    .orElseThrow(() ->
                            new UsernameNotFoundException(
                                    String.format(USER_NOT_FOUND_MSG, username)));
    }

}
