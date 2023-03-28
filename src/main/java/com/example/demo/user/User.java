package com.example.demo.user;

import com.example.demo.Hash256;
import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name="userbattlejudge")
public class User implements UserDetails{
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 2
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String name;
    private String mail;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority("USER");
        return Collections.singletonList(authority);
    }

    @Override
    public String getUsername(){
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User() {
    }

    public User(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = Hash256.hash(password);
        this.role = UserRole.USER;
    }

    public User(Long id, String name, String mail, String password) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.password = Hash256.hash(password);
        this.role = UserRole.USER;
    }

    public User(String name, String mail, String password, UserRole role) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.password = Hash256.hash(password);
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Hash256.hash(password);
    }

    public UserRole getRole() {
        return role;
    }
}


