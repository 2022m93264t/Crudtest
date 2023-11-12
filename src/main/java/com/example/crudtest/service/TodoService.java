package com.example.crudtest.service;

import com.example.crudtest.model.Todo;
import java.util.List;


public interface TodoService {


    public Todo updateTodo(Todo todo);
    public Todo getTodo(Long id);
    public List<Todo> getToDoList();
    public List<Todo> getToDoListPriority();
    public Todo addTodoItem(Todo todo);

    public Boolean delete(Long id);

}
