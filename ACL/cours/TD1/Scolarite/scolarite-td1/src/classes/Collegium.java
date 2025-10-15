package classes;

import java.util.List;

import inerface.FormationInterface;

public class Collegium implements FormationInterface{

    private String nom;
    private String contact;
    private List<FormationInterface> enfants; // disciplines
    private List<Module> modulesMutualises; // modules mutualisés au niveau du collégium

    private FormationInterface parent = null;

    public Collegium(String nom, String contact, List<FormationInterface> enfants, List<Module> modulesMutualises) {
        this.nom = nom;
        this.contact = contact;
        this.enfants = enfants;
        this.modulesMutualises = modulesMutualises;
        if (enfants != null) {
            for (FormationInterface enfant : enfants) {
                if (enfant instanceof classes.Discipline) {
                    ((classes.Discipline) enfant).setParent(this);
                }
            }
        }
    }

    public void setParent(FormationInterface parent) {
        this.parent = parent;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getContact() {
        if (contact != null && !contact.isEmpty()) {
            return contact;
        }
        if (parent != null) {
            return parent.getContact();
        }
        return null;
    }

    @Override
    public String getNombreUE() {
        // Calcul du nombre d'UEs en évitant les doublons (mutualisation)
        java.util.Set<Module> uniqueModules = new java.util.HashSet<>();
        if (modulesMutualises != null) {
            uniqueModules.addAll(modulesMutualises);
        }
        if (enfants != null) {
            for (FormationInterface enfant : enfants) {
                Module module = enfant.getModule();
                if (module != null) {
                    uniqueModules.add(module);
                }
            }
        }
        return String.valueOf(uniqueModules.size());
    }

    @Override
    public List<FormationInterface> getEnfants() {
        return enfants;
    }

    @Override
    public Module getModule() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getModule'");
    }

}
