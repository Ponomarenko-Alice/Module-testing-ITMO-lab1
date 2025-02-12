package radio.smart;

import radio.Direction;
import radio.RadioPlayer;

public class SmartRadioPlayer extends RadioPlayer {

    @Override
    public void changeVolumeRadio(int volume) { //TODO where is freq
        System.out.println("changeV");

    }

    /**
     * Method collect status information from radio parts (display) and update
     * playing values (playing status - play or pause, volume and frequency).
     * If radioPlayer is already playing and received signal to play, do nothing.
     * Otherwise, if radioPlayer is already stopped and receiving signal to stop, do nothing.
     * Displays the result of changes.
     */
    @Override
    public void update() {
        SmartRadio radio = (SmartRadio) this.getRadio();

        Direction lastInteractionDisplayDirection = radio.getDisplay().getLastInteractionDirection();
        int lastInteractionDisplayValue = radio.getDisplay().getLastInteractionValue();

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
            case UP -> this.setVolume(this.getVolume() + lastInteractionDisplayValue);
            case DOWN -> this.setVolume(this.getVolume() - lastInteractionDisplayValue);
            case FORWARD -> this.setFrequency(this.getFrequency() + lastInteractionDisplayValue);
            case BACK -> this.setFrequency(this.getFrequency() - lastInteractionDisplayValue);
        }

        display();

        radio.getDisplay().setWithoutChangeState(); // to reset changes status after displaying (applying) result of changes
    }

    //unused for display, but should be overridden
    @Override
    public void update(Direction direction, int waveValue) {
    }


}
