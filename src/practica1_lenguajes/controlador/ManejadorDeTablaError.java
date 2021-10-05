package practica1_lenguajes.controlador;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import practica1_lenguajes.domain.lexema;
import practica1_lenguajes.controlador.Evaluar;
/**
 *
 * @author douglas2021
 */
public class ManejadorDeTablaError {

    public static void llenarTabla(ArrayList<lexema> Lexema, JTable table, JTable aceptacion) {
        //table.setVisible(false);
        //aceptacion.setVisible(false);
        DefaultTableModel modelo = new DefaultTableModel();
        table.setModel(modelo);
        DefaultTableModel modelo2 = new DefaultTableModel();
        aceptacion.setModel(modelo2);
        //Anadir columnas
        modelo.addColumn("lexema");
        modelo.addColumn("Fila");
        modelo.addColumn("Columna");
        modelo.addColumn("Token");
        for (lexema txt : Lexema) {
            if (Evaluar.ev("Error",txt.getTokens())) {
                modelo.addRow(new Object[]{txt.getTexto(), txt.getFila(), txt.getColumna(), txt.getTokens()});
            }
        }
        modelo2.addColumn("lexema");
        modelo2.addColumn("Fila");
        modelo2.addColumn("Columna");
        modelo2.addColumn("Token");
        for (lexema txt : Lexema) {
            if (!Evaluar.ev("Error", txt.getTokens())) {
                modelo2.addRow(new Object[]{txt.getTexto(), txt.getFila(), txt.getColumna(), txt.getTokens()});
            }
        }
    }
}
