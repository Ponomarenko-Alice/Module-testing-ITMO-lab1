import exception.WheelDirectionException;
import lombok.Getter;
import radio.Direction;
import radio.primary.Button;
import radio.primary.Wheel;

@Getter
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
}
