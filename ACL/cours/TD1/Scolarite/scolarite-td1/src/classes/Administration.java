package classes;

public class Administration {

    //constante des facteurs des groupes
    private final static int factCM = 4;
    private final static int factTD = 2;
    private final static int factTP = 1;

    public static int getFactcm() {
        return factCM;
    }

    public static int getFacttd() {
        return factTD;
    }

    public static int getFacttp() {
        return factTP;
    }

    // Retourne [nbGroupesCM, nbGroupesTD, nbGroupesTP] pour un module
    public static int[] getNbGroupes(String module) {
        switch (module) {
            case "ACL": return new int[]{1, 2, 2};
            case "DP": return new int[]{1, 2, 1};
            case "IA": return new int[]{1, 1, 2};
            case "IHM": return new int[]{1, 2, 1};
            case "GLA": return new int[]{1, 1, 1};
            default: return new int[]{1, 1, 1}; // valeurs par défaut
        }
    }

}
