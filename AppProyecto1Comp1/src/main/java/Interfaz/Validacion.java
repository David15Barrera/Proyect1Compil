/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package Interfaz;
/**
 *
 * @author david
 */

import DatosClass.Guardar;
import DatosClass.LineCLass;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import DatosClass.RepJson;
import DatosClass.Json;
import reporte.Reportes;
import Analizador.sintac.LexerReporte;
import Analizador.sintac.parser;

public class Validacion extends javax.swing.JFrame {

    private Guardar carga = new Guardar();
    private ArrayList<String> errores = new ArrayList<String>();
    private Json jison;
    private String pathDEF;
    private String pathJSON;
    private String pathReporte;
    /**
     * Constructor
     */
    public Validacion(String nombre, String pathDEF, String pathJSON, String pathReporte) {
        initComponents();
        setTitle(nombre);
        setLocationRelativeTo(null);
        setResizable(false);
        this.pathDEF = pathDEF;
        this.pathJSON = pathJSON;
        this.pathReporte = pathReporte;
        cargarArchivos();
                    botonReporte.setEnabled(false);
                    botonCompilarJISON.setEnabled(false);
        compilarJison();

        area1.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                int pos = e.getDot();
                try {
                    int row = area1.getLineOfOffset(pos) + 1;
                    int col = pos - area1.getLineStartOffset(row - 1) + 1;
                    labelPosDef.setText("Fila: " + row + " Columna: " + col);
                    botonReporte.setEnabled(true);
                    botonCompilarJISON.setEnabled(false);
                } catch (BadLocationException exc) {
                    System.out.println(exc);
                }
            }
        });

        area2.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                int pos = e.getDot();
                try {
                    int row = area2.getLineOfOffset(pos) + 1;
                    int col = pos - area2.getLineStartOffset(row - 1) + 1;
                    labelPosDef.setText("Fila: " + row + " Columna: " + col);
                    botonReporte.setEnabled(false);
                    botonCompilarJISON.setEnabled(true);
                } catch (BadLocationException exc) {
                    System.out.println(exc);
                }
            }
        });
    }
    /**
     * metodos
     */
    public void cargarArchivos() {
        carga.cargarArchivo(pathDEF, area1);
        carga.cargarArchivo(pathJSON, area2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pestanas = new javax.swing.JTabbedPane();
        panelDEF = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area1 = new javax.swing.JTextArea();
        panelJISON = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        area2 = new javax.swing.JTextArea();
        labelPosDef = new javax.swing.JLabel();
        botonReporte = new javax.swing.JButton();
        botonCompilarJISON = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaErrores = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Archivos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        area1.setColumns(20);
        area1.setRows(5);
        jScrollPane1.setViewportView(area1);

        javax.swing.GroupLayout panelDEFLayout = new javax.swing.GroupLayout(panelDEF);
        panelDEF.setLayout(panelDEFLayout);
        panelDEFLayout.setHorizontalGroup(
            panelDEFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDEFLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelDEFLayout.setVerticalGroup(
            panelDEFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDEFLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pestanas.addTab("Def", panelDEF);

        area2.setColumns(20);
        area2.setRows(5);
        jScrollPane2.setViewportView(area2);

        javax.swing.GroupLayout panelJISONLayout = new javax.swing.GroupLayout(panelJISON);
        panelJISON.setLayout(panelJISONLayout);
        panelJISONLayout.setHorizontalGroup(
            panelJISONLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
        );
        panelJISONLayout.setVerticalGroup(
            panelJISONLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJISONLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        pestanas.addTab("Json", panelJISON);

        labelPosDef.setForeground(new java.awt.Color(51, 153, 255));
        labelPosDef.setText("Fila: Columna: ");

        botonReporte.setText("Reporte");
        botonReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReporteActionPerformed(evt);
            }
        });

        botonCompilarJISON.setText("Ejecutar");
        botonCompilarJISON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCompilarJISONActionPerformed(evt);
            }
        });

        areaErrores.setColumns(20);
        areaErrores.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        areaErrores.setRows(5);
        areaErrores.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        areaErrores.setEnabled(false);
        jScrollPane3.setViewportView(areaErrores);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setText("Consola");

        jButton1.setText("Save Def");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SaveJson");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelPosDef)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonCompilarJISON, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pestanas, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(31, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(botonReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonCompilarJISON))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pestanas, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelPosDef)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Se ejecuta el compilador del jison
     */
    private void botonCompilarJISONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCompilarJISONActionPerformed
        compilarJison();
    }//GEN-LAST:event_botonCompilarJISONActionPerformed

   /**
     * inicia el analisis sintactico y lexico
     */
    private void botonReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReporteActionPerformed
        Reportes dtsRep = new Reportes(jison);
        areaErrores.setText("");        
        errores.clear();
        try {
            dtsRep.setErrores(errores);
            StringReader str = new StringReader(area1.getText());
            LexerReporte lexer = new LexerReporte(str);
            lexer.setErrores(errores);
            parser par = new parser(lexer);
            par.setErrores(errores);
            par.setDtsRep(dtsRep);
            par.parse();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Corregir errores de compilacion");
        }

        if (errores.isEmpty() == true) {
            String cuerpo = dtsRep.exportarHTML();
            carga.exportarHTML(pathReporte, cuerpo);
            visualizarReporte();
        } else if (errores.isEmpty() == false) {
            areaErrores.append("Achivo de reportes con errores");
            areaErrores.append("\n");
            agregarErrores();
        }
    }//GEN-LAST:event_botonReporteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         carga.guardar(pathDEF, area1.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
               carga.guardar(pathJSON, area2.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

   /**
     * Llama al metodo para analizar el archivo Json.
     */
    public void compilarJison() {
        String texto = area2.getText();
        RepJson datos = new RepJson();
        areaErrores.setText("");   
        errores.clear();
        jison = datos.analizarJSON(texto, errores);

        if (errores.isEmpty() == false) {
            areaErrores.append("Json con errores");
            areaErrores.append("\n");
            agregarErrores();
        }

    }
    /**
     * Agrega los errores de cualquier archivo al area de texto de errores.
     */
    public void agregarErrores() {
        areaErrores.setText("");
        for (String error : errores) {
            areaErrores.append(error);
            areaErrores.append("\n");
        }
    }
    /**
     * Abre una ventana donde se pueda visualizar un reporte.
     */
    public void visualizarReporte() {
        try {            
            File file = new File(pathReporte);         
            Reporte reporte = new Reporte();
            reporte.verReporte(file);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el reporte");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area1;
    private javax.swing.JTextArea area2;
    private javax.swing.JTextArea areaErrores;
    private javax.swing.JButton botonCompilarJISON;
    private javax.swing.JButton botonReporte;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelPosDef;
    private javax.swing.JPanel panelDEF;
    private javax.swing.JPanel panelJISON;
    private javax.swing.JTabbedPane pestanas;
    // End of variables declaration//GEN-END:variables
}
