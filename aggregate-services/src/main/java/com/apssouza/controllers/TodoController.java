package com.apssouza.controllers;

import com.apssouza.clients.TodoClient;
import com.apssouza.pojos.User;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author apssouza
 */
@RequestMapping("/todos")
@RestController
public class TodoController {

    @Autowired
    TodoClient todoClient ;

    @GetMapping
    public List<User> all() {
        return this.todoClient.getAll();
    }

}
