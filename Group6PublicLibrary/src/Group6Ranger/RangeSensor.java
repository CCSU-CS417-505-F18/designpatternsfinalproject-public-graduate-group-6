package Group6Ranger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * abstract subject provides methods for storing, removing, and notifying
 * observers
 */
abstract class RangeSensor {

    private List<IRangeObserver> observers;

    /**
     * Constructor
     * creates a python file to use built in grove pi functionality
     * @param pin GrovePi pin the sensor is connected to
     */
    public RangeSensor(int pin) {
        PyFile.createFile(pin);
    }

    public void attachObserver(IRangeObserver observer) {
        observers.add(observer);
    }

    public void detachObserver(IRangeObserver observer) {
        observers.remove(observer);
    }

    public final void notifyObservers() {
        observers.forEach((o) -> {
            o.update(this);
        });
    }
}
