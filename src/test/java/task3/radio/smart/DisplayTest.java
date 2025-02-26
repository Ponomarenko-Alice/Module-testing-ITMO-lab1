package task3.radio.smart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task3.exception.DisplayInteractionException;
import task3.radio.Direction;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DisplayTest {
    private Display display;

    @BeforeEach
    void initDisplay() {
        display = new Display();
    }

    @Test
    void testDisplayException() {
        assertThrows(DisplayInteractionException.class, () -> display.setLastInteractionDirection(Direction.UP, -10));
    }


}
