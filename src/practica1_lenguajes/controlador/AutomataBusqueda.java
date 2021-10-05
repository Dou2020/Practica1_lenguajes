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
        
        if ((posicion < palabra.length()) && ('\n' == palabra.charAt(posicion)) ) {
            System.out.println("posicion: "+posicion+" Ingreso a un salto de linea");
            posicion++;
            return;
        }
        while ((seguirLeyendo) && (posicion < palabra.length())) {
            if (Character.isSpaceChar(tmp = palabra.charAt(posicion)) || ( !(estadoActual < txtBuscar.length()) && (estadoActual == -1)) ) {
                seguirLeyendo = false;
            } else {
                int a = estadoActual +1;
                System.out.println(
                        "posicion: " + posicion + " Estado actual "+ estadoActual +  " caracter " + tmp);
                if ((estadoActual < txtBuscar.length()) && (txtBuscar.charAt(estadoActual) == tmp)) {
                    token += tmp;
                    estadoActual++;
                    if (comprobar()) {
                        System.out.println("Encontrado el automata en: "+posicion);
                        listPosicion.add(posicion);
                    }
                } else { 
                    posicion++;
                    return;
                }
            }
            posicion++;
        }

    }
    private boolean comprobar(){
        int a = posicion;
        int b = posicion;
        if (posicion+1 < palabra.length()) {
            a = posicion+1;
        }
        
        // comprobar que el siguiente no sea mayor a la longitud de la cadena de busqueda
        if ((txtBuscar.length()==estadoActual)&&(posicion+1) == palabra.length()) {
            estadoActual = -1;
            return true; 
        }
        // comprobar que esta el automata terminando y evalua se es correcto
        if ((txtBuscar.length()==estadoActual) && ( (palabra.charAt(a) == ' ') || (palabra.charAt(a) == '\n') ) ) {
            b = posicion - txtBuscar.length();
            System.out.println(b);
            if (palabra.charAt(b) == ' ' || palabra.charAt(b)=='\n') {
                System.out.println("Es la frase completa");
                return true;
            }
        }
        
        return false;
    }

}
