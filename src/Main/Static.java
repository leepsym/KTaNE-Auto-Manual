package Main;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

public class Static {
    private static String[] input;
    private static int strikes = 0;
    private static String serial;
    public static Window window = new Window();

    public static void main(String[] args) {}
    public static GridBagConstraints constraints(int x, int y, int w, int h) {
        return new GridBagConstraints(
                x,y,w,h,
                1,1, GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0, 0, 0, 0),0,0);
    }
    public static int strikes() {
        return strikes;
    }
    public static String serial(ActionListener action) {
        if (serial == null) {
            String[] value = input();
            if (value != null) {
                serial = value[0];
            } else {
                window.textFieldQuery("What is the serial number?", action);
            }
        }
        return serial;
    }
    public static void input(String[] value) {
        input = value;
    }
    public static String[] input() {
        String[] value = input;
        input = null;
        return value;
    }
}
