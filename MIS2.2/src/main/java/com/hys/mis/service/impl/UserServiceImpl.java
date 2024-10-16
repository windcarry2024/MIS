package com.hys.mis.service.impl;

import com.hys.mis.mapper.UserMapper;
import com.hys.mis.pojo.Result;
import com.hys.mis.pojo.User;
import com.hys.mis.service.UserService;
import com.hys.mis.utils.JWTUtils;
import com.hys.mis.utils.StorageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserMapper userMapper;

    @Override
    public Result verifyUsername(User user)
    {
        User temp = userMapper.verifyUsername(user);
        if(Objects.isNull(temp))
        {
            return Result.generate(100,"用户名错误");
        }
        else
        {
            return Result.generate(200,"用户名正确");
        }
    }

    @Override
    public Result login(User user)
    {
        User temp1 = userMapper.verifyUsername(user);
        if(Objects.isNull(temp1))
        {
            return Result.generate(100,"用户名错误");
        }
        else
        {
            User temp2 = userMapper.verifyUAP(user);
            if(Objects.isNull(temp2))
            {
                return Result.generate(150,"密码错误");
            }
            else
            {
                Map<String,Object> claims = new HashMap<>();
                claims.put("username", user.getUsername());
                String token = JWTUtils.gengrateJWT(claims);
                return Result.generate(200,"登录成功",token);
            }
        }
    }

    @Override
    public Result enroll(User user)
    {
        User temp1 = userMapper.verifyUsername(user);
        if(Objects.isNull(temp1))
        {
            User temp2 = userMapper.verifyEmail(user);
            if(Objects.isNull(temp2))
            {
                userMapper.enroll(user);
                return Result.generate(200,"注册成功", user);
            }
            else
            {
                return Result.generate(100,"该邮箱已注册账号");
            }
        }
        else
        {
            return Result.generate(100,"用户名已注册");
        }
    }

    @Override
    public Result verifyEmail(User user)
    {
        User temp = userMapper.verifyEmail(user);
        if(Objects.isNull(temp))
        {
            return Result.generate(100,"找不到该邮箱");
        }
        else
        {
            return Result.generate(200,"查找到了邮箱");
        }
    }

    @Override
    public Result retrieveUsername(User user)
    {
        User temp1 = userMapper.verifyEmail(user);
        if(Objects.isNull(temp1))
        {
            return Result.generate(100,"找不到该邮箱");
        }
        else
        {
            User temp2 = userMapper.retrieveUsername(user);
            return Result.generate(200,"查找到了邮箱绑定的用户名",temp2.getUsername());
        }
    }

    @Override
    public Result retrievePWD(User user)
    {
        User temp = userMapper.verifyEmail(user);
        if(Objects.isNull(temp))
        {
            return Result.generate(100,"找不到该邮箱");
        }
        else
        {
            userMapper.retrievePWD(user);
            return Result.generate(200,"该邮箱绑定的账号的新密码修改成功！");
        }
    }

    @Override
    public Result getUID()
    {
        int UID;
        try
        {
            UID = StorageUtils.getUID();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return Result.generate(200,"获取UID成功",UID);
    }
}
