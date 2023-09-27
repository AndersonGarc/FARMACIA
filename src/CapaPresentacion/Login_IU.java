package CapaPresentacion;

import CapaDatos.Asistencia;
import CapaDatos.Turno;
import CapaDatos.Usuario;
import CapaNegocio.AsistenciaBD;
import CapaNegocio.TurnoBD;
import CapaNegocio.UsuarioBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.Calendar;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDER
 */
public class Login_IU extends javax.swing.JFrame {

    public static String dni_publico;
    public static String usuario;
    public static String tienda;
    public static int idasistencia;

    public Login_IU() {
        initComponents();
        setLocationRelativeTo(null);
        muestraimagen(lblFoto, "src/IMAGENES/mochi mochi.jpg");
    }

    private String obtener_fecha_actual() {
        Calendar calendario = Calendar.getInstance();
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int anio = calendario.get(Calendar.YEAR);

        String fecha = anio + "-" + mes + "-" + dia;
        return fecha;
    }

    private String obtener_hora_actual() {
        Calendar calendario = Calendar.getInstance();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minuto = calendario.get(Calendar.MINUTE);
        int segundo = calendario.get(Calendar.SECOND);

        String tiempo = hora + ":" + minuto + ":" + segundo;
        return tiempo;
    }

    private void exito(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "MENSAJE", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    private void error(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "ERROR", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
    }

    private void advertencia(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "ADVERTENCIA", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    private void muestraimagen(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(150, 150, WIDTH));
        labelName.setIcon(icon);
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtClave = new javax.swing.JPasswordField();
        lblFoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("¡ BIENVENIDOS ! ");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("DNI");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("CLAVE");

        txtDni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDniFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDniFocusLost(evt);
            }
        });
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        btnIngresar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/decrypted.gif"))); // NOI18N
        btnIngresar.setText("INGRESAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        btnIngresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnIngresarKeyPressed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/cross.png"))); // NOI18N
        jButton2.setText("CERRAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtClave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtClaveFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtClaveFocusLost(evt);
            }
        });
        txtClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClaveKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnIngresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(23, 23, 23))
                    .addComponent(txtDni)
                    .addComponent(txtClave))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnIngresar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (txtDni.getText().length() > 0) {
            if (txtClave.getText().length() > 0) {
                String dni = txtDni.getText().trim();
                String clave = txtClave.getText();
                UsuarioBD oUsuarioBD = new UsuarioBD();
                List<Usuario> lista_usuario = oUsuarioBD.login(dni, clave);

                if (lista_usuario.size() > 0) {
                    String nombre = lista_usuario.get(0).getuNombre();
                    String apellidos = lista_usuario.get(0).getuApellidos();
                    tienda = lista_usuario.get(0).getTienda();
                    dni_publico = dni;
                    usuario = nombre + " " + apellidos;

                    TurnoBD oTurnoBD = new TurnoBD();
                    String hora_actual = obtener_hora_actual();
                    List<Turno> lista_turno = oTurnoBD.buscarTurno(hora_actual, hora_actual, dni);

                    if (lista_turno.size() > 0) {
                        Menu_IU o_Menu_IU = new Menu_IU();
                        String fecha = obtener_fecha_actual();
                        String hora = obtener_hora_actual();
                        Asistencia o_Asistencia = new Asistencia();
                        AsistenciaBD o_AsistenciaBD = new AsistenciaBD();

                        int tipo = lista_usuario.get(0).getIdtipoUsuario();
                        if (tipo == 1) {
                            o_Menu_IU.menu_mantenimiento.setEnabled(true);
                            o_Menu_IU.menu_compras.setEnabled(true);
                            o_Menu_IU.menu_inventario.setEnabled(true);
                            o_Menu_IU.btnProductos.setEnabled(true);
                            o_Menu_IU.btnCompras.setEnabled(true);
                            o_Menu_IU.btnCerrar.setEnabled(true);
                            o_Menu_IU.btnUsuario.setEnabled(true);

                            o_Menu_IU.setVisible(true);
                            o_Menu_IU.setTitle("TIENDA: " + tienda + "- USUARIO: " + usuario);
                            this.setVisible(false);
                        }
                        if (tipo == 2) {
                            o_Menu_IU.menu_ventas.setEnabled(true);
                            o_Menu_IU.menu_caja.setEnabled(true);
                            o_Menu_IU.btnIngresos.setEnabled(true);
                            o_Menu_IU.btnCaja.setEnabled(true);
                            o_Menu_IU.btnVentas.setEnabled(true);
                            o_Menu_IU.btnCerrar.setEnabled(true);
                            o_Menu_IU.btnEgresos.setEnabled(true);

                            List<Asistencia> lista = o_AsistenciaBD.buscarAsistenciaUsuario(dni, tienda, fecha);
                            if (lista.size() > 0) {
                                String estado = lista.get(0).getaEstado();
                                if (estado.equals("CERRADO")) {
                                    advertencia("YA NO PUEDES INGRESAR AL SISTEMA POR QUE CERRASTE TU CAJA");

                                } else {
                                    idasistencia = lista.get(0).getIdasistencia();
                                    o_Menu_IU.setVisible(true);
                                    o_Menu_IU.setTitle("TIENDA: " + tienda + "- USUARIO: " + usuario);
                                }
                            } else {
                                o_Asistencia.setaFechaE(fecha);
                                o_Asistencia.setaHoraE(hora);
                                o_Asistencia.setaHoraS("00:00:00");
                                o_Asistencia.setUsuario_uDni(dni);
                                o_Asistencia.setaTurno("");
                                o_Asistencia.setaEstado("ABIERTO");
                                o_Asistencia.setaTienda(tienda);
                                idasistencia = o_AsistenciaBD.registrarAsistencia(o_Asistencia);
                                o_Menu_IU.setVisible(true);
                                o_Menu_IU.setTitle("TIENDA: " + tienda + "- USUARIO: " + usuario);
                                this.setVisible(false);
                            }
                        }

                    } else {
                        advertencia("No puedes ingresar al sistema, por que no es tu turno");
                    }
                } else {
                    error("No perteneces al sistema");
                    txtDni.requestFocus();
                }

            } else {
                advertencia("Ingrese su clave");
                txtClave.requestFocus();
            }
        } else {
            advertencia("Ingrese dni");
            txtDni.requestFocus();
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtDniFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusGained
        txtDni.setBackground(Color.yellow);
    }//GEN-LAST:event_txtDniFocusGained

    private void txtDniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusLost
        txtDni.setBackground(Color.white);
    }//GEN-LAST:event_txtDniFocusLost

    private void txtClaveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClaveFocusGained
        txtClave.setBackground(Color.yellow);
    }//GEN-LAST:event_txtClaveFocusGained

    private void txtClaveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClaveFocusLost
        txtClave.setBackground(Color.white);
    }//GEN-LAST:event_txtClaveFocusLost

    private void btnIngresarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnIngresarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnIngresar.doClick();
        }
    }//GEN-LAST:event_btnIngresarKeyPressed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtDni.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtClave.requestFocus();
        }
    }//GEN-LAST:event_txtDniKeyPressed

    private void txtClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnIngresar.requestFocus();
        }
    }//GEN-LAST:event_txtClaveKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
                if ("windosw".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_IU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtDni;
    // End of variables declaration//GEN-END:variables
}
