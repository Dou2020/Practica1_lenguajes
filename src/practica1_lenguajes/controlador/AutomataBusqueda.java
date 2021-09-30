package practica1_lenguajes.controlador;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author douglas2021
 */
public class AutomataBusqueda {

    private String txtBuscar;
    private int posicion = 0;
    private int estadoActual = 0;
    private String palabra;

    public AutomataBusqueda(String texto, String txtBuscar) {
        this.palabra = texto;
        this.txtBuscar = txtBuscar;

    }

    public List<Integer> listadoPalabras() {
        List<Integer> listPosicion = new ArrayList<>();
        while (posicion < palabra.length()) {
            getToken();
        }

        return listPosicion;
    }

    private void getToken() {
        estadoActual = 0;  // almacena el el valor del token con el que inicia
        int estadotxt = 0;
        boolean seguirLeyendo = true; //establece un estado de verdadero para ingresar como minimo una vez
        char tmp; //este nos permitira almacenar caracter por caracter
        String token = ""; // el token completo
        while ((seguirLeyendo) && (posicion < palabra.length())) {
            if (Character.isSpaceChar(tmp = palabra.charAt(posicion)) || estadoActual == -1) {
                seguirLeyendo = false;
            } else {
                if (txtBuscar.charAt(estadoActual) == tmp) {
                    estadoActual++;
                } else {
                    estadoActual = -1;
                }
                
            }
            posicion++;
        }

    }
    private boolean comprobar(){
        
        
        return false;
    }

}
