package com.example.crudtest.controller;

import com.example.crudtest.model.Todo;
import com.example.crudtest.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class WebsocketController {

    TodoService todoService;

    @Autowired
    WebsocketController(TodoService todoService){
        this.todoService = todoService;
    }
    @MessageMapping("/update-data")
    @SendTo("/topic/data-updated")
     public ResponseEntity<List<Todo>> sendDataUpdate(String message){
        return new ResponseEntity<>(todoService.getToDoList(), HttpStatus.OK);
     }
}
