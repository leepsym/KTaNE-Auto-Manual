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
        button("Basic Wires", j -> new Standard.Wires(),Static.constraints(0,0,0,0));

        revalidate();
    }
    public void query(String question, Option[] options) {
        reset();
        label(question, Static.constraints(0,0,3,1));
        for (int i = 0; i < options.length; i++) {
            Option o = options[i];
            JButton b = new JButton(o.text());
            b.addActionListener(o.action());
            add(b, Static.constraints(i, 1, 1, 1));
        }
        revalidate();
    }


    // Resets the pane to a blank slate
    private void reset() {
        content.removeAll();
    }

    private void label(String text, GridBagConstraints constraints) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, constraints);
    }

    // Creates a new button with an action listener
    private void button(String text, ActionListener action, GridBagConstraints constraints) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        add(button, constraints);
    }
}