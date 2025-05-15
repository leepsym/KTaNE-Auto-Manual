package Main;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(bar);
        menuItem("Modules", l -> returnToModules());

        setLayout(new GridBagLayout());
        setVisible(true);

        returnToModules();
    }

    public void returnToModules() {
        reset();
        // Modules
        button("Basic Wires", j -> new Standard.Wires(), Static.constraints(0,0,1,1));
        button("Simon Says", j -> new Standard.SimonSays(), Static.constraints(1,0,1,1));
        button("Who's on First?", j -> new Standard.WhosOnFirst(), Static.constraints(2,0,1,1));
        button("Memory", j -> new Standard.Memory(), Static.constraints(3,0,1,1));

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
    public void textFieldQuery(String question, ActionListener action) {
        reset();
        label(question, Static.constraints(0,0,1,1));
        JTextField textField = textField("",Static.constraints(0,1,1,1));
        textField.addActionListener(l -> {
            Static.input(new String[]{textField.getText()});
            action.actionPerformed(null);
        });
        revalidate();
    }
    public void comboBoxQuery(String question, String[][] text, Option option) {
        reset();
        label(question, Static.constraints(0,0,text.length,1));
        JComboBox<String>[] comboBox = new JComboBox[text.length];
        for (int i = 0; i < text.length; i++) {
            comboBox[i] = new JComboBox<>(text[i]);
            add(comboBox[i], Static.constraints(i, 1, 1, 1));
        }
        JButton b = new JButton(option.text());
        b.addActionListener(l -> {
            String[] input = new String[text.length];
            for (int i = 0; i < text.length; i++) {
                input[i] = (String) comboBox[i].getSelectedItem();
            }
            Static.input(input);
            option.action().actionPerformed(null);
        });
        add(b, Static.constraints(0, 2, text.length, 1));
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