package Standard;

import Main.Option;
import Main.Static;

public class SimonSays {
    private final Colour[] order;
    private enum Colour {
        RED,
        BLUE,
        GREEN,
        YELLOW;
        public String toString() {
            return switch (this) {
                case RED -> "Red";
                case BLUE -> "Blue";
                case GREEN -> "Green";
                case YELLOW -> "Yellow";
            };
        }
        private static Colour[] order() {
            for (char c : Static.serial().toCharArray()) {
                switch (c) {
                    case 'A', 'E', 'I', 'O', 'U':
                        return switch (Static.strikes()) { // Serial number contains a vowel
                            case 0 -> new Colour[]{BLUE,   RED,    YELLOW, GREEN };
                            case 1 -> new Colour[]{YELLOW, GREEN,  BLUE,   RED   };
                            case 2 -> new Colour[]{GREEN,  RED,    YELLOW, BLUE  };
                            default -> throw new IllegalStateException();
                        };
                }
            }           return switch (Static.strikes()) { // Serial number does not contain a vowel
                            case 0 -> new Colour[]{BLUE,   YELLOW, GREEN,  RED   };
                            case 1 -> new Colour[]{RED,    BLUE,   YELLOW, GREEN };
                            case 2 -> new Colour[]{YELLOW, GREEN,  BLUE,   RED   };
                            default -> throw new IllegalStateException();
                        };
        }
    }
    public SimonSays() {
        order = Colour.order();
        menu("What buttons are flashing?");
    }
    private void menu(String text) {
        Static.window.buttonQuery(text, new Option[]{
                option(Colour.RED),
                option(Colour.BLUE),
                option(Colour.GREEN),
                option(Colour.YELLOW)
        });
    }
    private Option option(Colour colour) {
        return new Option(colour.toString(), l -> menu(order[colour.ordinal()].toString()));
    }
}
