package task3.radio.primary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

public class RadioTest {
    private final PrimaryRadioPlayer radioPlayer = new PrimaryRadioPlayer();

    //    private PrimaryRadio radio = new PrimaryRadio(radioPlayer,);
    @BeforeEach
    void setRadio() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testPlayingStatusWhileButtonIsPressed() {
        Button button = new Button();

        PrimaryRadio radio = new PrimaryRadio(new PrimaryRadioPlayer(), new Button(), new VolumeWheel(), new FrequencyWheel());

    }
}
