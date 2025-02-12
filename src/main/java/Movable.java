import radio.Direction;

public interface Movable {
    default void wave(Direction direction) {
    }

    default void tap() {
    }

    default void twist(Object object, Direction direction, int degree) {
    }

    default void press(Object object) {
    }
}
