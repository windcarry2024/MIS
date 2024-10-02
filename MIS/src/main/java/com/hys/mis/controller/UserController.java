package com.hys.mis.controller;

import com.hys.mis.pojo.Result;
import com.hys.mis.pojo.User;
import com.hys.mis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    @Autowired
    UserService userService;

    @PostMapping("/verifyUsername")
    public Result verifyUsername(@RequestBody User user)
    {
        Result result = userService.verifyUsername(user);
        return result;
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user)
    {
        Result result = userService.login(user);
        return result;
    }

    @PostMapping("/enroll")
    public Result enroll(@RequestBody User user)
    {
        Result result = userService.enroll(user);
        return result;
    }

    @PostMapping("/verifyEmail")
    public Result verifyEmail(@RequestBody User user)
    {
        Result result = userService.verifyEmail(user);
        return result;
    }

    @PostMapping("/retrieveUsername")
    public Result retrieveUsername(@RequestBody User user)
    {
        Result result = userService.retrieveUsername(user);
        return result;
    }

    @PostMapping("/retrievePWD")
    public Result retrievePWD(@RequestBody User user)
    {
        Result result = userService.retrievePWD(user);
        return result;
    }

}
