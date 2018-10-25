package Group6Ranger;

import org.iot.raspberry.grovepi.GrovePi;

/**
 * concrete subject to detect when there is movement in front of the sensor
 */
public final class MovementRangeSensor extends RangeSensor {
    
    /**
     *
     * @param grovePi
     * @param pin
     */
    public MovementRangeSensor(GrovePi grovePi, int pin) {
        super(grovePi, pin);
    }
    
}
