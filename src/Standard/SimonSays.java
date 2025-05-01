package Standard;

import Main.Option;
import Main.Static;

public class SimonSays {
    public SimonSays() {
        Static.window.query("Does the serial number contain a vowel?", new Option[]{
            new Option("Yes", l -> Static.window.query("How many strikes have been used?", new Option[]{
                new Option("0", ll -> rotate(0)),
                new Option("1", ll -> rotate(1)),
                new Option("2", ll -> rotate(2)),
            })),
            new Option("No", l -> Static.window.query("How many strikes have been used?", new Option[]{
                new Option("0", ll -> jumble(0)),
                new Option("1", ll -> jumble(1)),
                new Option("2", ll -> jumble(2)),
            }))
        });
    }

    public void rotate(int strikes) {
        switch (strikes) {
            case 0 ->
                Static.window.query("What colour is flashing? (In Order)", new Option[]{
                    new Option("Red", l -> Static.window.query("Blue", new Option[]{
                        new Option("Return", ll -> rotate(strikes))
                    })),
                    new Option("Blue", l -> Static.window.query("Red", new Option[]{
                        new Option("Return", ll -> rotate(strikes))
                    })),
                    new Option("Green", l -> Static.window.query("Yellow", new Option[]{
                        new Option("Return", ll -> rotate(strikes))
                    })),
                    new Option("Yellow", l -> Static.window.query("Green", new Option[]{
                        new Option("Return", ll -> rotate(strikes))
                    })),
                    new Option("Return", l -> Static.window.returnToModules())
                });
            case 1 ->
                Static.window.query("What colour is flashing? (In Order)", new Option[]{
                    new Option("Red", l -> Static.window.query("Yellow", new Option[]{
                        new Option("Return", ll -> rotate(strikes))
                    })),
                    new Option("Blue", l -> Static.window.query("Green", new Option[]{
                        new Option("Return", ll -> rotate(strikes))
                    })),
                    new Option("Green", l -> Static.window.query("Blue", new Option[]{
                        new Option("Return", ll -> rotate(strikes))
                    })),
                    new Option("Yellow", l -> Static.window.query("Red", new Option[]{
                        new Option("Return", ll -> rotate(strikes))
                    })),
                    new Option("Return", l -> Static.window.returnToModules())
                });
            case 2 ->
                Static.window.query("What colour is flashing? (In Order)", new Option[]{
                    new Option("Red", l -> Static.window.query("Green", new Option[]{
                        new Option("Return", ll -> rotate(strikes))
                    })),
                    new Option("Blue", l -> Static.window.query("Red", new Option[]{
                        new Option("Return", ll -> rotate(strikes))
                    })),
                    new Option("Green", l -> Static.window.query("Yellow", new Option[]{
                        new Option("Return", ll -> rotate(strikes))
                    })),
                    new Option("Yellow", l -> Static.window.query("Blue", new Option[]{
                        new Option("Return", ll -> rotate(strikes))
                    })),
                    new Option("Return", l -> Static.window.returnToModules())
                });
            default ->
                System.out.println("Incorrect input case Standard/SimonSays.rotate");
        }
    }

    public void jumble(int strikes) {
        switch (strikes) {
            case 0 ->
                Static.window.query("What colour is flashing? (In Order)", new Option[]{
                    new Option("Red", l -> Static.window.query("Blue", new Option[]{
                        new Option("Return", ll -> jumble(strikes))
                    })),
                    new Option("Blue", l -> Static.window.query("Yellow", new Option[]{
                        new Option("Return", ll -> jumble(strikes))
                    })),
                    new Option("Green", l -> Static.window.query("Green", new Option[]{
                        new Option("Return", ll -> jumble(strikes))
                    })),
                    new Option("Yellow", l -> Static.window.query("Red", new Option[]{
                        new Option("Return", ll -> jumble(strikes))
                        })),
                    new Option("Return", l -> Static.window.returnToModules())
                });
            case 1 ->
                Static.window.query("What colour is flashing? (In Order)", new Option[]{
                    new Option("Red", l -> Static.window.query("Red", new Option[]{
                        new Option("Return", ll -> jumble(strikes))
                    })),
                    new Option("Blue", l -> Static.window.query("Blue", new Option[]{
                        new Option("Return", ll -> jumble(strikes))
                    })),
                    new Option("Green", l -> Static.window.query("Yellow", new Option[]{
                        new Option("Return", ll -> jumble(strikes))
                    })),
                    new Option("Yellow", l -> Static.window.query("Green", new Option[]{
                        new Option("Return", ll -> jumble(strikes))
                    })),
                    new Option("Return", l -> Static.window.returnToModules())
                });
            case 2 ->
                Static.window.query("What colour is flashing? (In Order)", new Option[]{
                    new Option("Red", l -> Static.window.query("Yellow", new Option[]{
                        new Option("Return", ll -> jumble(strikes))
                    })),
                    new Option("Blue", l -> Static.window.query("Green", new Option[]{
                        new Option("Return", ll -> jumble(strikes))
                    })),
                    new Option("Green", l -> Static.window.query("Blue", new Option[]{
                        new Option("Return", ll -> jumble(strikes))
                    })),
                    new Option("Yellow", l -> Static.window.query("Red", new Option[]{
                        new Option("Return", ll -> jumble(strikes))
                    })),
                    new Option("Return", l -> Static.window.returnToModules())
                });
            default ->
                System.out.println("Incorrect input case Standard/SimonSays.jumble");
        }
    }
}
