/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reporte;
/**
 *
 * @author david
 */

import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import DatosClass.Json;
import Analizador.LexicoArch;
import Analizador.Analizador;
import Analizador.sintac.parser;
import Analizador.sintac.LexerReporte;
import Analizador.Analizador;

public class Reportes {


    private TableSym tabla = new TableSym();
    private ArrayList<String> ids = new ArrayList<>();
    private ArrayList<Integer> fila = new ArrayList<>();
    private ArrayList<Integer> col = new ArrayList<>();
    private ArrayList<String> errores = new ArrayList<>();
    private ArrayList<String> lineasHTML = new ArrayList<>();
    private ArrayList<String> etiquetasFor = new ArrayList<>();
    private Json jison;
    private String etiquetaValor = "";
    private int inicioFor = 0;
    private int finFor = 0;
    private boolean forActivo = false;
    private Simbolo simFor = null;

    public String getEtiquetaValor() {
        return etiquetaValor;
    }

    public void setEtiquetaValor(String etiquetaValor) {
        this.etiquetaValor = etiquetaValor;
    }

    public void setErrores(ArrayList<String> errores) {
        this.errores = errores;
    }
    /**
     * Constructor de la clase Datos Reporte
     */
    public Reportes(Json json) {
        this.jison = json;
    }
    /**
     * Agrega un id a la lista de ids.
     */
    public void agregarID(String id, int fil, int columna) {
        ids.add(id);
        fila.add(fil);
        col.add(columna);
    }
    /**
     * Agrega el tipo de simbolo a diferentes ids que se encuentren en la lista de id.
     */
    public void agregarSimbolosID(String tipo) {
        for (int i = 0; i < ids.size(); i++) {
            Simbolo sim = new Simbolo(ids.get(i), tipo, fila.get(i), col.get(i));
            if (tabla.comprobarSimbolo(sim) == false) {
                tabla.agregarSimbolo(sim);
            } else {
                errores.add("Error Semantico linea: " + fila.get(i) + "       La variable ya esta declarada");
            }
        }
        ids.clear();
        fila.clear();
        col.clear();
    }
    /**
     * Agrega un simbolo a la tabla de simbolo.
     * @param id El identificador del simbolo
     * @param tipo El tipo de simbolo
     * @param valor El valor del simbolo
     * @param linea La linea en donde se encuentra
     * @param columna La columna en donde se encuentra.
     */
    public void agregarSimboloDeclaracion(String id, String tipo, String valor, int linea, int columna) {
        Simbolo sim = new Simbolo(id, tipo, valor, linea, columna);
        if (tabla.comprobarSimbolo(sim) == false) {
            tabla.agregarSimbolo(sim);
        } else {
            errores.add("Error Semantico linea: " + linea + "       La variable ya esta declarada");
        }
    }
    /**
     * Obtiene un valor de la variable global Json.
     * @param lista La lista de la que obtendremos el valor
     * @param i El lugar en donde se encuentra el valor en la lista
     * @param parametro El parametro que necesitamos obtener
     * @param linea La linea en donde se encuentra declarada la accion
     * @return El valor que necesitamos
     */
    public Object obtenerValorJISON(String lista, int i, String parametro, int linea) {
        Object valor = null;
        try {            
            if (parametro == null) {
                errores.add("Error Semantico linea: " + linea + "Objeto no permitidos");
            } else {
                if (lista.equals("Score")) {
                    valor = jison.getScore();
                } else if (lista.equals("Clases")) {
                    valor = jison.obtenerParametrosClases(parametro, i);
                } else if (lista.equals("Variables")) {
                    valor = jison.obtenerParametrosVariables(parametro, i);
                } else if (lista.equals("Metodos")) {
                    valor = jison.obtenerParametrosMetodos(parametro, i);
                } else if (lista.equals("Comentarios")) {
                    valor = jison.obtenerParametrosComentarios(parametro, i);
                }
            }

        } catch (Exception e) {
            errores.add("Error Semantico linea: " + linea + "       La variable solicitada no existe");
        }
        return valor;
    }
    /**
     * Obtiene el valor un id de la tabla de simbolos
     */
    public String obtenerID(String id, int linea) {
        String valor = null;
        boolean obtencion = false;
        for (Simbolo simbolo : tabla.getTabla()) {
            if (simbolo.getId().equals(id)) {
                valor = simbolo.getValor();
                obtencion = true;
            }
        }
        if (obtencion == false) {
            errores.add("Error Semantico linea: " + linea + "       La variable no fue definida");
        }
        return valor;
    }
    /**
     * Asigna un valor a un identificador en la tabla de simbolos
     */
    public void asignarID(String id, String valor, int linea) {
        boolean obtencion = false;
        for (Simbolo simbolo : tabla.getTabla()) {
            if (simbolo.getId().equals(id)) {
                simbolo.setValor(valor);
                obtencion = true;
            }
        }
        if (obtencion == false) {
            errores.add("Error Semantico linea: " + linea + "       La variable no fue definida");
        }
    }   
    /**
     * Convierte varias cadenas en una sola
     */
    public String convertirCadena(String cadena, String resto) {
        String cad = cadena.substring(1, cadena.length() - 1);
        if (resto != null) {
            cad = cad + resto;
        }
        return cad;
    }
    /**
     * Inicia el estado For en donde se realizan acciones para obtener datos de un for
     */
    public void iniciarFor(int inicioFor, int finFor) {
        this.inicioFor = inicioFor;
        this.finFor = finFor;
        forActivo = true;

    }
    /**
     * Realiza los distintos pasos para iniciar la iteracion.
     */
    public void recorrerFor() {
        if (forActivo == true || errores.isEmpty() == false) {
            forActivo = false;
            String texto = "INICIO\n";
            for (int i = 0; i < etiquetasFor.size(); i++) {
                texto = texto + etiquetasFor.get(i);
                texto = texto + "\n";
            }
            String completo = "";
            for (int i = inicioFor; i < finFor; i++) {
                completo = completo + texto;
            }
            try {
                if (completo.equals("") == false) {
                    StringReader str = new StringReader(completo);
                    LexicoArch lexer = new LexicoArch(str);
                    Analizador ciclo = new Analizador(lexer);
                    ciclo.setDtsRep(this);
                    ciclo.setErrores(errores);
                    ciclo.parse();
                }
            } catch (Exception e) {
                errores.add("Error ciclo");
            }
            etiquetasFor.clear();
            simFor = null;
            inicioFor = 0;
            finFor = 0;
        } else {
            errores.add("No puede haber metodo dentro de otro");
        }
    }
    /**
     * Obtiene el simbolo que se declaro en el for para iniciar las iteraciones
     * @param id El nombre del simbolo
     */
    public void obtenerSimboloFor(String id) {
        for (Simbolo simbolo : tabla.getTabla()) {
            if (simbolo.getId().equals(id)) {
                simFor = simbolo;
            }
        }
    }
    /**
     * Agrega una etiqueta a la lista de etiquetas segun el estado en el que se encuentre
     * @param etiqueta La cadena de la etiqueta
     */
    public void agregarEtiqueta(String etiqueta) {
        if (forActivo == true) {
            etiquetasFor.add(etiqueta);
        } else {
            lineasHTML.add(etiqueta);
        }
    }
    /**
     * Agrega una etiqueta H1 a la lista de etiquetas
     * @param valor El valor contenido dentro de la etiqueta H!
     */
    public void agregarH1(String valor) {
        if (forActivo == true) {
            etiquetasFor.add("<h1>" + etiquetaValor + "</h1>");
        } else {
            lineasHTML.add("<h1>" + valor + "</h1>");
        }
    }
    /**
     * Agrega una etiqueta H2 a la lista de etiquetas
     * @param valor El valor contenido dentro de la etiqueta H!
     */
    public void agregarH2(String valor) {
        if (forActivo == true) {
            etiquetasFor.add("<h2>" + etiquetaValor + "</h2>");
        } else {
            lineasHTML.add("<h2>" + valor + "</h2>");
        }
    }
    /**
     * Agrega una etiqueta TH a la lista de etiquetas
     * @param valor El valor contenido dentro de la etiqueta H!
     */
    public void agregarFilaTH(String valor) {
        if (forActivo == true) {
            etiquetasFor.add("<th scope=\"col\">" + etiquetaValor + "</th>");
        } else {
            lineasHTML.add("<th scope=\"col\">" + valor + "</th>");
        }
    }
    /**
     * Agrega una etiqueta TD a la lista de etiquetas
     * @param valor El valor contenido dentro de la etiqueta H!
     */
    public void agregarFilaTD(String valor) {
        if (forActivo == true) {
            etiquetasFor.add("<td>" + etiquetaValor + "</td>");
        } else {
            lineasHTML.add("<td>" + valor + "</td>");
        }
    }
    /**
     * Llama al metodo para iterar un id
     */
    public void aumentarID() {
        simFor.sumarValor();
    }
    /**
     * Obtiene todas las lineas del HTMl y las agrega a un texto.
     * @return El texto con todas las lineas contenidas.
     */
    public String exportarHTML() {
        String cuerpo = "";
        for (String linea : lineasHTML) {
            cuerpo = cuerpo + linea + "\n";
        }
        return cuerpo;
    }

}
