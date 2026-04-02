package com.example.dao;

import com.example.entity.User;
import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository 
public class UserDao {

    // CREATE
	
	@Autowired
	JdbcTemplate template; 
    public void saveUser(User user) {
    	String query="insert into users(name,email,age) values(?,?,?)";
    	template.update(query,
                user.getName(),
                user.getEmail(),
                user.getAge());
    }
    
    public User getUserById(int id) {
        String query = "select * from users where id=?";
        
        List<User> list = template.query(query, (rs, rnum) -> {
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setName(rs.getString("name"));
            u.setAge(rs.getInt("age"));
            u.setEmail(rs.getString("email"));
            return u;   // ✅ added
        }, id);

        return list.isEmpty()?null:list.get(0);
    }
    
    public List<User> getAllUsers() {
        String query = "select * from users";

        return template.query(query, (rs, rowNum) -> {
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setName(rs.getString("name"));
            u.setAge(rs.getInt("age"));
            u.setEmail(rs.getString("email"));
            return u;
        });
    }
    	
    public void deleteUser(int id) {
        String query = "delete from users where id=?";
        template.update(query, id);
    }
    
    public void updateUser(User user) {
        String query = "update users set name=?, age=?, email=? where id=?";
        
        template.update(query,
                user.getName(),
                user.getAge(),
                user.getEmail(),
                user.getId());
    }
}