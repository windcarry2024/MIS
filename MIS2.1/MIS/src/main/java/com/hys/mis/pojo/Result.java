package com.hys.mis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result
{
    private Integer code;
    private String msg;
    private Object data;

    public static Result generate(int code,String msg,Object data)
    {
        return new Result(code,msg,data);
    }
    public static Result generate(int code,String msg)
    {
        return new Result(code,msg,null);
    }
}
