package com.hys.mis.utils;

import java.sql.ResultSet;

public class StorageUtils
{
    public static String token = "";

    public static int getUID() throws Exception
    {
        String username = JWTUtils.getUsername(token);
        JDBCUtils jdbc = new JDBCUtils("mis","root","1234");
        ResultSet rs = jdbc.executeQuery("select uid from user where username = '"+username+"'");
        rs.next();
        int uid = rs.getInt("uid");
        return uid;
    }
}
