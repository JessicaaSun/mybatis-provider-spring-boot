package com.example.mybatis_provider.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String gender;
    private String address;
    private String secretKey;
    private String email;
    private List<String> role;
}
