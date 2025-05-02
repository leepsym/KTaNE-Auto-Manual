package Main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private final JMenuBar bar = new JMenuBar();
    private final Container content = getContentPane();
    public Window() {
        setTitle("KTaNE Automatic Manual");
        setSize(1280, 720);
        setJMenuBar(bar);
        menuItem("Modules", l -> returnToModules());

        setLayout(new GridBagLayout());
        setVisible(true);

        returnToModules();
    }

    public void returnToModules() {
        reset();
        // Modules
        button("Basic Wires", j -> new Standard.Wires(),Static.constraints(0,0,1,1));
        button("Simon Says", j -> new Standard.SimonSays(),Static.constraints(1,0,1,1));

        revalidate();
    }
    public void buttonQuery(String question, Option[] options) {
        reset();
        label(question, Static.constraints(0,0,options.length,1));
        for (int i = 0; i < options.length; i++) {
            Option o = options[i];
            JButton b = new JButton(o.text());
            b.addActionListener(o.action());
            add(b, Static.constraints(i, 1, 1, 1));
        }
        revalidate();
    }
    public void textFieldQuery(String question) {
        reset();
        Static.input = null;
        label(question, Static.constraints(0,0,1,1));
        JTextField textField = textField("",Static.constraints(0,1,1,1));
        textField.addActionListener(l -> {
            Static.input = textField.getText();
            returnToModules();
        });
        revalidate();
    }

    // Resets the pane to a blank slate
    public void reset() {
        content.removeAll();
    }

    private void menuItem(String text, ActionListener action) {
        JMenuItem item = new JMenuItem(text);
        item.addActionListener(action);
        bar.add(item);
    }

    public void label(String text, GridBagConstraints constraints) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, constraints);
    }

    // Creates a new button with an action listener
    public void button(String text, ActionListener action, GridBagConstraints constraints) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        add(button, constraints);
    }

    // Creates a new button with an action listener
    public JTextField textField(String text, GridBagConstraints constraints) {
        JTextField textField = new JTextField(text);
        add(textField, constraints);
        return textField;
    }
}