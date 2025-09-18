package controleur;

import library.Converter;
import modele.Modele;
// import view.ClasicViewDigit;

public class Controleur {
    private Modele modele;
    // private ClasicViewDigit CVD = new ClasicViewDigit();

    public Controleur(Modele modele) {
        this.modele = modele;
        // this.CVD = CVD;
    }

    public void recevoirNombre(int n) {
        this.modele.ajouterInt(n);
    }

    public void recevoirOp(int op) {
        String opString = Converter.op2String(op);

        if (opString == "=") {
            this.modele.executer();
        } else {
            this.modele.ajouterOp(opString);
        }
    }

}
