package com.todo.rest.webservices.restfulwebservice.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ToDoResource {

    @Autowired
    private ToDoHardcodedService toDoHardcodedService;

    @GetMapping("/users/{username}/todos")
    public List<ToDo> getAllToDos(@PathVariable  String username) {
            return toDoHardcodedService.findAll();
    }

}
