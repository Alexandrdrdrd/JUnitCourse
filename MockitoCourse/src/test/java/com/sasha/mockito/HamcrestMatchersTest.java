package com.sasha.mockito;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class HamcrestMatchersTest {


    @Test
    public void test(){
        List<Integer> scores = Arrays.asList(99,100,101,105);

        //scores has 4 items
        assertThat(scores, hasSize(4));
        assertThat(scores, hasItems(99,100));

        //every item > 90
        assertThat(scores,everyItem(greaterThan(10)));
        assertThat(scores,everyItem(lessThan(200)));


        //String

        assertThat("", isEmptyString());
        assertThat(null, isEmptyOrNullString());


        // Arrays

        Integer[] marks = {1,2,3};
        assertThat(marks,arrayWithSize(3));

        //ожидает что все содержимое array совпадает с параметрами в методе
        assertThat(marks, arrayContaining(1,2,3));
        assertThat(marks, arrayContainingInAnyOrder(1,3,2));
    }
}
