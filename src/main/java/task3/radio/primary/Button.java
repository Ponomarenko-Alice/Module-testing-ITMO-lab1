package task3.radio.primary;

import lombok.Getter;
import task3.radio.Direction;
import task3.util.Observable;
import task3.util.Observer;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Button implements Observable {
    List<Observer> observers = new ArrayList<>();
    private boolean isPressed;

    public Button() {
        this.isPressed = false;
    }

    public void changePressState() {
        isPressed = !isPressed;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    /**
     * Notifying PrimaryRadioPlayer about button changing
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void notifyObservers(Direction direction, int waveValue) {
        //unused
    }
}
