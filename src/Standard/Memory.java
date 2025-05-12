package Standard;

import Main.Option;
import Main.Static;

public class Memory {
    int[][] memoryLog = new int[5][5];
    String[][] comboOptions = new String[1][];
    public Memory() {
        displayQuery(0);
    }

    private void displayQuery(int stage) {
        String[] nums = new String[]{
                "1",
                "2",
                "3",
                "4"
        };
        comboOptions[0] = nums;
        Static.window.comboBoxQuery("What number is displayed?", comboOptions, new Option("Submit", l -> solve(Static.input()[0], stage)));
    }

    private int arraySearch(int[] array, int item) {
        int location = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) location = i;
        }

        return location;
    }

    private void solve(String num, int stage) {
        switch (stage) {
            case 1:
                switch (num) {
                    case "1":
                        memoryLog[0][4] = memoryLog[0][1];
                        Static.window.buttonQuery("Press the button in the second position.", new Option[]{
                                new Option("Next", l -> displayQuery(1))
                        });
                    case "2":
                        memoryLog[0][4] = memoryLog[0][1];
                        Static.window.buttonQuery("Press the button in the second position.", new Option[]{
                                new Option("Next", l -> displayQuery(1))
                        });
                    case "3":
                        memoryLog[0][4] = memoryLog[0][2];
                        Static.window.buttonQuery("Press the button in the third position.", new Option[]{
                                new Option("Next", l -> displayQuery(1))
                        });
                    case "4":
                        memoryLog[0][4] = memoryLog[0][3];
                        Static.window.buttonQuery("Press the button in the fourth position.", new Option[]{
                                new Option("Next", l -> displayQuery(1))
                        });
                }
            case 2:
                switch (num) {
                    memoryLog[1][4] =
                }
        }
    }
}
