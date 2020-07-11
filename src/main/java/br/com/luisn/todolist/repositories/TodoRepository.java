package br.com.luisn.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luisn.todolist.models.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
