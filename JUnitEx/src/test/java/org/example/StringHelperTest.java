package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringHelperTest {
    StringHelper stringHelper;


    @Before
    public void before() {
        stringHelper = new StringHelper();
        System.out.println("before test");
    }


    @Test
    public void testTruncateAInFirst2Positions_AInFirst2Positions() {
        assertEquals("CD", stringHelper.truncateAInFirst2Positions("AACD"));

    }

    @Test
    public void testTruncateAInFirst2Positions_AInFirstPosition() {
        assertEquals("CD", stringHelper.truncateAInFirst2Positions("ACD"));


    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
        assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("ABCD"));


    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
        assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("ABAB"));

    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_ScenarioWithTwoCharacter() {
        assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("AB"));

    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_ScenarioWithOneCharacter() {
        assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("A"));


    }


    @Test
    public void areFirstAndLastTwoCharactersTheSame() {
    }

    @Test
    public void truncateAInFirst2Positions() {

    }

    @After
    public void teardown(){
        System.out.println("after test");
    }
}