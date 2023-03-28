package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.mail = ?1")
    Optional<User> findUserByMail(String mail);

    @Query("SELECT u FROM User u WHERE u.name = ?1")
    Optional<User> findUserByName(String name);

    @Query("SELECT u FROM User u WHERE u.mail = ?1 AND u.password = ?2")
    Optional<User> findUserByMailConnection(String mail, String password);


}
