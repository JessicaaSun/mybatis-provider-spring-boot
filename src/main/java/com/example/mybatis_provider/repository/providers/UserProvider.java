package com.example.mybatis_provider.repository.providers;

import com.example.mybatis_provider.model.User;
import org.apache.ibatis.jdbc.SQL;

public class UserProvider {
    public static String getAllUsers(){
        return new SQL(){{
            SELECT("*");
            FROM("users_tb");
        }}.toString();
    }

    public static String getRolesByUserId(int id){
        return new SQL(){{
            SELECT("rt.role");
            FROM("user_role_tb urt"); // Corrected table alias
            INNER_JOIN("role_tb rt ON urt.role_id = rt.id");
            WHERE("urt.user_id = #{id}");
        }}.toString();
    }
    public static String getAllUsers2(){
        return new SQL()
                .SELECT("*")
                .FROM("users_tb")
                .toString();
    }

    public static String insertNewUser(User user){
        return new SQL(){{
            INSERT_INTO("users_tb");
            VALUES("username ", "#{user.username}");
            VALUES("gender ", "#{user.gender}");
            VALUES("address ", "#{user.address}");
            VALUES("secret_key ", "#{user.secretKey}");
            VALUES("email ", "#{user.email}");
        }}.toString();
    }

    public static String deleteUserById(int id){
        return new SQL(){{
            DELETE_FROM("users_tb");
            WHERE("id=#{id}");
        }}.toString();
    }

    public static String updateUserById(User user){
        return new SQL(){{
            UPDATE("users_tb");
            SET("username=#{user.username}");
            SET("gender=#{user.gender}");
            SET("address=#{user.address}");
            SET("secret_key=#{user.secretKey}");
            SET("email=#{user.email}");
            WHERE("id = #{user.id}");
        }}.toString();
    }
}


