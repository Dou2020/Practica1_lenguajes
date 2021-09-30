/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1_lenguajes.domain;

/**
 *
 * @author douglas2021
 */
public class lineaEntrada {
    private String texto;
    private int noLinea;

    public lineaEntrada(String texto, int noLinea) {
        this.texto = texto;
        this.noLinea = noLinea;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getNoLinea() {
        return noLinea;
    }

    public void setNoLinea(int noLinea) {
        this.noLinea = noLinea;
    }
    
    
}
