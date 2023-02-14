package com.sasha.business;


import com.sasha.data.api.TodoService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;


import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;


public class TodoBusinessImplMockitoInjectMockTest {


    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    TodoService todoServiceMock;

    @InjectMocks
    TodoBusinessImpl todoBusiness;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock() {

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        when(todoServiceMock.retrieveTodos("Dummy"))
                .thenReturn(todos);

        List<String> filteredTodos = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
    }


    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDD() {

        //Given
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn((todos));

        //When
        List<String> filteredTodos = todoBusiness.retrieveTodosRelatedToSpring("Dummy");

        //Then
        assertThat(filteredTodos.size(), is(2));
    }


    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD() {

        //Given
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn((todos));

        //When
        todoBusiness.deleteTodosNotRelatedToSpring("Dummy");

        //Then
        then(todoServiceMock).should().delete("Learn to Dance");

        verify(todoServiceMock, times(1)).delete("Learn to Dance");

        then(todoServiceMock).should(never()).delete("Learn Spring");
        verify(todoServiceMock, never()).delete("Learn Spring");

        then(todoServiceMock).should(never()).delete("Learn Spring MVC");
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture() {

        //Given
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn((todos));

        //When
        todoBusiness.deleteTodosNotRelatedToSpring("Dummy");

        //Then
        // 2 последние строчки делают одинаковую работу (проверяют вызывается ли метод delete("Learn to Dance")
        // именно с этим параметром ("Learn to Dance")
        verify(todoServiceMock).delete("Learn to Dance");
        then(todoServiceMock).should().delete(stringArgumentCaptor.capture());

        assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
    }


    @Test
    public void testRetrieveTodosRelatedToSpring_withEmptyList() {

        List<String> todos = Arrays.asList();

        when(todoServiceMock.retrieveTodos("Dummy"))
                .thenReturn(todos);

        List<String> filteredTodos = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(0, filteredTodos.size());
    }
}
