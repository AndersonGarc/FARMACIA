package CapaPresentacion;

import java.awt.Dimension;
import javax.swing.JOptionPane;

public class Menu_IU extends javax.swing.JFrame {

    public Menu_IU() {
        initComponents();
        JOptionPane.showMessageDialog(null, "BIENVENIDO PAPU");
        menu_mantenimiento.setEnabled(false);
        menu_compras.setEnabled(false);
        menu_inventario.setEnabled(false);
        btnProductos.setEnabled(false);
        btnCompras.setEnabled(false);
        btnCerrar.setEnabled(false);
        btnUsuario.setEnabled(false);
        menu_ventas.setEnabled(false);
        menu_caja.setEnabled(false);
        btnIngresos.setEnabled(false);
        btnVentas.setEnabled(false);
        btnCaja.setEnabled(false);
        btnEgresos.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        btnUsuario = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnCompras = new javax.swing.JButton();
        btnIngresos = new javax.swing.JButton();
        btnEgresos = new javax.swing.JButton();
        btnCaja = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_mantenimiento = new javax.swing.JMenu();
        menu_item_turno = new javax.swing.JMenuItem();
        menu_item_usuario = new javax.swing.JMenuItem();
        menu_item_marca = new javax.swing.JMenuItem();
        menu_item_categoria = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menu_item_cuentas_bancarias = new javax.swing.JMenuItem();
        menu_compras = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menu_inventario = new javax.swing.JMenu();
        menu_ventas = new javax.swing.JMenu();
        menu_caja = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        escritorio.setBackground(new java.awt.Color(102, 102, 102));
        escritorio.setForeground(new java.awt.Color(0, 0, 0));

        jToolBar1.setRollover(true);

        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/usuario.png"))); // NOI18N
        btnUsuario.setFocusable(false);
        btnUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });
        jToolBar1.add(btnUsuario);

        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/productos.png"))); // NOI18N
        btnProductos.setFocusable(false);
        btnProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        jToolBar1.add(btnProductos);

        btnCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/ventas.png"))); // NOI18N
        btnCompras.setFocusable(false);
        btnCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnCompras);

        btnIngresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/dinero.png"))); // NOI18N
        btnIngresos.setFocusable(false);
        btnIngresos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIngresos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnIngresos);

        btnEgresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/reporte ventas.png"))); // NOI18N
        btnEgresos.setFocusable(false);
        btnEgresos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEgresos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnEgresos);

        btnCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/compras.png"))); // NOI18N
        btnCaja.setFocusable(false);
        btnCaja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCaja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnCaja);

        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Ventas_1.png"))); // NOI18N
        btnVentas.setFocusable(false);
        btnVentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVentas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnVentas);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/salir.png"))); // NOI18N
        btnCerrar.setFocusable(false);
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCerrar);

        escritorio.setLayer(jToolBar1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 251, Short.MAX_VALUE))
        );

        menu_mantenimiento.setText("MANTENIMIENTO");

        menu_item_turno.setText("TURNO");
        menu_item_turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_turnoActionPerformed(evt);
            }
        });
        menu_mantenimiento.add(menu_item_turno);

        menu_item_usuario.setText("TIPO DE USUARIO");
        menu_item_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_usuarioActionPerformed(evt);
            }
        });
        menu_mantenimiento.add(menu_item_usuario);

        menu_item_marca.setText("MARCA");
        menu_item_marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_marcaActionPerformed(evt);
            }
        });
        menu_mantenimiento.add(menu_item_marca);

        menu_item_categoria.setText("CATEGORIA");
        menu_item_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_categoriaActionPerformed(evt);
            }
        });
        menu_mantenimiento.add(menu_item_categoria);

        jMenuItem1.setText("MEDIDA");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu_mantenimiento.add(jMenuItem1);

        jMenuItem3.setText("COMPOSICION");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menu_mantenimiento.add(jMenuItem3);

        jMenuItem2.setText("PROVEEDOR");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menu_mantenimiento.add(jMenuItem2);

        menu_item_cuentas_bancarias.setText("CUENTAS BANCARIAS");
        menu_item_cuentas_bancarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_cuentas_bancariasActionPerformed(evt);
            }
        });
        menu_mantenimiento.add(menu_item_cuentas_bancarias);

        jMenuBar1.add(menu_mantenimiento);

        menu_compras.setText("COMPRAS");
        menu_compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_comprasActionPerformed(evt);
            }
        });

        jMenuItem4.setText("REALIZAR COMPRA");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menu_compras.add(jMenuItem4);

        jMenuItem5.setText("REPORT DE COMPRAS VARIOS");
        menu_compras.add(jMenuItem5);

        jMenuBar1.add(menu_compras);

        menu_inventario.setText("INVENTARIO");
        jMenuBar1.add(menu_inventario);

        menu_ventas.setText("VENTAS");
        jMenuBar1.add(menu_ventas);

        menu_caja.setText("CAJA");
        jMenuBar1.add(menu_caja);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_item_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_usuarioActionPerformed
        TipoUsuario_IU frame = new TipoUsuario_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension framesize = frame.getSize();
        frame.setLocation((desktopSize.width - framesize.width) / 2, (desktopSize.height - framesize.height) / 2);
        frame.show();
    }//GEN-LAST:event_menu_item_usuarioActionPerformed

    private void menu_item_turnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_turnoActionPerformed
        turno_IU frame = new turno_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension framesize = frame.getSize();
        frame.setLocation((desktopSize.width - framesize.width) / 2, (desktopSize.height - framesize.height) / 2);
        frame.show();
    }//GEN-LAST:event_menu_item_turnoActionPerformed

    private void menu_item_marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_marcaActionPerformed
        Marca_IU frame = new Marca_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension framesize = frame.getSize();
        frame.setLocation((desktopSize.width - framesize.width) / 2, (desktopSize.height - framesize.height) / 2);
        frame.show();
    }//GEN-LAST:event_menu_item_marcaActionPerformed

    private void menu_item_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_categoriaActionPerformed
        Categoria_IU frame = new Categoria_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension framesize = frame.getSize();
        frame.setLocation((desktopSize.width - framesize.width) / 2, (desktopSize.height - framesize.height) / 2);
        frame.show();
    }//GEN-LAST:event_menu_item_categoriaActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        Producto_IU frame = new Producto_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension framesize = frame.getSize();
        frame.setLocation((desktopSize.width - framesize.width) / 2, (desktopSize.height - framesize.height) / 2);
        frame.show();
    }//GEN-LAST:event_btnProductosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Medida_IU frame = new Medida_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension framesize = frame.getSize();
        frame.setLocation((desktopSize.width - framesize.width) / 2, (desktopSize.height - framesize.height) / 2);
        frame.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        Usuario_IU frame = new Usuario_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension framesize = frame.getSize();
        frame.setLocation((desktopSize.width - framesize.width) / 2, (desktopSize.height - framesize.height) / 2);
        frame.show();
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Composicion_IU frame = new Composicion_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension framesize = frame.getSize();
        frame.setLocation((desktopSize.width - framesize.width) / 2, (desktopSize.height - framesize.height) / 2);
        frame.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Proveedor_IU frame = new Proveedor_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension framesize = frame.getSize();
        frame.setLocation((desktopSize.width - framesize.width) / 2, (desktopSize.height - framesize.height) / 2);
        frame.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menu_item_cuentas_bancariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_cuentas_bancariasActionPerformed
        CuentasBancarias_IU frame = new CuentasBancarias_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension framesize = frame.getSize();
        frame.setLocation((desktopSize.width - framesize.width) / 2, (desktopSize.height - framesize.height) / 2);
        frame.show();
    }//GEN-LAST:event_menu_item_cuentas_bancariasActionPerformed

    private void menu_comprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_comprasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_comprasActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Compra_IU frame = new Compra_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension framesize = frame.getSize();
        frame.setLocation((desktopSize.width - framesize.width) / 2, (desktopSize.height - framesize.height) / 2);
        frame.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_IU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCaja;
    public javax.swing.JButton btnCerrar;
    public javax.swing.JButton btnCompras;
    public javax.swing.JButton btnEgresos;
    public javax.swing.JButton btnIngresos;
    public javax.swing.JButton btnProductos;
    public javax.swing.JButton btnUsuario;
    public javax.swing.JButton btnVentas;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JToolBar jToolBar1;
    public javax.swing.JMenu menu_caja;
    public javax.swing.JMenu menu_compras;
    public javax.swing.JMenu menu_inventario;
    private javax.swing.JMenuItem menu_item_categoria;
    private javax.swing.JMenuItem menu_item_cuentas_bancarias;
    private javax.swing.JMenuItem menu_item_marca;
    private javax.swing.JMenuItem menu_item_turno;
    private javax.swing.JMenuItem menu_item_usuario;
    public javax.swing.JMenu menu_mantenimiento;
    public javax.swing.JMenu menu_ventas;
    // End of variables declaration//GEN-END:variables
}
