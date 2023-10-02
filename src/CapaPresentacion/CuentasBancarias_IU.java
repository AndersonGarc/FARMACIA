package CapaPresentacion;

import CapaDatos.DetallesCuentasBancarias;
import CapaNegocio.DetallesCuentasBancariasBD;
import CapaNegocio.ProveedorBD;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDER
 */
public class CuentasBancarias_IU extends javax.swing.JInternalFrame {

    DefaultTableModel tabla_temporal_detalle_cuenta, tabla_temporal_proveedor;
    int idcuenta;

    public CuentasBancarias_IU() {
        initComponents();
        txtRazon.setEnabled(false);
    }

    private void limpiar_tabla_formulario() {
        tabla_temporal_detalle_cuenta = (DefaultTableModel) tabla_reporte_cuenta.getModel();
        tabla_temporal_detalle_cuenta.setRowCount(0);
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

    public void limpiar() {
        txtBanco.setText("");
        txtNro.setText("");
        txtCuenta.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRazon = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCuenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBanco = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_cuenta = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();

        jLabel7.setText("jLabel7");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CUENTAS BANCARIAS DEL PROVEEDOR");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSCAR PROVEEDOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("RUC");

        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("RAZON SOCIAL");

        btnBuscar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/report_user.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtRazon))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRazon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTRO DE CUENTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("CUENTA");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("NRO DE CUENTA");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("BANCO");

        btnRegistrar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/book.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
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
                        .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNro, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(152, 152, 152)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrar))
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabla_reporte_cuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_reporte_cuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_reporte_cuentaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_reporte_cuenta);

        btnCerrar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/button_cancel.gif"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/bin_empty.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("CANTIDAD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCerrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar)
                    .addComponent(btnEliminar)
                    .addComponent(jLabel6)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            if (txtRuc.getText().length() > 0) {
                DetallesCuentasBancariasBD o_DetallesCuentasBancariasBD = new DetallesCuentasBancariasBD();
                ProveedorBD o_ProveedorBD = new ProveedorBD();
                tabla_temporal_proveedor = o_ProveedorBD.buscarProveedor(txtRuc.getText().trim());

                if (tabla_temporal_proveedor.getRowCount() > 0) {
                    txtRazon.setText(tabla_temporal_proveedor.getValueAt(0, 1).toString());
                    tabla_temporal_detalle_cuenta = o_DetallesCuentasBancariasBD.buscarDetalleCuentaBancaria(txtRuc.getText().trim());
                    tabla_reporte_cuenta.setModel(tabla_temporal_detalle_cuenta);
                    txtCuenta.requestFocus();
                } else {
                    error("No se encontraro al proveedor, tienes que registrarlo primero");
                    txtRuc.requestFocus();
                    txtRuc.setText("");
                    txtRazon.setText("");
                    tabla_temporal_detalle_cuenta = o_DetallesCuentasBancariasBD.buscarDetalleCuentaBancaria(txtRuc.getText().trim());
                    tabla_reporte_cuenta.setModel(tabla_temporal_detalle_cuenta);
                }
            } else {
                advertencia("Ingrese un ruc");
                txtRuc.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyTyped
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscar.doClick();
            txtCuenta.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarKeyTyped

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            if (txtBanco.getText().length() > 0) {
                if (txtNro.getText().length() > 0) {
                    if (txtCuenta.getText().length() > 0) {
                        DetallesCuentasBancarias o_Detalles = new DetallesCuentasBancarias();
                        DetallesCuentasBancariasBD o_BancariasBD = new DetallesCuentasBancariasBD();

                        o_Detalles.setBanco(txtBanco.getText().toUpperCase().trim());
                        o_Detalles.setNroCuenta(txtNro.getText().toUpperCase().trim());
                        o_Detalles.setCuenta(txtCuenta.getText().toUpperCase().trim());
                        o_Detalles.setIdproveedor(txtRuc.getText().trim());

                        boolean rpta = o_BancariasBD.registrarDetalleCuentasBancarias(o_Detalles);
                        if (rpta) {
                            exito("Se registro correctamente");
                            DefaultTableModel tabla_temporal;
                            DetallesCuentasBancariasBD oCuentasBancariasBD = new DetallesCuentasBancariasBD();
                            tabla_temporal = oCuentasBancariasBD.buscarDetalleCuentaBancaria(txtRuc.getText().trim());
                            tabla_reporte_cuenta.setModel(tabla_temporal);
                            limpiar();
                            txtRuc.requestFocus();
                        } else {
                            error("Tienes problemas para registrar");
                        }

                    } else {
                        advertencia("Ingrese cuenta bancaria");
                        txtCuenta.requestFocus();
                    }
                } else {
                    advertencia("Ingrese nro de cuenta");
                    txtNro.requestFocus();
                }
            } else {
                advertencia("Ingrese un ruc");
                txtBanco.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyPressed

    }//GEN-LAST:event_txtRucKeyPressed

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtRuc.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRucKeyTyped

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int aviso = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar..?");
        if (aviso == 0) {
            DetallesCuentasBancariasBD o_DetallesCuentasBancariasBD = new DetallesCuentasBancariasBD();
            boolean rpta = o_DetallesCuentasBancariasBD.eliminaarDetalleCuentasBancarias(idcuenta);
            if (rpta) {
                exito("Se elimino");
                limpiar();
                limpiar_tabla_formulario();
                txtRuc.setText("");
                txtRuc.requestFocus();
            } else {
                error("Tienes problemas al eliminar");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tabla_reporte_cuentaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reporte_cuentaMousePressed
        int fila_selecionada = tabla_reporte_cuenta.getSelectedRow();
        idcuenta = Integer.parseInt(tabla_reporte_cuenta.getValueAt(fila_selecionada, 0).toString());
    }//GEN-LAST:event_tabla_reporte_cuentaMousePressed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_cuenta;
    private javax.swing.JTextField txtBanco;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCuenta;
    private javax.swing.JTextField txtNro;
    private javax.swing.JTextField txtRazon;
    private javax.swing.JTextField txtRuc;
    // End of variables declaration//GEN-END:variables
}
