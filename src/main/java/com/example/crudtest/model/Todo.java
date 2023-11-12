package com.example.crudtest.model;

import jakarta.persistence.*;

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String item;

    private int completed;

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", completed=" + completed +
                ", priority=" + priority +
                '}';
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    private int priority;

    public Todo(Long id, String item, int completed, int priority) {
        this.id = id;
        this.item = item;
        this.completed = completed;
        this.priority = priority;
    }

    public Todo() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

}
