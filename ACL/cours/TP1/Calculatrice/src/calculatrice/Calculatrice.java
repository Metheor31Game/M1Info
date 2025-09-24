package calculatrice;

import controleur.Controleur;
import modele.Modele;
import view.ClasicViewDigit;
import view.HexaView;

/**
 *
 * @author cirstea
 */
public class Calculatrice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClasicViewDigit guid = new ClasicViewDigit();
        HexaView hguid = new HexaView();
        Modele m = new Modele();
        Controleur c = new Controleur(m);
        guid.ajouterControleur(c);
        hguid.ajouterControleur(c);
        m.addObserver(guid);
        m.addObserver(hguid);

        
    }
}
