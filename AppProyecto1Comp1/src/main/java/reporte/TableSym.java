/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reporte;
/**
 *
 * @author david
 */
import java.util.ArrayList;


public class TableSym {
    
    private ArrayList<Simbolo> tabla = new ArrayList<>();

    public TableSym() {
    }

    public ArrayList<Simbolo> getTabla() {
        return tabla;
    }

    public void setTabla(ArrayList<Simbolo> tabla) {
        this.tabla = tabla;
    }
      
    public void agregarSimbolo(Simbolo simbolo){
        tabla.add(simbolo);
    }
    /**
     * Comprueba si un simbolo ya se encuentra repetido en la tabla de simbolos
     * @param s El simbolo que se comprobara
     * @return True si el simbolo es repetido y false si no esta repetido.
     */
    public boolean comprobarSimbolo(Simbolo s){
        boolean comprobacion = false;
        for (Simbolo simbolo : tabla) {
            if (s.getId().equals(simbolo.getId()) && s.getTipo().equals(simbolo.getTipo())){
                comprobacion = true;
                break;
            }
        }
        return comprobacion;
    }
    /**
     * Muestra todos los simbolos de la tabla de simbolos
     */
    public void pintarSimbolos(){
        for (Simbolo simbolo: tabla){
            System.out.println("Sim:");
            System.out.println(simbolo.getId());
            System.out.println(simbolo.getTipo());
            System.out.println(simbolo.getValor());
            System.out.println(simbolo.getLinea());
            System.out.println(simbolo.getColumna());
            System.out.println("");
        }
    }
    
}
