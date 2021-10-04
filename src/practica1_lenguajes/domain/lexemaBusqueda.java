package practica1_lenguajes.domain;

/**
 *
 * @author douglas2021
 */
public class lexemaBusqueda {
    private int inicio;
    private int end;

    public lexemaBusqueda(int inicio, int end) {
        this.inicio = inicio;
        this.end = end;
    }
    
    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
    
}
