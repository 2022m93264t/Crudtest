package com.example.crudtest.repository;

import com.example.crudtest.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Todorepository extends JpaRepository<Todo,Long> {

    @Query("SELECT e FROM Todo e WHERE e.priority=1")
    public List<Todo> getPriorityItems();
}
