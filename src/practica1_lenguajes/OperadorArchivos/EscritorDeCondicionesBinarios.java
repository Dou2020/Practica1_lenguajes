/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_lenguajes.OperadorArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import practica1_lenguajes.domain.lexema;

/**
 *
 * @author douglas2021
 */
public class EscritorDeCondicionesBinarios {

    public static final File FILE_CONDICIONES = new File("/media/douglas2021/Dou_job/junio_vaquera/ArchivosBinarios");

    public void guardarLexemas(ArrayList<lexema> condiciones) throws IOException, FileNotFoundException {
        FileOutputStream fileOutput;
        ObjectOutputStream salida;
        for (lexema condicion : condiciones) {
            System.out.println(condicion.getTokens() + " " + condicion.getTexto());
            if (FILE_CONDICIONES.mkdirs()) {
                System.out.println("no existe lo voy a tratar de generar");
            } else {
                System.out.println("existe");

                fileOutput = new FileOutputStream(FILE_CONDICIONES + "/" + condicion.getTokens());
                salida = new ObjectOutputStream(fileOutput);
                salida.writeObject(condicion);
                salida.close();
            }
        }
    }
}
