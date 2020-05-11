package com.sjh.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回前端通用json封装实体类
 * @author SJH
 * @create 2020/4/30
 */
@Data
//全参
@AllArgsConstructor
//空参
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
