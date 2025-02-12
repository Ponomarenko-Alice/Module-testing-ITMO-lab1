package radio.smart;

import lombok.Getter;
import radio.Observable;
import radio.Observer;

import java.util.LinkedList;
import java.util.List;

@Getter
public class Display implements Observable {

    private Direction lastInteractionDirection;
    private List<Observer> observers = new LinkedList<>();


    public Display(Direction lastInteractionDirection) {
        this.lastInteractionDirection = lastInteractionDirection;
    }

    public Display() {
    }

    public void changePressState(Direction newDirection) {
        this.lastInteractionDirection = newDirection;
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
