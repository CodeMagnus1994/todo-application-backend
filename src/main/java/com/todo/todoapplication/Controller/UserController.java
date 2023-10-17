package com.todo.todoapplication.Controller;

import com.todo.todoapplication.Model.UserModel;
import com.todo.todoapplication.Repository.UserRepository;
import com.todo.todoapplication.Service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("createuser")
    public UserModel createUser(@RequestBody UserModel userModel) {
        return userService.createUser(userModel);
    }

    @GetMapping("getuser/{id}")
    public UserModel getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @DeleteMapping("deleteuser/{id}")
    public String deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }

    @PutMapping("updateuser/{id}")
    public UserModel updateUser(@RequestBody UserModel userModel, @PathVariable String id) {
        return userService.updateUser(userModel, id);
    }

}
