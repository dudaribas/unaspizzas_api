package com.unaspizzas_api.controller;

import com.unaspizzas_api.model.dto.LoginDTO;
import com.unaspizzas_api.model.entity.User;
import com.unaspizzas_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }

}
