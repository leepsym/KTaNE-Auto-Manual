package Standard;

import Main.Option;
import Main.Static;

public class Wires {
    public Wires() {
        Static.window.query("How many wires?", new Option[]{
                new Option("3", l -> three(0)),
                new Option("4", l -> four(0)),
                new Option("5", l -> five(0)),
                new Option("6", l -> six(0))
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
                System.out.println("Incorrect input case Standard/Wires.three");
        }
    }

    // 297 sense

    private void four(int state) {
        switch (state) {
            case 0 ->
                Static.window.query("Is there more than one red wire?", new Option[]{
                    new Option("Yes", l -> Static.window.query("Is the last digit of the serial number odd?", new Option[]{
                        new Option("Yes", ll -> Static.window.query("Cut the last red wire.", new Option[]{
                            new Option("Return", lll -> Static.window.returnToModules())
                        })),
                        new Option("No", ll -> four(1)),
                    })),
                    new Option("No", l -> four(1))
                });
            case 1 ->
                Static.window.query("Is the last wire yellow?", new Option[]{
                    new Option("Yes", l -> Static.window.query("Are there any red wires?", new Option[]{
                        new Option("Yes", ll -> four(2)),
                        new Option("No", ll -> Static.window.query("Cut the first wire.", new Option[]{
                            new Option("Return", lll -> Static.window.returnToModules())
                        }))
                    })),
                    new Option("No", l -> four(2))
                });
            case 2 ->
                Static.window.query("Is there exactly one blue wire?", new Option[]{
                    new Option("Yes", l -> Static.window.query("Cut the first wire.", new Option[]{
                        new Option("Return", ll -> Static.window.returnToModules())
                    })),
                    new Option("No", l -> four(3))
                });
            case 3 ->
                Static.window.query("Is there more than one yellow wire?", new Option[]{
                    new Option("Yes", l -> Static.window.query("Cut the last wire.", new Option[]{
                        new Option("Return", ll -> Static.window.returnToModules())
                    })),
                    new Option("No", l -> Static.window.query("Cut the second wire.", new Option[]{
                            new Option("Return", ll -> Static.window.returnToModules())
                    }))
                });
            default ->
                    System.out.println("Incorrect input case Standard/Wires.four");
        }
    }

    private void five(int state) {
        switch (state) {
            case 0 ->
                Static.window.query("Is the last wire black?", new Option[]{
                    new Option("Yes", l -> Static.window.query("Is the last digit of the serial number odd?", new Option[]{
                        new Option("Yes", ll -> Static.window.query("Cut the fourth wire.", new Option[]{
                            new Option("Return", lll -> Static.window.returnToModules())
                        })),
                        new Option("No", ll -> five(1))
                    })),
                    new Option("No", l -> five(1))
                });
            case 1 ->
                Static.window.query("Is there exactly one red wire?", new Option[]{
                    new Option("Yes", l -> Static.window.query("Is there more than one yellow wire?", new Option[]{
                        new Option("Yes", ll -> Static.window.query("Cut the first wire.", new Option[]{
                            new Option("Return", lll -> Static.window.returnToModules())
                        })),
                        new Option("No", ll -> five(2))
                    })),
                    new Option("No", l -> five(2))
                });
            case 2 ->
                Static.window.query("Are there any black wires?", new Option[]{
                    new Option("Yes", l -> Static.window.query("Cut the second wire.", new Option[]{
                        new Option("Return", ll -> Static.window.returnToModules())
                    })),
                    new Option("No", l -> Static.window.query("Cut the first wire.", new Option[]{
                        new Option("Return", ll -> Static.window.returnToModules())
                    }))
                });
            default ->
                    System.out.println("Incorrect input case Standard/Wires.five");
        }
    }

    private void six(int state) {
        switch (state) {
            case 0 ->
                Static.window.query("Are there any yellow wires?", new Option[]{
                    new Option("Yes", l -> Static.window.query("Is there exactly one yellow wire?", new Option[]{
                        new Option("Yes", ll -> Static.window.query("Is there more than one white wire?", new Option[]{
                            new Option("Yes", lll -> Static.window.query("Cut the fourth wire.", new Option[]{
                                new Option("Return", llll -> Static.window.returnToModules())
                            })),
                            new Option("No", lll -> six(1))
                        })),
                        new Option("No", ll -> six(1))
                    })),
                    new Option("No", l -> Static.window.query("Is the last digit of the serial number odd?.", new Option[]{
                        new Option("Yes", ll -> Static.window.query("Cut the fourth wire.", new Option[]{
                            new Option("Return", lll -> Static.window.returnToModules())
                        })),
                        new Option("No", ll -> six(1))
                    }))
                });
            case 1 ->
                Static.window.query("Are there any red wires?", new Option[]{
                    new Option("Yes", l -> Static.window.query("Cut the fourth wire.", new Option[]{
                        new Option("Return", ll -> Static.window.returnToModules())
                    })),
                    new Option("No", l -> Static.window.query("Cut the last wire.", new Option[]{
                        new Option("Return", ll -> Static.window.returnToModules())
                    }))
                });
            default ->
                    System.out.println("Incorrect input case Standard/Wires.six");
        }
    }
}
