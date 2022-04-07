/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package clases;

import java.io.File;
/**
 * @author david
 */

public class Proceso extends Thread {

    private String[] paths;
    /**
     * Constructor
     */
    public Proceso(String[] paths) {
        this.paths = paths;
    }
    /**
     * Inicia el analisis de de los proyectos.
     */
    @Override
    public void run() {
        Analisis analisis = new Analisis();
        File proyecto1 = new File(paths[0]);
        File proyecto2 = new File(paths[1]);
        analisis.iniciarAnalisisProyecto1(proyecto1);
        analisis.iniciarAnalisisProyecto2(proyecto2);
        analisis.comparar();

    }

}
