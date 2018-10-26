package Group6Ranger;

import java.io.IOException;
import org.iot.raspberry.grovepi.GrovePi;

/**
 * concrete subject to return the current range of an object in front of the
 * sensor
 */
public final class DetectRangeSensor extends RangeSensor {

    /**
     *
     * @param grovePi
     * @param pin
     */
    public DetectRangeSensor(GrovePi grovePi, int pin) {
        super(grovePi, pin);
    }

    public double getRange() {
        try {
            double distance = ranger.get();
            notifyObservers(distance);
            return distance;
        } catch (IOException ex) {
            return -1;
        }
    }
}
