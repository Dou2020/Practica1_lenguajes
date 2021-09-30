/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_lenguajes.domain;

/**
 *
 * @author douglas2021
 */
public class lexema {
    private String texto;
    private int columna;
    private int fila;
    private String tokens;

    public lexema(String texto) {
        this.texto = texto;
    }

    public lexema(String texto, int columna, int fila, String tokens) {
        this.texto = texto;
        this.columna = columna;
        this.fila = fila;
        this.tokens = tokens;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public String getTokens() {
        return tokens;
    }

    public void setTokens(String tokens) {
        this.tokens = tokens;
    }
    
}
