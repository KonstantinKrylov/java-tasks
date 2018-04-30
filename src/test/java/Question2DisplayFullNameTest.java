import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Question2DisplayFullNameTest {

    private String code;
    private String expected;

    public Question2DisplayFullNameTest(String code, String expected) {
        this.code = code;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: for the Code \"{0}\" the State should be \"{1}\"")
    public static Iterable<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"AL", "Alabama"},
                {"AK", "Alaska"},
                {"AZ", "Arizona"},
                {"AR", "Arkansas"},
                {"CA", "California"},
        });
    }

    @Test
    public void displayStateFullNameTest() {
        assertEquals(expected, new Question2().displayStateFullName(code));
    }
}