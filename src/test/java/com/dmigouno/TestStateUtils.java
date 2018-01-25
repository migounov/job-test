package com.dmigouno;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Map;

import static com.dmigouno.StateUtils.*;
import static org.junit.Assert.assertEquals;

public class TestStateUtils {

    @BeforeClass
    public static void setUp() {
        readStateInfoFromCSV();
    }

    @Test
    public void verifyStateCodeToNameMap() {
        Map<String, String> stateCodeToNameMap = getStateCodeToNameMap();
        assertEquals("California", stateCodeToNameMap.get("CA"));
    }

    @Test
    public void verifyStateNameToCodeMap() {
        Map<String, String> stateCodeToNameMap = getStateNameToCodeMap();
        assertEquals("CA", stateCodeToNameMap.get("California"));
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void verifyDisplayStateFullName() {
        assertEquals("California", displayStateFullName("CA"));
    }

    @Test
    public void verifyParseSelectedState() {
        assertEquals("CA", parseSelectedState("California"));
    }

    @Test
    public void verifyCreateStateSelectList() {

        String expectedStr = "<select name=\"state\">\n" +
                "<option value=\"Alabama\">Alabama</option>\n" +
                "<option value=\"Alaska\">Alaska</option>\n" +
                "<option value=\"Arizona\">Arizona</option>\n" +
                "<option value=\"Arkansas\">Arkansas</option>\n" +
                "<option value=\"California\">California</option>\n" +
                "<option value=\"Colorado\">Colorado</option>\n" +
                "<option value=\"Connecticut\">Connecticut</option>\n" +
                "<option value=\"Delaware\">Delaware</option>\n" +
                "<option value=\"Florida\">Florida</option>\n" +
                "<option value=\"Georgia\">Georgia</option>\n" +
                "<option value=\"Hawaii\">Hawaii</option>\n" +
                "<option value=\"Idaho\">Idaho</option>\n" +
                "<option value=\"Illinois\">Illinois</option>\n" +
                "<option value=\"Indiana\">Indiana</option>\n" +
                "<option value=\"Iowa\">Iowa</option>\n" +
                "<option value=\"Kansas\">Kansas</option>\n" +
                "<option value=\"Kentucky\">Kentucky</option>\n" +
                "<option value=\"Louisiana\">Louisiana</option>\n" +
                "<option value=\"Maine\">Maine</option>\n" +
                "<option value=\"Maryland\">Maryland</option>\n" +
                "<option value=\"Massachusetts\">Massachusetts</option>\n" +
                "<option value=\"Michigan\">Michigan</option>\n" +
                "<option value=\"Minnesota\">Minnesota</option>\n" +
                "<option value=\"Mississippi\">Mississippi</option>\n" +
                "<option value=\"Missouri\">Missouri</option>\n" +
                "<option value=\"Montana\">Montana</option>\n" +
                "<option value=\"Nebraska\">Nebraska</option>\n" +
                "<option value=\"Nevada\">Nevada</option>\n" +
                "<option value=\"New Hampshire\">New Hampshire</option>\n" +
                "<option value=\"New Jersey\">New Jersey</option>\n" +
                "<option value=\"New Mexico\">New Mexico</option>\n" +
                "<option value=\"New York\">New York</option>\n" +
                "<option value=\"North Carolina\">North Carolina</option>\n" +
                "<option value=\"North Dakota\">North Dakota</option>\n" +
                "<option value=\"Ohio\">Ohio</option>\n" +
                "<option value=\"Oklahoma\">Oklahoma</option>\n" +
                "<option value=\"Oregon\">Oregon</option>\n" +
                "<option value=\"Pennsylvania\">Pennsylvania</option>\n" +
                "<option value=\"Rhode Island\">Rhode Island</option>\n" +
                "<option value=\"South Carolina\">South Carolina</option>\n" +
                "<option value=\"South Dakota\">South Dakota</option>\n" +
                "<option value=\"Tennessee\">Tennessee</option>\n" +
                "<option value=\"Texas\">Texas</option>\n" +
                "<option value=\"Utah\">Utah</option>\n" +
                "<option value=\"Vermont\">Vermont</option>\n" +
                "<option value=\"Virginia\">Virginia</option>\n" +
                "<option value=\"Washington\">Washington</option>\n" +
                "<option value=\"West Virginia\">West Virginia</option>\n" +
                "<option value=\"Wisconsin\">Wisconsin</option>\n" +
                "<option value=\"Wyoming\">Wyoming</option>\n" +
                "</select>\n";

        String str = createStateSelectList();
        assertEquals(expectedStr, str);
    }

}
