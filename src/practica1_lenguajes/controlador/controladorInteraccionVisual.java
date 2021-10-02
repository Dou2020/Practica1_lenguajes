/*
 * Aqui se va a realizar toda la parte de cambios a la parte visual interaccion Visual
 */
package practica1_lenguajes.controlador;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import practica1_lenguajes.OperadorArchivos.LectorDeCondicionesEnTexto;
import practica1_lenguajes.Vista.InteraccionVisual;
import practica1_lenguajes.domain.lexema;
import practica1_lenguajes.domain.lineaEntrada;

/**
 *
 * @author douglas2021
 */
public class controladorInteraccionVisual {

    ArrayList<lexema> expreciones = new ArrayList<>();
    ArrayList<lineaEntrada> linea = new ArrayList<>();
    Highlighter.HighlightPainter painter;
    Highlighter hilit;
    Color colorfondodefault;
    InteraccionVisual visual;

    public controladorInteraccionVisual(InteraccionVisual visual) {
        this.visual = visual;
        hilit = new DefaultHighlighter();
        painter = new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN);
        this.visual.getTextoEntrada().setHighlighter(hilit);
        colorfondodefault = this.visual.getTextoBuscar().getBackground();
    }

    public void subirArchivo() throws IOException {
        LectorDeCondicionesEnTexto lector = new LectorDeCondicionesEnTexto();
        JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showOpenDialog(visual);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            //aqui selecciono y guardo el FILE que va a utilizar el FileReader
            File fichero = fileChosser.getSelectedFile();
            try {
                linea = lector.leerFichero(fichero, this.visual.getTextoEntrada());
                //this.escritorDeTextoBinarios.guardarVehiculo(expreciones);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(visual, "Error al leer el archivo");
                ex.printStackTrace();
            }
        }
        for (lineaEntrada l : linea) {
            System.out.println(l.getTexto()+" "+l.getNoLinea());
        }
    }

    public void recibirCambio() {

    }
    public void actualizarLinea(){
        linea.clear();
        String text = "";
        int fila = 0;
        String p = visual.getTextoEntrada().getText();
        System.out.println(p);
        for (int i = 0; i < p.length(); i++) {
            char a = p.charAt(i);
            if ( a != '\n') {
                text += a;
            }else{
                linea.add(new lineaEntrada(text,fila));
                text = "";
                fila++;
            }
        }
    }

    public void evaluar() {
        actualizarLinea();
        Automata automata = new Automata();
        for (lineaEntrada entra : linea) {
            System.out.println(entra.getTexto()+" "+entra.getNoLinea());
            expreciones = automata.evaluando(entra);
            System.out.println(expreciones.toString());
            ManejadorDeTablaError.llenarTabla(expreciones, visual.getTablaError());
        }
    }

    public void buscar() {
        String contenido = visual.getTextoEntrada().getText();
        String txtBuscar = visual.getTextoBuscar().getText();
        if (contenido != null) {

            hilit.removeAllHighlights();
            AutomataBusqueda automata = new AutomataBusqueda(contenido, txtBuscar);
            ArrayList<Integer> listado = automata.listadoPalabras();
            for (int numero : listado) {
                int index = (numero+1) - txtBuscar.length();
                int end = numero+1;
                System.out.println("numero es: "+listado+"inicio: "+index+"final: "+end);
                try {
                    hilit.addHighlight(index, end, painter);
                    if (txtBuscar.length() <= contenido.length()) {
                        visual.getTextoEntrada().setCaretPosition(end);
                    }

                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
