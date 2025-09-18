package controleur;

import library.Converter;
import modele.Modele;

public class Controleur {
    private Modele modele;

    public Controleur(Modele modele) {
        this.modele = modele;
    }

    public void recevoirNombre(int n) {
        this.modele.ajouterInt(n);
    }

    public void recevoirOp(int op) {
        String opString = Converter.op2String(op);
        if (opString.equals("=")) {
            this.modele.executer();
        } else {
            this.modele.ajouterOp(opString);
        }
    }

}
