package Main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private volatile String input;
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
    public String textFieldQuery(String question) {
        reset();
        input = null;
        label(question, Static.constraints(0,0,1,1));
        JTextField textField = textField("",Static.constraints(0,1,1,1));
        textField.addActionListener(l -> input = textField.getText());
        revalidate();
        System.out.println("a");
        new Thread(new Runnable() {
            @Override
            public void run() {
                return input;
            }
        });

    }

    // Resets the pane to a blank slate
    public void reset() {
        content.removeAll();
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