package inerface;
import java.util.List;

import classes.Module;

public interface FormationInterface {
    public String getNom();
    public String getNombreUE();
    public String getContact();
    public List<FormationInterface> getEnfants();
    public Module getModule(); 


}
