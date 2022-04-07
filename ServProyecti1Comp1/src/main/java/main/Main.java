/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;
/**
 * @author david
 */

import clases.Analisis;
import clases.Proceso;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class Main {
    /**
     * Recibe e inicia el socket :0
     */
    public static void main(String[] args) throws Exception {
        Analisis analisis = new Analisis();
        

        Socket socket = null;
        DataInputStream in;
        DataOutputStream out;
        String mensaje = "";
        int puerto = 7000;
        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Servidor activo");
            JOptionPane.showMessageDialog(null, "Servidor activo");
            while (true){
            socket = servidor.accept();            
            System.out.println("Archivo enviado");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            mensaje = in.readUTF();
            String[] paths = mensaje.split("\n");
            Proceso proceso = new Proceso(paths);
            proceso.start();
            out.writeUTF("Archivos Recividos");            
            socket.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de datos");
        }


    }

}
