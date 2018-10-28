package Group6Ranger;

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
