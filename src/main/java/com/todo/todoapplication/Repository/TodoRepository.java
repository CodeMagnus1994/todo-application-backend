package com.todo.todoapplication.Repository;

import com.todo.todoapplication.Model.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Interface is communicating with the data source.
public interface TodoRepository extends JpaRepository<TodoModel, String> {



}
