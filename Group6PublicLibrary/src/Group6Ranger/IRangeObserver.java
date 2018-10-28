package Group6Ranger;
/**
 * 
 * Public interface which is notified by an associated range sensor when 
 * requirements are met.
 */
public interface IRangeObserver {
    
    /**
     * Provide implementation for updating application data based on 
     * Sensor values
     * @param rangesensor The Range Sensor to receive updates from
     * @param range A given range to have the Sensor check against
     */
    public void update(RangeSensor rangesensor, double range);
}
