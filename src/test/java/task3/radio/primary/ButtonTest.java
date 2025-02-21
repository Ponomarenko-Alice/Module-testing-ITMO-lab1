package task3.radio.primary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import task3.util.Observer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ButtonTest {
    private Button button;

    @BeforeEach
    void setButton() {
        MockitoAnnotations.openMocks(this);
        button = new Button();
    }

    @Test
    void testInitialPressState() {
        assertFalse(button.isPressed(), "Should be not pressed initially");
    }

    @Test
    void testPressChangeState() {
        button.changePressState();
        assertTrue(button.isPressed());

        button.changePressState();
        assertFalse(button.isPressed());
    }

    @Test
    void testRegisterObserver() {
        Observer testObserver = mock(Observer.class);
        button.registerObserver(testObserver);
        assertAll(() -> assertEquals(1, button.getObservers().size()),
                () -> assertEquals(testObserver, button.getObservers().getFirst()));
    }

    @Test
    void testRemoveObserver() {
        Observer testObserver = mock(Observer.class);
        button.registerObserver(testObserver);
        button.removeObserver(testObserver);

        assertEquals(0, button.getObservers().size());
    }


    @Test
    void testCallUpdateMethodAfterChangingButtonStatus() {
        Observer testObserver = mock(Observer.class);
        button.registerObserver(testObserver);
        button.changePressState();

        verify(testObserver, times(1)).update();
    }


}
