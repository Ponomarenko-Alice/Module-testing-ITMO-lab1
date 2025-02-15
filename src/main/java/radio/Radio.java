package radio;

import lombok.Getter;
import radio.smart.Observable;
import util.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Radio implements Observable {
    protected final RadioPlayer radioPlayer;
    @Getter
    private List<Observer> observers = new ArrayList<>();

    public Radio(RadioPlayer radioPlayer) {
        this.radioPlayer = radioPlayer;
    }

    public void play() {
        radioPlayer.playRadio();
    }

    public void stop() {
        radioPlayer.stopRadio();
    }

    public void changeVolume(int volume) {
        radioPlayer.changeVolumeRadio(volume);
        notifyObservers();
    }

    public void changeFrequency(double frequency) {
        radioPlayer.changeFrequencyRadio(frequency);
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

}
