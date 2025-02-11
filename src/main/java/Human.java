import radio.primary.Button;
import radio.smart.Direction;

public class Human implements Movable {
    private final String name;


    public Human(String name) {
        this.name = name;
    }

    @Override
    public void wave(Direction direction) {
        Movable.super.wave(direction);
    }

    @Override
    public void tap() {
        Movable.super.tap();
    }

    @Override
    public void swing() {
        Movable.super.swing();
    }

    @Override
    public void press(Object object) {
        if (object instanceof Button button) {
            button.changePressState();
        }
    }

    public String getName() {
        return name;
    }
}
