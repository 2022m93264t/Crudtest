package com.example.crudtest.service;

import com.example.crudtest.model.Todo;
import com.example.crudtest.repository.Todorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class TodoServiceImpl implements TodoService{

    Todorepository todorepository;

    @Autowired
    public TodoServiceImpl(Todorepository todorepository) {
        this.todorepository = todorepository;
    }

    public Todo addTodoItem(Todo todo){
     //   todo.setId(System.currentTimeMillis());
        System.out.println(todo.toString());
        return todorepository.save(todo);
    }

    public Todo getTodo(Long id){
       Optional<Todo> elem = todorepository.findById(id);
       return elem.orElse(null);
    }

    public Todo updateTodo(Todo todo){
        return todorepository.save(todo);
    }
    @Override
    public List<Todo> getToDoList(){
        return todorepository.findAll();
    }

    public List<Todo> getToDoListPriority(){
        return todorepository.getPriorityItems();
    }

    public Boolean delete(Long id){
        todorepository.deleteById(id);
        if(getTodo(id) == null){
            return true;
        }
        else return false;
    }
}
