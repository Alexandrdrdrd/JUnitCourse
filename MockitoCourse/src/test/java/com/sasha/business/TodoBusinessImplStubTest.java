package com.sasha.business;


import com.sasha.data.api.TodoService;
import com.sasha.data.api.TodoServiceStub;
import org.junit.Test;
import static org.junit.Assert.*;


import java.util.List;

public class TodoBusinessImplStubTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAStab(){
        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
        List<String> filteredTodos = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2,filteredTodos.size());
    }
}
