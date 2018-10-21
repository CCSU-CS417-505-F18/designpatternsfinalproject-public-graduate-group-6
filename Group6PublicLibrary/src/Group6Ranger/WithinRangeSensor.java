package Group6Ranger;

import org.iot.raspberry.grovepi.GrovePi;

/**
 * concrete subject which detects when an object is within a certain range of the sensor
 */
public final class WithinRangeSensor extends RangeSensor {
    
    /**
     *
     * @param grovePi
     * @param pin
     */
    public WithinRangeSensor(GrovePi grovePi, int pin) {
        super(grovePi, pin);
    }
    
}
