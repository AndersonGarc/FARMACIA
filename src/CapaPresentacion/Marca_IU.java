package CapaPresentacion;

import CapaDatos.Marca;
import CapaNegocio.MarcaBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Marca_IU extends javax.swing.JInternalFrame {

    public Marca_IU() {
        initComponents();
        txtCodigo.setEnabled(false);
        txtCantidad.setEnabled(false);
        reporte_marca();
    }

    private void limpiar() {
        txtCodigo.setText("");
        txtNomre.setText("");
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

    private void reporte_marca() {
        try {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            DefaultTableModel tabla_temporal;
            MarcaBD o_MarcaBD = new MarcaBD();
            tabla_temporal = o_MarcaBD.reportarMarca();
            tabla_reporte_marca.setModel(tabla_temporal);
            int cat = tabla_temporal.getRowCount();
            txtCantidad.setText("" + cat);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNomre = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_marca = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("LABORATORIO");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("CODIGO");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("NOMBRE");

        txtNomre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomreFocusLost(evt);
            }
        });
        txtNomre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomreKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("CANTIDAD");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Laboratorio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("LABORATORIO");

        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarFocusLost(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tabla_reporte_marca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_reporte_marca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_reporte_marcaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_reporte_marca);

        btnRegistrar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/report.png"))); // NOI18N
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
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(btnCerrar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNomre))))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            if (txtNomre.getText().length() > 0) {
                if (txtCodigo.getText().length() == 0) {
                    Marca o_Marca = new Marca();
                    MarcaBD o_MarcaBD = new MarcaBD();
                    o_Marca.setMaNombre(txtNomre.getText().toUpperCase().trim());
                    boolean rpta = o_MarcaBD.registraMarca(o_Marca);
                    if (rpta) {
                        exito("se registro con ecxito");
                        reporte_marca();
                        limpiar();
                        txtNomre.requestFocus();

                    } else {
                        error("Tienes problemas al registrar marca");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No puedes registrar por que ya existe", "error", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                error("Ingrese nombre");
                txtNomre.requestFocus();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtNomreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomreFocusGained
        txtNomre.setBackground(Color.yellow);
    }//GEN-LAST:event_txtNomreFocusGained

    private void txtNomreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomreFocusLost
        txtNomre.setBackground(Color.white);
    }//GEN-LAST:event_txtNomreFocusLost

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        txtBuscar.setBackground(Color.yellow);
    }//GEN-LAST:event_txtBuscarFocusGained

    private void txtBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusLost
        txtBuscar.setBackground(Color.white);
    }//GEN-LAST:event_txtBuscarFocusLost

    private void btnRegistrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRegistrarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.doClick();
        }
    }//GEN-LAST:event_btnRegistrarKeyPressed

    private void txtNomreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomreKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
        }
    }//GEN-LAST:event_txtNomreKeyPressed

    private void tabla_reporte_marcaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reporte_marcaMousePressed
        if (evt.getClickCount() == 2) {
            int fila_seleccionada = tabla_reporte_marca.getSelectedRow();

            txtCodigo.setText(tabla_reporte_marca.getValueAt(fila_seleccionada, 0).toString());
            txtNomre.setText(tabla_reporte_marca.getValueAt(fila_seleccionada, 1).toString());
        }
    }//GEN-LAST:event_tabla_reporte_marcaMousePressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            if (txtCodigo.getText().length() > 0) {
                if (txtNomre.getText().length() > 0) {
                    Marca o_Marca = new Marca();
                    MarcaBD o_MarcaBD = new MarcaBD();
                    o_Marca.setIdmarca(Integer.parseInt(txtCodigo.getText().trim()));
                    o_Marca.setMaNombre(txtNomre.getText().toUpperCase().trim());

                    boolean rpta = o_MarcaBD.modificarMarca(o_Marca);
                    if (rpta) {
                        exito("Se registro con ecxito");
                        reporte_marca();
                        limpiar();
                    } else {
                        error("Tienes problemas para modificar");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El campo no puede estar vacio");
                    txtNomre.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe el codigo a modicar");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al modifcar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if (txtCodigo.getText().length() > 0) {
                int aviso = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar");
                if (aviso == 0) {
                    int idmarca = Integer.parseInt(txtCodigo.getText().trim());
                    MarcaBD o_MarcaBD = new MarcaBD();
                    boolean rpta = o_MarcaBD.eliminarMarca(idmarca);
                    if (rpta) {
                        exito("Se elimino con ecxito");
                        reporte_marca();
                        limpiar();

                    } else {
                        error("Tienes problemas para eliminar");
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un codigo");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al eliminar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        try {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            DefaultTableModel tabla_temporal;
            String valor = txtBuscar.getText();
            MarcaBD oMarcaBD = new MarcaBD();
            tabla_temporal = oMarcaBD.buscarMarca(valor);
            tabla_reporte_marca.setModel(tabla_temporal);
            int cantLista = tabla_temporal.getRowCount();
            txtCantidad.setText("" + cantLista);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtCodigo.setText("");
        txtNomre.setText("");
        txtNomre.requestFocus();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtNomreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomreKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNomreKeyTyped

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_marca;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNomre;
    // End of variables declaration//GEN-END:variables
}
