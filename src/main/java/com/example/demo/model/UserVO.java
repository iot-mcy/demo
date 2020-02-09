package com.example.demo.model;

import lombok.Data;

import java.util.Date;

@Data
//@Builder
public class UserVO {
    private int id;

    private String username;

    private String email;

    private String password;
    
    private Date createTime;
}
