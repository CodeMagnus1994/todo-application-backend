package com.todo.todoapplication.Model;

import jakarta.persistence.*;

@Entity // Represent class in relational database
@Table(name = "todo") // Define name.
public class TodoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int rating;
    private String title;
    private String message;

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
