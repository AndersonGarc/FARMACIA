package CapaPresentacion;

import CapaDatos.Composicion;
import CapaNegocio.ComposicionBD;
import CapaNegocio.ProductoBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDER
 */
public class Composicion_IU extends javax.swing.JInternalFrame {

    public Composicion_IU() {
        initComponents();
        reportar();
        txtProducto.setEnabled(false);
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

    private void limpiar() {
        txtComposicion.setText("");
        txtProducto.setText("");
        txtSerie.setText("");
    }

    private void limpiar_tabla_formulario() {
        DefaultTableModel tabla_temporal_composicio = (DefaultTableModel) tabla_reporte_composicion.getModel();
        tabla_temporal_composicio.getRowCount();
    }

    private void reportar() {
        try {
            limpiar_tabla_formulario();
            DefaultTableModel tabla_temporal_composicio = (DefaultTableModel) tabla_reporte_composicion.getModel();
            ComposicionBD o_ComposicionBD = new ComposicionBD();
            List<Composicion> lista_composiciones = o_ComposicionBD.reportarComposicion();
            int cant = lista_composiciones.size();
            for (int i = 0; i < cant; i++) {
                int idcomposiciones = lista_composiciones.get(i).getIdcomposicion();
                String nombre = lista_composiciones.get(i).getCoNombre();
                String serie = lista_composiciones.get(i).getpSerie();

                Object[] data = {idcomposiciones, nombre, serie};
                tabla_temporal_composicio.addRow(data);

            }
            tabla_reporte_composicion.setModel(tabla_temporal_composicio);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error al reportar", JOptionPane.ERROR_MESSAGE);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        txtSerie = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtComposicion = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_composicion = new javax.swing.JTable();
        btncerrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("COMPOSICION");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("SERIE");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("PRODUCTO");

        txtProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductoFocusLost(evt);
            }
        });

        txtSerie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSerieFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSerieFocusLost(evt);
            }
        });
        txtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSerieKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSerieKeyTyped(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/lupa.gif"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("COMPOSICION");

        txtComposicion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtComposicionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtComposicionFocusLost(evt);
            }
        });
        txtComposicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtComposicionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtComposicionKeyTyped(evt);
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

        tabla_reporte_composicion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "COMPOSICION", "SERIE"
            }
        ));
        jScrollPane1.setViewportView(tabla_reporte_composicion);

        btncerrar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btncerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/cross.png"))); // NOI18N
        btncerrar.setText("CERRAR");
        btncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btncerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtComposicion)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegistrar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtProducto))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtComposicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRegistrar))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncerrar)
                    .addComponent(btnEliminar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            if (txtSerie.getText().length() > 0) {
                ProductoBD o_ProductoBD = new ProductoBD();
                DefaultTableModel tabla_temporal;
                String serie = txtSerie.getText();
                tabla_temporal = o_ProductoBD.buscarProducto(serie);
                String producto = tabla_temporal.getValueAt(0, 1).toString();
                txtProducto.setText(producto);
                txtComposicion.requestFocus();
            } else {
                advertencia("se necesita la serie");
                txtSerie.requestFocus();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            if (txtSerie.getText().length() > 0) {
                if (txtComposicion.getText().length() > 0) {
                    Composicion o_Composicion = new Composicion();
                    ComposicionBD o_ComposicionBD = new ComposicionBD();
                    o_Composicion.setCoNombre(txtComposicion.getText().toUpperCase());
                    o_Composicion.setpSerie(txtSerie.getText());
                    boolean rpta = o_ComposicionBD.registrarComposicion(o_Composicion);
                    if (rpta) {
                        exito("se registro exitosamente");
                        reportar();
                        limpiar();
                        txtSerie.requestFocus();
                    } else {
                        error("tienes problemas papu,aparte de tu vida");
                        limpiar();
                        txtComposicion.requestFocus();
                    }

                } else {
                    advertencia("agrege una composicion");
                    txtComposicion.requestFocus();
                }
            } else {
                advertencia("agrege una serie");
                txtSerie.requestFocus();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btncerrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            int fila_seleccionada = tabla_reporte_composicion.getSelectedRow();
            if (fila_seleccionada > -1) {
                int aviso = JOptionPane.showConfirmDialog(rootPane, "EStas seguro de eliminar..?,", "CONFIRMACION", JOptionPane.YES_NO_OPTION);
                if (aviso == 0) {
                    int idcomposicion = Integer.parseInt(tabla_reporte_composicion.getValueAt(fila_seleccionada, 0).toString());
                    ComposicionBD oComposicionBD = new ComposicionBD();
                    boolean rpta = oComposicionBD.eliminarComposicion(idcomposicion);
                    if (rpta) {
                        exito("buena");
                        reportar();
                        limpiar();
                        txtSerie.requestFocus();
                    } else {
                        error("Tienes problemas para eliminar");
                    }

                } else {
                    txtSerie.requestFocus();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtSerieFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerieFocusGained
        txtSerie.setBackground(Color.yellow);
    }//GEN-LAST:event_txtSerieFocusGained

    private void txtSerieFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerieFocusLost
        txtSerie.setBackground(Color.white);
    }//GEN-LAST:event_txtSerieFocusLost

    private void txtProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductoFocusGained
        txtProducto.setBackground(Color.yellow);
    }//GEN-LAST:event_txtProductoFocusGained

    private void txtProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductoFocusLost
        txtProducto.setBackground(Color.white);
    }//GEN-LAST:event_txtProductoFocusLost

    private void txtComposicionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtComposicionFocusGained
        txtComposicion.setBackground(Color.yellow);
    }//GEN-LAST:event_txtComposicionFocusGained

    private void txtComposicionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtComposicionFocusLost
        txtComposicion.setBackground(Color.white);
    }//GEN-LAST:event_txtComposicionFocusLost

    private void txtSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtSerie.getText().length() >= 13) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSerieKeyTyped

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscar.doClick();
        }
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void txtSerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscar.requestFocus();
        }
    }//GEN-LAST:event_txtSerieKeyPressed

    private void txtComposicionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComposicionKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtComposicionKeyTyped

    private void txtComposicionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComposicionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
        }
    }//GEN-LAST:event_txtComposicionKeyPressed

    private void btnRegistrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRegistrarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.doClick();
        }
    }//GEN-LAST:event_btnRegistrarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btncerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_composicion;
    private javax.swing.JTextField txtComposicion;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
