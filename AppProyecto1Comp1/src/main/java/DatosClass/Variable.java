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

public class Variable {

    private String id;
    private String tipo;
    private ArrayList<String> padres = new ArrayList<>();

    public Variable() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<String> getPadres() {
        return padres;
    }

    public void setPadres(ArrayList<String> padres) {
        this.padres = padres;
    }

    public void agregarPadre(String padre) {
        boolean comprobacion = false;
        for (String p : padres) {
            if (p.equals(padre)) {
                comprobacion = true;
                break;
            }
        }
        if (comprobacion == false) {
            padres.add(padre);
        }
    }
}
