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
    public static void llenarTabla(ArrayList<lexema> Lexema, JTable table,JTable aceptacion) {
        table.setVisible(false);
        aceptacion.setVisible(false);
        DefaultTableModel modelo = new DefaultTableModel();
        DefaultTableModel modelo2 = new DefaultTableModel();
        aceptacion.setModel(modelo2);
        table.setModel(modelo);
        //Anadir columnas
        if ( Evaluar(Lexema) ) {
            table.setVisible(true);
           modelo.addColumn("lexema");
            modelo.addColumn("Fila");
            modelo.addColumn("Columna");
            modelo.addColumn("Token");
            for (lexema txt : Lexema) {
                if (txt.getTokens().equals("Error")) {
                    modelo.addRow(new Object[]{txt.getTexto(), txt.getFila(), txt.getColumna(),txt.getTokens()});
                }
            }
        }
        modelo2.addColumn("lexema");
        modelo2.addColumn("Fila");
        modelo2.addColumn("Columna");
        modelo2.addColumn("Token");
        for (lexema txt : Lexema) {
            if (!txt.getTokens().equals("Error")) {
                modelo2.addRow(new Object[]{txt.getTexto(), txt.getFila(), txt.getColumna(),txt.getTokens()});
            }
        }
    }
    public static boolean Evaluar(ArrayList<lexema> Le){
        for (lexema txt : Le) {
            if (txt.equals("Error")) {
                return true;
            }
        }
        return false;
    }
    
}
