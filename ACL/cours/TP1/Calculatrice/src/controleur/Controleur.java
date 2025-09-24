package controleur;

import library.Converter;
import library.HexaConverter;
import modele.Modele;

public class Controleur {
    private Modele modele;

    public Controleur(Modele modele) {
        this.modele = modele;
    }

    public void recevoirNombre(int n) {
        this.modele.ajouterInt(n, false);
    }
    public void recevoirHexa(String h) {
        this.modele.ajouterInt(HexaConverter.hexToInt(h), true);
    }

    public String getHexa(int n) {
        return HexaConverter.intToHex(n);
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
