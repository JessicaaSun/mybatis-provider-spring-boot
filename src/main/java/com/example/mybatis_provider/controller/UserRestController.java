package com.example.mybatis_provider.controller;

import com.example.mybatis_provider.model.User;
import com.example.mybatis_provider.model.response.UserResponse;
import com.example.mybatis_provider.service.UserService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
    private  final UserService userService;
    UserRestController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/all-users")
    public List<UserResponse> getAllUsers(){
        try{
            List<UserResponse> responses = userService.getAllUsers();
            return responses;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @PostMapping("/new-user")
    public User addNewUser(@RequestBody User user){
        try {
            int affectedRow = userService.insertNewUser(user);
            if(affectedRow>0) {
                return user;
            }
            else return null;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable int id){
        try {
            int affectedRow = userService.deleteUserById(id);
            System.out.println(affectedRow);
            return "delete successfully";
        } catch (Exception ex){
            ex.printStackTrace();
            return "fail to delete";
        }
    }

    @PatchMapping("/update-user/{id}")
    public String updateUser(@PathVariable int id , @RequestBody User user){
        try {
            user.setId(id);
            int affectedRow = userService.updateUserById(user);
            System.out.println(affectedRow);
            return "Update successfully";
        } catch (Exception ex){
            ex.printStackTrace();
            return "Fail to update";
        }

    }

}
