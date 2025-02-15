package radio.smart;

import util.Observer;

import java.util.LinkedList;
import java.util.List;

public interface Observable {
    List<Observer> observers = new LinkedList<>();

    default void registerObserver(Observer o) {
        observers.add(o);
    }

    default void removeObserver(Observer o) {
        observers.remove(o);
    }

    void notifyObservers();

}