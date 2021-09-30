/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_lenguajes.OperadorArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JTextArea;
import practica1_lenguajes.domain.lexema;
import practica1_lenguajes.domain.lineaEntrada;

/**
 *
 * @author douglas2021
 */

public class LectorDeCondicionesEnTexto {
       
    public ArrayList<lineaEntrada> leerFichero(File archivo,JTextArea text) throws FileNotFoundException, IOException {
        // crea el arreglo para ingresar el vehiculo
        ArrayList<lineaEntrada> condiciones = new ArrayList<>();
        System.out.println("ingreso aqui leer");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        int contar = 0;
        while ((linea = br.readLine()) != null) {
            //agregarlo al array para luego enviarlo
            condiciones.add(new lineaEntrada(linea,contar));
            contar++;
            //con la linea leida, separamos los campos
            text.append("\n"+linea);
        }
        fr.close(); 
        return condiciones;
    }
}
