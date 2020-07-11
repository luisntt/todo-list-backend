package br.com.luisn.todolist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luisn.todolist.dtos.TodoDTO;
import br.com.luisn.todolist.models.Todo;
import br.com.luisn.todolist.services.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@PostMapping
	public ResponseEntity<Todo> createTodo(@RequestBody TodoDTO todoDTO){
		todoService.createTodo(todoDTO);
		return new ResponseEntity<Todo>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<TodoDTO>> readAllTodos(){
		return new ResponseEntity<List<TodoDTO>>(todoService.readAllTodos(), HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<TodoDTO> readTodo(@PathVariable Long id){
		return new ResponseEntity<TodoDTO>(todoService.readTodo(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<TodoDTO> updateTodo(@PathVariable Long id, @RequestBody TodoDTO todoDTO){
		todoService.updateTodo(id,todoDTO);
		return new ResponseEntity<TodoDTO>(HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<TodoDTO> deleteTodo(@PathVariable Long id){
		todoService.deleteTodo(id);
		return new ResponseEntity<TodoDTO>(HttpStatus.OK);
	}
}
