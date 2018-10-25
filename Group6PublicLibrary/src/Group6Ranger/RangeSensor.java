package Group6Ranger;

import java.util.List;
import org.iot.raspberry.grovepi.GrovePi;
import org.iot.raspberry.grovepi.devices.GroveUltrasonicRanger;

/**
 * abstract subject provides methods for storing, removing, and notifying observers
 */
abstract class RangeSensor extends GroveUltrasonicRanger{
    private List<IRangeObserver> observers;

    public RangeSensor(GrovePi grovePi, int pin) {
        super(grovePi, pin);
    }
    
    public void attachObserver(IRangeObserver observer){
        observers.add(observer);
    }
    public void detachObserver(IRangeObserver observer){
        observers.remove(observer);
    }
    public final void notifyObservers(){
        observers.forEach((o) -> {
            o.update(this);
        });
    }
}
