package task3.human;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import task3.exception.WheelDirectionException;
import task3.radio.Direction;
import task3.radio.primary.Button;
import task3.radio.primary.Wheel;
import task3.util.Observer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HumanTest {
    private Human human;
    private Observer observer;

    @BeforeEach
    void initHuman() {
        human = new Human("testName");
        MockitoAnnotations.openMocks(this);
        observer = mock(Observer.class);

    }

    @Test
    void testWave() {
        human.registerObserver(observer);
        human.wave(Direction.LEFT, 5);

        verify(observer, times(1)).update(Direction.LEFT, 5);
    }

    @Test
    void testTwistWheel() throws WheelDirectionException {
        Wheel wheel = mock(Wheel.class);

        human.twist(wheel, Direction.RIGHT, 100);
        verify(wheel, times(1)).setLastInteraction(Direction.RIGHT, 100);
    }

    @Test
    void testTwistWheelThrowsException() throws WheelDirectionException {
        Wheel wheel = mock(Wheel.class);
        doThrow(new WheelDirectionException("Invalid direction"))
                .when(wheel).setLastInteraction(any(Direction.class), anyInt());

        assertDoesNotThrow(() -> human.twist(wheel, Direction.RIGHT, 100));
    }

    @Test
    void testPressButton() {
        Button button = mock(Button.class);
        human.press(button);
        verify(button, times(1)).changePressState();
    }

    @Test
    void testObserverRegistration() {
        human.registerObserver(observer);
        assertTrue(human.getObservers().contains(observer));
    }

    @Test
    void testObserverRemoval() {
        human.registerObserver(observer);
        human.removeObserver(observer);
        assertFalse(human.getObservers().contains(observer));
    }
}
