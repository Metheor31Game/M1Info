package classes;

import java.util.List;

import inerface.FormationInterface;

public class Collegium implements FormationInterface{

    private String nom;
    private String contact;
    private List<FormationInterface> enfants; // disciplines
    private List<Module> modulesMutualises; // modules mutualisés au niveau du collégium

    public Collegium(String nom, String contact, List<FormationInterface> enfants, List<Module> modulesMutualises) {
        this.nom = nom;
        this.contact = contact;
        this.enfants = enfants;
        this.modulesMutualises = modulesMutualises;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getContact() {
        // Si le contact n'est pas défini, retourne null
        return contact;
    }

    @Override
    public int getNombreUE() {
        // Calcul du nombre d'UEs en évitant les doublons (mutualisation)
        java.util.Set<Module> uniqueModules = new java.util.HashSet<>();
        if (modulesMutualises != null) {
            uniqueModules.addAll(modulesMutualises);
        }
        if (enfants != null) {
            for (FormationInterface enfant : enfants) {
                List<Module> modules = enfant.getModules();
                if (modules != null) {
                    uniqueModules.addAll(modules);
                }
            }
        }
        return uniqueModules.size();
    }

    @Override
    public List<FormationInterface> getEnfants() {
        return enfants;
    }

    @Override
    public List<Module> getModules() {
        return modulesMutualises;
    }

    @Override
    public Module getModule() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getModule'");
    }

}
