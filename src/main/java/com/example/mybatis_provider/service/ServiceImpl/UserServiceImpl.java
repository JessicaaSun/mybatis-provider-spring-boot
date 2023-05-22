package com.example.mybatis_provider.service.ServiceImpl;

import com.example.mybatis_provider.model.User;
import com.example.mybatis_provider.model.response.UserResponse;
import com.example.mybatis_provider.repository.UserRepository;
import com.example.mybatis_provider.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public int insertNewUser(User user) {
        return userRepository.insertNewUserProvider(user);
    }

    @Override
    public int deleteUserById(int id) {
        return userRepository.deleteUserById(id);
    }

    @Override
    public int updateUserById(User user) {
        return userRepository.updateUserInfo(user);
    }
}
