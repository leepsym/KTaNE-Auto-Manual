package Main;

import java.awt.*;

public class Static {
    public static Window window;
    public static void main(String[] args) {
        window = new Window();
    }
    public static GridBagConstraints constraints(int x, int y, int w, int h) {
        return new GridBagConstraints(
                x,y,w,h,
                1,1, GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0, 0, 0, 0),0,0);
    }
}
