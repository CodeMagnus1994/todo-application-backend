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

            existingUser.setUserName(userModel.getUserName());
            existingUser.setFirstName(userModel.getFirstName());
            existingUser.setLastName(userModel.getLastName());
            existingUser.setPassword(userModel.getPassword());

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
