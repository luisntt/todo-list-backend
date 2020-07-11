package br.com.luisn.todolist.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luisn.todolist.dtos.TodoDTO;
import br.com.luisn.todolist.models.Todo;
import br.com.luisn.todolist.repositories.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public void createTodo(TodoDTO dto) {
		todoRepository.save(fromDTO(dto));
	}
	
	public List<TodoDTO> readAllTodos(){
		List<Todo> todos = todoRepository.findAll();
		List<TodoDTO> todosDTO = new ArrayList<>();
		for(Todo todo : todos) {
			todosDTO.add(new TodoDTO(todo));
		}
		
		return todosDTO;
	}
	public TodoDTO readTodo(Long id) {
		TodoDTO todoDTO = new TodoDTO(todoRepository.findById(id).get());
		return todoDTO;
	}
	
	public void updateTodo(Long id, TodoDTO todoDTO) {
		Todo todo = todoRepository.findById(id).get();
		todo.setEstimate(todoDTO.getEstimate());
		todo.setName(todoDTO.getName());
		todoRepository.save(todo);
	}
	
	public void deleteTodo(Long id) {
		todoRepository.deleteById(id);
	}
	
	private Todo fromDTO(TodoDTO dto)  {
		return new Todo(dto.getId(),dto.getName(),dto.getEstimate());
	}


}
