package com.example.demo.user;

import com.example.demo.Hash256;
import jakarta.persistence.Id;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import java.util.List;
@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            UserRepository repository) {
        return args -> {
            long i = 1;
            repository.deleteById(i);
            User jean = new User("Jean", "Jean@gmail.com", "J34n",UserRole.USER);

            User marie = new User("Marie", "Marie@gmail.com", "M4r13", UserRole.USER);

            User sa = new User("sa", "sa@gmail.com", "password", UserRole.USER);


            repository.saveAll(
                    List.of(jean, marie, sa)
            );

        };


    }
}
