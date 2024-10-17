package com.hys.mis.utils;

import java.sql.*;

public class JDBCUtils
{
    String url;
    String username;
    String password;
    Connection con;
    Statement sta;
    public JDBCUtils(String database, String username, String password) throws Exception
    {
        //已经把端口号设置为了默认的3306
        url = "jdbc:mysql://localhost:3306/"+database+"?useSSL=false&allowPublicKeyRetrieval=true";
        this.username = username;
        this.password = password;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url,username,password);
        sta = con.createStatement();
    }

    public ResultSet executeQuery(String sql) throws SQLException
    {
        return sta.executeQuery(sql);
    }
}

