package radio;

import java.util.LinkedList;
import java.util.List;

public abstract class Radio implements Observable {
    public RadioPlayer radioPlayer;
    private boolean isPlaying;
    private List<Observer> observers = new LinkedList<>();

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

    }

    public void changeFrequency(double frequency) {
        radioPlayer.changeFrequencyRadio(frequency);
    }

    public void changePlayingStatus(boolean isPlaying) {
        this.isPlaying = !isPlaying;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers)
            observer.update(radioPlayer.volume, radioPlayer.frequency, isPlaying);
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}
