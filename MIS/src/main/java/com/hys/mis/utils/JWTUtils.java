package com.hys.mis.utils;

import io.jsonwebtoken.*;
import java.util.Date;
import java.util.Map;

public class JWTUtils
{
    private static String signKey = "MISSignKey";
    private static long expire = 4320*10000;

    public static String gengrateJWT(Map<String,Object> claims)
    {
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,signKey)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+expire))
                .compact();
        return jwt;
    }

    public static Boolean verifyJWT(String jwt)
    {
        try
        {
            Jwts.parser().setSigningKey(signKey).parseClaimsJws(jwt);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
