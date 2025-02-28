package task3.radio.smart;

import lombok.Getter;
import task3.radio.Direction;
import task3.radio.Radio;
import task3.radio.RadioPlayer;
import task3.util.Observer;

@Getter
public class SmartRadioPlayer extends RadioPlayer implements Observer {
    private final Display display;

    public SmartRadioPlayer(Radio radio, Display display) {
        super(radio);
        this.display = display;
    }


    /**
     * Method collect status information from radio parts (display) and update
     * playing values (playing status - play or pause, volume and frequency).
     * If radioPlayer is already playing and received signal to play, do nothing.
     * Otherwise, if radioPlayer is already stopped and receiving signal to stop, do nothing.
     * Displays the result of changes.
     */
    public void update() {
        Direction lastDirection = display.getLastDirection();
        int lastValue = display.getLastValue();

        switch (lastDirection) {
            case RIGHT -> {
                if (!radio.isPLaying()) {
                    togglePower(radio);
                }
            }
            case LEFT -> {
                if (radio.isPLaying()) {
                    radio.disable();
                }
            }
            case UP -> volumeUpByValue(lastValue);
            case DOWN -> volumeDownByValue(lastValue);
            case FORWARD -> frequencyUpByValue(lastValue);
            case BACK -> frequencyDownByValue(lastValue);
            case NONE -> {
                return;
            }
        }

        radio.display();

        display.setWithoutChangeState(); // to reset changes status after displaying (applying) result of changes
    }

    @Override
    public void update(Direction direction, int waveValue) {
        //unused
    }


}
