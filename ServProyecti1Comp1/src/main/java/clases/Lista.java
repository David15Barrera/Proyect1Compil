package clases;
/**
 * @author david
 */

import clases.Clase;
import clases.Metodo;
import clases.Variable;
import clases.Comentario;
import java.util.ArrayList;

public class Lista {

    private ArrayList<Comentario> listaComentarios = new ArrayList<>();
    private ArrayList<Clase> listaClases = new ArrayList<>();
    private ArrayList<Metodo> listaMetodos = new ArrayList<>();
    private ArrayList<Variable> listaVariables = new ArrayList<>();

    private Variable variable = new Variable();
    private Variable parametro = new Variable();
    private Metodo metodo = new Metodo();
    private Clase clase = new Clase();
    /**
     * Constructor
     */
    public Lista() {
    }

    public ArrayList<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(ArrayList<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public ArrayList<Clase> getListaClase() {
        return listaClases;
    }

    public void setListaClase(ArrayList<Clase> listaClase) {
        this.listaClases = listaClase;
    }

    public ArrayList<Metodo> getListaMetodos() {
        return listaMetodos;
    }

    public void setListaMetodos(ArrayList<Metodo> listaMetodos) {
        this.listaMetodos = listaMetodos;
    }

    public ArrayList<Variable> getListaVariables() {
        return listaVariables;
    }

    public void setListaVariables(ArrayList<Variable> listaVariables) {
        this.listaVariables = listaVariables;
    }
    /**
     * Añade un comentario a la lista de comentarios
     */
    public void añadirComentario(String comentario) {
        Comentario nuevo = new Comentario();
        nuevo.setTexto(comentario);
        listaComentarios.add(nuevo);
    }
    /**
     * Añade una variable nueva obtenida
     */
    public void añadirDatosVariable(String id, String tipo) {
        variable.setId(id);
        variable.setTipo(tipo);
        listaVariables.add(variable);
        Variable nueva = new Variable();
        variable = nueva;
    }
    /**
     * Añade un metodo a la lista de metodos del proyecto
     */
    public void añadirMetodo(String id, String tipo, int conteo) {
        metodo.setId(id);
        metodo.setTipo(tipo);
        int cantidadVariables = listaVariables.size() - 1;
        int resta = cantidadVariables - conteo;
        for (int i = cantidadVariables; i > resta; i--) {

            Variable var = listaVariables.get(i);
            var.agregarPadre(id);
        }
        listaMetodos.add(metodo);
        Metodo nuevo = new Metodo();
        metodo = nuevo;
    }
    /**
     * Añade un parametro de un metodo a la lista de parametros
     */
    public void añadirParametro(String id, String tipo) {
        parametro.setId(id);
        parametro.setTipo(tipo);
        metodo.añadirParametro(parametro);
        Variable nuevo = new Variable();
        parametro = nuevo;
    }
    /**
     * Reinicia la lista de parametros para dejarla limpia
     */
    public void reiniciarParametros() {
        metodo.reiniciarListaParametros();
    }
    /**
     * Agrega una clase a la lista de clases del proyecto
     */
    public void agregarClase(String id) {
        clase.setId(id);
        int numero = contarMetodos();
        for (int i = numero; i < listaMetodos.size(); i++) {
            clase.agregarMetodo(listaMetodos.get(i));
        }
        listaClases.add(clase);
        agregarClasesPadre(id);
        Clase nueva = new Clase();
        clase = nueva;
    }
    /**
     * Cuenta los metodos que tiene cada clase
     */
    public int contarMetodos() {
        int numero = 0;
        for (Clase cl : listaClases) {
            numero = numero + cl.getCantidadMetodos();
        }
        return numero;
    }
    /**
     * Agrega la clase como parametro "Padre" a las variables que no tengan uno
     */
    public void agregarClasesPadre(String padre) {
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable aux = listaVariables.get(i);
            if (aux.getPadres().isEmpty()) {
                aux.agregarPadre(padre);
            }
        }
    }
    
    /**
     * Elimina las clases repetidas que se encuentren en la lista final
     */
    public void eliminarClasesRepetidas() {
        for (int i = 0; i < listaClases.size(); i++) {
            Clase aux = listaClases.get(i);
            for (int j = i + 1; j < listaClases.size(); j++) {
                Clase repetida = listaClases.get(j);
                if (aux.getId().equals(repetida.getId())) {
                    aux.aumentarRepeticiones(1);
                    listaClases.remove(j);
                    j--;
                }
            }
        }
    }
    
    /**
     * Elimina los proyectos repetidos entre los proyectos 
     */
    public void eliminarMetodosRepetidos() {
        for (int i = 0; i < listaMetodos.size(); i++) {
            Metodo aux = listaMetodos.get(i);
            for (int j = i + 1; j < listaMetodos.size(); j++) {
                Metodo repetida = listaMetodos.get(j);
                if (aux.getId().equals(repetida.getId()) && aux.getTipo().equals(repetida.getTipo()) && aux.getCantidad_parametros() == repetida.getCantidad_parametros()) {
                    aux.aumentarRepeticiones(1);
                    listaMetodos.remove(j);
                    j--;
                }
            }
        }
    }
    
    /**
     * Elimina las variables repetidas para agregar los valores a los padres
     */
    public void eliminarVariablesRepetidas(){
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable aux = listaVariables.get(i);
            for (int j = i+1; j < listaVariables.size(); j++) {
                Variable repetida = listaVariables.get(j);
                if(aux.getId().equals(repetida.getId()) && aux.getTipo().equals(repetida.getTipo())){
                    aux.aumentarRepeticiones(1);
                    ArrayList<String> padres = repetida.getPadres();
                    for (int k = 0; k < padres.size(); k++) {
                        aux.agregarPadre(padres.get(k));                                         
                    }
                    listaVariables.remove(j);
                    j--;
                }
            }
        }
    }
    
    /**
     * Elimina los comentarios repetidos
     */
    public void eliminarComentariosRepetidos(){
        for (int i = 0; i < listaComentarios.size(); i++) {
            Comentario aux = listaComentarios.get(i);
            for (int j = i+1; j < listaComentarios.size(); j++) {
                Comentario repetido = listaComentarios.get(j);
                if(aux.getTexto().equals(repetido.getTexto())){
                    aux.aumentarRepeticiones(1);
                    listaComentarios.remove(j);
                    j--;
                }
            }
        }
    }

}
