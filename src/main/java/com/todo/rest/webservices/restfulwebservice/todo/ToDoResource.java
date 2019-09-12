package com.todo.rest.webservices.restfulwebservice.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable String username, @PathVariable long id) {
        ToDo toDo = toDoHardcodedService.deleteById(id);
        if(toDo != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
