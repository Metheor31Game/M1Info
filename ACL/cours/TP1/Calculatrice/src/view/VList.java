package view;

import javax.swing.*;
import java.awt.*;

public class VList {
    private JFrame fenetre;
    private JTextArea zoneTexte;

    public VList() {
        fenetre = new JFrame("VList");
        zoneTexte = new JTextArea(10, 10);
        zoneTexte.setEditable(false);
        zoneTexte.setFont(new Font("Monospaced", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(zoneTexte);
        fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fenetre.setLayout(new BorderLayout());
        fenetre.add(scrollPane, BorderLayout.CENTER);
        fenetre.setSize(200, 300);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
    }

    // Affiche les étapes du calcul en vertical
    public void setText(String expression) {
        StringBuilder builder = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '=') {
             builder.append('\n').append(c).append('\n');
            } else {
             builder.append(c);
            }
        }
        // Nettoyage des éventuels doubles sauts de ligne
        String vertical = builder.toString().replaceAll("\\n+", "\n").trim();
        zoneTexte.setText(vertical);
    }
}
