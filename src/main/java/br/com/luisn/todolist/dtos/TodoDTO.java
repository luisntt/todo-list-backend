package br.com.luisn.todolist.dtos;

import br.com.luisn.todolist.models.Todo;

public class TodoDTO {
	
    private Long id;
    private String name;
    private String estimate;
    
    public TodoDTO() {
    	
    }
    
    public TodoDTO(Todo todo) {
    	this.id = todo.getId();
    	this.name = todo.getName();
    	this.estimate = todo.getEstimate();
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEstimate() {
		return estimate;
	}
	public void setEstimate(String estimate) {
		this.estimate = estimate;
	}
    
}
