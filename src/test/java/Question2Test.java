import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Question2Test {
    private Question2 question2 = new Question2();

    @Test
    void createStateSelectListTest() {
        assertEquals("<select name=\"state\">\n"
                + "<option value=\"Alabama\">Alabama</option>\n"
                + "<option value=\"Alaska\">Alaska</option>\n"
                + "<option value=\"Arizona\">Arizona</option>\n"
                + "<option value=\"Arkansas\">Arkansas</option>\n"
                + "<option value=\"California\">California</option>\n"
                + "</select>\n", question2.createStateSelectList());
    }

    @Test
    void parseSelectedStateTest() {
        assertEquals("AL", question2.parseSelectedState("Alabama"));
    }

    @Test
    void displayStateFullNameTest() {
        assertEquals("California", question2.displayStateFullName("CA"));
    }
}


