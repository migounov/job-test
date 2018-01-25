package com.dmigouno;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestIdenticalStringSets {

    @Test
    public void emptySetIsIdenticalToItself() {
        String[][] input = {};
        assertTrue(IdenticalStringSets.allStringSetsIdentical(input));
    }

    @Test
    public void singleSetIsIdenticalToItself() {
        String[][] input = {{"a"}};
        assertTrue(IdenticalStringSets.allStringSetsIdentical(input));
    }

    @Test
    public void setsIdentical() {
        String[][] input = {{"a", "b"}, {"b", "b", "a"}, {"b", "a"}};
        assertTrue(IdenticalStringSets.allStringSetsIdentical(input));
    }

    @Test
    public void setsNotIdentical() {
        String[][] input = {{"a", "b"}, {"a"}, {"b"}};
        assertFalse(IdenticalStringSets.allStringSetsIdentical(input));
    }

}
