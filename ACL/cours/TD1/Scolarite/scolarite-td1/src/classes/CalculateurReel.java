package classes;

import inerface.Calculateur;
import inerface.FormationInterface;

public class CalculateurReel implements Calculateur{

    @Override
    public double calculPonderation(FormationInterface formation) {
        double charge = 0;
        // Si formation est un module, on calcule la charge réelle pour chaque UE du module
        if (formation.getModule() != null) {
            classes.Module module = formation.getModule();
            for (classes.UE ue : module.UEs) {
                int[] groupes = classes.Administration.getNbGroupes(ue.nom);
                int nbHeuresCM = ue.getNbHeuresCM();
                int nbHeuresTD = ue.getNbHeuresTD();
                int nbHeuresTP = ue.getNbHeuresTP();
                charge += nbHeuresCM * classes.Administration.getFactcm() * groupes[0]
                        + nbHeuresTD * classes.Administration.getFacttd() * groupes[1]
                        + nbHeuresTP * classes.Administration.getFacttp() * groupes[2];
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
