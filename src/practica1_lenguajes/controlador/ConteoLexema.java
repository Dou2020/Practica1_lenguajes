package practica1_lenguajes.controlador;

import java.util.ArrayList;
import practica1_lenguajes.domain.lexema;

/**
 *
 * @author douglas2021
 */
public class ConteoLexema {
    private ArrayList<lexema> l;

    public ConteoLexema(ArrayList<lexema> l) {
        this.l = (ArrayList<lexema>) l.clone();
        
    }
    public ArrayList<lexema> contar(){
        ArrayList<lexema> en = new ArrayList<>();
        lexema temporal;
        int contador=0;
        while(0<l.size()){
            temporal = l.get(0);
            for (int i = 0; i < l.size(); i++) {
                if (Evaluar.ev(temporal.getTexto(),l.get(i).getTexto())) {
                    contador++;
                    l.remove(i);
                    i--;
                }
            }
            System.out.println(temporal.getTexto()+" "+temporal.getTokens()+" "+contador);
            en.add(new lexema(temporal.getTexto(),temporal.getTokens(),contador));
            contador =0;
        }
        return en;
    }
}
