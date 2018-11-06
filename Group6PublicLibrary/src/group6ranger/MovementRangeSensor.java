package group6ranger;

import java.io.IOException;
import org.iot.raspberry.grovepi.GrovePi;

/**
 * Concrete subject to detect when there is movement in front of the sensor
 */
public final class MovementRangeSensor extends RangeSensor {

    /**
     * Constructor
     * @param grovePi Reference to the GrovePi object
     * @param pin The pin the Sensor is attached to on the Pi itself
     */
    public MovementRangeSensor(GrovePi grovePi, int pin) {
        super(grovePi, pin);
        System.out.println("Movement Range Sensor initialized on pin: " + pin);
    }

    /**
     * Continuously fires Range calls from the Ultrasonic Sensor to check for 
     * movement. Checks differences in the distance returned against a static 
     * threshold to determine if an object moved within the Sensor's range.
     * Notifies all Observers if a valid movement was determined
     * @return true when valid movement is detected
     */
    public boolean detectMovement() {
        running = true;
        double distance;
        try {
            distance = ranger.get();
        } catch (IOException ex) {
            System.out.println("IOException in detectMovement of Movement Range Sensor:\n" + ex);
            return false;
        }
        while (running) {
            try {
                //System.out.println("Movement Range Sensor: Checking range");
                double newRange = ranger.get();
                if (Math.abs(distance - newRange) > 5) {
                    notifyObservers(distance);
                    return true;
                }
            } catch (IOException ex) {
                System.out.println("IOException in detectMovement of Movement Range Sensor:\n" + ex);
                return false;
            }
        }
        return false;
    }
}
