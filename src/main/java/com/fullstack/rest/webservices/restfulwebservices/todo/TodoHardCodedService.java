package com.fullstack.rest.webservices.restfulwebservices.todo;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardCodedService {

    private static List<Todo> todos= new ArrayList<Todo>();
    private static int idCounter=0;

    static {
        todos.add(new Todo(++idCounter ,"gunjan","Learn To Dance??", new Date(), false));
        todos.add(new Todo(++idCounter ,"gunjan","Learn To MicroServices", new Date(), false));
        todos.add(new Todo(++idCounter ,"gunjan","Learn To Angular", new Date(), false));
    }

    public List<Todo> findAll()
    {
        return todos;
    }

    public Todo save(Todo todo)
    {
        if(todo.getId()==-1 || todo.getId()==0)
        {   todo.setId(++idCounter);
            todos.add(todo);
        }else {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }
    public Todo deleteById(Long id)
    {
        Todo todo=findById(id);
        if(todo==null)
            return null;
        if(todos.remove(todo)) {
            return todo;
        }
        return null;
    }

    public Todo findById(Long id) {
        for(Todo todo:todos)
        {
            if(todo.getId()==id)
            {
                return todo;
            }
        }
        return null;
    }


}
