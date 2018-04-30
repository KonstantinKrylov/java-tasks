
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Question1Test {

    private Question1 question1 = new Question1();

    @Test
    void allStringSetsIdenticalTest() {
        assertEquals(false, question1.allStringSetsIdentical(new String[][]{{}, {"d"}}));
        assertEquals(true, question1.allStringSetsIdentical(new String[][]{{"a", "b"}, {"b", "b", "a"}, {"b", "a"}}));
        assertEquals(false, question1.allStringSetsIdentical(new String[][]{{"a", "b"}, {"a"}, {"b"}}));
    }
}
