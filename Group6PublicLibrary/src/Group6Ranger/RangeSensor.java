package Group6Ranger;

import java.util.*;
import org.iot.raspberry.grovepi.GrovePi;
import org.iot.raspberry.grovepi.devices.GroveUltrasonicRanger;

/**
 * Abstract subject provides methods for storing, removing, and notifying observers
 */
public abstract class RangeSensor{
    private List<IRangeObserver> observers = new ArrayList<IRangeObserver>();
    GroveUltrasonicRanger ranger;

    protected boolean running = false;
    protected GrovePi grovePi;
    protected int pin;

     /**
     * Constructor - initializes an instance of the GroveUltrasonicRanger
     * @param grovePi Reference to the GrovePi object
     * @param pin The pin the Sensor is attached to on the Pi itself
     */
    public RangeSensor(GrovePi grovePi, int pin) {
        this.grovePi = grovePi;
        this.pin = pin;
        ranger = new GroveUltrasonicRanger(grovePi, pin);
    }
    
     /**
     * Stops the Sensor from firing continuous Range calls
     */
    public void stop() {
        running = false;
    }
    
    /**
     * Use to attach Observers to this Subject so they can receive future updates
     * @param observer 
     */
    public void attachObserver(IRangeObserver observer){
        observers.add(observer);
    }
    
    /**
     * Use to detach Observers so they no longer receive updates
     * @param observer 
     */
    public void detachObserver(IRangeObserver observer){
        observers.remove(observer);
    }
    
    /**
     * Updates all attached Observers
     */
    public final void notifyObservers(double range){
        observers.forEach((o) -> {
            o.update(this, range);
        });
    }
    
    /*
     * Checks 'this' and 'o' for equality
     * @param o object to check against 'this' for equality
     */
    @Override 
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        
        if (o == this) {
            return true;
        }
     
        if (o.getClass() != this.getClass()) {
            return false;
        }
        
        RangeSensor that = (RangeSensor) o;
        return Objects.equals(this.grovePi, that.grovePi) && this.pin == that.pin;
    }
    
    @Override 
    public int hashCode() {
        int hashCode = 0;
        hashCode += grovePi.hashCode();
        hashCode += pin;
        return hashCode;
    }
    
    @Override 
    public String toString() {
        return String.format("%s %s %s", this.getClass().getSimpleName(), grovePi, pin);
    }
}
