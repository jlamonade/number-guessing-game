import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class MainTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getName() throws Exception {
        Main main = new Main();
        String input = "Jason";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Jason", main.getName());
    }

    @Test
    void getGuess() throws Exception {
        Main main = new Main();
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(Integer.parseInt("1"), main.getGuess());
    }

    @Test
    void getTargetNumber() throws Exception {
        Main main = new Main();
        assertTrue(main.getTargetNumber() < 21);
        assertTrue(main.getTargetNumber() > 0);
    }

    @Test
    void playAgain() throws Exception {
        Main main = new Main();
        String input = "y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertTrue(main.playAgain());

        input = "n";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertFalse(main.playAgain());
    }
}