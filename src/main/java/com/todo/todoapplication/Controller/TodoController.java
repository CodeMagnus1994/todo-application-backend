package com.todo.todoapplication.Controller;

import com.todo.todoapplication.Model.TodoModel;
import com.todo.todoapplication.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo/")
public class TodoController {

    @Autowired
    TodoService todoService;

    @RequestMapping("createtodo")
    public TodoModel createTodo(@RequestBody TodoModel todoModel) {
        return todoService.createTodo(todoModel);
    }

    @GetMapping("gettodo/{id}")
    public TodoModel getTodo(@PathVariable String id) {
        return todoService.getTodo(id);
    }

    @DeleteMapping("removetodo/{id}")
    public String deleteTodo(@PathVariable String id) {
        return todoService.deleteTodo(id);
    }

    @PutMapping("updatetodo/{id}")
    public TodoModel updateTodo(@RequestBody TodoModel todoModel, @PathVariable String id) {
        return todoService.updateTodo(todoModel, id);
    }
}
