package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private final Container content = getContentPane();
    public Window() {
        setTitle("KTaNE Automatic Manual");
        setSize(1280, 720);

        setLayout(new GridBagLayout());
        setVisible(true);

        returnToModules();
    }

    public void returnToModules() {
        reset();
        // Modules
        newButton("Basic Wires", j -> new Standard.Wires());

        revalidate();
    }
    public void query(String question, Option[] options) {
        reset();
        add(new JLabel(question));
        for (Option o : options) {
            JButton b = new JButton(o.text());
            b.addActionListener(o.action());
            add(b);
        }
        revalidate();
    }


    // Resets the pane to a blank slate
    private void reset() {
        content.removeAll();
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