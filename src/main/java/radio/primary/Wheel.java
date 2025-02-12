package radio.primary;

import exception.WheelDirectionException;
import lombok.Getter;
import radio.Direction;
import radio.Observable;
import radio.Observer;

import java.util.LinkedList;
import java.util.List;

@Getter
public abstract class Wheel implements Observable {
    private final List<Observer> observers = new LinkedList<>();

    protected final int WITHOUT_CHANGE_STATE = -1000;

    private int lastTwistedDegree;
    private Direction lastInteractionDirection;

    Wheel() {
        this.lastInteractionDirection = Direction.NONE;
        this.lastTwistedDegree = WITHOUT_CHANGE_STATE;
    }

    public void setLastInteraction(Direction direction, int degree) throws WheelDirectionException {
        if (Direction.RIGHT.equals(direction) || Direction.LEFT.equals(direction)) {
            this.lastInteractionDirection = direction;
            this.lastTwistedDegree = degree;
            notifyObservers();
        } else {
            throw new WheelDirectionException("Invalid direction: " + direction);
        }

    }

    public void setWithoutChangeState() {
        this.lastInteractionDirection = Direction.NONE;
        this.lastTwistedDegree = WITHOUT_CHANGE_STATE;

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
