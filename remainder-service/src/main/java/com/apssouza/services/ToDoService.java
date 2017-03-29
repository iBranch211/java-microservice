package com.apssouza.services;

import com.apssouza.repositories.TodoRepository;
import com.apssouza.entities.ToDo;
import com.apssouza.exceptions.DataNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToDoService {

    @Autowired
    private TodoRepository todoRepository;

    public Optional<ToDo> findById(long id) {
        ToDo todo = this.todoRepository.findOne(id);
        return Optional.ofNullable(todo);
    }

    public boolean delete(long id) {
        this.findById(id).orElseThrow(() -> new DataNotFoundException("Not found ToDo id " + id));
        return this.todoRepository.deleteById(id);
    }

    public List<ToDo> all() {
        return this.todoRepository.findAll();
    }

    public ToDo save(ToDo todo) {
        return this.todoRepository.save(todo);
    }

    public ToDo updateStatus(long id, boolean done) {
        return this.findById(id)
                .map((t) -> {
                    t.setDone(done);
                    todoRepository.save(t);
                    return t;
                }).orElseThrow(() -> new DataNotFoundException("Not found ToDo id " + id));
    }

}
