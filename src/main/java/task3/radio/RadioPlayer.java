package task3.radio;

import lombok.Getter;

@Getter
public abstract class RadioPlayer {

    protected final Radio radio;

    public RadioPlayer(Radio radio) {
        this.radio = radio;
    }

    public void togglePower(Radio radio) {
        if (radio.isPLaying()) {
            radio.disable();
        } else {
            radio.enable();
        }
    }

    public void volumeUpByValue(int value) {
        radio.setVolume(radio.getVolume() + value);
    }

    public void volumeDownByValue(int value) {
        radio.setVolume(radio.getVolume() - value);
    }

    public void frequencyUpByValue(double value) {
        radio.setFrequency(radio.getFrequency() + value);
    }

    public void frequencyDownByValue(double value) {
        radio.setFrequency(radio.getFrequency() - value);
    }

}

