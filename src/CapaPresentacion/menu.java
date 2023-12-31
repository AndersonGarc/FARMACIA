package CapaPresentacion;
import java.awt.Dimension;

public class menu extends javax.swing.JFrame {

    public menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        jButton5 = new javax.swing.JButton();
        menu_item_producto = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu_item_turno = new javax.swing.JMenuItem();
        menu_item_tipo_usuario = new javax.swing.JMenuItem();
        menu_item_usuario = new javax.swing.JMenuItem();
        menu_item_marca = new javax.swing.JMenuItem();
        menu_item_categoria = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        escritorio.setBackground(new java.awt.Color(0, 0, 0));
        escritorio.setForeground(new java.awt.Color(0, 0, 0));

        jToolBar1.setRollover(true);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/usuario.png"))); // NOI18N
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);

        menu_item_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/productos.png"))); // NOI18N
        menu_item_producto.setFocusable(false);
        menu_item_producto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menu_item_producto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        menu_item_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_productoActionPerformed(evt);
            }
        });
        jToolBar1.add(menu_item_producto);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/dinero.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/ventas.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/salir.png"))); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        escritorio.setLayer(jToolBar1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 206, Short.MAX_VALUE))
        );

        jMenu1.setText("MANTENIMIENTO");

        menu_item_turno.setText("TURNO");
        menu_item_turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_turnoActionPerformed(evt);
            }
        });
        jMenu1.add(menu_item_turno);

        menu_item_tipo_usuario.setText("USUARIO");
        menu_item_tipo_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_tipo_usuarioActionPerformed(evt);
            }
        });
        jMenu1.add(menu_item_tipo_usuario);

        menu_item_usuario.setText("TIPO DE USUARIO");
        menu_item_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_usuarioActionPerformed(evt);
            }
        });
        jMenu1.add(menu_item_usuario);

        menu_item_marca.setText("MARCA");
        menu_item_marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_marcaActionPerformed(evt);
            }
        });
        jMenu1.add(menu_item_marca);

        menu_item_categoria.setText("CATEGORIA");
        menu_item_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_categoriaActionPerformed(evt);
            }
        });
        jMenu1.add(menu_item_categoria);

        jMenuItem1.setText("MEDIDA");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

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

    private void menu_item_tipo_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_tipo_usuarioActionPerformed
        Usuario_IU frame = new Usuario_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension framesize = frame.getSize();
        frame.setLocation((desktopSize.width - framesize.width) / 2, (desktopSize.height - framesize.height) / 2);
        frame.show();
    }//GEN-LAST:event_menu_item_tipo_usuarioActionPerformed

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void menu_item_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_productoActionPerformed
        Producto_IU frame = new Producto_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension framesize = frame.getSize();
        frame.setLocation((desktopSize.width - framesize.width) / 2, (desktopSize.height - framesize.height) / 2);
        frame.show();
    }//GEN-LAST:event_menu_item_productoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Medida_IU frame = new Medida_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension framesize = frame.getSize();
        frame.setLocation((desktopSize.width - framesize.width) / 2, (desktopSize.height - framesize.height) / 2);
        frame.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem menu_item_categoria;
    private javax.swing.JMenuItem menu_item_marca;
    private javax.swing.JButton menu_item_producto;
    private javax.swing.JMenuItem menu_item_tipo_usuario;
    private javax.swing.JMenuItem menu_item_turno;
    private javax.swing.JMenuItem menu_item_usuario;
    // End of variables declaration//GEN-END:variables
}
