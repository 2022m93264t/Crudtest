package com.example.crudtest.controller;

import com.example.crudtest.model.Todo;
import com.example.crudtest.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/v1/api/todos")
@CrossOrigin(origins = "http://localhost:4200")
public class TodosController {

    TodoService service;

    @Autowired
    public TodosController(TodoService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<Todo> getAllPriorityTodoItems(@RequestBody Todo todo){
        Todo elem = service.addTodoItem(todo);
        if(elem == null)
            throw new ErrorResponseException(HttpStatus.NOT_ACCEPTABLE);
        return new ResponseEntity<>(elem,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Long id){
        Todo todo = service.getTodo(id);
        if(todo == null)
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(todo,HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Todo>> getAllTodosItems(){
        return new ResponseEntity<>(service.getToDoList(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/priority")
    public ResponseEntity<List<Todo>> getAllPriorityTodoItems(){
        return new ResponseEntity<>(service.getToDoListPriority(),HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo){
        Todo elem = service.updateTodo(todo);
        if(elem == null)
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(elem,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}/delete")
    public HttpStatus deleteTodo(@PathVariable Long id){
        if(service.delete(id)){
            return HttpStatus.OK;
        }
        else return HttpStatus.NOT_FOUND;
    }

}
