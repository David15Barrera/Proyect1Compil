/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package DatosClass;
/**
 *
 * @author david
 */
import java.util.ArrayList;

public class Clase {

    private String id;
    private ArrayList<Metodo> lista_metodos = new ArrayList<>();
    private int cantidadMetodos = 0;

    public Clase() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Metodo> getLista_metodos() {
        return lista_metodos;
    }

    public void setLista_metodos(ArrayList<Metodo> lista_metodos) {
        this.lista_metodos = lista_metodos;
    }

    public void agregarMetodo(Metodo nuevo_metodo) {
        lista_metodos.add(nuevo_metodo);
        cantidadMetodos++;
    }

    public int getCantidadMetodos() {
        return cantidadMetodos;
    }

    public void setCantidadMetodos(int cantidadMetodos) {
        this.cantidadMetodos = cantidadMetodos;
    }

}
