/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author david
 */
public class Guardar {

    
     public void abrirProyecto(){
        File arch;
        JFileChooser archivo2 = new JFileChooser();
        archivo2.setAcceptAllFileFilterUsed(false);
        archivo2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        archivo2.showOpenDialog(null);
        arch = archivo2.getSelectedFile();
    }
         
}
