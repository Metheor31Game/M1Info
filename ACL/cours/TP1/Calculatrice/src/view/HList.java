
package view;

import javax.swing.*;
import java.awt.*;

public class HList {
	private JFrame fenetre;
	private JTextField champTexte;

	public HList() {
		fenetre = new JFrame("HList");
		champTexte = new JTextField(20);
		champTexte.setEditable(false);
		champTexte.setHorizontalAlignment(JTextField.CENTER);
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre.setLayout(new BorderLayout());
		fenetre.add(champTexte, BorderLayout.CENTER);
		fenetre.setSize(300, 80);
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
	}

	
	public void setText(String texte) {
		champTexte.setText(texte);
	}
}
