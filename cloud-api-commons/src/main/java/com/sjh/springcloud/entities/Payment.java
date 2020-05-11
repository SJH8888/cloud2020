package com.sjh.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 支付实体类 Payment表
 * @author SJH
 * @create 2020/5/7
 */
@Data
//全参
@AllArgsConstructor
//空参
@NoArgsConstructor
public class Payment implements Serializable {

    private Long id;
    private String serial;
}