package Group6Ranger;
/**
 * 
 * Public interface which is notified by an associated range sensor when requirements are met.
 */
public interface IRangeObserver {
    
    /**
     *
     * @param rangesensor
     */
    public void update(RangeSensor rangesensor);
}
