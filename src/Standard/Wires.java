package Standard;

import Main.Option;
import Main.Static;

public class Wires {
    public Wires() {
        Static.window.query("How many wires?", new Option[]{
                new Option("3", l -> three(0)),
                new Option("4", l -> four(0)),
                new Option("5", l -> five()),
                new Option("6", l -> six())
        });
    }
    private void three(int state) {
        switch (state) {
            case 0 ->
                Static.window.query("Are there any red wires?", new Option[]{
                        new Option("Yes", l -> three(1)),
                        new Option("No", l -> Static.window.query("Cut the second wire.", new Option[]{
                                new Option("Return", i -> Static.window.returnToModules())
                        }))
                });

            case 1 ->
                Static.window.query("Is the last wire white?", new Option[]{
                        new Option("Yes", l -> Static.window.query("Cut the last wire.", new Option[]{
                                new Option("Return", i -> Static.window.returnToModules())}
                        )),
                        new Option("No", l -> three(2))
                });

            case 2 ->
                Static.window.query("Is there more than one blue wire?", new Option[]{
                        new Option("Yes", l -> Static.window.query("Cut the last blue wire.", new Option[]{
                                new Option("Return", i -> Static.window.returnToModules())}
                        )),
                        new Option("No", l -> Static.window.query("Cut the last wire.", new Option[]{
                                new Option("Return", i -> Static.window.returnToModules())}
                        ))
                });

            default ->
                System.out.println("Incorrect input case Standard/Wires.wiresVisualization");
        }
    }

    private void four(int state) {
        switch (state) {
            case 0 ->
                Static.window.query("Is there more than one red wire?", new Option[]{
                        new Option("Yes", l -> Static.window.query("Is the last digit of the serial number odd?", new Option[]{new Option("Yes", l -> Static.window.query("Cut the last red wire.", new Option[]{new Option("Return", i -> Static.window.returnToModules())}))})});
        }
    }

    private void five() {
        System.out.println("5");
    }

    private void six() {
        System.out.println("6");
    }
}
