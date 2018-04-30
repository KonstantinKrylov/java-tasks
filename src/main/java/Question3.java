/*
 * Write a Java method with the following method signature that takes a String and
 returns a String formatted so that it satisfies the requirements below.  It may
 need to insert newlines and/or delete spaces.

 Method Signature:
 public static String wrapText(String text, int maxCharsPerLine)

 Definitions and Assumptions:
 A word is a nonempty sequence of characters that contains no spaces and no newlines.
 Lines in the return String are separated by the newline character, '\n'.
 Words on each line are separated by spaces. Assume that the String argument does
 not contain any whitespace characters other than spaces and newlines.

 Requirements:
 1. Newlines in the String argument are preserved.
 2. Words in the return String are separated by either a single space or by one or
 more newlines.
 3. Lines in the return String do not start or end with any spaces.
 4. When constructing the return String from the String argument, each word in the
 String argument with at most maxCharsPerLine characters should not be broken up.
 Each word in the String argument with more than maxCharsPerLine characters should
 be broken up so that all of the other requirements are satisfied.
 5. The String argument may contain lines longer than maxCharsPerLine. Newlines
 should be added so that each line in the return String has at most maxCharsPerLine
 characters. To determine where newlines should be added, try to fit as many words
 as possible on a line (while keeping line length at most maxCharsPerLine and
 satisfying the other requirements) before starting a new line.
 */

public class Question3 {

    public String wrapText(String text, int maxCharsPerLine) {

        if (maxCharsPerLine < 1 || text == null) return "";

        String[] array = text.split("\n");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            result.append(wrapLine(array[i], maxCharsPerLine));
            if (i != array.length - 1) result.append("\n");
        }
        return result.toString();

    }

    private String wrapLine(String text, int maxCharsPerLine) {

        String[] array = text.split("\\s+");
        StringBuilder result = new StringBuilder();
        int lineFreeSpace = maxCharsPerLine;

        for (int i = 0; i < array.length; i++) {
            String word = array[i];
            while (word.length() > 0) {
                if (doesItFit(word, lineFreeSpace)) {
                    result.append(word);
                    lineFreeSpace -= word.length() + 1;
                    String nextWord = nextWord(array, i);
                    if (isSpaceNeeded(lineFreeSpace, nextWord)) result.append(" ");
                    word = "";
                } else {
                    if (canBeBroken(word, maxCharsPerLine)) {
                        result.append(word.substring(0, lineFreeSpace) + "\n");
                        word = word.substring(lineFreeSpace);
                        lineFreeSpace = maxCharsPerLine;
                    } else {
                        lineFreeSpace = maxCharsPerLine;
                        result.append("\n" + word);
                        lineFreeSpace -= word.length() + 1;
                        String nextWord = nextWord(array, i);
                        if (isSpaceNeeded(lineFreeSpace, nextWord)) result.append(" ");
                        if (lineFreeSpace < 0) lineFreeSpace = 0;
                        word = "";
                    }
                }
            }
        }
        return result.toString();
    }

    private boolean doesItFit(String str, int freeSpace) {
        return str.length() <= freeSpace;
    }

    private boolean canBeBroken(String str, int maxCharsPerLine) {
        return str.length() > maxCharsPerLine;
    }

    private boolean isSpaceNeeded(int lineFreeSpace, String nextWord) {
        if (nextWord.length() == 0) return false;
        return lineFreeSpace >= 1 && lineFreeSpace >= nextWord.length();
    }

    private String nextWord(String[] array, int i) {
        String nextWord = "";
        if (i != array.length - 1) nextWord = array[i + 1];
        return nextWord;
    }
}
