package library;

/**
 *
 * @author cirstea
 */
public class Converter {
    
    public static final int PLUS = 0;
    public static final int MINUS = 1;
    public static final int TIMES = 2;
    public static final int DIV = 3;
    public static final int EQUAL = 4;
    
    
    public static String op2String(int op) {
        String opString = "";
        switch (op) {
            case PLUS:
                opString = "+";
                break;
            case MINUS:
                opString = "-";
                break;
            case TIMES:
                opString = "*";
                break;
            case DIV:
                opString = "/";
                break;
            case EQUAL:
                opString = "=";
                break;
            default:
                opString = "##";
        }
        return opString;
    }
}
