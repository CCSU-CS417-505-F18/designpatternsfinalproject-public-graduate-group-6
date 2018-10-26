package Group6Ranger;

import java.io.IOException;
import org.iot.raspberry.grovepi.GrovePi;

/**
 * concrete subject which detects when an object is within a certain range of
 * the sensor
 */
public final class WithinRangeSensor extends RangeSensor {

    private boolean running = false;

    /**
     *
     * @param grovePi
     * @param pin
     */
    public WithinRangeSensor(GrovePi grovePi, int pin) {
        super(grovePi, pin);
    }

    public void stop() {
        running = false;
    }

    public boolean withinRange(double range) {
        running = true;
        while (running) {
            try {
                double distance = ranger.get();
                if (distance < range) {
                    notifyObservers(distance);
                    return true;
                }
            } catch (IOException ex) {
                return false;
            }
        }
        return false;
    }

}
