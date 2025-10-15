package classes;

import inerface.Calculateur;
import inerface.FormationInterface;

public class CalculateurTheorique implements Calculateur{

    @Override
    public double calculPonderation(FormationInterface formation) {
        double charge = 0;
        // Si formation est un module, on calcule la charge théorique pour chaque UE du module
        if (formation.getModule() != null) {
            classes.Module module = formation.getModule();
            for (classes.UE ue : module.UEs) {
                int nbHeuresCM = ue.getNbHeuresCM();
                int nbHeuresTD = ue.getNbHeuresTD();
                int nbHeuresTP = ue.getNbHeuresTP();
                // Un seul groupe pour chaque type
                charge += nbHeuresCM * classes.Administration.getFactcm() * 1
                        + nbHeuresTD * classes.Administration.getFacttd() * 1
                        + nbHeuresTP * classes.Administration.getFacttp() * 1;
            }
        }
        // Si formation a des enfants, on additionne la charge de chaque enfant
        else if (formation.getEnfants() != null && !formation.getEnfants().isEmpty()) {
            for (FormationInterface enfant : formation.getEnfants()) {
                charge += calculPonderation(enfant);
            }
        }
        return charge;
    }

}
