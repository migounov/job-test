package com.dmigouno;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IdenticalStringSets {

    public static boolean allStringSetsIdentical(String[][] sets) {
        Set<String> referenceSet, currentSet;
        if (sets.length > 1) {
            referenceSet = convertStringArrayToSet(sets[0]);
            for (int i = 1; i < sets.length; i++) {
                currentSet = convertStringArrayToSet(sets[i]);
                if (!currentSet.equals(referenceSet))
                    return false;
            }
        }
        return true;
    }

    private static HashSet<String> convertStringArrayToSet(String[] set) {
        return new HashSet<>(Arrays.asList(set));
    }

}
