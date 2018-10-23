package Group6Ranger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * concrete subject to return the current range of an object in front of the
 * sensor
 */
public final class DetectRangeSensor extends RangeSensor {

    public DetectRangeSensor(int pin) {
        super(pin);
    }

    /**
     * Detects the range of an object in front of the sensor
     * @param pin pin the sensor is attached to
     * @return range
     */
    public int getRange(int pin) {
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "range.py");
            Process p = pb.start();
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            return Integer.parseInt(in.readLine());
        } catch (IOException e) {
            System.out.println(e);
            return -1;
        }
    }

}
