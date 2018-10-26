package Group6Ranger;

import java.io.IOException;
import org.iot.raspberry.grovepi.GrovePi;

/**
 * concrete subject to detect when there is movement in front of the sensor
 */
public final class MovementRangeSensor extends RangeSensor {

    private boolean running = false;

    /**
     *
     * @param grovePi
     * @param pin
     */
    public MovementRangeSensor(GrovePi grovePi, int pin) {
        super(grovePi, pin);
    }

    public void stop() {
        running = false;
    }

    public boolean detectMovement() {
        running = true;
        double distance;
        try {
            distance = ranger.get();
        } catch (IOException ex) {
            System.out.println("error");
            return false;
        }
        while (running) {
            try {
                double newRange = ranger.get();
                if (Math.abs(distance - newRange) > 5) {
                    notifyObservers(distance);
                    return true;
                }
            } catch (IOException ex) {
                System.out.println("error");
                return false;
            }
        }
        return false;
    }
}
