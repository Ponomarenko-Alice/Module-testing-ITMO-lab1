package radio.primary;

import lombok.Getter;
import radio.smart.Observable;
import util.Observer;

import java.util.LinkedList;
import java.util.List;

@Getter
public class Button implements Observable {
    private final List<Observer> observers = new LinkedList<>();
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

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
