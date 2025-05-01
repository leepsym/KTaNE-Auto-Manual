package Main;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Static {
    private static int strikes;
    private static String serial;

    public static Window window;
    public static void main(String[] args) {
        strikes = 3;
        window = new Window();
    }
    public static GridBagConstraints constraints(int x, int y, int w, int h) {
        return new GridBagConstraints(
                x,y,w,h,
                1,1, GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0, 0, 0, 0),0,0);
    }
    public static int strikes() {
        return strikes;
    }
    public static String serial() {
        if (serial == null) serial = window.textFieldQuery("What is the serial number?").toUpperCase();
        return serial;
    }
}
