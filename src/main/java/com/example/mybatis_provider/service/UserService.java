package com.example.mybatis_provider.service;

import com.example.mybatis_provider.model.User;
import com.example.mybatis_provider.model.response.UserResponse;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

@Service
public interface UserService {
    public List<UserResponse> getAllUsers();
    public int insertNewUser(User user);
    public int deleteUserById(int id);
    public int updateUserById(User user);

}
