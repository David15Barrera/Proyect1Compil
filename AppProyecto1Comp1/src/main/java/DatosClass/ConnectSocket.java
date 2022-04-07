/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DatosClass;
/**
 *
 * @author david
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.swing.JOptionPane;


public class ConnectSocket {
    /**
     * Constructor
     */
    public ConnectSocket() {
    }
    /**
     * Inicia la conexion con el servidor
     */
    public void enviarParametros(String path1, String path2){       
        final String HOST = "localhost";
        final int puerto = 7000;
        DataInputStream in;
        DataOutputStream out;
        try {
            Socket socket = new Socket(HOST, puerto);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            
            out.writeUTF(path1 + "\n" + path2);
            
            String mensaje = in.readUTF();            
            System.out.println(mensaje);
            socket.close();           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar con el servidor");
        }
        
        
        
    }
    
}
