package view;


/**
 *
 * @author cirstea
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import library.Converter;

public class ClasicViewDigit {

    private final JFrame frame = new JFrame("Calculator");
    private final JPanel[] panels = new JPanel[6];
    private final JTextField textField = new JTextField();
    private final JButton[] numberButtons = new JButton[10];
    private final JButton subtractButton = new JButton("-");
    private final JButton addButton = new JButton("+");
    private final JButton equateButton = new JButton(" = ");

    public ClasicViewDigit() {
        buildFrame();
    }

    /**
     * final because is called in the constructor
     */
    public final void buildFrame() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = (JPanel) frame.getContentPane();

        // initialize panels
        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
        }

        // initialize button 0-9
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(" " + i + " ");
            numberButtons[i].addActionListener(new DigitListener(i));
        }

        // default layout = BorderLayout.CENTER
        textField.setColumns(20);
        textField.setText("");
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        panels[0].add(textField);

        // layout = FlowLayout.LEFT
        panels[1].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[1].add(numberButtons[7]);
        panels[1].add(numberButtons[8]);
        panels[1].add(numberButtons[9]);
        panels[1].add(addButton);
        addButton.addActionListener(new OpListener(Converter.PLUS));

        // layout = FlowLayout.LEFT
        panels[2].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[2].add(numberButtons[4]);
        panels[2].add(numberButtons[5]);
        panels[2].add(numberButtons[6]);
        panels[2].add(subtractButton);
        subtractButton.addActionListener(new OpListener(Converter.MINUS));

        // layout = FlowLayout.LEFT
        panels[3].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[3].add(numberButtons[1]);
        panels[3].add(numberButtons[2]);
        panels[3].add(numberButtons[3]);
        panels[3].add(equateButton);
        equateButton.addActionListener(new OpListener(Converter.EQUAL));

        // layout = FlowLayout.LEFT
        panels[4].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[4].add(numberButtons[0]);

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        for (JPanel jPanel : panels) {
            contentPane.add(jPanel);
        }

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Controller for the operation keys
     */
    class OpListener implements ActionListener {
        private final int op;

        public OpListener(int op) {
            this.op = op;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("op: " + op);
        }
    }

    /**
     * Controller for the digit keys
     */
    class DigitListener implements ActionListener {

        private final int digit;

        public DigitListener(int digit) {
            this.digit = digit;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("digit: " + digit);
        }
    }
}
