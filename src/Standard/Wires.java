package Standard;

import Main.Option;
import Main.Static;

public class Wires {
    public Wires() {
        Static.window.buttonQuery("How many wires?", new Option[]{
                new Option("3", l -> three(0)),
                new Option("4", l -> four(0)),
                new Option("5", l -> five(0)),
                new Option("6", l -> six(0))
        });
    }
    private void three(int state) {
        switch (state) {
            case 0 ->
                Static.window.buttonQuery("Are there any red wires?", new Option[]{
                        new Option("Yes", l -> three(1)),
                        new Option("No", l -> Static.window.buttonQuery("Cut the second wire.", new Option[]{
                                new Option("Return", i -> Static.window.returnToModules())
                        }))
                });

            case 1 ->
                Static.window.buttonQuery("Is the last wire white?", new Option[]{
                        new Option("Yes", l -> Static.window.buttonQuery("Cut the last wire.", new Option[]{
                                new Option("Return", i -> Static.window.returnToModules())}
                        )),
                        new Option("No", l -> three(2))
                });

            case 2 ->
                Static.window.buttonQuery("Is there more than one blue wire?", new Option[]{
                        new Option("Yes", l -> Static.window.buttonQuery("Cut the last blue wire.", new Option[]{
                                new Option("Return", i -> Static.window.returnToModules())}
                        )),
                        new Option("No", l -> Static.window.buttonQuery("Cut the last wire.", new Option[]{
                                new Option("Return", i -> Static.window.returnToModules())}
                        ))
                });

            default ->
                System.out.println("Incorrect input case Standard/Wires.three");
        }
    }

    private void four(int state) {
        switch (state) {
            case 0:
                if (odd()) {
                    Static.window.buttonQuery("Is there more than one red wire?", new Option[]{
                        new Option("Yes", l -> Static.window.buttonQuery("Cut the last red wire.", new Option[]{
                                new Option("Return", m -> Static.window.returnToModules())
                        })),
                        new Option("No", l -> four(1))
                    });
                } else four(1);

            case 1:
                Static.window.buttonQuery("Is the last wire yellow?", new Option[]{
                    new Option("Yes", l -> Static.window.buttonQuery("Are there any red wires?", new Option[]{
                        new Option("Yes", m -> four(2)),
                        new Option("No", m -> Static.window.buttonQuery("Cut the first wire.", new Option[]{
                            new Option("Return", n -> Static.window.returnToModules())
                        }))
                    })),
                    new Option("No", l -> four(2))
                });

            case 2:
                Static.window.buttonQuery("Is there exactly one blue wire?", new Option[]{
                    new Option("Yes", l -> Static.window.buttonQuery("Cut the first wire.", new Option[]{
                        new Option("Return", m -> Static.window.returnToModules())
                    })),
                    new Option("No", l -> four(3))
                });
            case 3:
                Static.window.buttonQuery("Is there more than one yellow wire?", new Option[]{
                    new Option("Yes", l -> Static.window.buttonQuery("Cut the last wire.", new Option[]{
                        new Option("Return", m -> Static.window.returnToModules())
                    })),
                    new Option("No", l -> Static.window.buttonQuery("Cut the second wire.", new Option[]{
                            new Option("Return", m -> Static.window.returnToModules())
                    }))
                });
            default:
                System.out.println("Incorrect input case Standard/Wires.four");
        }
    }

    private void five(int state) {
        switch (state) {
            case 0:
                if (odd()) {
                        Static.window.buttonQuery("Is the last wire black?", new Option[]{
                                new Option("Yes", l -> Static.window.buttonQuery("Cut the last red wire.", new Option[]{
                                        new Option("Return", lll -> Static.window.returnToModules())
                                })),
                                new Option("No", l -> five(1))
                        });
                } else {
                    five(1);
                }
            case 1:
                Option no = new Option("No", l -> five(2));
                Static.window.buttonQuery("Is there exactly one red wire?", new Option[]{
                    new Option("Yes", l -> Static.window.buttonQuery("Is there more than one yellow wire?", new Option[]{
                        new Option("Yes", m -> Static.window.buttonQuery("Cut the first wire.", new Option[]{
                            new Option("Return", n -> Static.window.returnToModules())
                        })),
                        no
                    })),
                    no
                });
            case 2:
                Static.window.buttonQuery("Are there any black wires?", new Option[]{
                    new Option("Yes", l -> Static.window.buttonQuery("Cut the second wire.", new Option[]{
                        new Option("Return", m -> Static.window.returnToModules())
                    })),
                    new Option("No", l -> Static.window.buttonQuery("Cut the first wire.", new Option[]{
                        new Option("Return", m -> Static.window.returnToModules())
                    }))
                });
            default:
                System.out.println("Incorrect input case Standard/Wires.five");
        }
    }

    private void six(int state) {
        switch (state) {
            case 0:
                if (odd()) {

                } else {
                    six(1);
                }
                Static.window.buttonQuery("Are there any yellow wires?", new Option[]{
                    new Option("Yes", l -> Static.window.buttonQuery("Is there exactly one yellow wire?", new Option[]{
                        new Option("Yes", m -> Static.window.buttonQuery("Is there more than one white wire?", new Option[]{
                            new Option("Yes", n -> Static.window.buttonQuery("Cut the fourth wire.", new Option[]{
                                new Option("Return", o -> Static.window.returnToModules())
                            })),
                            new Option("No", lll -> six(1))
                        })),
                        new Option("No", ll -> six(1))
                    })),
                    new Option("No", l -> Static.window.buttonQuery("Is the last digit of the serial number odd?.", new Option[]{
                        new Option("Yes", m -> {
                            if (Static.serial(n -> six(state)).toCharArray()[5] % 2 == 1) {
                                Static.window.buttonQuery("Cut the last red wire.", new Option[]{
                                        new Option("Return", lll -> Static.window.returnToModules())
                                });
                            } else {
                                four(1);
                            }
                        }),
                        new Option("No", ll -> four(1))
                    }))
                });
            case 1:
                Static.window.buttonQuery("Are there any red wires?", new Option[]{
                    new Option("Yes", l -> Static.window.buttonQuery("Cut the fourth wire.", new Option[]{
                        new Option("Return", m -> Static.window.returnToModules())
                    })),
                    new Option("No", l -> Static.window.buttonQuery("Cut the last wire.", new Option[]{
                        new Option("Return", m -> Static.window.returnToModules())
                    }))
                });
            default:
                System.out.println("Incorrect input case Standard/Wires.six");
        }
    }
    private boolean odd() {
        return (Static.serial(l -> six(0)).toCharArray()[5] % 2 == 1);
    }
}
