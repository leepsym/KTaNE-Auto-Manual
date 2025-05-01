package Standard;

import Main.Option;
import Main.Static;

public class Wires {
    public Wires() {
        Static.window.query("How many wires?", new Option[]{
                new Option("3", l -> three()),
                new Option("4", l -> four()),
                new Option("5", l -> five()),
                new Option("6", l -> six())
        });
    }
    private void three() {
        System.out.println("3");
    }

    private void four() {
        System.out.println("4");
    }

    private void five() {
        System.out.println("5");
    }

    private void six() {
        System.out.println("6");
    }
}
