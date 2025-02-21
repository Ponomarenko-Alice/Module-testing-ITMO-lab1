package task3.radio.primary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import task3.radio.Radio;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    private PrimaryRadioPlayer radioPlayer;

    @BeforeEach
    void setRadioPlayer() {
        MockitoAnnotations.openMocks(this);
        Radio radio = new Radio();
        Button button = new Button();
        Wheel volumeWheel = new Wheel();
        Wheel frequencyWheel = new Wheel();
        radioPlayer = new PrimaryRadioPlayer(radio, button, volumeWheel, frequencyWheel);
        button.registerObserver(radioPlayer);
        volumeWheel.registerObserver(radioPlayer);
        frequencyWheel.registerObserver(radioPlayer);

    }


    @Test
    void testPlayingStatusWhileButtonIsNotPressed() {
        assertEquals(radioPlayer.getButton().isPressed(), radioPlayer.getRadio().isPLaying());
    }

    @Test
    void testPlayingStatusWhileButtonIsPressed() {
        radioPlayer.getButton().changePressState();

        assertEquals(radioPlayer.getButton().isPressed(), radioPlayer.getRadio().isPLaying());
    }


}
