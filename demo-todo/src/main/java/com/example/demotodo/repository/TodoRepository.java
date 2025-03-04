package com.example.demotodo.repository;

import com.example.demotodo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    // Intentionally leaving empty for Copilot to suggest query methods
}
