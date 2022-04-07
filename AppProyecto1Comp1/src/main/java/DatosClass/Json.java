/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package DatosClass;
/**
 *
 * @author david
 */
import DatosClass.Clase;
import DatosClass.Metodo;
import DatosClass.Variable;
import java.util.ArrayList;

public class Json {

    private String score;
    private ArrayList<Clase> clases = new ArrayList<>();
    private ArrayList<Metodo> metodos = new ArrayList<>();
    private ArrayList<Variable> variables = new ArrayList<>();
    private ArrayList<String> comentarios = new ArrayList<>();
    private Variable var = new Variable();
    /**
     * Constructor
     */
    public Json() {

    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public ArrayList<Clase> getClases() {
        return clases;
    }

    public void setClases(ArrayList<Clase> clases) {
        this.clases = clases;
    }

    public ArrayList<Metodo> getMetodos() {
        return metodos;
    }

    public void setMetodos(ArrayList<Metodo> metodos) {
        this.metodos = metodos;
    }

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<Variable> variables) {
        this.variables = variables;
    }

    public ArrayList<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<String> comentarios) {
        this.comentarios = comentarios;
    }
    /**
     * Agrega las clases del Json
     */
    public void agregarClase(String nombre) {
        Clase clase = new Clase();
        clase.setId(nombre);
        clases.add(clase);
    }
    /**
     * Agrega una funcion
     */
    public void agregarFuncion(String funcion) {
        var.agregarPadre(funcion);
    }
    /**
     * Agrega a la lista una variable 
     */
    public void agregarVariable(String nombre, String tipo) {
        var.setId(nombre);
        var.setTipo(tipo);
        variables.add(var);
        Variable nueva = new Variable();
        var = nueva;
    }
    /**
     * Agrega los metodos al archivo JSon
     */
    public void agregarMetodo(String nombre, String tipo, int param) {
        Metodo metodo = new Metodo();
        metodo.setId(nombre);
        metodo.setTipo(tipo);
        metodo.setCantidad_parametros(param);
        metodos.add(metodo);
    }
    /**
     * Agrega un comentario a la lista de comentarios
     */
    public void agregarComentario(String comentario) {
        comentarios.add(comentario);
    }
    /**
     * Obtiene el nombre de la clase.
     */
    public String obtenerParametrosClases(String parametro, int i) {
        String valor = "";
        Clase clase = clases.get(i);
        if (parametro.equals("Nombre")) {
            valor = String.valueOf(clase.getId());
        }
        return valor;
    }
    /**
     * Obtiene las variables
     */
    public String obtenerParametrosVariables(String parametro, int i) {
        String valor = "";
        Variable variable = variables.get(i);

        if (parametro.equals("Nombre")) {
            valor = variable.getId();
        } else if (parametro.equals("Tipo")) {
            valor = variable.getTipo();
        } else if (parametro.equals("Funcion")) {
            valor = String.valueOf(variable.getPadres());
        }
        return valor;
    }
    /**
     * Obtiene los metodos
     */
    public String obtenerParametrosMetodos(String parametro, int i) {
        String valor = "";
        Metodo metodo = metodos.get(i);

        if (parametro.equals("Nombre")) {
            valor = metodo.getId();
        } else if (parametro.equals("Tipo")) {
            valor = metodo.getTipo();
        } else if (parametro.equals("Parametros")) {
            valor = String.valueOf(metodo.getCantidad_parametros());
        }
        return valor;
    }
    /**
     * Obtiene al comentario
     */
    public String obtenerParametrosComentarios(String parametro, int i) {
        String valor = "";
        if (parametro.equals("Texto")) {
            valor = comentarios.get(i);
        }
        return valor;
    }

}
