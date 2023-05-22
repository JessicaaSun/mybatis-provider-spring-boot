package com.example.mybatis_provider.repository;

import com.example.mybatis_provider.model.User;
import com.example.mybatis_provider.model.response.UserResponse;
import com.example.mybatis_provider.repository.providers.UserProvider;
import jakarta.websocket.OnOpen;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;

@Repository
@Mapper
public interface UserRepository {

    @SelectProvider(type = UserProvider.class, method = "getAllUsers")
    @Results({
            @Result(property = "secretKey", column = "secret_key"),
            @Result(property = "id", column = "id"),
            @Result(property = "roles", column = "id", javaType = List.class, many = @Many(select = "findRolesByUserID"))
    })
    public List<UserResponse> getAllUsers();

    @SelectProvider(type = UserProvider.class, method="getRolesByUserId")
    List<String> findRolesByUserID(int id);

//    @Select("insert into users_tb ( username, gender, address, secret_key, email)\n" +
//            "values ('Mona Lisa', 'female', 'Kompong Cham','43424','lisa@gmail.com' ) returning id")
//    int insertNewUser(@Param("user")User user);

    @InsertProvider(type = UserProvider.class, method = "insertNewUser")
    @Options(useGeneratedKeys = true, keyProperty = "user.id", keyColumn = "id")
    int insertNewUserProvider(@Param("user") User user);

    @DeleteProvider(type = UserProvider.class, method = "deleteUserById")
    int deleteUserById(int id);

    @UpdateProvider(type = UserProvider.class, method = "updateUserById")
    int updateUserInfo(@Param("user") User user);
}
