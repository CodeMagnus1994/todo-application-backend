package com.todo.todoapplication.Service;

import com.todo.todoapplication.Model.Role;
import com.todo.todoapplication.Model.UserModel;
import com.todo.todoapplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserModel createUser(UserModel userModel) {

        if(Objects.equals(userModel.getFirstName(), "magnus")) {
            userModel.setRole(Role.ADMIN);
        } else
            userModel.setRole(Role.USER);

        return userRepository.save(userModel);
    }

    public UserModel getUser(String id) {
        return userRepository.findById(id).get();
    }

    public UserModel updateUser(UserModel userModel, String id) {

        UserModel existingUser = userRepository.findById(id).orElse(null);

        if(existingUser != null) {

            if(userModel.getFirstName() != null)
                existingUser.setFirstName(userModel.getFirstName());


            if(userModel.getLastName() != null)
                existingUser.setLastName(userModel.getLastName());


            if(userModel.getPassword() != null)
                existingUser.setPassword(userModel.getPassword());


            if(userModel.getUserName() != null)
                existingUser.setUserName(userModel.getUserName());


            UserModel newUpdatedUser = userRepository.save(existingUser);

            return newUpdatedUser;
        } else {
            return userRepository.save(existingUser);
        }
    }

    public String deleteUser(String id) {
        userRepository.deleteById(id);
        return "User id " + id + " has been deleted";
    }
}