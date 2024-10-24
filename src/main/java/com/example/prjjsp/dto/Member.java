package com.example.prjjsp.dto;

import lombok.Data;

@Data
public class Member {
    private String id;
    private String password;
    private String nickName;
    private String description;
}