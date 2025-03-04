package com.example.demotodo.controller;

import com.example.demotodo.model.Todo;
import com.example.demotodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {
    
    @Autowired
    private TodoRepository todoRepository;
    
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
    
    // More endpoints will be added using Copilot
}
