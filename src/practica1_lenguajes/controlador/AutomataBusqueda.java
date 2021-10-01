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
    ArrayList<Integer> listPosicion;

    public AutomataBusqueda(String texto, String txtBuscar) {
        this.palabra = texto;
        this.txtBuscar = txtBuscar;
        listPosicion = new ArrayList<Integer>();
    }

    public ArrayList<Integer> listadoPalabras() {
        posicion = 0;
        listPosicion.clear();
        while (posicion < palabra.length()) {
            getToken();
        }

        return listPosicion;
    }
    public int getSiguienteEstado(int estadoActual, int caracter) {
        int resultado = -1;
        if (caracter >= 0 && caracter < txtBuscar.length()) {
            resultado = caracter++;
        }
        return resultado;
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
                int a = estadoActual +1;
                System.out.println(
                        "posicion:" + posicion + " Estado actual "+ estadoActual +  " caracter " + tmp + " transicion a ");
                if ((estadoActual < txtBuscar.length()) && (txtBuscar.charAt(estadoActual) == tmp)) {
                    token += tmp;
                    estadoActual++;
                    if (comprobar()) {
                        listPosicion.add(posicion);
                    }
                } else { 
                    estadoActual = -1;
                }
            }
            posicion++;
        }

    }
    private boolean comprobar(){
        int a = posicion;
        if (posicion+1 < palabra.length()) {
            a = posicion+1;
        }
        if ((txtBuscar.length()==estadoActual)&&(posicion+1) == palabra.length()) {
            estadoActual = -1;
            return true; 
        }
        if ((txtBuscar.length()==estadoActual) && (palabra.charAt(a) == ' ')) {
            return true;
        }
        
        return false;
    }

}
