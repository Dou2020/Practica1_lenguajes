/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_lenguajes.OperadorArchivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import practica1_lenguajes.domain.lexema;

/**
 *
 * @author douglas2021
 */
public class LectorDeCondionesBinarios {
    
    public ArrayList<lexema> leerCondiciones() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<lexema> cuadros = new ArrayList<>();
        String[]  archivos = EscritorDeCondicionesBinarios.FILE_CONDICIONES.list();
        ObjectInputStream lector;   
        System.out.println("Archivos logitud: "+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            System.out.println(archivo);
                lector = new ObjectInputStream(new FileInputStream(EscritorDeCondicionesBinarios.FILE_CONDICIONES+"/"+archivo));
                lexema l = (lexema)lector.readObject();
                cuadros.add(l);
                lector.close();
        }
        return cuadros;
    }
}
