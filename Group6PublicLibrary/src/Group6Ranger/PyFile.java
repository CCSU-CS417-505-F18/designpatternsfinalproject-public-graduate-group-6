package Group6Ranger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * creates the Py file which will get the range sensor data with a singleton pattern
 */
public class PyFile {

    private static File file = null;

    private PyFile(int pin) {
        file = new File("range.py");
        if (file.exists()) {
            file.delete();
        }
        try {
            String prg = "import sys\nsys.path.insert(0, '/home/pi/Desktop/GrovePi/Software/Python')\nimport grovepi\nprint(grovepi.ultrasonicRead(" + pin + "))";
            BufferedWriter out = new BufferedWriter(new FileWriter("range.py"));
            out.write(prg);
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void createFile(int pin) {
        if (file == null) {
           new PyFile(pin);
        }
    }

}
