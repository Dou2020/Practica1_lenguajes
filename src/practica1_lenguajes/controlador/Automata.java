package practica1_lenguajes.controlador;

import java.util.ArrayList;
import practica1_lenguajes.domain.lexema;
import practica1_lenguajes.domain.lineaEntrada;

/**
 *
 * @author douglas2021
 */
public class Automata {

    String palabra;
    int posicion = 0;
    int estadoActual = 0;
    ArrayList<lexema> palabras;

    //tabla de matriz de tansiciones  -1 no esta en el alfabeto
    //              {\L, \D, \P, \OP, \AP, '.'}              
    int matriz[][] = {{1, 2, 3, 4, 5, 3}, //S0
    {1, 8, -1, -1, -1, -1}, //S1
    {-1, 2, -1, -1, -1, 6}, //S2
    {-1, -1, -1, -1, -1, -1}, //S3
    {-1, -1, -1, -1, -1, -1}, //S4
    {-1, -1, -1, -1, -1, -1}, //S5
    {-1, 7, -1, -1, -1, -1}, //S6
    {-1, 7, -1, -1, -1, -1}, //S7
    {1, 8, -1, -1, -1, -1}};      //s8

    // Estados de aceptacion con su valor de finalizaciòn
    int[] estadosFinalizacion = {1, 2, 7, 3, 4, 5, 8};
    String[] descripcionFinalizacion = {"Identificador", "entero", "decimal", "puntuacion", "operador", "agrupacion", "indentificador"};

    //alfabeto de todos los signos agrupados
    char[] letras = {'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l', 'L',
        'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z'};
    char[] agrupacion = {'{', '}', '[', ']', '(', ')'};
    char[] signos = {'.', ',', ';', ':'};
    char[] operadores = {'+', '-', '*', '/', '%'};

    public Automata() {
        palabras = new ArrayList<>();
        //for (int i = 0; i < 9; i++) {
        //    for (int j = 0; j < 6; j++) { System.out.print(""+matriz[i][j]+", "); }  //visualizar el arreglo bidimencional
        //    System.out.println("");  // el salto de linea 
        //}
        /*
         * for (char caracter : palabra.toCharArray()) { System.out.println(caracter); }
         */
    }

    public ArrayList<lexema> evaluando(lineaEntrada linea) {
        System.out.println("Ingreso al automata logitud: " + linea.getTexto().length());
        posicion = 0;
        palabra = linea.getTexto();
        int no = linea.getNoLinea();
        while (posicion < palabra.length()) {
            getToken(no);  // interaccion con el tokens
        }
        return palabras;
    }

    // revisa movimiento den la matriz
    public int getSiguienteEstado(int estadoActual, int caracter) {
        int resultado = -1;
        if (caracter >= 0 && caracter <= 5) {
            resultado = matriz[estadoActual][caracter];
        }
        return resultado;
    }

    //establece aqui el alfabeto 
    public int getIntCaracter(char caracter) {
        int resultado = -1; // es instancia en un valor de no aceptacion
        //for(int i=0; i < letras.length; i++){ // verificar si es una letra
        //    if( letras[i] == caracter )
        //        return resultado = 0;
        //}
        if (Character.isLetter(caracter)) {
            if (!(caracter == 'ñ') && !(caracter == 'Ñ')) {
                return resultado = 0;
            }
        }
        for (int i = 0; i < agrupacion.length; i++) { // verificar si es un estado de agrupacion
            if (agrupacion[i] == caracter) {
                return resultado = 4;
            }
        }
        if (Character.isDigit(caracter)) { // verificar si es un digito
            resultado = 1;
        } else {
            if (estadoActual == 2 && caracter == '.') // verificar si es un punto
            {
                return resultado = 5;
            }
        }
        // verificar que es un estado de signo de puntuacion
        for (int i = 0; i < signos.length; i++) {
            if (signos[i] == caracter) {
                return resultado = 2;
            }
        }
        // verificar que es un estado de operadores 
        for (int i = 0; i < operadores.length; i++) {
            if (operadores[i] == caracter) {
                return resultado = 3;
            }
        }
        return resultado;
    }

    public String getEstadoAceptacion(int i) {
        String res = "Error";
        int indice = 0;
        for (int estadoAceptacion : estadosFinalizacion) {
            if (estadoAceptacion == i) {
                res = descripcionFinalizacion[indice];
                break;
            }
            indice++;
        }

        return res;
    }

    /*
    * get token funciona para para validar cada uno de los lexemas y darle un token si existe o error
     */
    public void getToken(int fila) {
        estadoActual = 0;  // almacena el el valor del token con el que inicia

        boolean seguirLeyendo = true; //establece un estado de verdadero para ingresar como minimo una vez
        char tmp; //este nos permitira almacenar caracter por caracter
        String token = ""; // el token completo
        if ((posicion < palabra.length()) && (Character.isSpaceChar(palabra.charAt(posicion)))) {
            posicion++;
            return;
        }

        while ((seguirLeyendo) && (posicion < palabra.length())) {    // posicion es global nos permitir verificar si leemos todo el string

            if (!Character.isSpaceChar(tmp = palabra.charAt(posicion)) && (estadoActual == -1)) {
                posicion--;
            }
            if (Character.isSpaceChar(tmp = palabra.charAt(posicion)) || (estadoActual == -1)) { // verificar si es un espacio 
                seguirLeyendo = false; // cambia el estado si es un espacio
            } else {// establece que no es un espacio segira leyendo el la cadena
                // para mi automata  (establece el automata)
                int estadoTemporal = getSiguienteEstado(estadoActual, getIntCaracter(tmp)); // establece un estado temporal  para el posicionamiento
                System.out.println(
                        "posicion:" + posicion + " Estado actual " + estadoActual + " caracter " + tmp + " transicion a " + estadoTemporal);
                token += tmp;
                estadoActual = estadoTemporal;
                if (evaluarEstado()) {
                    int va  = token.length() - 1;
                    palabras.add(new lexema(token + " " + token.length(), posicion - va, fila, getEstadoAceptacion(estadoActual)));
                }
                System.out.println(tmp);
            }
            posicion++;
        }
        //if (estadoActual != 0) {
        System.out.println(
                "posicion:" + posicion + "********* Termino en el estado " + getEstadoAceptacion(estadoActual) + " token actual : " + token);
        //}
        // verificar el estado de aceptación
    }

    private boolean evaluarEstado() {
        int a = posicion;
        if (posicion + 1 < palabra.length()) {
            a = posicion + 1;
        }
        char l = palabra.charAt(a);

        if (Character.isSpaceChar(l) || posicion == (palabra.length() - 1)) {
            for (int i = 0; i < estadosFinalizacion.length; i++) {
                if (estadosFinalizacion[i] == estadoActual) {
                    return true;
                }
            }
        }
        if (estadoActual == -1) {
            return true;
        }
        return false;
    }

}
