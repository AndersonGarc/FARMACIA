package CapaPresentacion;

import CapaDatos.Medida;
import CapaNegocio.MedidaBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDER
 */
public class Medida_IU extends javax.swing.JInternalFrame {

    public Medida_IU() {
        initComponents();
        txtCantidad.setEnabled(false);
        txtCodigo.setEnabled(false);
        reporte_medida();
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

    public void reporte_medida() {
        try {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            DefaultTableModel tabla_temporal;
            MedidaBD o_MedidaBD = new MedidaBD();
            tabla_temporal = o_MedidaBD.reportarMedida();
            tabla_reporte_medida.setModel(tabla_temporal);
            int cantidad = tabla_temporal.getRowCount();
            txtCantidad.setText("" + cantidad);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            JOptionPane.showMessageDialog(null, e, "Error al reportar", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpiar() {
        txtCodigo.setText("");
        txtEquivalencia.setText("");
        txtPresentacion.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_medida = new javax.swing.JTable();
        txtCantidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPresentacion = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtEquivalencia = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        jTextField3.setText("jTextField3");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("MANTENIMIENTO DE MEDIDA");

        tabla_reporte_medida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_reporte_medida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tabla_reporte_medidaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_reporte_medidaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_reporte_medida);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("PRESENTACION");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("CODIGO");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("EQUIVALENCIA");

        txtPresentacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPresentacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPresentacionFocusLost(evt);
            }
        });
        txtPresentacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPresentacionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPresentacionKeyTyped(evt);
            }
        });

        txtEquivalencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEquivalenciaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEquivalenciaFocusLost(evt);
            }
        });
        txtEquivalencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEquivalenciaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEquivalenciaKeyTyped(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/book.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        btnRegistrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnRegistrarKeyPressed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/book_edit.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/bin_empty.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/page.png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR");

        btnCerrar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/cross.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEquivalencia, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPresentacion)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(btnCerrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEquivalencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnCerrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            if (txtPresentacion.getText().length() > 0) {
                if (txtEquivalencia.getText().length() > 0) {
                    if (txtCodigo.getText().length() == 0) {
                        Medida o_Medida = new Medida();
                        MedidaBD o_MedidaBD = new MedidaBD();
                        o_Medida.setmPresentacion(txtPresentacion.getText().toUpperCase().trim());
                        o_Medida.setmEquivalencia(txtEquivalencia.getText().toUpperCase().trim());
                        boolean rpta = o_MedidaBD.registraMedida(o_Medida);
                        if (rpta) {
                            exito("Se registro ecxitosamente");
                            reporte_medida();
                            limpiar();
                            txtPresentacion.requestFocus();
                        } else {
                        }

                    } else {
                        advertencia("la medida la existe");
                    }
                } else {
                    advertencia("Ingrese equivalencia");
                    txtEquivalencia.requestFocus();
                }
            } else {
                advertencia("Ingrese presentacion");
                txtPresentacion.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al registrar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            if (txtPresentacion.getText().length() > 0) {
                if (txtEquivalencia.getText().length() > 0) {
                    if (txtCodigo.getText().length() > 0) {
                        Medida o_Medida = new Medida();
                        MedidaBD o_MedidaBD = new MedidaBD();
                        o_Medida.setIdmedida(Integer.parseInt(txtCodigo.getText().trim()));
                        o_Medida.setmPresentacion(txtPresentacion.getText().toUpperCase().trim());
                        o_Medida.setmEquivalencia(txtEquivalencia.getText().toUpperCase().trim());
                        boolean rpta = o_MedidaBD.modicarMedida(o_Medida);
                        if (rpta) {
                            exito("Se registro ecxitosamente");
                            reporte_medida();
                            limpiar();
                            txtPresentacion.requestFocus();
                        } else {
                        }

                    } else {
                        advertencia("selecciona un codigo");
                    }
                } else {
                    advertencia("Ingrese equivalencia");
                    txtEquivalencia.requestFocus();
                }
            } else {
                advertencia("Ingrese presentacion");
                txtPresentacion.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al modificar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if (txtCodigo.getText().length() > 0) {
                int aviso = JOptionPane.showConfirmDialog(rootPane, "estas seguro de eliminar","confimacion",JOptionPane.YES_NO_OPTION);
                if (aviso == 0) {
                    int codigo = Integer.parseInt(txtCodigo.getText().trim());
                    Medida o_Medida = new Medida();
                    MedidaBD o_MedidaBD = new MedidaBD();
                    o_Medida.setIdmedida(codigo);
                    boolean rpta = o_MedidaBD.eliminarMedida(codigo);
                    if (rpta) {
                        exito("se elimino");
                        reporte_medida();
                        limpiar();
                        txtPresentacion.requestFocus();
                    } else {
                        error("hubo problemas");
                    }

                }else{
                    txtPresentacion.requestFocus();
                }
            } else {
                advertencia("ingrese codigo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al eliminar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtPresentacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPresentacionFocusGained
        txtPresentacion.setBackground(Color.yellow);
    }//GEN-LAST:event_txtPresentacionFocusGained

    private void txtPresentacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPresentacionFocusLost
        txtPresentacion.setBackground(Color.white);
    }//GEN-LAST:event_txtPresentacionFocusLost

    private void txtEquivalenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEquivalenciaFocusGained
        txtEquivalencia.setBackground(Color.yellow);
    }//GEN-LAST:event_txtEquivalenciaFocusGained

    private void txtEquivalenciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEquivalenciaFocusLost
        txtEquivalencia.setBackground(Color.white);
    }//GEN-LAST:event_txtEquivalenciaFocusLost

    private void txtPresentacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresentacionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtEquivalencia.requestFocus();
        }
    }//GEN-LAST:event_txtPresentacionKeyPressed

    private void txtEquivalenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEquivalenciaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
        }
    }//GEN-LAST:event_txtEquivalenciaKeyPressed

    private void btnRegistrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRegistrarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.doClick();
        }
    }//GEN-LAST:event_btnRegistrarKeyPressed

    private void txtPresentacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresentacionKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPresentacionKeyTyped

    private void txtEquivalenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEquivalenciaKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtEquivalenciaKeyTyped

    private void tabla_reporte_medidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reporte_medidaMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tabla_reporte_medidaMouseExited

    private void tabla_reporte_medidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reporte_medidaMousePressed
        if (evt.getClickCount() == 2) {
            int fila_seleccionada = tabla_reporte_medida.getSelectedRow();

            txtCodigo.setText(tabla_reporte_medida.getValueAt(fila_seleccionada, 0).toString());
            txtPresentacion.setText(tabla_reporte_medida.getValueAt(fila_seleccionada, 1).toString());
            txtEquivalencia.setText(tabla_reporte_medida.getValueAt(fila_seleccionada, 1).toString());
           txtPresentacion.requestFocus();
        }
    }//GEN-LAST:event_tabla_reporte_medidaMousePressed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tabla_reporte_medida;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEquivalencia;
    private javax.swing.JTextField txtPresentacion;
    // End of variables declaration//GEN-END:variables
}
