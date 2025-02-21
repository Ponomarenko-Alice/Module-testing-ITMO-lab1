package task3.human;

import lombok.Getter;
import task3.exception.WheelDirectionException;
import task3.radio.Direction;
import task3.radio.primary.Button;
import task3.radio.primary.Wheel;
import task3.util.Observable;
import task3.util.Observer;

import java.util.LinkedList;
import java.util.List;

@Getter
public class Human implements Movable, Observable {
    private final String name;
    private final List<Observer> observers = new LinkedList<>();


    public Human(String name) {
        this.name = name;
    }

    @Override
    public void wave(Direction direction, int waveValue) {
        System.out.printf("\n %s waved hand to %s with %d value \n", name, direction.name(), waveValue);
        notifyObservers(direction, waveValue);
    }

    @Override
    public void tap() {
        Movable.super.tap();
    }

    @Override
    public void twist(Object object, Direction direction, int degree) {
        System.out.printf("\n %s twisted the %s to %s on %d degree \n", name, object.getClass().getSimpleName(), direction.name(), degree);
        try {
            if (object instanceof Wheel wheel) {
                wheel.setLastInteraction(direction, degree);
            }
        } catch (WheelDirectionException e) {
            System.out.printf("\n Failed to twist wheel. %s \n", e.getMessage());
        }
    }

    @Override
    public void press(Object object) {
        if (object instanceof Button button) {
            System.out.printf("\n %s pressed the button \n", name);
            button.changePressState();
        }
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
        //unused
    }

    /**
     * Observer is a display of radio
     */
    @Override
    public void notifyObservers(Direction direction, int waveValue) {
        for (Observer observer : observers) {
            observer.update(direction, waveValue);
        }
    }
}
