package classes;
public class UE {
    public String nom;
    private int nbHeuresCM;
    private int nbHeuresTD;
    private int nbHeuresTP;

    public UE(String nom, int nbHeuresCM, int nbHeuresTD, int nbHeuresTP) {
        this.nom = nom;
        this.nbHeuresCM = nbHeuresCM;
        this.nbHeuresTD = nbHeuresTD;
        this.nbHeuresTP = nbHeuresTP;
    }

    public int getNbHeuresCM() { return nbHeuresCM; }
    public void setNbHeuresCM(int nbHeuresCM) { this.nbHeuresCM = nbHeuresCM; }
    public int getNbHeuresTD() { return nbHeuresTD; }
    public void setNbHeuresTD(int nbHeuresTD) { this.nbHeuresTD = nbHeuresTD; }
    public int getNbHeuresTP() { return nbHeuresTP; }
    public void setNbHeuresTP(int nbHeuresTP) { this.nbHeuresTP = nbHeuresTP; }
    @Override
    public boolean equals(Object obj) {
        return obj instanceof UE ue && java.util.Objects.equals(nom, ue.nom);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(nom);
    }



}
