package com.sasha.business;


import com.sasha.data.api.TodoService;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock(){
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        when(todoServiceMock.retrieveTodos("Dummy"))
                .thenReturn(todos);


        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2,filteredTodos.size());
    }



    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDD(){

        //Given
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn((todos));


        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);

        //When
        List<String> filteredTodos = todoBusiness.retrieveTodosRelatedToSpring("Dummy");

        //Then
        assertThat(filteredTodos.size(), is(2));

    }


    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD(){

        //Given
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn((todos));


        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        //When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        //Then
        verify( todoServiceMock, atLeast(1)).delete( "Learn to Dance");

        verify( todoServiceMock, times(1)).delete( "Learn to Dance");
        verify( todoServiceMock, never()).delete( "Learn Spring");



    }




    @Test
    public void testRetrieveTodosRelatedToSpring_withEmptyList(){
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList();

        when(todoServiceMock.retrieveTodos("Dummy"))
                .thenReturn(todos);


        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(0,filteredTodos.size());
    }
}
