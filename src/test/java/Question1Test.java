
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Question1Test {

    private String[][] sets;
    private boolean expected;

    public Question1Test(String[][] sets, boolean expected) {
        this.sets = sets;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: expected {1}")
    public static Iterable<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {new String[][]{{}, {"d"}}, false},
                {new String[][]{{"a", "b"}, {"b", "b", "a"}, {"b", "a"}}, true},
                {new String[][]{{"a", "b"}, {"a"}, {"b"}}, false},
                {new String[][]{{}, {}, {}}, true},
                {new String[][]{{}}, true},
                {new String[][]{{"Q","q"},{"q","q"}}, false},
                {null, false},
                {new String[][]{{"hello\nMark","what's up"},{"what's up","hello\nMark"}}, true},
                {new String[][]{{" "}, {" "}, {"  "}}, false}
        });
    }

    @Test
    public void allStringSetsIdenticalTest() {
        assertEquals(expected, new Question1().allStringSetsIdentical(sets));
    }
}