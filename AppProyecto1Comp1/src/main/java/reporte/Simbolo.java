/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reporte;
/**
 *
 * @author david
 */
public class Simbolo {

    private String id;
    private String tipo;
    private String valor;
    private int linea;
    private int columna;

    public Simbolo(String id, String tipo, String valor, int linea, int columna) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
    }

    public Simbolo(String id, String tipo, int linea, int columna) {
        this.id = id;
        this.tipo = tipo;
        this.linea = linea;
        this.columna = columna;
    }

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getValor() {
        return valor;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    /**
     * Suma una unidad al valor del simbolo.
     */
    public void sumarValor() {
        try {
            int cantidad = Integer.parseInt(valor);
            cantidad++;
            setValor(String.valueOf(cantidad));
        } catch (Exception e) {
            System.out.println("Error");
        }

    }

}
