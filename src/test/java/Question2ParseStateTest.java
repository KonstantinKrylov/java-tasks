import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Question2ParseStateTest {

    private String stateName;
    private String expected;

    public Question2ParseStateTest(String stateName, String expected) {
        this.stateName = stateName;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: for the State \"{0}\" the code should be \"{1}\"")
    public static Iterable<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Alabama", "AL"},
                {"Alaska", "AK"},
                {"Arizona", "AZ"},
                {"Arkansas", "AR"},
                {"California", "CA"}
        });
    }

    @Test
    public void parseSelectedStateTest() {
        assertEquals(expected, new Question2().parseSelectedState(stateName));
    }
}