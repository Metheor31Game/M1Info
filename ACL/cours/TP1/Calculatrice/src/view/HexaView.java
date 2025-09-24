package view;


/**
 *
 * @author cirstea
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import controleur.Controleur;
import library.Converter;
import library.Observer;


public class HexaView implements Observer{

    private final JFrame frame = new JFrame("Calculatrice");
    private int resultat = 0;
    private final JPanel[] panels = new JPanel[6];
    private final JTextField textField = new JTextField();
    private final JButton[] numberButtons = new JButton[10];
    private final JButton[] hexaButtons = new JButton[6];
    private final JButton subtractButton = new JButton("-");
    private final JButton addButton = new JButton("+");
    private final JButton multiplyButton = new JButton("*");
    private final JButton divideButton = new JButton("/");
    private final JButton equateButton = new JButton(" = ");
    private Controleur controleur;
    private String currentExp;

    public HexaView() {
        this.currentExp = "";
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
        char[] hexaChars = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i = 0; i < hexaButtons.length; i++) {
            hexaButtons[i] = new JButton(String.valueOf(hexaChars[i]));
            hexaButtons[i].addActionListener(new HexaListener(String.valueOf(hexaChars[i])));
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
        panels[1].add(multiplyButton);
        multiplyButton.addActionListener(new OpListener(Converter.TIMES));

        // layout = FlowLayout.LEFT
        panels[2].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[2].add(numberButtons[4]);
        panels[2].add(numberButtons[5]);
        panels[2].add(numberButtons[6]);
        panels[2].add(subtractButton);
        subtractButton.addActionListener(new OpListener(Converter.MINUS));
        panels[2].add(divideButton);
        divideButton.addActionListener(new OpListener(Converter.DIV));

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
        panels[4].add(hexaButtons[0]); //boutons hexa
        panels[4].add(hexaButtons[1]);
        panels[4].add(hexaButtons[2]);
        panels[5].add(hexaButtons[3]);
        panels[5].add(hexaButtons[4]);
        panels[5].add(hexaButtons[5]);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        for (JPanel jPanel : panels) {
            contentPane.add(jPanel);
        }
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void ajouterControleur(Controleur controleur) {
        this.controleur = controleur;
    }
    
    @Override
    public void update(String chaine) {
        // Extraire le dernier nombre de la chaîne (après le dernier opérateur)
        String[] parts = chaine.split("[\\+\\-\\*/=]");
        String fin = parts[parts.length - 1].trim();
        try {
            resultat = Integer.parseInt(fin);
        } catch (NumberFormatException e) {
            resultat = 0;
        }
        majBarre(resultat);
    }

    // Met à jour la barre de la fenêtre avec le résultat
    public void majBarre(int resultat) {
        String r = this.controleur.getHexa(resultat);
        this.currentExp = r;
        textField.setText(r);
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
            HexaView.this.currentExp = HexaView.this.currentExp + Converter.op2String(op);
            textField.setText(HexaView.this.currentExp);
            controleur.recevoirOp(op);
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
            HexaView.this.currentExp = HexaView.this.currentExp + String.valueOf(digit);
            textField.setText(HexaView.this.currentExp);
            controleur.recevoirNombre(digit);
        }
    }

    class HexaListener implements ActionListener {

        private final String h;

        public HexaListener(String h) {
            this.h = h;
        }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Hexa: " + h);
            HexaView.this.currentExp = HexaView.this.currentExp + h;
            textField.setText(HexaView.this.currentExp);
            controleur.recevoirHexa(h);
        }
    }

}
