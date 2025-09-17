package modele;

import library.Converter;

public class Modele {
    private String expression;
    private int resultat;
    private int premierNombre;
    private int secondNombre;
    private String dernierOp;

    public Modele() {
        this.expression = "";
        this.premierNombre = -1;
        this.secondNombre = -1;
        this.dernierOp = "";
        this.resultat = 0;
    }

    //Ajouter le dernier chiffre a l'expression globale
    public void ajouterInt(int n) {
        StringBuilder builder = new StringBuilder(this.expression);
        builder.append(n);
        this.expression = builder.toString();
        if(dernierOp == "") {
            if(premierNombre == -1) {
                this.premierNombre = n;
            } else {
                this.premierNombre = 10*this.premierNombre + n;
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
        this.premierNombre = -1;
        this.secondNombre = -1;
        this.dernierOp = "";
        
        //Ajouter le resultat a l'expression;
        StringBuilder builder = new StringBuilder(this.expression);
        builder.append(resultat);
        this.expression = builder.toString();

        return this.resultat;
    }


    public String getExpression() {
        return this.expression;
    }

}
