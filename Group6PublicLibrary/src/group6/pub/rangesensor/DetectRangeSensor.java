package group6.pub.rangesensor;

import java.io.IOException;
import org.iot.raspberry.grovepi.GrovePi;

/**
 * Concrete subject to return the current range of an object in front of the 
 * sensor
 */
public final class DetectRangeSensor extends RangeSensor {

    /**
     * Constructor
     * @param grovePi Reference to the GrovePi object
     * @param pin The pin the Sensor is attached to on the Pi itself
     */
    public DetectRangeSensor(GrovePi grovePi, int pin) {
        super(grovePi, pin);
    }

    /**
     * Calls the Ultrasonic's range finder to get the current distance 
     * in front of the sensor.  Updates all observers with the distance
     * then returns the distance
     * Will return -1 if the sensor get() fails with IOException
     * @return double - 
     */
    public double GetRange() {
        try {
            double distance = ranger.get();
            notifyObservers(distance);
            return distance;
        } catch (IOException ex) {
            return -1;
        }
    }
}
