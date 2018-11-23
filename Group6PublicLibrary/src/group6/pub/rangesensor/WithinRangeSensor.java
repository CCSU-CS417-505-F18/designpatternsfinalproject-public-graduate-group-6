package group6.pub.rangesensor;

import java.io.IOException;
import org.iot.raspberry.grovepi.GrovePi;

/**
 * Concrete subject which detects when an object is within a certain range 
 * of the sensor
 */
public final class WithinRangeSensor extends RangeSensor {

    /**
     * Constructor
     * @param grovePi Reference to the GrovePi object
     * @param pin The pin the Sensor is attached to on the Pi itself
     */
    public WithinRangeSensor(GrovePi grovePi, int pin) {
        super(grovePi, pin);
    }

    /**
     * Continuously fires Range calls from the Ultrasonic Sensor to check for 
     * range. Checks the returned range against the passed in range 
     * threshold to determine if an object is within range.
     * Notifies all Observers if an object is within range
     * @param range range that the sensor should check against
     * @return true when an object is within the given range
     */
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
