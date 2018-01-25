package com.dmigouno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class StateUtils {

    private static final String csvFile = "src/main/resources/states.csv";
    private static Map<String, String> stateCodeToNameMap = new TreeMap<>();
    private static Map<String, String> stateNameToCodeMap = new TreeMap<>();

    // COMMENTS:
    // I've added this method to read all 50 state names and codes from a CSV file
    // to avoid data being hardcoded into the class.
    // The data is inserted into two TreeMaps.
    // One maps state codes to state names and the other does the opposite.
    public static void readStateInfoFromCSV() {
        String line;
        String delimiter = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] state = line.split(delimiter);
                stateNameToCodeMap.put(state[0], state[1]);
                stateCodeToNameMap.put(state[1], state[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //
    // Generates an HTML select list that can be used to select a specific
    // U.S. state.
    //
    // COMMENTS:
    // There is a lot of repetitive code in the original version.
    // List items are created in a similar fashion, so we end up
    // with 50 lines of code that is pretty much the same.
    // I've reformatted the method by iterating over the stateNameToCodeMap keys
    // making the code DRYer.
    public static String createStateSelectList() {
        String str = "<select name=\"state\">\n";

        for (String name : stateNameToCodeMap.keySet()) {
            str += "<option value=\"" + name + "\">" + name + "</option>\n";
        }

        str += "</select>\n";
        return str;
    }

    //
    // Parses the state from an HTML form submission, converting it to
    // the two-letter abbreviation.
    //
    // COMMENTS:
    // Again, a violation of the DRY principle. Moreover, the code is not very effective.
    // We have to go through all the preceding if statements to get to the state we want.
    // In the worst case scenario, we have to go through 49 if statements to get to Wyoming.
    // I've reformatted this method into a single string that gets the needed data out of a TreeMap.
    public static String parseSelectedState(String s) {
        return stateNameToCodeMap.get(s);
    }

    //
    // Displays the full name of the state specified by the two-letter code.
    //
    // COMMENTS:
    // Same as in the method above. The only difference is that I'm using the other TreeMap.
    public static String displayStateFullName(String abbr) {
        return stateCodeToNameMap.get(abbr);
    }

    // These are getters used for validating TreeMaps' data with JUnit tests
    public static Map<String, String> getStateCodeToNameMap() {
        return stateCodeToNameMap;
    }

    public static Map<String, String> getStateNameToCodeMap() {
        return stateNameToCodeMap;
    }
}
