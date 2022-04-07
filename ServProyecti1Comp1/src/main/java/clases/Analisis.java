/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
/**
 * @author david
 */
import Analisis.LexerServidor;
import Analisis.parser;
import clases.Clase;
import clases.Comentario;
import clases.Metodo;
import clases.Variable;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import main.Principal;

public class Analisis {

    private ArrayList<Comentario> listaComentarios1 = new ArrayList<>();
    private ArrayList<Clase> listaClase1 = new ArrayList<>();
    private ArrayList<Metodo> listaMetodos1 = new ArrayList<>();
    private ArrayList<Variable> listaVariables1 = new ArrayList<>();

    private ArrayList<Comentario> listaComentarios2 = new ArrayList<>();
    private ArrayList<Clase> listaClase2 = new ArrayList<>();
    private ArrayList<Metodo> listaMetodos2 = new ArrayList<>();
    private ArrayList<Variable> listaVariables2 = new ArrayList<>();
    private ArrayList<String> errores = new ArrayList<>();
      
    public Analisis() {
    }
    /**
     * Inicia el analisis lexico del primer proyecto que obtengamos
     */
    public void iniciarAnalisisProyecto1(File fichero) {
        Lista lista1 = new Lista();
        try {

            for (File file : fichero.listFiles()) {
                if (file.getName().endsWith(".java")) {
                    FileReader Lector = new FileReader(file);
                    LexerServidor lexer = new LexerServidor(Lector);
                    lexer.setErrores(errores);
                    lexer.setNombre_clase(file.getName());
                    lexer.setLista(lista1);
                    parser par = new parser(lexer);
                    par.setErrores(errores);
                    par.setNombre_clase(file.getName());
                    par.setLista(lista1);
                    par.parse();
                } else {
                    System.out.println("Error en el archivo");
                }

            }
            lista1.eliminarClasesRepetidas();
            lista1.eliminarMetodosRepetidos();
            lista1.eliminarVariablesRepetidas();
            lista1.eliminarComentariosRepetidos();
            listaComentarios1 = lista1.getListaComentarios();
            listaClase1 = lista1.getListaClase();
            listaMetodos1 = lista1.getListaMetodos();
            listaVariables1 = lista1.getListaVariables();

           
        } catch (Exception e) {
     //       Alerta alerta = new Alerta("Error de Carga de archivo");
        }
    }
    /**
     * Inicia el analisis lexico del segundo proyecto que obtengamos
     */
    public void iniciarAnalisisProyecto2(File fichero) {
        Lista lista2 = new Lista();
        try {

            for (File file : fichero.listFiles()) {
                if (file.getName().endsWith(".java")) {
                    FileReader Lector = new FileReader(file);
                    LexerServidor lexer = new LexerServidor(Lector);
                    lexer.setErrores(errores);
                    lexer.setNombre_clase(file.getName());
                    lexer.setLista(lista2);
                    parser par = new parser(lexer);
                    par.setErrores(errores);
                    par.setNombre_clase(file.getName());
                    par.setLista(lista2);
                    par.parse();
                } else {
                    System.out.println("Error en el archivo");
                }

            }

            lista2.eliminarClasesRepetidas();
            lista2.eliminarMetodosRepetidos();
            lista2.eliminarVariablesRepetidas();
            lista2.eliminarComentariosRepetidos();
            listaComentarios2 = lista2.getListaComentarios();
            listaClase2 = lista2.getListaClase();
            listaMetodos2 = lista2.getListaMetodos();
            listaVariables2 = lista2.getListaVariables();

        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al agregar archivo");
       
        }
    }
    /**
     * Llama a los metodos para comparar de los analisis
     */
    public void comparar(){
        if (errores.isEmpty()){
        Comparacion comparacion = new Comparacion();
        comparacion.compararClases(listaClase1, listaClase2);
        comparacion.compararVariables(listaVariables1, listaVariables2);
        comparacion.compararMetodos(listaMetodos1, listaMetodos2);
        comparacion.compararComentarios(listaComentarios1, listaComentarios2);
        comparacion.exportar();
        }
        else {
            Principal vtnServer = new Principal();
            vtnServer.agregarErrores(errores);
            vtnServer.setVisible(true);
        }
    }
    
    
}
