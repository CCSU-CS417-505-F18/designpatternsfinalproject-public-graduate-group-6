package group6.pub.rangesensor;

import java.util.*;
import org.iot.raspberry.grovepi.GrovePi;
import org.iot.raspberry.grovepi.devices.GroveUltrasonicRanger;

/**
 * Abstract subject provides methods for storing, removing, and notifying observers
 */
public abstract class RangeSensor{
    private List<IRangeObserver> observers = new ArrayList<IRangeObserver>();
    protected GroveUltrasonicRanger ranger;

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
     * @param observer observer object that should receive updates
     */
    public void attachObserver(IRangeObserver observer){
        observers.add(observer);
    }
    
    /**
     * Use to detach Observers so they no longer receive updates
     * @param observer observer object that should no longer receive updates
     */
    public void detachObserver(IRangeObserver observer){
        observers.remove(observer);
    }
    
    /**
     * Updates all attached Observers
     * @param range the range that the sensor detected
     */
    public final void notifyObservers(double range){
        observers.forEach((o) -> {
            o.update(this, range);
        });
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.observers);
        hash = 43 * hash + (this.running ? 1 : 0);
        hash = 43 * hash + this.pin;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RangeSensor other = (RangeSensor) obj;
        if (this.running != other.running) {
            return false;
        }
        if (this.pin != other.pin) {
            return false;
        }
        if (!Objects.equals(this.observers, other.observers)) {
            return false;
        }
        return true;
    }
    
    /*
     * Returns string representation of this instance.
     */
    @Override 
    public String toString() {
        return String.format("%s %s %s", this.getClass().getSimpleName(), grovePi, pin);
    }
    
    /*
     * An iterator over a RangeSensor's observers.
     * @return an iterator that moves through the RangeSensor's observers in reverse order starting with the most recently attached observer.
     */
    public Iterator<IRangeObserver> iterator() {
        return new RangeObserverIterator(this.observers);
    }
    
    /*
     * An iterator over a RangeSensor's observers.
     *
     * The RangeObserverIterator iterates over a RangeSensor's observers in reverse order starting with the most recently attached observer.
     */
    private class RangeObserverIterator implements Iterator<IRangeObserver> {
        
        private final List<IRangeObserver> observers;
        private int index; 
        
        public RangeObserverIterator(List<IRangeObserver> observers) {
            Objects.requireNonNull(observers, "Non null observers value required.");
            this.observers = observers;
            this.index = observers.size() - 1;
        }
        
        /*
         * Returns true if iteration is not complete and false otherwise.
         */
        public boolean hasNext() {
            return this.index >= 0;
        }
                    
        /*
         * Returns next observer or null if iteration was completed in a previous call.
         * Clients should always call hasNext before calling next to ensure a non-null value.
         */
        public IRangeObserver next() {
            if (this.index < 0) {
                return null;
            }
            return this.observers.get(this.index--);
        }
        
    }
}
