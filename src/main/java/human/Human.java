package human;

import exception.WheelDirectionException;
import lombok.Getter;
import radio.Direction;
import radio.primary.Button;
import radio.primary.Wheel;
import util.Observer;

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
        System.out.println("\n" + this.name + " waved hand to " + direction.name() + " with " + waveValue + " value");
        notifyObservers(direction, waveValue);
    }

    @Override
    public void tap() {
        Movable.super.tap();
    }

    @Override
    public void twist(Object object, Direction direction, int degree) {
        System.out.println("\n" + this.name + " twisted the " + object.getClass().getSimpleName() + " to " + direction.name() + " on " + degree + " degree");
        try {
            if (object instanceof Wheel wheel) {
                wheel.setLastInteraction(direction, degree);
            }
        } catch (WheelDirectionException e) {
            System.out.println("\n Failed to twist wheel. " + e.getMessage());
        }
    }

    @Override
    public void press(Object object) {
        if (object instanceof Button button) {
            System.out.println("\n" + this.name + " pressed the button ");
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
    public void notifyObservers(Direction direction, int waveValue) {
        for (Observer observer : observers) {
            observer.update(direction, waveValue);
        }
    }
}
