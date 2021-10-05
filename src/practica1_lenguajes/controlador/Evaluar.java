package practica1_lenguajes.controlador;

/**
 *
 * @author douglas2021
 */
public class Evaluar {
     public static boolean ev(String n1, String n2){
        if ( n1.length() == n2.length() ) {
            for (int i = 0; i < n1.length(); i++) {
                if (n1.charAt(i) == n2.charAt(i)) {
                    if (i == (n2.length()-1)) {
                        return true;
                    }
                }else{
                    break;
                }
            }
        }
        return false;
    }
}
