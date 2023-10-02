package CapaPresentacion;

import CapaDatos.Categoria;
import CapaNegocio.CategoriaBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDER
 */
public class Categoria_IU extends javax.swing.JInternalFrame {

    public Categoria_IU() {
        initComponents();
        reporteCategoria();
        txtCatidad.setEnabled(false);
        txtCodigo.setEnabled(false);
        
    }

    private void limpiar_tabla_formulario() {
        DefaultTableModel tabla_temporal_categorias = (DefaultTableModel) tabla_reporte_categoria.getModel();
        tabla_temporal_categorias.setRowCount(0);
    }

    private void limpiar() {
        txtCodigo.setText("");
        txtCatidad.setText("");
        txtNombre.setText("");
        reporteCategoria();

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

    private void reporteCategoria() {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        try {
            limpiar_tabla_formulario();

            DefaultTableModel tabla_temporal = (DefaultTableModel) this.tabla_reporte_categoria.getModel();
            CategoriaBD o_CategoriaBD = new CategoriaBD();

            List<Categoria> lista_categorias = o_CategoriaBD.reportarCategoria();

            for (int i = 0; i < lista_categorias.size(); i++) {
                int idcategoria = lista_categorias.get(i).getIdCategoria();
                String maNombre = lista_categorias.get(i).getCaNombre();
                Object[] data = {idcategoria, maNombre};
                tabla_temporal.addRow(data);
                int canLista = tabla_temporal.getRowCount();
                txtCatidad.setText("" + canLista);
            }
            tabla_reporte_categoria.setModel(tabla_temporal);

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
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCatidad = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_categoria = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("MANTENIMIENTO DE CATEGORIAS");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("CODIGO");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("NOMBRE");

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("CANTIDAD");

        txtCatidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCatidadActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("BUSCAR CATEGORIA"));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("CATEGORIA");

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
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tabla_reporte_categoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE"
            }
        ));
        tabla_reporte_categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_reporte_categoriaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_reporte_categoria);

        btnRegistrar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
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

        btnModificar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/book_edit.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
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

        btnLimpiar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/page.png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnCerrar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCatidad, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombre))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(btnCerrar)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtCatidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txtCatidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCatidadActionPerformed

    }//GEN-LAST:event_txtCatidadActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            if (txtCodigo.getText().length() == 0) {
                if (txtNombre.getText().length() > 0) {
                    Categoria o_Categoria = new Categoria();
                    CategoriaBD o_caCategoriaBD = new CategoriaBD();

                    o_Categoria.setCaNombre(txtNombre.getText().toUpperCase().trim());
                    boolean rpta = o_caCategoriaBD.registrarCategoria(o_Categoria);
                    if (rpta) {
                        exito("Se registro correctamente");
                        reporteCategoria();
                        limpiar();
                        txtNombre.requestFocus();
                    } else {
                        error("Tienes problemas al registrar");
                    }
                } else {
                    advertencia("Ingrese nombre");
                    txtNombre.requestFocus();
                }
            } else {
                advertencia("No puedes registrar por que ya existe");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al registrar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void tabla_reporte_categoriaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reporte_categoriaMousePressed
        if (evt.getClickCount() == 2) {
            int fila_seleccionada = tabla_reporte_categoria.getSelectedRow();
            txtCodigo.setText(tabla_reporte_categoria.getValueAt(fila_seleccionada, 0).toString());
            txtNombre.setText(tabla_reporte_categoria.getValueAt(fila_seleccionada, 1).toString());
            txtNombre.requestFocus();
        }
    }//GEN-LAST:event_tabla_reporte_categoriaMousePressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            if (txtCodigo.getText().length() > 0) {
                if (txtNombre.getText().length() > 0) {
                    
                    Categoria o_Categoria = new Categoria();
                    CategoriaBD o_caCategoriaBD = new CategoriaBD();

                    o_Categoria.setIdCategoria(Integer.parseInt(txtCodigo.getText().toUpperCase().trim()));
                    o_Categoria.setCaNombre(txtNombre.getText().toUpperCase().trim());

                    boolean rpta = o_caCategoriaBD.ModificarCategoria(o_Categoria);
                    if (rpta) {
                        exito("Se modifico correctamente");
                        reporteCategoria();
                        limpiar();
                        txtNombre.requestFocus();
                    } else {
                        error("Tienes problemas al registrar");
                    }
                } else {
                    advertencia("Ingrese nombre");
                    txtNombre.requestFocus();
                }
            } else {
                advertencia("No puedes registrar por que ya existe");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al modificar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if (txtCodigo.getText().length() > 0) {
                int aviso = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar ?");
                if (aviso == 0) {
                    int idcategoria = Integer.parseInt(txtCodigo.getText().trim());
                    Categoria o_Categoria = new Categoria();
                    CategoriaBD o_CategoriaBD = new CategoriaBD();
                    o_Categoria.setIdCategoria(idcategoria);
                    boolean rpta = o_CategoriaBD.eliminarCategoria(idcategoria);
                    if (rpta) {
                        exito("Se elimino con exito");
                        reporteCategoria();
                        limpiar();
                        txtNombre.requestFocus();
                    } else {
                        error("Tienes problemas para eliminar");
                    }

                }
            } else {
                advertencia("Ingrese un codigo para eliminar");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al eliminar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        try {
            limpiar_tabla_formulario();
            DefaultTableModel tabla_temporal = (DefaultTableModel) this.tabla_reporte_categoria.getModel();
            CategoriaBD oCategoriaBD = new CategoriaBD();
            String valor = txtBuscar.getText().trim();
            List<Categoria> lista_categoria = oCategoriaBD.buscarCategoria(valor);

            for (int i = 0; i < lista_categoria.size(); i++) {
                int idcategoria = lista_categoria.get(i).getIdCategoria();
                String maNombre = lista_categoria.get(i).getCaNombre();
                Object[] data = {idcategoria, maNombre};
                tabla_temporal.addRow(data);
            }
            tabla_reporte_categoria.setModel(tabla_temporal);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        txtNombre.setBackground(Color.yellow);
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        txtNombre.setBackground(Color.white);
    }//GEN-LAST:event_txtNombreFocusLost

    private void btnRegistrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRegistrarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.doClick();
        }
    }//GEN-LAST:event_btnRegistrarKeyPressed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtNombre.setText("");
        txtBuscar.setText("");
        txtCodigo.setText("");
        txtNombre.requestFocus();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        txtBuscar.setBackground(Color.yellow);
    }//GEN-LAST:event_txtBuscarFocusGained

    private void txtBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusLost
       txtBuscar.setBackground(Color.white);
    }//GEN-LAST:event_txtBuscarFocusLost

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyReleased


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
    private javax.swing.JTable tabla_reporte_categoria;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCatidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
