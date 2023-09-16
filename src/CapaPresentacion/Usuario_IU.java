package CapaPresentacion;

import CapaDatos.TipoUsuario;
import CapaDatos.Usuario;
import CapaNegocio.TipoUsuarioBD;
import CapaNegocio.UsuarioBD;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Usuario_IU extends javax.swing.JInternalFrame {

    List<TipoUsuario> lista_tipo_usuario;

    public Usuario_IU() {
        initComponents();
        reportarUsuario();
        cargarTipoUsuario();
        txtId_tipo_usuario.setEnabled(false);
        txtCantidad.setEnabled(false);
    }

    public void limpiar() {
        txtDni.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtCelular.setText("");
        txtClave.setText("");
        txtDirecciom.setText("");
        txtNombre.requestFocus();
    }

    private void reportarUsuario() {
        try {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            DefaultTableModel tabla_temporal;
            UsuarioBD o_tipo = new UsuarioBD();

            tabla_temporal = o_tipo.reportarUsuarios();
            tabla_reporte_usuario.setModel(tabla_temporal);

            int canLista = tabla_temporal.getRowCount();
            txtCantidad.setText("" + canLista);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }
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

    private void cargarTipoUsuario() {
        try {
            cmbTipo.removeAllItems();
            TipoUsuarioBD oTipoUsuarioBD = new TipoUsuarioBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = oTipoUsuarioBD.reportarTipoUsuario();
            lista_tipo_usuario = new ArrayList<>();
            cmbTipo.addItem("seleccionar");

            for (int i = 0; i < tabla_temporal.getRowCount(); i++) {
                int idtipoUsuario = Integer.valueOf(tabla_temporal.getValueAt(i, 0).toString());
                String tuNombre = String.valueOf(tabla_temporal.getValueAt(i, 1));
                lista_tipo_usuario.add(new TipoUsuario(idtipoUsuario, tuNombre));
                cmbTipo.addItem(tuNombre);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error al cargar", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDirecciom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbTienda = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_usuario = new javax.swing.JTable();
        txtId_tipo_usuario = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("DNI");

        txtDni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDniFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDniFocusLost(evt);
            }
        });

        jLabel2.setText("NOMBRE");

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });

        jLabel3.setText("APELLIDOS");

        jLabel4.setText("DIRECCION");

        jLabel5.setText("CLAVE");

        jLabel6.setText("CELULAR");

        jLabel7.setText("TIPO");

        cmbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoItemStateChanged(evt);
            }
        });

        jLabel8.setText("TIENDA");

        cmbTienda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "principal" }));

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMNAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnImprimir.setText("IMPRIMIR");

        btnCerrar.setText("CERRAR");

        jLabel9.setText("BUSCAR APELLIDO");

        tabla_reporte_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_reporte_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_reporte_usuarioMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_reporte_usuario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrar))
                    .addComponent(cmbTienda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClave)
                    .addComponent(txtCelular)
                    .addComponent(cmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDni)
                    .addComponent(txtNombre)
                    .addComponent(txtApellidos)
                    .addComponent(txtDirecciom))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtId_tipo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscar)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDirecciom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRegistrar)
                        .addComponent(btnModificar)
                        .addComponent(btnEliminar)
                        .addComponent(btnImprimir)
                        .addComponent(btnCerrar)
                        .addComponent(txtId_tipo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            if (txtDni.getText().length() > 0) {
                if (txtNombre.getText().length() > 0) {
                    if (txtApellidos.getText().length() > 0) {
                        if (txtDirecciom.getText().length() > 0) {

                            if (txtClave.getText().length() > 0) {
                                if (txtCelular.getText().length() > 0) {
                                    Usuario o_Usuario = new Usuario();
                                    UsuarioBD o_UsuarioBD = new UsuarioBD();

                                    o_Usuario.setuDni(txtDni.getText().toUpperCase().trim());
                                    o_Usuario.setuNombre(txtNombre.getText().toUpperCase().trim());
                                    o_Usuario.setuApellidos(txtApellidos.getText().toUpperCase().trim());
                                    o_Usuario.setuDireccion(txtDirecciom.getText().toUpperCase().trim());
                                    o_Usuario.setuClave(txtClave.getText().toUpperCase());
                                    o_Usuario.setuCelular(txtCelular.getText());
                                    o_Usuario.setIdtipoUsuario(Integer.parseInt(txtId_tipo_usuario.getText()));
                                    o_Usuario.setTienda(cmbTienda.getSelectedItem().toString());

                                    boolean rtpa = o_UsuarioBD.registrarUsuario(o_Usuario);
                                    if (rtpa) {
                                        exito("se registro corretamente");
                                        reportarUsuario();
                                        limpiar();

                                    } else {
                                        error("problemas");
                                    }
                                } else {
                                    error("falta nro de celular");
                                }

                            } else {
                                error("falta clave");
                            }

                        } else {
                            error("falta direccion");
                        }
                    } else {
                        error("falta apellidos");
                    }
                } else {
                    error("falta nombre");
                }
            } else {
                error("falta dni");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void cmbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String textoSeleccionado = (String) cmbTipo.getSelectedItem();
            if (textoSeleccionado.equals("seleccionar")) {
                txtId_tipo_usuario.getText();
            } else {
                int i = cmbTipo.getSelectedIndex() - 1;
                txtId_tipo_usuario.setText("" + lista_tipo_usuario.get(i).getIdtipoUsuario());
            }
        }
    }//GEN-LAST:event_cmbTipoItemStateChanged

    private void tabla_reporte_usuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reporte_usuarioMousePressed
        if (evt.getClickCount() == 2) {
            int fila_seleccionada = tabla_reporte_usuario.getSelectedRow();

            txtDni.setText(tabla_reporte_usuario.getValueAt(fila_seleccionada, 0).toString());
            txtNombre.setText(tabla_reporte_usuario.getValueAt(fila_seleccionada, 1).toString());
            txtApellidos.setText(tabla_reporte_usuario.getValueAt(fila_seleccionada, 2).toString());
            txtDirecciom.setText(tabla_reporte_usuario.getValueAt(fila_seleccionada, 3).toString());
            txtCelular.setText(tabla_reporte_usuario.getValueAt(fila_seleccionada, 4).toString());
            txtClave.setText(tabla_reporte_usuario.getValueAt(fila_seleccionada, 5).toString());
            cmbTipo.setSelectedItem(tabla_reporte_usuario.getValueAt(fila_seleccionada, 6).toString());
            cmbTienda.setSelectedItem(tabla_reporte_usuario.getValueAt(fila_seleccionada, 7).toString());
        }
    }//GEN-LAST:event_tabla_reporte_usuarioMousePressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            if (txtDni.getText().length() > 0) {
                if (txtNombre.getText().length() > 0) {
                    if (txtApellidos.getText().length() > 0) {
                        if (txtDirecciom.getText().length() > 0) {
                            if (txtClave.getText().length() > 0) {
                                if (txtCelular.getText().length() > 0) {
                                    if (txtId_tipo_usuario.getText().length() > 0) {
                                        Usuario o_Usuario = new Usuario();
                                        UsuarioBD o_UsuarioBD = new UsuarioBD();

                                        o_Usuario.setuDni(txtDni.getText().toUpperCase().trim());
                                        o_Usuario.setuNombre(txtNombre.getText().toUpperCase().trim());
                                        o_Usuario.setuApellidos(txtApellidos.getText().toUpperCase().trim());
                                        o_Usuario.setuDireccion(txtDirecciom.getText().toUpperCase().trim());
                                        o_Usuario.setuClave(txtClave.getText().toUpperCase());
                                        o_Usuario.setuCelular(txtCelular.getText());
                                        o_Usuario.setIdtipoUsuario(Integer.parseInt(txtId_tipo_usuario.getText()));
                                        o_Usuario.setTienda(cmbTienda.getSelectedItem().toString());

                                        boolean rtpa = o_UsuarioBD.modificarUsuario(o_Usuario);
                                        if (rtpa) {
                                            exito("se modifico corretamente");
                                            reportarUsuario();
                                            limpiar();

                                        } else {
                                            error("Tienes problemas al modificar");
                                        }
                                    } else {

                                    }

                                } else {
                                    error("falta nro de celular");
                                    txtCelular.requestFocus();
                                }

                            } else {
                                error("falta clave");
                                txtClave.requestFocus();
                            }

                        } else {
                            error("falta direccion");
                        }
                    } else {
                        error("falta apellidos");
                    }
                } else {
                    error("falta nombre");
                }
            } else {
                error("falta dni");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtDniFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusGained
        txtDni.setBackground(Color.yellow);
    }//GEN-LAST:event_txtDniFocusGained

    private void txtDniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusLost
        txtDni.setBackground(Color.white);
    }//GEN-LAST:event_txtDniFocusLost

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        txtNombre.setBackground(Color.yellow);
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        txtNombre.setBackground(Color.white);
    }//GEN-LAST:event_txtNombreFocusLost

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (txtDni.getText().length() > 0) {
            int aviso = JOptionPane.showConfirmDialog(rootPane, "¿ ESTAS SEGURO DE ELIMINAR ?");
            if (aviso == 0) {
                UsuarioBD o_UsuarioBD = new UsuarioBD();

                String dni = txtDni.getText();
                boolean rpta = o_UsuarioBD.eliminarUsuario(dni);
                if (rpta) {
                    exito("SE ELIMINO CON EXICTO");
                    reportarUsuario();
                    limpiar();
                    txtDni.requestFocus();   

                } else {
                    error("HAY PROBLEMAS");
                }
            }
        } else {
            error("FALTA EL DNI");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbTienda;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_usuario;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtDirecciom;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtId_tipo_usuario;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
