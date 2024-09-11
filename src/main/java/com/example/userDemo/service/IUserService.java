package com.example.userDemo.service;

import com.example.userDemo.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IUserService {

    public List<User> getAllUsers();
    public String addUser(User user);
    public Optional<User> getUserById(Integer id);
    public String deleteUser(Integer id);
}
