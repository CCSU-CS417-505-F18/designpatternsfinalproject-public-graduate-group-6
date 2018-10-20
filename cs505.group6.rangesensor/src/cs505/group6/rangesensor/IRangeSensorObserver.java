package cs505.group6.rangesensor;
/**
 * A range sensor observer that can be registered with an instances of a class implementing the IRangeSensor interface 
 * and receive updates with range-related information.
 * 
 * @authors Paul Borysewicz, David Hanley, Chris Mirabello, Wayne Work 
 * @version 10/20/2018
 */
public interface IRangeSensorObserver
{
    /**
     * Update the range sensor observer with range sensor info.
     * 
     * @param rangeSensorInfo object containing information from the range sensor (i.e. distance etc.)
     */
    void update(RangeSensorInfo rangeSensorInfo);
}
