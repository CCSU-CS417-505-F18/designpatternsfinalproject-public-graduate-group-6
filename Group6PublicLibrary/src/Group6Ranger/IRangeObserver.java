package Group6Ranger;
/**
 * 
 * Public interface which is notified by an associated range sensor when requirements are met.
 */
public interface IRangeObserver {
    
    /**
     *
     * @param rangesensor
     * @param range
     */
    public void update(RangeSensor rangesensor, double range);
}
