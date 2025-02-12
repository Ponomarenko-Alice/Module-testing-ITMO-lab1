package radio.smart;

import radio.Direction;
import radio.RadioPlayer;

public class SmartRadioPlayer extends RadioPlayer {

    @Override
    public void playRadio() {
        System.out.println("song");
    }

    @Override
    public void stopRadio() {
        System.out.println("stop");
    }

    @Override
    public void changeVolumeRadio(int volume) {
        System.out.println("changeV");

    }

    @Override
    public void update() {
        SmartRadio radio = (SmartRadio) this.getRadio();
        Direction lastInteractionDisplayDirection = radio.getDisplay().getLastInteractionDirection();
        int lastInteractionDisplayValue = radio.getDisplay().getLastInteractionValue();
        switch (lastInteractionDisplayDirection) {
            case RIGHT -> this.playRadio();
            case LEFT -> this.stopRadio();
            case UP -> this.setVolume(this.getVolume() + lastInteractionDisplayValue);
            case DOWN -> this.setVolume(this.getVolume() - lastInteractionDisplayValue);
            case FORWARD -> this.setFrequency(this.getFrequency() + lastInteractionDisplayValue);
            case BACK -> this.setFrequency(this.getFrequency() - lastInteractionDisplayValue);
        }

        display();

        radio.getDisplay().setWithoutChangeState();
    }


}
