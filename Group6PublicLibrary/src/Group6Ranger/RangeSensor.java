package Group6Ranger;

import java.util.*;
import org.iot.raspberry.grovepi.GrovePi;
import org.iot.raspberry.grovepi.devices.GroveUltrasonicRanger;

/**
 * abstract subject provides methods for storing, removing, and notifying observers
 */
public abstract class RangeSensor{
    private List<IRangeObserver> observers = new ArrayList<IRangeObserver>();
     GroveUltrasonicRanger ranger;

    public RangeSensor(GrovePi grovePi, int pin) {
        ranger = new GroveUltrasonicRanger(grovePi, pin);
    }
    
    public void attachObserver(IRangeObserver observer){
        observers.add(observer);
    }
    public void detachObserver(IRangeObserver observer){
        observers.remove(observer);
    }
    public final void notifyObservers(double range){
        observers.forEach((o) -> {
            o.update(this, range);
        });
    }
}
