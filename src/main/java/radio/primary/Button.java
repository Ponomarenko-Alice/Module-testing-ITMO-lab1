package radio.primary;

import radio.Observable;
import radio.Observer;

import java.util.LinkedList;
import java.util.List;

public class Button implements Observable {
    private boolean isPressed;
    private List<Observer> observers = new LinkedList<>();;

    public Button() {
        this.isPressed = false;
    }

    public void changePressState() {
        this.isPressed = !isPressed;
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

    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update();
        }
    }

    public boolean isPressed() {
        return isPressed;
    }
}
