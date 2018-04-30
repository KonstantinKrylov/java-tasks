
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Question3Test {

    private String text;
    private int maxCharsPerLine;
    private String expected;

    public Question3Test(String text, int maxCharsPerLine, String expected) {
        this.text = text;
        this.maxCharsPerLine = maxCharsPerLine;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: text: \"{0}\", maxCharsPerLine={1}, expected: \"{2}\"")
    public static Iterable<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"abcd   ef     j hig", 3, "abc\nd\nef\nj\nhig"},
                {"abcdef", 50, "abcdef"},
                {"abcdef", 0, ""},
                {"abc\ndef\nhig", 2, "ab\nc\nde\nf\nhi\ng"},
                {"a a a a a", 4, "a a\na a\na"},
                {"\n\n\nZZZ\n\n", 1, "\n\n\nZ\nZ\nZ"},
                {"\n\n\n\n",10, ""},
                {null,1,""},
                {"",1,""}
        });
    }

    @Test
    public void allStringSetsIdenticalTest() {
        assertEquals(expected, new Question3().wrapText(text, maxCharsPerLine));
    }
}