package com.hys.mis.service;

import com.hys.mis.pojo.Result;
import com.hys.mis.pojo.User;

public interface UserService
{
    Result verifyUsername(User user);
    Result login(User user);
    Result enroll(User user);
    Result verifyEmail(User user);
    Result retrieveUsername(User user);
    Result retrievePWD(User user);
    Result getUID();
}
