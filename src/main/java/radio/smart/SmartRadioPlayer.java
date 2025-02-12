package radio.smart;

import radio.Direction;
import radio.RadioPlayer;

public class SmartRadioPlayer extends RadioPlayer {

    SmartRadio radio = (SmartRadio) getRadio();

    /**
     * Method collect status information from radio parts (display) and update
     * playing values (playing status - play or pause, volume and frequency).
     * If radioPlayer is already playing and received signal to play, do nothing.
     * Otherwise, if radioPlayer is already stopped and receiving signal to stop, do nothing.
     * Displays the result of changes.
     */
    @Override
    public void update() {
        Direction lastInteractionDisplayDirection = radio.getDisplay().getLastInteractionDirection();
        int lastValue = radio.getDisplay().getLastInteractionValue();

        switch (lastInteractionDisplayDirection) {
            case RIGHT -> {
                if (!isPLaying()) {
                    radio.play();
                }
            }
            case LEFT -> {
                if (isPLaying()) {
                    radio.stop();
                }
            }
            case UP -> setVolume(getVolume() + lastValue);
            case DOWN -> setVolume(getVolume() - lastValue);
            case FORWARD -> setFrequency(getFrequency() + lastValue);
            case BACK -> setFrequency(getFrequency() - lastValue);
        }

        display();

        radio.getDisplay().setWithoutChangeState(); // to reset changes status after displaying (applying) result of changes
    }

    //unused for display, but should be overridden
    @Override
    public void update(Direction direction, int waveValue) {
    }


}
