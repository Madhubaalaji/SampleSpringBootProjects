package com.example.userDemo.service;

import com.example.userDemo.Entity.User;
import com.example.userDemo.data.UserRepository;
import com.example.userDemo.exceptions.ResourceNotFoundException;
import com.example.userDemo.exceptions.UserAlreeadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String addUser(User user) {
        Optional<User> alreadyAddedUser = userRepository.findById(user.getId());
        if(alreadyAddedUser.isPresent())
        {
            System.out.println("Inside if");
            throw new UserAlreeadyExistsException("User is already present in Database");
        }
        else {
            System.out.println("Inside else "+user.getId()+" "+user.getEmail());
            User userAdded = userRepository.save(user);
            System.out.println("u = " + userAdded);
            return "user added/updated successfully";
       }
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        Optional<User> addedUser = userRepository.findById(id);
        if(addedUser.isPresent())
        {
            return addedUser;
        }
        else {
            throw new ResourceNotFoundException("User is not found");
        }
    }

    @Override
    public String deleteUser(Integer id) {
        userRepository.deleteById(id);
        return "User is deleted successfully";
    }
}
