/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;
/**
 *
 * @author david
 */

import DatosClass.ConnectSocket;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import DatosClass.Guardar;

public class VentanaComparar extends javax.swing.JFrame {
    private Guardar carga = new Guardar();
    
    public VentanaComparar() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        botonComparar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonComparar = new javax.swing.JButton();
        boton2 = new javax.swing.JButton();
        text2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        boton1 = new javax.swing.JButton();
        text1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Analizar");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        botonComparar.setText("Analizar");
        botonComparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCompararActionPerformed(evt);
            }
        });

        boton2.setText("Archivo 2");
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });

        text2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        text2.setForeground(new java.awt.Color(102, 204, 255));
        text2.setText("Ruta");
        text2.setBorder(null);
        text2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        text2.setEnabled(false);
        text2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text2ActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Proyecto 2: ");

        boton1.setText("Archivo 1");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });

        text1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        text1.setForeground(new java.awt.Color(51, 102, 255));
        text1.setText("Ruta");
        text1.setBorder(null);
        text1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        text1.setEnabled(false);
        text1.setSelectedTextColor(new java.awt.Color(51, 102, 255));

        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setText("Proyecto 1: ");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 153, 255));
        jLabel3.setText("Bienvenido");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Ingrese los documentos a comparar");

        jButton1.setText("Abrir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(102, 204, 255));
        jLabel5.setText("Archivo Copy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(135, 135, 135))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonComparar, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(325, 325, 325))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(botonComparar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Agrega la direccion de la carpeta del proyecto 1.
     */
    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        try {
            File fichero;
            JFileChooser seleccionar = new JFileChooser();
            seleccionar.setAcceptAllFileFilterUsed(false);
            seleccionar.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            seleccionar.showOpenDialog(null);
            fichero = seleccionar.getSelectedFile();
            text1.setText(fichero.getAbsolutePath());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se escogio ningun archivo");
            text1.setText(null);
        }
    }//GEN-LAST:event_boton1ActionPerformed
    /**
     * Agrega la direccion de la carpeta del proyecto 2.
     */
    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        try {
            File fichero;
            JFileChooser seleccionar = new JFileChooser();
            seleccionar.setAcceptAllFileFilterUsed(false);
            seleccionar.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            seleccionar.showOpenDialog(null);
            fichero = seleccionar.getSelectedFile();
            text2.setText(fichero.getAbsolutePath());
            botonComparar.setEnabled(true);

        } catch (Exception e) {
            text2.setText(null);
        }
    }//GEN-LAST:event_boton2ActionPerformed
    /**
     * Envia los datos al socket para que se ejecute el analisis de los
     * proyectos.
     */
    private void botonCompararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCompararActionPerformed
        if (text1.getText().equals("") || text2.getText().equals("")) {
           JOptionPane.showMessageDialog(null, "Entradas vacias");
        } else {
            ConnectSocket dtsSocket = new ConnectSocket();
            dtsSocket.enviarParametros(text1.getText(), text2.getText());
        }
    }//GEN-LAST:event_botonCompararActionPerformed

    private void text2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                try {
            String[] paths = carga.obtenerCOPY();
            Validacion app = new Validacion(paths[3],paths[0], paths[1], paths[2]);
            app.setVisible(true);
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error de carga");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton1;
    private javax.swing.JButton boton2;
    private javax.swing.JButton botonComparar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField text1;
    private javax.swing.JTextField text2;
    // End of variables declaration//GEN-END:variables
}
