package cs505.group6.rangesensor;
/**
 * A range sensor that keeps track of registered IRangeSensorObserver instances and notifies them when necessary.
 * 
 * @authors Paul Borysewicz, David Hanley, Chris Mirabello, Wayne Work 
 * @version 10/20/2018
 */
public interface IRangeSensor
{
    /**
     * Register an observer with the range sensor so it can receive updates
     * 
     * @param observer 
     */
    public void addObserver(IRangeSensorObserver observer);
    
    /**
     * Unregister an observer with the range sensor so it no longer receive updates
     *
     * @param observer
     */
    public void removeObserver(IRangeSensorObserver observer);
    
    /**
     * Notify any registered observers with a range sensor update
     */
    public void notifyObservers();
}
