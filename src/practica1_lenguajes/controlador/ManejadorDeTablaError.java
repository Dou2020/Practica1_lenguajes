/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1_lenguajes.controlador;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import practica1_lenguajes.domain.lexema;

/**
 *
 * @author douglas2021
 */
public class ManejadorDeTablaError {
    public static void llenarTabla(ArrayList<lexema> Lexema, JTable table) {
        DefaultTableModel modelo = new DefaultTableModel();
        table.setModel(modelo);
        //Anadir columnas
        modelo.addColumn("lexema");
        modelo.addColumn("Fila");
        modelo.addColumn("Columna");
        modelo.addColumn("Token");
        for (lexema txt : Lexema) {
            modelo.addRow(new Object[]{txt.getTexto(), txt.getFila(), txt.getColumna(),txt.getTokens()});
        }

    }
    
}
