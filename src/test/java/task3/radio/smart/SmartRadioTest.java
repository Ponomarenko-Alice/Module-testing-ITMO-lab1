package task3.radio.smart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import task3.radio.Radio;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SmartRadioTest {
    private SmartRadioPlayer smartRadioPlayer;

    @BeforeEach
    void init() {
        smartRadioPlayer = new SmartRadioPlayer(Mockito.mock(Radio.class), Mockito.mock(Display.class));
    }

    @Test
    void testRadioInteraction() {
        smartRadioPlayer.togglePower(smartRadioPlayer.getRadio());
        verify(smartRadioPlayer.getRadio(), times(1)).enable();
    }


}
