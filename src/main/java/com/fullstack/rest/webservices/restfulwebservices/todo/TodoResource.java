package com.fullstack.rest.webservices.restfulwebservices.todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoResource {
    @Autowired
    private TodoHardCodedService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username)
    {
       return todoService.findAll();
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<?> deletToDo(@PathVariable String username , @PathVariable long id)
    {
        Todo todo = todoService.deleteById(id);
        if(todo!=null)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username , @PathVariable long id)
    {
               return todoService.findById(id);
    }


@PutMapping("/users/{username}/todos/{id}")
public ResponseEntity<?> updateTodo(@PathVariable String username ,
                                    @PathVariable long id,
                                    @RequestBody Todo todo)
{
    Todo todoUpdated = todoService.save(todo);

    return new ResponseEntity<Todo>(todo, HttpStatus.OK);
}

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<?> addTodo(@PathVariable String username ,
                                     @RequestBody Todo todo)
    {
        Todo createTodo = todoService.save(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("{id}").buildAndExpand(createTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }



}
