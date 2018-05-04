package com.bysj.pss.controller;

import com.bysj.pss.model.ReturnValue;
import com.bysj.pss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/bysj/pss")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public ReturnValue<String> login(@RequestParam String mobile,@RequestParam String password){
        return userService.login(mobile,password);
    }
}
