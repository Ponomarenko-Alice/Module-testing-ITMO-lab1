package radio.smart;

import lombok.Getter;
import radio.Radio;
import radio.RadioPlayer;

@Getter
public class SmartRadio extends Radio {
    private final Display display;

    public SmartRadio(RadioPlayer radioPlayer, Display display) {
        super(radioPlayer);
        this.display = display;
    }

    @Override
    public void play() {
        super.play();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void changeVolume(int volume) {
        super.changeVolume(volume);
    }


}
