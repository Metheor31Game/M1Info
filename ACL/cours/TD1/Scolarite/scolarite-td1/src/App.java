public class App {
    public static void main(String[] args) throws Exception {
    // Création des UEs
    classes.UE ue1 = new classes.UE("ACL");
    classes.UE ue2 = new classes.UE("DP");
    classes.UE ue3 = new classes.UE("IA");
    classes.UE ue4 = new classes.UE("IHM");
    classes.UE ue5 = new classes.UE("GLA");

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

    // Test affichage
    masterInfo.afficher("");
    }
}
