package com.sasha.business;

import com.sasha.data.api.TodoService;

import java.util.ArrayList;
import java.util.List;

public class TodoBusinessImpl {
    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user){
        List<String> filteredTodos = new ArrayList<>();
        List<String> todos = todoService.retrieveTodos(user);
        for (String todo:todos){
            if(todo.contains("spring")){
                filteredTodos.add(todo);
            }
        }
        return null;
    }
}
