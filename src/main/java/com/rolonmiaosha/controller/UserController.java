package com.rolonmiaosha.controller;

import com.rolonmiaosha.service.UserService;
import com.rolonmiaosha.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/UserController")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    @ResponseBody
    public UserModel getUser(@RequestParam(name="id")Integer id){

        UserModel userModel = userService.getUserById(id);
        return userModel;
    }
}
