package radio.smart;

import lombok.Getter;
import radio.Direction;
import radio.Observable;
import radio.Observer;

import java.util.LinkedList;
import java.util.List;


@Getter
public class Display implements Observable {

    private Direction lastInteractionDirection;
    private int lastInteractionValue;
    protected final int WITHOUT_CHANGE_STATE = -1000;

    private final List<Observer> observers = new LinkedList<>();


    public void setLastInteractionDirection(Direction newDirection, int newValue) {
        this.lastInteractionDirection = newDirection;
        this.lastInteractionValue = newValue;
        notifyObservers();
    }

    public void setWithoutChangeState() {
        this.lastInteractionDirection = Direction.NONE;
        this.lastInteractionValue = WITHOUT_CHANGE_STATE;

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
