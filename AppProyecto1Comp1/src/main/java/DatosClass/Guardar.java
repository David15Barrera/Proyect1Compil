/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DatosClass;
/**
 *
 * @author david
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Guardar {
    /**
     * Constructor
     */
    public Guardar() {
    }
    /**
     * Obtiene la direccion del archivo
     */
    public void cargarArchivo(String path, JTextArea areaTexto) {
        try {
            File fichero = new File(path);
            FileReader Lector = new FileReader(fichero);
            BufferedReader bufer = new BufferedReader(Lector);
            String linea = "";

            while ((linea = bufer.readLine()) != null) {
                areaTexto.append(linea);
                areaTexto.append("\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error de subida");
        }
    }
    /**
     * Obtiene todas las direcciones de un archivo .copy 
     * @return El array donde estan guardadas las direcciones del proyecto.
     */
    public String[] obtenerCOPY() {
        String[] paths = new String[4];
        File fichero;
        JFileChooser seleccionar = new JFileChooser();

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo copy", "copy");
        seleccionar.setAcceptAllFileFilterUsed(false);
        seleccionar.addChoosableFileFilter(filtro);
        seleccionar.showOpenDialog(null);
        fichero = seleccionar.getSelectedFile();
        try {
            FileReader Lector = new FileReader(fichero);
            BufferedReader bufer = new BufferedReader(Lector);
            String linea = "";
            int i = 0;
            while ((linea = bufer.readLine()) != null) {

                paths[i] = linea;
                i++;

            }
            paths[3] = fichero.getName();
            if (paths[0].endsWith(".def") == false) {
                JOptionPane.showMessageDialog(null, "Error al cargar DEF");
                paths[0] = null;
            }
            if (paths[1].endsWith(".json") == false) {
                JOptionPane.showMessageDialog(null, "Error al cargar JSON");
                paths[1] = null;
            }
            if (paths[2].endsWith(".html") == false) {
                JOptionPane.showMessageDialog(null, "Error al cargar HTML");
                paths[2] = null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar archivo");
        }
        return paths;
    }
    /**
     * Guarda el texto en la direccion.
     */
    public void guardar(String path, String texto) {
        int decision = JOptionPane.showConfirmDialog(null, "¿Desea Guardar el archivo?");
        if (decision == JOptionPane.YES_OPTION) {
            try {
                File file = new File(path);
                FileWriter escribir;
                escribir = new FileWriter(file, false);
                escribir.write(texto);
                escribir.close();
                JOptionPane.showMessageDialog(null, "Guardado con exito");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
        }
    }
    /**
     * Exporta el HTML.
     */
    public void exportarHTML(String path, String cuerpo) {
        System.out.println(path);
        String textoHTML = "<!DOCTYPE html>\n"
                + "    <html lang=\"es\">\n"
                + "    <head>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n"
                + "        <title>Reporte</title>\n"
                + "    </head>\n"
                + "    <body>\n";
        textoHTML = textoHTML + cuerpo;
        textoHTML = textoHTML + "   </body>\n" + "</html>";
        try {
            File file = new File(path);
            if (file.exists()) {
                FileWriter escribir;
                escribir = new FileWriter(file, false);
                escribir.write(textoHTML);
                escribir.close();
                JOptionPane.showMessageDialog(null, "Visualiza el reporte");
            } else {
                file.createNewFile();
                FileWriter escribir;
                escribir = new FileWriter(file, false);
                escribir.write(textoHTML);
                escribir.close();
                JOptionPane.showMessageDialog(null, "Ya puedes visualizar el reporte");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }

}
