package com.dmigouno;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTextWrapper {

    @Test
    public void nullInputReturnsNull() {
        String str = null;
        assertEquals(null, TextWrapper.wrapText(str, 14));
    }

    @Test
    public void verifyWrapper() {
        String str = " The  String\n\nargument may\n contain lines\n longer than" +
                " maxCharsPerLine.\nNewlines should be added so that each line in" +
                " the return  String  has at most maxCharsPerLine characters.";
        String expected = "The String\n\nargument may\ncontain lines\nlonger than ma\n" +
                "xCharsPerLine.\nNewlines\nshould be\nadded so that\neach line in\n" +
                "the return\nString has at\nmost maxCharsP\nerLine\ncharacters.";
        assertEquals(expected, TextWrapper.wrapText(str, 14));
    }

}
