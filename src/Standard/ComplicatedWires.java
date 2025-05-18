package Standard;

import Main.Static;
import Main.Option;

public class ComplicatedWires {
    String[][] compCont = new String[4][4];
    String[][] possible = new String[4][4];
    String[] options = new String[]{
            "",
            "The wire has red colour",
            "The wire has blue colour",
            "A star is present",
            "The LED is activated"
    };
    final String[][] chart = new String[][]{
        new String[]{"C", "C", "S", "C"},
        new String[]{"D", "P", "S", "S"},
        new String[]{"P", "D", "S", "P"},
        new String[]{"B", "B", "B", "D"}
    };

    final String[][] red = new String[][]{
        new String[]{null, "C", "S", null},
        new String[]{null, "P", "S", null},
        new String[]{null, "D", "S", null},
        new String[]{null, "B", "B", null}
    };

    final String[][] blue = new String[][]{
        new String[]{null, null, null, null},
        new String[]{"D", "P", "S", "S"},
        new String[]{"P", "D", "S", "P"},
        new String[]{null, null, null, null}
    };

    final String[][] star = new String[][]{
        new String[]{"C", "C", null, null},
        new String[]{"D", "P", null, null},
        new String[]{"P", "D", null, null},
        new String[]{"B", "B", null, null}
    };

    final String[][] led = new String[][]{
        new String[]{null, null, null, null},
        new String[]{null, null, null, null},
        new String[]{"P", "D", "S", "P"},
        new String[]{"B", "B", "B", "D"}
    };

    public ComplicatedWires() {
        for (int i = 0; i < 4; i++) {
            compCont[i] = options;
        }

        Static.window.comboBoxQuery("Select all valid options (Leave everything else blank)", compCont, new Option("Submit", l -> solve(Static.input())));
    }

    private int arraySearch(String[] array, String item) {
        int location = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) location = i;
        }

        return location;
    }

    private void solve(String[] options) {
        int[] opts = new int[4];
        for (int i = 0; i < options.length; i++) {
            opts[i] = arraySearch(options, options[i]);
        }

        boolean[] items = new boolean[4];
        for (int opt : opts) {
            switch (opt - 1) {
                case 0:
                    items[0] = true;
                    venn(red, true);
                case 1:
                    items[1] = true;
                    venn(blue, true);
                case 2:
                    items[2] = true;
                    venn(star, true);
                case 3:
                    items[3] = true;
                    venn(led, true);
            }

            switch (opt - 1) {
                case 0:
                    if (!items[0]) {
                        venn(red, false);
                    }
                case 1:
                    if (!items[1]) {
                        venn(blue, false);
                    }
                case 2:
                    if (!items[2]) {
                        venn(star, false);
                    }
                case 3:
                    if (!items[3]) {
                        venn(led, false);
                    }
            }
        }



        boolean isNull = true;
        for (int i = 0; i < possible.length; i++) {
            for (int j = 0; j < possible[i].length; j++) {
                if (possible[i][j] != null) {
                    isNull = false;
                } else {
                    switch (possible[i][j]) {
                        case "C":
                            Static.window.buttonQuery("Cut the wire.", new Option[]{
                                new Option("Return", l -> Static.window.returnToModules())
                            });
                        case "D":
                            Static.window.buttonQuery("Do NOT cut the wire.", new Option[]{
                                    new Option("Return", l -> Static.window.returnToModules())
                            });
                        case "S": // When E fixes storage check if last digit of serial is even
                            Static.window.buttonQuery("Cut the wire.", new Option[]{
                                    new Option("Return", l -> Static.window.returnToModules())
                            });
                        case "P": // When E fixes storage check if parallel port exists
                            Static.window.buttonQuery("Cut the wire.", new Option[]{
                                    new Option("Return", l -> Static.window.returnToModules())
                            });
                        case "B": // When E fixes storage check if 2 or more batteries
                            Static.window.buttonQuery("Cut the wire.", new Option[]{
                                    new Option("Return", l -> Static.window.returnToModules())
                            });
                    }
                }
            }
        }
    }

    private void venn(String[][] list, boolean item) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (!item && list[i][j] == null) possible[i][j] = null; else if (item && possible[i][j] != null) possible[i][j] = list[i][j];
            }
        }
    }
}
