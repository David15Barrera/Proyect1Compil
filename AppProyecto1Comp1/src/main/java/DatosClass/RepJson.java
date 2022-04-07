/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package DatosClass;
/**
 *
 * @author david
 */
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import AnJson.LexerJISON;
import AnJson.parser;


public class RepJson {
    /**
     * Constructor
     */
    public RepJson() {
    }
    /**
     * Archivo Json del proyecto.
     */
    public Json analizarJSON(String texto, ArrayList<String> errores){
        Json json = new Json();
        try {
            StringReader str = new StringReader(texto);
            LexerJISON lexer = new LexerJISON(str);
            lexer.setErrores(errores);
            parser par = new parser(lexer);
            par.setErrores(errores);
            par.setJson(json);
            par.parse();
            JOptionPane.showMessageDialog(null, "COmpilacion COrrecta");
        } catch (Exception e) {
            json = null;
        }
        return json;
    }
    
    
}
