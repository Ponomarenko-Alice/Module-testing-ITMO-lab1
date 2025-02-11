import radio.smart.Direction;

public interface Movable {
    default void wave(Direction direction) {}
    default void tap(){}
    default void swing(){}
    default void press(Object object){}
}
