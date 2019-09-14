package com.todo.rest.webservices.restfulwebservice.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ToDoHardcodedService {

    private static List<ToDo> todos = new ArrayList();
    private static int idCounteer = 0;

    static {
        todos.add(new ToDo(++idCounteer, "mario","dance",new Date(), false));
        todos.add(new ToDo(++idCounteer, "klop","qwa",new Date(), false));
        todos.add(new ToDo(++idCounteer, "oko","jump",new Date(), false));
    }

    public ToDo save(ToDo toDo) {
        if(toDo.getId() == -1 || toDo.getId() == 0){
            toDo.setId(++idCounteer);
            todos.add(toDo);
        } else {
          deleteById(toDo.getId());
          todos.add(toDo);
        }
        return toDo;
    }

    public List<ToDo> findAll() {
        return todos;
    }

    public ToDo deleteById(long id) {
        ToDo todo = findById(id);
        if(todo==null) return null;
        if(todos.remove(todo)) return todo;
        todos.remove(todo);
        return null;
    }

    public ToDo findById(long id) {
        for(ToDo todo:todos) {
            if(todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

}
