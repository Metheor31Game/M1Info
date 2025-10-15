public class App {
    public static void main(String[] args) throws Exception {
    // Création des UEs avec nombre d'heures CM, TD, TP
    classes.UE ue1 = new classes.UE("ACL", 20, 15, 10);
    classes.UE ue2 = new classes.UE("DP", 18, 12, 8);
    classes.UE ue3 = new classes.UE("IA", 22, 14, 6);
    classes.UE ue4 = new classes.UE("IHM", 16, 10, 12);
    classes.UE ue5 = new classes.UE("GLA", 24, 16, 10);

    // Création des modules
    java.util.Set<classes.UE> s7UEs = new java.util.HashSet<>();
    s7UEs.add(ue1); s7UEs.add(ue2);
    classes.Module moduleS7 = new classes.Module(s7UEs);

    java.util.Set<classes.UE> s8UEs = new java.util.HashSet<>();
    s8UEs.add(ue3); s8UEs.add(ue4);
    classes.Module moduleS8 = new classes.Module(s8UEs);

    java.util.Set<classes.UE> s9UEs = new java.util.HashSet<>();
    s9UEs.add(ue5); s9UEs.add(ue2);
    classes.Module moduleS9 = new classes.Module(s9UEs);

    // Création des semestres
    classes.Semestre semestre7 = new classes.Semestre("S7", "FL", moduleS7);
    classes.Semestre semestre8 = new classes.Semestre("S8", "FL", moduleS8);
    classes.Semestre semestre9 = new classes.Semestre("S9", "FL", moduleS9);

    // Création du diplôme
    java.util.List<inerface.FormationInterface> semestres = new java.util.ArrayList<>();
    semestres.add(semestre7);
    semestres.add(semestre8);
    semestres.add(semestre9);
    classes.Diplome masterInfo = new classes.Diplome("Master Info", "HC", semestres);

    // Test affichage avec le calculateur théorique
    System.out.println("Affichage avec calculateur théorique :");
    inerface.Calculateur calculateurTheorique = new classes.CalculateurTheorique();
    masterInfo.afficher("", calculateurTheorique);

    // Test affichage avec le calculateur réel
    System.out.println("\nAffichage avec calculateur réel :");
    inerface.Calculateur calculateurReel = new classes.CalculateurReel();
    masterInfo.afficher("", calculateurReel);
    }
}
