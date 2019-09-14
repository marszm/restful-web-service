package com.todo.rest.webservices.restfulwebservice.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ToDoResource {

    @Autowired
    private ToDoHardcodedService toDoHardcodedService;

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> createToDo(@PathVariable String username, @RequestBody ToDo toDo  ) {
        ToDo createdToDo = toDoHardcodedService.save(toDo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(createdToDo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable String username, @PathVariable long id, @RequestBody ToDo toDo) {
        ToDo todoUpdated = toDoHardcodedService.save(toDo);
        return new ResponseEntity<ToDo>(toDo, HttpStatus.OK);
    }

    @GetMapping("/users/{username}/todos")
    public List<ToDo> getAllToDos(@PathVariable  String username) {
            return toDoHardcodedService.findAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public ToDo getToDo(@PathVariable  String username, @PathVariable long id) {
        return toDoHardcodedService.findById(id);
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
