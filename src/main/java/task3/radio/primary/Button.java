package task3.radio.primary;

import lombok.Getter;
import task3.util.Observer;

import java.util.LinkedList;
import java.util.List;

@Getter
public class Button {
    private final List<Observer> observers = new LinkedList<>();
    private boolean isPressed;

    public Button() {
        this.isPressed = false;
    }

    public void changePressState() {
        isPressed = !isPressed;
    }

}
