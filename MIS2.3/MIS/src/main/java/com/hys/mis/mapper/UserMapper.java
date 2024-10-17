package com.hys.mis.mapper;

import com.hys.mis.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper
{
    @Select("select * from user where username = #{username}")
    User verifyUsername(User user);

    @Select("select * from user where username = #{username} and password = #{password}")
    User verifyUAP(User user);

    @Select("select * from user where email = #{email}")
    User verifyEmail(User user);

    @Insert("insert into user(username,email,password) values(#{username},#{email},#{password})")
    void enroll(User user);

    @Select("select username from user where email = #{email}")
    User retrieveUsername(User user);

    @Update("update user set password = #{password} where email = #{email}")
    void retrievePWD(User user);
}
