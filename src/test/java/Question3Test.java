import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Question3Test {

    private Question3 question3 = new Question3();

    @Test
    void wrapTextTest(){
        assertEquals("Hel\nlo\nmm\nm\nyrw\nk\npp",question3.wrapText("Hello mm m yrw\nk pp",3));
    }

}
