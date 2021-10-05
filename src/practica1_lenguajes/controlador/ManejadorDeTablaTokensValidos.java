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
public class ManejadorDeTablaTokensValidos {

    public static void llenarTabla(ArrayList<lexema> Lexema, JTable tokens, JTable lexema) {
        //table.setVisible(false);
        //aceptacion.setVisible(false);
        DefaultTableModel modelo = new DefaultTableModel();
        tokens.setModel(modelo);
        DefaultTableModel modelo2 = new DefaultTableModel();
        lexema.setModel(modelo2);
        //Anadir columnas
        modelo.addColumn("Lexema");
        modelo.addColumn("Tokens");
        modelo.addColumn("Fila");
        modelo.addColumn("Columna");
        for (lexema txt : Lexema) {
            modelo.addRow(new Object[]{txt.getTexto(), txt.getTokens(), txt.getFila(), txt.getColumna()});
        }
        modelo2.addColumn("lexema");
        modelo2.addColumn("Tokens");
        modelo2.addColumn("Cantidad");
        ConteoLexema cl = new ConteoLexema(Lexema);
        for (lexema txt : cl.contar()) {
            if (!Evaluar.ev("Error", "")) {
                modelo2.addRow(new Object[]{txt.getTexto(), txt.getTokens(), txt.getCantidad()});
            }
        }
    }
}
