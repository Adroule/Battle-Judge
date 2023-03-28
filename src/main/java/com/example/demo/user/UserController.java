package com.example.demo.user;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@Controller
@RequestMapping(path = "connection")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/register")
    public String register(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "register";
    }

    @GetMapping("/signIn")
    public String signIn(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "signIn";
    }



    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute("user") User user){

        try{
            userService.addNewUser(user);
            return "congratulations";
        }
        catch (Exception e){
            return "register";
        }
    }

    @PostMapping("/signIn")
    public String signInUser(@ModelAttribute("user") User user){

        try{
            userService.testUser(user);
            return "congratulations";
        }
        catch (Exception e){
            return "signIn";
        }
    }

    public String wrongPassword(){
        return "Wrong Email or Password";
    }
}
