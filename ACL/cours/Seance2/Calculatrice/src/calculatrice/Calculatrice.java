package calculatrice;

import controleur.Controleur;
import modele.Modele;
import view.ClasicViewDigit;

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
        Modele m = new Modele();
        Controleur c = new Controleur(m);
        guid.ajouterControleur(c);
        m.addObserver(guid);


        
    }
}
