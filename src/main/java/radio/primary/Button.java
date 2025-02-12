package radio.primary;

import radio.smart.Observable;
import util.Observer;

import java.util.LinkedList;
import java.util.List;

public class Button implements Observable {
    private boolean isPressed;
    private final List<Observer> observers = new LinkedList<>();

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
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public boolean isPressed() {
        return isPressed;
    }
}
