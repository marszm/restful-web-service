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

    public List<ToDo> findAll() {
        return todos;
    }

}
