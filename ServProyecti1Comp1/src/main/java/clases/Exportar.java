/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clases;
/**
 * @author david
 */
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Exportar {

    /**
     * Constructor
     */
    public Exportar() {
          
    }
    /**
     * Exporta la carpeta del proyecto con el archivo .copy, reportes.def, y el archivo json.
     */
    public void exportarJISON(String json, String carpeta) {
        try {
            File fichero;
            System.out.println("Start creacion de archivos");
            JFileChooser seleccionar = new JFileChooser();
            seleccionar.setAcceptAllFileFilterUsed(false);
            seleccionar.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            seleccionar.showOpenDialog(null);
            fichero = seleccionar.getSelectedFile();

            File directorio = new File(fichero.getAbsolutePath() + "/" + carpeta);
            if (directorio.exists()) {
                           JOptionPane.showMessageDialog(null, "Directorio ya existe");
//                Alerta alerta = new Alerta("El directorio ya existe");
            } else {
                directorio.mkdirs();
            }
            String pathDEF = directorio.getAbsolutePath() + "/reportes.def";
            String pathJISON = directorio.getAbsolutePath() + "/" + carpeta + ".json";
            String pathCOPY = directorio.getAbsolutePath() + "/" + carpeta + ".copy";
            String pathReporte = directorio.getAbsolutePath() + "/reporte.html";
            File archivoDEF = new File(pathDEF);
            File archivoJISON = new File(pathJISON);
            File archivoCOPY = new File(pathCOPY);
            String textoCOPY = pathDEF + "\n" + pathJISON + "\n" + pathReporte;
            
            archivoDEF.createNewFile();
            archivoJISON.createNewFile();
            archivoCOPY.createNewFile();
            FileWriter escribirJISON = new FileWriter(archivoJISON, false);
            FileWriter escribirCOPY = new FileWriter(archivoCOPY, false);
            escribirJISON.write(json);
            escribirJISON.close();
            escribirCOPY.write(textoCOPY);
            escribirCOPY.close();
            JOptionPane.showMessageDialog(null, "Exportacion Exitosa");
//            Alerta alerta = new Alerta("Archivos Exportados");
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al cargar los archivos");
        }
    }

}
