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
                String[] ready = new String[] {"YES", "OKAY", "WHAT", "MIDDLE", "LEFT", "PRESS", "RIGHT", "BLANK", "READY", "NO", "FIRST", "UHHH", "NOTHING", "WAIT"};
                words[0] = ready;
                break;
            case "FIRST":
                String[] first = new String[] {"LEFT", "OKAY", "YES", "MIDDLE", "NO", "RIGHT", "NOTHING", "UHHH", "WAIT", "READY", "BLANK", "WHAT", "PRESS", "FIRST"};
                words[0] = first;
                break;
            case "NO":
                String[] no = new String[] {"BLANK", "UHHH", "WAIT", "FIRST", "WHAT", "READY", "RIGHT", "YES", "NOTHING", "LEFT", "PRESS", "OKAY", "NO", "MIDDLE"};
                words[0] = no;
                break;
            case "BLANK":
                String[] blank = new String[] {"WAIT", "RIGHT", "OKAY", "MIDDLE", "BLANK", "PRESS", "READY", "NOTHING", "NO", "WHAT", "LEFT", "UHHH", "YES", "FIRST"};
                words[0] = blank;
                break;
            case "NOTHING":
                String[] nothing = new String[] {"UHHH", "RIGHT", "OKAY", "MIDDLE", "YES", "BLANK", "NO", "PRESS", "LEFT", "WHAT", "WAIT", "FIRST", "NOTHING", "READY"};
                words[0] = nothing;
                break;
            case "YES":
                String[] yes = new String[] {"OKAY", "RIGHT", "UHHH", "MIDDLE", "FIRST", "WHAT", "PRESS", "READY", "NOTHING", "YES", "LEFT", "BLANK", "NO", "WAIT"};
                words[0] = yes;
                break;
            case "WHAT":
                String[] what = new String[] {"UHHH", "WHAT", "LEFT", "NOTHING", "READY", "BLANK", "MIDDLE", "NO", "OKAY", "FIRST", "WAIT", "YES", "PRESS", "RIGHT"};
                words[0] = what;
                break;
            case "UHHH":
                String[] uhhh = new String[] {"READY", "NOTHING", "LEFT", "WHAT", "OKAY", "YES", "RIGHT", "NO", "PRESS", "BLANK", "UHHH", "MIDDLE", "WAIT", "FIRST"};
                words[0] = uhhh;
                break;
            case "LEFT":
                String[] left = new String[] {"RIGHT", "LEFT", "FIRST", "NO", "MIDDLE", "YES", "BLANK", "WHAT", "UHHH", "WAIT", "PRESS", "READY", "OKAY", "NOTHING"};
                words[0] = left;
                break;
            case "RIGHT":
                String[] right = new String[] {"YES", "NOTHING", "READY", "PRESS", "NO", "WAIT", "WHAT", "RIGHT", "MIDDLE", "LEFT", "UHHH", "BLANK", "OKAY", "FIRST"};
                words[0] = right;
                break;
            case "MIDDLE":
                String[] middle = new String[] {"BLANK", "READY", "OKAY", "WHAT", "NOTHING", "PRESS", "NO", "WAIT", "LEFT", "MIDDLE", "RIGHT", "FIRST", "UHHH", "YES"};
                words[0] = middle;
                break;
            case "OKAY":
                String[] okay = new String[] {"MIDDLE", "NO", "FIRST", "YES", "UHHH", "NOTHING", "WAIT", "OKAY", "LEFT", "READY", "BLANK", "PRESS", "WHAT", "RIGHT"};
                words[0] = okay;
                break;
            case "WAIT":
                String[] wait = new String[] {"UHHH", "NO", "BLANK", "OKAY", "YES", "LEFT", "FIRST", "PRESS", "WHAT", "WAIT", "NOTHING", "READY", "RIGHT", "MIDDLE"};
                words[0] = wait;
                break;
            case "PRESS":
                String[] press = new String[] {"RIGHT", "MIDDLE", "YES", "READY", "PRESS", "OKAY", "NOTHING", "UHHH", "BLANK", "LEFT", "FIRST", "WHAT", "NO", "WAIT"};
                words[0] = press;
                break;
            case "YOU":
                String[] you = new String[] {"SURE", "YOU ARE", "YOUR", "YOU'RE", "NEXT", "UH HUH", "UR", "HOLD", "WHAT?", "YOU", "UH UH", "LIKE", "DONE", "U"};
                words[0] = you;
                break;


            Static.window.comboBoxQuery("On the bomb, click the first word that appears in the dropdown below, from top to bottom.", );
        }
    }
}