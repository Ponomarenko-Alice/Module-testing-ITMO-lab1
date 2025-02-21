package task3.radio.primary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import task3.exception.WheelDirectionException;
import task3.radio.Direction;
import task3.radio.Radio;

import static org.junit.jupiter.api.Assertions.*;

public class WheelTest {

    private PrimaryRadioPlayer radioPlayer;

    @BeforeEach
    void setRadioPlayer() {
        MockitoAnnotations.openMocks(this);
        Wheel volumeWheel = new Wheel();
        Wheel frequencyWheel = new Wheel();
        Radio radio = new Radio();
        radioPlayer = new PrimaryRadioPlayer(radio, Mockito.mock(Button.class), volumeWheel, frequencyWheel);
        volumeWheel.registerObserver(radioPlayer);
        frequencyWheel.registerObserver(radioPlayer);
    }

    @Test
    void testSetInvalidWheelUpDirection() {
        WheelDirectionException directionException = assertThrows(WheelDirectionException.class, () -> {
            radioPlayer.getFrequencyWheel().setLastInteraction(Direction.UP, 10);
        });
        assertEquals("Invalid direction: " + Direction.UP, directionException.getMessage());
    }

    @Test
    void testSetInvalidWheelDownDirection() {
        WheelDirectionException directionException = assertThrows(WheelDirectionException.class, () -> {
            radioPlayer.getFrequencyWheel().setLastInteraction(Direction.DOWN, 10);
        });
        assertEquals("Invalid direction: " + Direction.DOWN, directionException.getMessage());
    }

    @Test
    void testSetInvalidWheelForwardDirection() {
        WheelDirectionException directionException = assertThrows(WheelDirectionException.class, () -> {
            radioPlayer.getFrequencyWheel().setLastInteraction(Direction.FORWARD, 10);
        });
        assertEquals("Invalid direction: " + Direction.FORWARD, directionException.getMessage());
    }

    @Test
    void testSetInvalidWheelBackDirection() {
        WheelDirectionException directionException = assertThrows(WheelDirectionException.class, () -> {
            radioPlayer.getFrequencyWheel().setLastInteraction(Direction.BACK, 10);
        });
        assertEquals("Invalid direction: " + Direction.BACK, directionException.getMessage());
    }

    @Test
    void testSetWheelNoneDirection() {
        assertDoesNotThrow(() -> {
            radioPlayer.getFrequencyWheel().setLastInteraction(Direction.NONE, 10);
        });
    }

    @Test
    void testBigFrequencyDegreeValue() {
        double previousFrequencyValue = radioPlayer.getRadio().getFrequency();

        radioPlayer.frequencyUpByValue(1000.0);
        assertEquals(previousFrequencyValue + 1000.0, radioPlayer.getRadio().getFrequency());
    }

    @Test
    void testBigNegativeFrequencyDegreeValue() {
        radioPlayer.frequencyDownByValue(1000.0);
        assertEquals(radioPlayer.getRadio().getMIN_FREQUENCY(), radioPlayer.getRadio().getFrequency());
    }

    @Test
    void testBigVolumeDegreeValue() {
        radioPlayer.volumeUpByValue(1000);
        assertEquals(radioPlayer.getRadio().getMAX_VOLUME(), radioPlayer.getRadio().getVolume());
    }

    @Test
    void testBigNegativeVolumeDegreeValue() {
        radioPlayer.volumeDownByValue(1000);
        assertEquals(radioPlayer.getRadio().getMIN_VOLUME(), radioPlayer.getRadio().getVolume());
    }


}
