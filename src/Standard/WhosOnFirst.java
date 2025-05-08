package Standard;

import Main.Option;
import Main.Static;

public class WhosOnFirst {
    public WhosOnFirst() {
        Static.window.textFieldQuery("What word is displayed?", l -> whichBox(Static.input()[0]));
    }

    private void whichBox(String display) {
        switch (display.toUpperCase().replace(" ", "_").replace("'", "")) {
            case "UR" ->
                boxQuery(0);
            case "FIRST", "OKAY", "C" ->
                boxQuery(1);
            case "YES", "NOTHING", "LED", "THEY_ARE" ->
                boxQuery(2);
            case "BLANK", "READ", "YOU", "YOUR", "YOURE", "THEIR" ->
                boxQuery(3);
            case "", "REED", "LEED", "THEYRE" ->
                boxQuery(4);
            case "DISPLAY", "SAYS", "NO", "LEAD", "HOLD_ON", "YOU_RE", "THERE", "SEE", "CEE" ->
                boxQuery(5);
            default ->
                Static.window.buttonQuery("Invalid Word.", new Option[]{
                    new Option("Return", l -> Static.window.returnToModules())
                });
        }
    }

    private void boxQuery(int box){
        switch (box) {
            case 0 ->
                Static.window.textFieldQuery("What word is displayed in the top left box?", l -> wordList(Static.input()[0]));
            case 1 ->
                    Static.window.textFieldQuery("What word is displayed in the top right box?", l -> wordList(Static.input()[0]));
            case 2 ->
                    Static.window.textFieldQuery("What word is displayed in the middle left box?", l -> wordList(Static.input()[0]));
            case 3 ->
                    Static.window.textFieldQuery("What word is displayed in the middle right box?", l -> wordList(Static.input()[0]));
            case 4 ->
                    Static.window.textFieldQuery("What word is displayed in the bottom left box?", l -> wordList(Static.input()[0]));
            case 5 ->
                    Static.window.textFieldQuery("What word is displayed in the bottom right box?", l -> wordList(Static.input()[0]));
        }
    }

