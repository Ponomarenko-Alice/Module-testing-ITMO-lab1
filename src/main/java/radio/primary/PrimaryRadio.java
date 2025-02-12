package radio.primary;

import lombok.Getter;
import radio.Radio;
import radio.RadioPlayer;

@Getter
public class PrimaryRadio extends Radio {
    private final Button button;

    public PrimaryRadio(RadioPlayer radioPlayer, Button button) {
        super(radioPlayer);
        this.button = button;
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

    @Override
    public void changeFrequency(double frequency) {
        super.changeFrequency(frequency);
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }
}
