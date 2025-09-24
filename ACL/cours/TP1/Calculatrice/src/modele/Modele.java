package modele;

import java.util.ArrayList;

import library.Observable;
import library.Observer;

public class Modele implements Observable{
    private String expression;
    private int resultat;
    private int premierNombre;
    private int secondNombre;
    private String dernierOp;
    private ArrayList<Observer> observateurs;

    public Modele() {
        this.expression = "";
        this.premierNombre = -1;
        this.secondNombre = -1;
        this.dernierOp = "";
        this.resultat = 0;
        this.observateurs = new ArrayList<>();
    }

    //Ajouter le dernier chiffre a l'expression globale
    public void ajouterInt(int n, boolean hex) {
        StringBuilder builder = new StringBuilder(this.expression);
        builder.append(n);
        this.expression = builder.toString();
        if(dernierOp == "") {
            if(premierNombre == -1) {
                this.premierNombre = n;
            } else if (premierNombre != -1 && !hex) {
                this.premierNombre = 10*this.premierNombre + n;
            } else if (premierNombre != -1 && hex) {
                this.premierNombre = 16*this.premierNombre + n;
            }

        } else {
            if(secondNombre == -1) {
                this.secondNombre = n;
            } else {
                this.secondNombre = 10*this.secondNombre + n;
            }
        }
        
    }

    //Ajouter la derniere operation a l'expression globale
    public void ajouterOp(String op) {
        StringBuilder builder = new StringBuilder(this.expression);
        if(this.premierNombre != -1 && this.secondNombre != -1) {
            this.executer();
            this.dernierOp = op;
        }
        builder.append(op);
        this.expression = builder.toString();
        this.dernierOp = op;
    }

    //Le modele doit chercher dans ses derniers nombres le calcul a faire
    public int executer() {
        switch (dernierOp) {
            case "+":
                this.resultat = this.premierNombre + this.secondNombre;
                break;
            case "-":
                this.resultat = this.premierNombre - this.secondNombre;;
                break;
            case "*":
                this.resultat = this.premierNombre * this.secondNombre;;
                break;
            case "/":
                this.resultat = this.premierNombre / this.secondNombre;
                break;        
            default:
                break;
        }
        this.premierNombre = resultat;
        this.secondNombre = -1;
        this.dernierOp = "";
        
        //Ajouter le resultat a l'expression;
        StringBuilder builder = new StringBuilder(this.expression);
        builder.append("=");
        builder.append(resultat);
        this.expression = builder.toString();

        System.out.println("Resultat : " + resultat);
        System.out.println("Expression : " + this.expression);
        this.notifyObservers();
        return this.resultat;
    }


    public String getExpression() {
        return this.expression;
    }

    @Override
    public void addObserver(Observer o) {
        this.observateurs.add(o);    
    }

    @Override
    public void removeObserver(Observer o) {
        this.observateurs.remove(o);    
    }

    @Override
    public void notifyObservers() {
        for(Observer o: observateurs) {
            o.update(this.expression);
        }
    }

}
