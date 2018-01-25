package com.dmigouno;

public class TextWrapper {
    private static final String linebreak = "\n";
    private static int remainingSymbolsInLine;
    private static int MAX_LENGTH;
    private static String formattedText = "";

    public static String wrapText(String text, int maxCharsPerLine) {
        MAX_LENGTH = maxCharsPerLine;
        remainingSymbolsInLine = maxCharsPerLine;
        int wordLength = 0;

        if (text == null) {
            return text;
        }

        for (String line : text.split("\n")) {
            String[] words = line.trim().split("\\s+");
            Boolean addedCRLF = false;
            for (String word : words) {

                //Need this variable since a word might be split later on
                String currentWord = word;

                while ((wordLength = currentWord.length()) > 0) {

                    // The word fits into the current line
                    if (wordLength <= remainingSymbolsInLine) {
                        formattedText += currentWord;
                        remainingSymbolsInLine -= wordLength;

                        // Add CRLF but don't add a trailing space if 0 or 1 remaining characters on the current line
                        if (remainingSymbolsInLine == 0 || remainingSymbolsInLine == 1) {
                            formattedText += linebreak;
                            addedCRLF = true; // to prevent double linebreak
                            resetRemainingSymbolsInLine();
                        // Otherwise add only a trailing space
                        } else {
                            formattedText += " ";
                            remainingSymbolsInLine--;
                        }

                        currentWord = "";
                    // The word does not fit but too short for wrapping
                    } else if (wordLength <= maxCharsPerLine) {
                        trimTrailingSpaceAddCRLF();
                    // The word can be wrapped
                    } else {
                        String wordSplitHead = currentWord.substring(0, remainingSymbolsInLine);
                        String wordSplitTail = currentWord.substring(remainingSymbolsInLine);
                        formattedText = formattedText + wordSplitHead + linebreak;
                        currentWord = wordSplitTail;
                        resetRemainingSymbolsInLine();
                    }
                }
            }

            if (!addedCRLF) {
                trimTrailingSpaceAddCRLF();
            }

        }

        return formattedText.trim();
    }

    private static void trimTrailingSpaceAddCRLF() {
        formattedText = formattedText.replaceAll("[^\\S\\n]+$", "") + linebreak;
        resetRemainingSymbolsInLine();
    }

    private static void resetRemainingSymbolsInLine() {
        remainingSymbolsInLine = MAX_LENGTH;
    }

}