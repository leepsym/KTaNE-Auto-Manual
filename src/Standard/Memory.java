package Standard;

import Main.Option;
import Main.Static;

public class Memory {
    int[][] memoryLog;

    String[][] comboOptions = new String[1][];
    String[] nums = new String[]{
            "1",
            "2",
            "3",
            "4"
    };
    public Memory() {
        memoryLog = new int[5][5];
        displayQuery(0);
    }

    private void displayQuery(int stage) {
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
        String[][] fourNums = new String[4][4];
        for (int i = 0; i < 4; i++) {
            fourNums[i] = nums;
        }
        Static.window.comboBoxQuery("What is the order of the buttons?", fourNums, new Option("Submit", n -> {
            int[] order = new int[5];

            for (int i = 0; i < 4; i++) {
                order[i] = Integer.parseInt(Static.input()[i]);
            }

            memoryLog[stage] = order;

            switch (stage) {
                case 0:
                    switch (num) {
                        case "1":
                            memoryLog[0][4] = order[1];
                            Static.window.buttonQuery("Press the button in the second position.", new Option[]{
                                    new Option("Next", l -> displayQuery(1))
                            });
                        case "2":
                            memoryLog[0][4] = order[1];
                            Static.window.buttonQuery("Press the button in the second position.", new Option[]{
                                    new Option("Next", l -> displayQuery(1))
                            });
                        case "3":
                            memoryLog[0][4] = order[2];
                            Static.window.buttonQuery("Press the button in the third position.", new Option[]{
                                    new Option("Next", l -> displayQuery(1))
                            });
                        case "4":
                            memoryLog[0][4] = order[3];
                            Static.window.buttonQuery("Press the button in the fourth position.", new Option[]{
                                    new Option("Next", l -> displayQuery(1))
                            });
                    }
                case 1:
                    switch (num) {
                        case "1":
                            memoryLog[1][4] = 4;
                            Static.window.buttonQuery("Press the button labeled 4", new Option[]{
                                    new Option("Next", l -> displayQuery(2))
                            });
                        case "2":
                            memoryLog[1][4] = memoryLog[0][arraySearch(memoryLog[0], memoryLog[0][4])];
                            Static.window.buttonQuery("Press the button in position " + memoryLog[1][4], new Option[]{
                                    new Option("Next", l -> displayQuery(2))
                            });
                        case "3":
                            memoryLog[1][4] = 1;
                            Static.window.buttonQuery("Press the button in the first position", new Option[]{
                                    new Option("Next", l -> displayQuery(2))
                            });
                        case "4":
                            memoryLog[1][4] = memoryLog[0][arraySearch(memoryLog[0], memoryLog[0][4])];
                            Static.window.buttonQuery("Press the button in position " + memoryLog[1][4], new Option[]{
                                    new Option("Next", l -> displayQuery(2))
                            });
                    }
                case 2:
                    switch (num) {
                        case "1":
                            memoryLog[2][4] = memoryLog[1][arraySearch(memoryLog[1], memoryLog[1][4])];
                            Static.window.buttonQuery("Press the button labeled " + memoryLog[2][4], new Option[]{
                                    new Option("Next", l -> displayQuery(3))
                            });
                        case "2":
                            memoryLog[2][4] = memoryLog[0][arraySearch(memoryLog[0], memoryLog[0][4])];
                            Static.window.buttonQuery("Press the button labeled " + memoryLog[2][4], new Option[]{
                                    new Option("Next", l -> displayQuery(3))
                            });
                        case "3":
                            memoryLog[2][4] = order[2];
                            Static.window.buttonQuery("Press the button in the third position", new Option[]{
                                    new Option("Next", l -> displayQuery(3))
                            });
                        case "4":
                            memoryLog[2][4] = 4;
                            Static.window.buttonQuery("Press the button labeled 4", new Option[]{
                                    new Option("Next", l -> displayQuery(3))
                            });
                    }
                case 3:
                    switch (num) {
                        case "1":
                            memoryLog[3][4] = memoryLog[0][arraySearch(memoryLog[0], memoryLog[0][4])];
                            Static.window.buttonQuery("Press the button in position " + memoryLog[3][4], new Option[]{
                                    new Option("Next", l -> displayQuery(4))
                            });
                        case "2":
                            memoryLog[3][4] = order[1];
                            Static.window.buttonQuery("Press the button in the second position", new Option[]{
                                    new Option("Next", l -> displayQuery(4))
                            });
                        case "3":
                            memoryLog[3][4] = memoryLog[1][arraySearch(memoryLog[1], memoryLog[1][4])];
                            Static.window.buttonQuery("Press the button in position " + memoryLog[3][4], new Option[]{
                                    new Option("Next", l -> displayQuery(4))
                            });
                        case "4":
                            memoryLog[3][4] = memoryLog[1][arraySearch(memoryLog[1], memoryLog[1][4])];
                            Static.window.buttonQuery("Press the button in position " + memoryLog[3][4], new Option[]{
                                    new Option("Next", l -> displayQuery(4))
                            });
                    }
                case 4:
                    switch (num) {
                        case "1":
                            memoryLog[4][4] = memoryLog[0][arraySearch(memoryLog[0], memoryLog[0][4])];
                            Static.window.buttonQuery("Press the button labeled " + memoryLog[4][4], new Option[]{
                                    new Option("Next", l -> Static.window.returnToModules())
                            });
                        case "2":
                            memoryLog[4][4] = memoryLog[1][arraySearch(memoryLog[1], memoryLog[1][4])];
                            Static.window.buttonQuery("Press the button labeled " + memoryLog[4][4], new Option[]{
                                    new Option("Next", l -> Static.window.returnToModules())
                            });
                        case "3":
                            memoryLog[4][4] = memoryLog[3][arraySearch(memoryLog[3], memoryLog[3][4])];
                            Static.window.buttonQuery("Press the button labeled " + memoryLog[4][4], new Option[]{
                                    new Option("Next", l -> Static.window.returnToModules())
                            });
                        case "4":
                            memoryLog[4][4] = memoryLog[2][arraySearch(memoryLog[2], memoryLog[2][4])];
                            Static.window.buttonQuery("Press the button labeled " + memoryLog[4][4], new Option[]{
                                    new Option("Next", l -> Static.window.returnToModules())
                            });
                    }
            }
        }));
    }
}
