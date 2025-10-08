package classes;
public class UE {
    public String nom;

    public UE(String nom) {
        this.nom = nom;
    }
    @Override
    public boolean equals(Object obj) {
        return obj instanceof UE ue && java.util.Objects.equals(nom, ue.nom);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(nom);
    }



}
