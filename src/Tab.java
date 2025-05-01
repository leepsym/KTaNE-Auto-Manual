import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Tab extends JFrame{
    int WINDOW_HEIGHT = 1000;
    int WINDOW_WIDTH = 1500;
    String TITLE = "KTaNE Automatic Manual";

    public static void main(String[] args) {
        new Tab();
    }

    public Tab() {
        setTitle(TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        returnToModules();

        setLayout(new GridBagLayout());


        setVisible(true);
    }

    public void returnToModules() {
        reset();

        // Modules
        newButton("Basic Wires", j -> basicWiresModule());
        newButton("The Button", j -> theButtonModule());
        newButton("Keypads", j -> keypadsModule());
        newButton("Simon Says", j -> simonSaysModule());
        newButton("Who's On First (Words)", j -> whosOnFirstModule());
        newButton("Memory (Numbers)", j -> memoryModule());
        newButton("Morse Code", j -> morseCodeModule());
        newButton("Complicated Wires", j -> complicatedWiresModule());
        newButton("Wire Sequences", j -> wireSequencesModule());
        newButton("Mazes", j -> mazesModule());
        newButton("Passwords", j -> passwordsModule());

        // Needy Modules
        newButton("Venting Gas", j -> ventingGasNeedyModule());
        newButton("Knobs", j -> knobsNeedyModule());

        revalidate();
    }

    public void basicWiresModule() {
        reset();

        newTextField("How many wires?");
        newButton("3", j -> SimpleWiresModule.solveThreeWires());
        newButton("4", j -> SimpleWiresModule.solveFourWires());
        newButton("5", j -> SimpleWiresModule.solveFiveWires());
        newButton("6", j -> SimpleWiresModule.solveSixWires());

        revalidate();
    }

    public void theButtonModule() {

    }

    public void keypadsModule() {

    }

    public void simonSaysModule() {

    }

    public void whosOnFirstModule() {

    }

    public void memoryModule() {

    }

    public void morseCodeModule() {

    }

    public void complicatedWiresModule() {

    }

    public void wireSequencesModule() {

    }

    public void mazesModule(){

    }

    public void passwordsModule() {

    }

    public void ventingGasNeedyModule() {

    }

    public void knobsNeedyModule() {

    }


    // Resets the pane to a blank slate
    private void reset() {
        getContentPane().removeAll();
        revalidate();
    }

    // Creates a new button with an action listener
    private JButton newButton(String name, ActionListener action) {
        JButton button = new JButton(name);
        button.addActionListener(action);
        add(button);
        return button;
    }

    // Adds a field of text with information
    private JTextField newTextField(String name) {
        JTextField textField = new JTextField(name);
        add(textField);
        return textField;
    }

    private JTextArea newTextArea(String contents) {
        JTextArea textArea = new JTextArea(contents);
        textArea.setEditable(false);
        add(textArea);
        return textArea;
    }

    // Makes a dropdown box with options
    private JComboBox<String> newDropdown(String[] items) {
        JComboBox<String> dropdown = new JComboBox<>(items);
        add(dropdown);
        return dropdown;
    }
}