package com.todo.todoapplication.Service;

import com.todo.todoapplication.Model.TodoModel;
import com.todo.todoapplication.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public TodoModel createTodo(TodoModel todoModel) {
        return todoRepository.save(todoModel);
    }

    public TodoModel getTodo(String id) {
        return todoRepository.findById(id).get();
    }

    public TodoModel updateTodo(TodoModel updateModel, String id) {
        TodoModel existingTodo = todoRepository.findById(id).orElse(null);

        if(existingTodo != null) {

            if(updateModel.getTitle() != null)
                existingTodo.setTitle(updateModel.getTitle());

            if(updateModel.getMessage() != null)
                existingTodo.setMessage(updateModel.getMessage());

            if(updateModel.getRating() > 0 && updateModel.getRating() <= 10)
                existingTodo.setRating(updateModel.getRating());

            TodoModel newUpdatedTodoModel = todoRepository.save(existingTodo);
            return newUpdatedTodoModel;
        } else {
            return null;
        }
    }

    public String deleteTodo(String id) {
        todoRepository.deleteById(id);
        return "Todo id" + id + "has been deleted!";
    }
}