    private void wordList(String box) {
        String[][] words = new String[1][14];
        switch (box.toUpperCase().replace(" ", "_").replace("'", "")) {
            case "READY":
                words[0] = new String[] {"YES", "OKAY", "WHAT", "MIDDLE", "LEFT", "PRESS", "RIGHT", "BLANK", "READY", "NO", "FIRST", "UHHH", "NOTHING", "WAIT"};
                break;
            case "FIRST":
                words[0] = new String[] {"LEFT", "OKAY", "YES", "MIDDLE", "NO", "RIGHT", "NOTHING", "UHHH", "WAIT", "READY", "BLANK", "WHAT", "PRESS", "FIRST"};
                break;
            case "NO":
                words[0] = new String[] {"BLANK", "UHHH", "WAIT", "FIRST", "WHAT", "READY", "RIGHT", "YES", "NOTHING", "LEFT", "PRESS", "OKAY", "NO", "MIDDLE"};
                break;
            case "BLANK":
                words[0] = new String[] {"WAIT", "RIGHT", "OKAY", "MIDDLE", "BLANK", "PRESS", "READY", "NOTHING", "NO", "WHAT", "LEFT", "UHHH", "YES", "FIRST"};
                break;
            case "NOTHING":
                words[0] = new String[] {"UHHH", "RIGHT", "OKAY", "MIDDLE", "YES", "BLANK", "NO", "PRESS", "LEFT", "WHAT", "WAIT", "FIRST", "NOTHING", "READY"};
                break;
            case "YES":
                words[0] = new String[] {"OKAY", "RIGHT", "UHHH", "MIDDLE", "FIRST", "WHAT", "PRESS", "READY", "NOTHING", "YES", "LEFT", "BLANK", "NO", "WAIT"};
                break;
            case "WHAT":
                words[0] = new String[] {"UHHH", "WHAT", "LEFT", "NOTHING", "READY", "BLANK", "MIDDLE", "NO", "OKAY", "FIRST", "WAIT", "YES", "PRESS", "RIGHT"};
                break;
            case "UHHH":
                words[0] = new String[] {"READY", "NOTHING", "LEFT", "WHAT", "OKAY", "YES", "RIGHT", "NO", "PRESS", "BLANK", "UHHH", "MIDDLE", "WAIT", "FIRST"};
                break;
            case "LEFT":
                words[0] = new String[] {"RIGHT", "LEFT", "FIRST", "NO", "MIDDLE", "YES", "BLANK", "WHAT", "UHHH", "WAIT", "PRESS", "READY", "OKAY", "NOTHING"};
                break;
            case "RIGHT":
                words[0] = new String[] {"YES", "NOTHING", "READY", "PRESS", "NO", "WAIT", "WHAT", "RIGHT", "MIDDLE", "LEFT", "UHHH", "BLANK", "OKAY", "FIRST"};
                break;
            case "MIDDLE":
                words[0] = new String[] {"BLANK", "READY", "OKAY", "WHAT", "NOTHING", "PRESS", "NO", "WAIT", "LEFT", "MIDDLE", "RIGHT", "FIRST", "UHHH", "YES"};
                break;
            case "OKAY":
                words[0] = new String[] {"MIDDLE", "NO", "FIRST", "YES", "UHHH", "NOTHING", "WAIT", "OKAY", "LEFT", "READY", "BLANK", "PRESS", "WHAT", "RIGHT"};
                break;
            case "WAIT":
                words[0] = new String[] {"UHHH", "NO", "BLANK", "OKAY", "YES", "LEFT", "FIRST", "PRESS", "WHAT", "WAIT", "NOTHING", "READY", "RIGHT", "MIDDLE"};
                break;
            case "PRESS":
                words[0] = new String[] {"RIGHT", "MIDDLE", "YES", "READY", "PRESS", "OKAY", "NOTHING", "UHHH", "BLANK", "LEFT", "FIRST", "WHAT", "NO", "WAIT"};
                break;
            case "YOU":
                words[0] = new String[] {"SURE", "YOU ARE", "YOUR", "YOU'RE", "NEXT", "UH HUH", "UR", "HOLD", "WHAT?", "YOU", "UH UH", "LIKE", "DONE", "U"};
                break;
            case "YOU_ARE":
                words[0] = new String[] {"YOUR", "NEXT", "LIKE", "UH HUH", "WHAT?", "DONE", "UH UH", "HOLD", "YOU", "U", "YOU'RE", "SURE", "UR", "YOU ARE"};
                break;
            case "YOUR":
                words[0] = new String[] {"UH UH", "YOU ARE", "UH HUH", "YOUR", "NEXT", "UR", "SURE", "U", "YOU'RE", "YOU", "WHAT?", "HOLD", "LIKE", "DONE"};
                break;
            case "YOURE":
                words[0] = new String[] {"YOU", "YOU'RE", "UR", "NEXT", "UH UH", "YOU ARE", "U", "YOUR", "WHAT?", "UH HUH", "SURE", "DONE", "LIKE", "HOLD" };
                break;
            case "UR":
                words[0] = new String[] {"DONE", "U", "UR", "UH HUH", "WHAT?", "SURE", "YOUR", "HOLD", "YOU'RE", "LIKE", "NEXT", "UH UH", "YOU ARE", "YOU"};
                break;
            case "U":
                words[0] = new String[] {"UH HUH", "SURE", "NEXT", "WHAT?", "YOU'RE", "UR", "UH UH", "DONE", "U", "YOU", "LIKE", "HOLD", "YOU ARE", "YOUR"};
                break;
            case "UH_HUH":
                words[0] = new String[] {"UH HUH", "YOUR", "YOU ARE", "YOU", "DONE", "HOLD", "UH UH", "NEXT", "SURE", "LIKE", "YOU'RE", "UR", "U", "WHAT?"};
                break;
            case "UH_UH":
                words[0] = new String[] {"UR", "U", "YOU ARE", "YOU'RE", "NEXT", "UH UH", "DONE", "YOU", "UH HUH", "LIKE", "YOUR", "SURE", "HOLD", "WHAT?"};
                break;
            case "WHAT?":
                words[0] = new String[] {"YOU", "HOLD", "YOU'RE", "YOUR", "U", "DONE", "UH UH", "LIKE", "YOU ARE", "UH HUH", "UR", "NEXT", "WHAT?", "SURE"};
                break;
            case "DONE":
                words[0] = new String[] {"SURE", "UH HUH", "NEXT", "WHAT?", "YOUR", "UR", "YOU'RE", "HOLD", "LIKE", "YOU", "U", "YOU ARE", "UH UH", "DONE"};
                break;
            case "NEXT":
                words[0] = new String[] {"WHAT?", "UH HUH", "UH UH", "YOUR", "HOLD", "SURE", "NEXT", "LIKE", "DONE", "YOU ARE", "UR", "YOU'RE", "U", "YOU"};
                break;
            case "HOLD":
                words[0] = new String[] {"YOU ARE", "U", "DONE", "UH UH", "YOU", "UR", "SURE", "WHAT?", "YOU'RE", "NEXT", "HOLD", "UH HUH", "YOUR", "LIKE"};
                break;
            case "SURE":
                words[0] = new String[] {"YOU ARE", "DONE", "LIKE", "YOU'RE", "YOU", "HOLD", "UH HUH", "UR", "SURE", "U", "WHAT?", "NEXT", "YOUR", "UH UH"};
                break;
            case "LIKE":
                words[0] = new String[] {"YOU'RE", "NEXT", "U", "UR", "HOLD", "DONE", "UH UH", "WHAT?", "UH HUH", "YOU", "LIKE", "SURE", "YOU ARE", "YOUR"};
                break;
            default:
                Static.window.buttonQuery("Invalid word.", new Option[] {
                        new Option("Return", l -> Static.window.returnToModules())
                });


            Static.window.comboBoxQuery("On the bomb, click the first word that appears in the dropdown below, from top to bottom.", words, new Option("Return", l -> Static.window.returnToModules()));

        }
    }
}