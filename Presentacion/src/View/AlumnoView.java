/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author dh173
 */
import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import Controller.AlumnoController;
import Entities.Alumno;
import Model.AlumnoModel;
import Principal.Presentacion;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class AlumnoView extends javax.swing.JFrame implements java.util.Observer   {

    /**
     * Creates new form Alumno
     */
    public AlumnoView() {
        initComponents();
        matricula.setVisible(false);
        guardar.setVisible(false);
        msj.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        matricula = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        carrera = new javax.swing.JLabel();
        cedula = new javax.swing.JLabel();
        fechaNac = new javax.swing.JLabel();
        labelNomAlum = new javax.swing.JTextField();
        labelCarreraAlum = new javax.swing.JTextField();
        labelCedAlum = new javax.swing.JTextField();
        labelfechaNacAlum = new javax.swing.JTextField();
        correo = new javax.swing.JLabel();
        labelCorreoAlum = new javax.swing.JTextField();
        cerraS = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        msj = new javax.swing.JLabel();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PerfilAlumno");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        matricula.setBackground(new java.awt.Color(255, 255, 255));
        matricula.setForeground(new java.awt.Color(202, 55, 55));
        matricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/archivo.png"))); // NOI18N
        matricula.setText("Matricular");
        matricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                matriculaMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Perfil de Estudiante");

        nombre.setForeground(new java.awt.Color(0, 51, 51));
        nombre.setText("Nombre ");

        carrera.setForeground(new java.awt.Color(0, 51, 51));
        carrera.setText("Carrera");

        cedula.setForeground(new java.awt.Color(0, 51, 51));
        cedula.setText("Cédula");

        fechaNac.setForeground(new java.awt.Color(0, 51, 51));
        fechaNac.setText("Fecha de Nacimiento");

        labelNomAlum.setEditable(false);
        labelNomAlum.setBackground(new java.awt.Color(255, 255, 255));
        labelNomAlum.setForeground(new java.awt.Color(0, 51, 51));
        labelNomAlum.setAutoscrolls(false);
        labelNomAlum.setBorder(null);

        labelCarreraAlum.setEditable(false);
        labelCarreraAlum.setBackground(new java.awt.Color(255, 255, 255));
        labelCarreraAlum.setForeground(new java.awt.Color(0, 51, 51));
        labelCarreraAlum.setBorder(null);

        labelCedAlum.setEditable(false);
        labelCedAlum.setBackground(new java.awt.Color(255, 255, 255));
        labelCedAlum.setForeground(new java.awt.Color(0, 51, 51));
        labelCedAlum.setBorder(null);

        labelfechaNacAlum.setEditable(false);
        labelfechaNacAlum.setBackground(new java.awt.Color(255, 255, 255));
        labelfechaNacAlum.setForeground(new java.awt.Color(0, 51, 51));
        labelfechaNacAlum.setBorder(null);

        correo.setForeground(new java.awt.Color(0, 51, 51));
        correo.setText("Email");

        labelCorreoAlum.setBackground(new java.awt.Color(255, 255, 255));
        labelCorreoAlum.setForeground(new java.awt.Color(0, 51, 51));
        labelCorreoAlum.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        labelCorreoAlum.setBorder(null);
        labelCorreoAlum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCorreoAlumMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaNac)
                            .addComponent(correo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCorreoAlum)
                            .addComponent(labelfechaNacAlum)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 126, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carrera)
                            .addComponent(nombre)
                            .addComponent(cedula))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCedAlum)
                            .addComponent(labelCarreraAlum)
                            .addComponent(labelNomAlum))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre)
                    .addComponent(labelNomAlum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedula)
                    .addComponent(labelCedAlum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carrera)
                    .addComponent(labelCarreraAlum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaNac)
                    .addComponent(labelfechaNacAlum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(correo)
                    .addComponent(labelCorreoAlum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cerraS.setBackground(new java.awt.Color(255, 255, 255));
        cerraS.setForeground(new java.awt.Color(202, 55, 55));
        cerraS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        cerraS.setText("Cerrar Sesion");
        cerraS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerraSMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/UNA2LINE.jpg"))); // NOI18N

        guardar.setBackground(new java.awt.Color(255, 255, 255));
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/check.png"))); // NOI18N
        guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarMouseClicked(evt);
            }
        });

        msj.setForeground(new java.awt.Color(124, 209, 96));
        msj.setText("Email Actualizado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cerraS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(matricula))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(msj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(msj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matricula)
                    .addComponent(cerraS))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerraSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerraSMouseClicked
        if(cerraS.getText()=="Cerrar Sesion"){
            this.setVisible(false);
            Presentacion.LOGIN_VIEW.setVisible(true);
        }else{
            this.setVisible(false);
            Presentacion.ADMINISTRADOR_VIEW.setVisible(true);
        }
    }//GEN-LAST:event_cerraSMouseClicked

    private void matriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matriculaMouseClicked
        
        try {
            controller.matricular();
            this.setVisible(false);
        } catch (GlobalException | NoDataException | SQLException | InstantiationException | IllegalAccessException ex) {
           
        }
    }//GEN-LAST:event_matriculaMouseClicked

    private void labelCorreoAlumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCorreoAlumMouseClicked
        guardar.setVisible(true);
    }//GEN-LAST:event_labelCorreoAlumMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        guardar.setVisible(false);
        msj.setVisible(false);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseClicked
        try {
            controller.guardar(labelCorreoAlum.getText());
            msj.setVisible(true);
        } catch (GlobalException | NoDataException | InstantiationException | IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }
    }//GEN-LAST:event_guardarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlumnoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlumnoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlumnoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlumnoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlumnoView().setVisible(true);
            }
        });
    }
    AlumnoController controller;
    AlumnoModel model;
    
    public void setController(AlumnoController controller){
        this.controller=controller;
    }
    public void setModel(AlumnoModel model){
        this.model=model;
         model.addObserver(this);
    }

    public AlumnoModel getModel() {
        return model;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel carrera;
    private javax.swing.JLabel cedula;
    public javax.swing.JButton cerraS;
    private javax.swing.JLabel correo;
    private javax.swing.JLabel fechaNac;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField labelCarreraAlum;
    private javax.swing.JTextField labelCedAlum;
    private javax.swing.JTextField labelCorreoAlum;
    private javax.swing.JTextField labelNomAlum;
    private javax.swing.JTextField labelfechaNacAlum;
    public javax.swing.JButton matricula;
    private javax.swing.JLabel msj;
    private javax.swing.JLabel nombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        Alumno alumno= new Alumno();
        alumno= model.getCurrent();
        labelNomAlum.setText(alumno.getNombre());
        String ced = Integer.toString(alumno.getCedula());
        labelCedAlum.setText(ced);
        labelCarreraAlum.setText(alumno.getCarrera().nombre);
        labelCorreoAlum.setText(alumno.getEmail());
        //labelfechaNacAlum.setText(""+alumno.getFecha_nacimiento().getTime());
        
    }
}
