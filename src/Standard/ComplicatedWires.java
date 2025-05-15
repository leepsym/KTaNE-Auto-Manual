package Standard;

import Main.Static;
import Main.Option;

public class ComplicatedWires {
    String[][] compCont = new String[4][4];
    String[] options = new String[]{
            "",
            "The wire has red colour",
            "The wire has blue colour",
            "A star is present",
            "The LED is activated"
    };
    String[][] chart = new String[][]{
        new String[]{"C", "C", "S", "C"},
        new String[]{"D", "P", "S", "S"},
        new String[]{"P", "D", "S", "P"},
        new String[]{"B", "B", "B", "D"}
    };

    String[][] red = new String[][]{
        new String[]{null, "C", "S", null},
        new String[]{null, "P", "S", null},
        new String[]{null, "D", "S", null},
        new String[]{null, "B", "B", null}
    };

    String[][] blue = new String[][]{
        new String[]{null, null, null, null},
        new String[]{"D", "P", "S", "S"},
        new String[]{"P", "D", "S", "P"},
        new String[]{null, null, null, null}
    };

    String[][] star = new String[][]{
        new String[]{"C", "C", null, null},
        new String[]{"D", "P", null, null},
        new String[]{"P", "D", null, null},
        new String[]{"B", "B", null, null}
    };

    // LED

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



        for (int i = 0; i < opts.length; i++) {
            switch (opts[i]) {
                case 0:
                case 1:

                case 2:
                case 3:
                case 4:
            }
        }
    }
}
