
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Question2CreateSelectListTest {

    @Test
    public void createStateSelectListTest() {
        assertEquals("<select name=\"state\">\n"
                + "<option value=\"Alabama\">Alabama</option>\n"
                + "<option value=\"Alaska\">Alaska</option>\n"
                + "<option value=\"Arizona\">Arizona</option>\n"
                + "<option value=\"Arkansas\">Arkansas</option>\n"
                + "<option value=\"California\">California</option>\n"
                + "</select>\n", new Question2().createStateSelectList());
    }
}




