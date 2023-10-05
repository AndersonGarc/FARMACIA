package CapaPresentacion;
import CapaNegocio.CompraBD;
import CapaNegocio.DetalleCompraBD;
import CapaNegocio.ProveedorBD;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDER
 */
public class ReporteComprasVarios_IU extends javax.swing.JInternalFrame {
    
    DefaultTableModel tabla_temporal_compras, tabla_temporal_detalle_compras;
    
    public ReporteComprasVarios_IU() {
        initComponents();
        cargarProveedores();
    }
    
    private void cargarProveedores() {
        try {
            cmbProveedor.removeAllItems();
            ProveedorBD o_ProveedorBD = new ProveedorBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = o_ProveedorBD.reportarProveedor();
            cmbProveedor.addItem("Seleccionar");
            
            for (int i = 0; i < tabla_temporal.getRowCount(); i++) {
                String proveedor = String.valueOf(tabla_temporal.getValueAt(i, 1));
                cmbProveedor.addItem(proveedor);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al cargar proveedor", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limpiar_tabla_formulario() {
        tabla_temporal_compras = (DefaultTableModel) tabla_reporte_compras.getModel();
        tabla_temporal_compras.setRowCount(0);
        
        tabla_temporal_detalle_compras = (DefaultTableModel) tabla_reporte_detalle_compas.getModel();
        tabla_temporal_detalle_compras.setRowCount(0);
    }
    
    private void advertencia(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "ADVERTENCIA", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
    }
    
    private double dineroGastado() {
        tabla_temporal_compras = (DefaultTableModel) tabla_reporte_compras.getModel();
        int maxPedidos = tabla_temporal_compras.getRowCount();
        double total = 0;
        for (int i = 0; i < maxPedidos; i++) {
            total = total + Double.parseDouble(tabla_temporal_compras.getValueAt(i, 8).toString());
        }
        return total;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dcFecha_inicio_fecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        dcFecha_final_fecha = new com.toedter.calendar.JDateChooser();
        btnBuscar_compra_fecha = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnRliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        dcFecha_inicio_documento = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        dcFecha_final_documento = new com.toedter.calendar.JDateChooser();
        cmbDocumento = new javax.swing.JComboBox<>();
        btnBuscar_documento = new javax.swing.JButton();
        btnImrpimir_documento = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtTotal_compras_documento = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        dcFecha_inicio_proveedor = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        dcFecha_fin_proveedor = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox<>();
        btnBuscar_compras_proveedor = new javax.swing.JButton();
        btnimprimir_compra_Proveedor = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtTtal_compras_proveedor = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_compras = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_reporte_detalle_compas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jInternalFrame2.setVisible(true);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jLabel6.setText("jLabel6");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("REPORTE DE COMPRAS");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("FECHA INICIO");

        jLabel2.setText("FECHA FINAL");

        btnBuscar_compra_fecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/lupa.gif"))); // NOI18N
        btnBuscar_compra_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar_compra_fechaActionPerformed(evt);
            }
        });

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/computer_go.png"))); // NOI18N
        btnImprimir.setText("IMPRIMIR");

        btnRliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/bin_empty_2.png"))); // NOI18N
        btnRliminar.setText("ELIMINAR");
        btnRliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcFecha_inicio_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcFecha_final_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar_compra_fecha)
                .addGap(18, 18, 18)
                .addComponent(btnImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 390, Short.MAX_VALUE)
                .addComponent(btnRliminar)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dcFecha_inicio_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(dcFecha_final_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRliminar)
                        .addComponent(btnImprimir))
                    .addComponent(btnBuscar_compra_fecha))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("COMPRA X FECHA", jPanel1);

        jLabel4.setText("FECHA INICIO");

        jLabel5.setText("FECHA FINAL");

        cmbDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BOLETA", "FACTURA" }));
        cmbDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbDocumentoKeyPressed(evt);
            }
        });

        btnBuscar_documento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/lupa.gif"))); // NOI18N
        btnBuscar_documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar_documentoActionPerformed(evt);
            }
        });
        btnBuscar_documento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscar_documentoKeyPressed(evt);
            }
        });

        btnImrpimir_documento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/computer_go.png"))); // NOI18N
        btnImrpimir_documento.setText("IMPRIMIR");

        jLabel7.setText("TOTAL COMPRAS");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/coins_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcFecha_inicio_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcFecha_final_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar_documento)
                .addGap(33, 33, 33)
                .addComponent(btnImrpimir_documento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal_compras_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBuscar_documento, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnImrpimir_documento)
                            .addComponent(txtTotal_compras_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(dcFecha_final_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(dcFecha_inicio_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("COMPRA X DOCUMENTO", jPanel2);

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("FECHA INICIO");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("FECHA FINAL");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel10.setText("PROVEEDOR");

        cmbProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbProveedorKeyPressed(evt);
            }
        });

        btnBuscar_compras_proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/lupa.gif"))); // NOI18N
        btnBuscar_compras_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar_compras_proveedorActionPerformed(evt);
            }
        });
        btnBuscar_compras_proveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscar_compras_proveedorKeyPressed(evt);
            }
        });

        btnimprimir_compra_Proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/computer_go.png"))); // NOI18N
        btnimprimir_compra_Proveedor.setText("IMPRIMIR");

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel11.setText("TOTAL COMPRAS");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/coins_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcFecha_inicio_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcFecha_fin_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar_compras_proveedor)
                .addGap(18, 18, 18)
                .addComponent(btnimprimir_compra_Proveedor)
                .addGap(38, 38, 38)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTtal_compras_proveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnimprimir_compra_Proveedor)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar_compras_proveedor)
                        .addComponent(jLabel11)
                        .addComponent(txtTtal_compras_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dcFecha_fin_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(dcFecha_inicio_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("COMPRA X PROVEEDOR", jPanel3);

        tabla_reporte_compras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "FECHA", "RUC", "PROVEEDOR", "DOCUMENTO", "CORRELATIVO", "TIPOPAGO", "FORMAPAGO", "TOTAL", "USUARIO", "TEINDA"
            }
        ));
        tabla_reporte_compras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_reporte_comprasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_reporte_compras);
        if (tabla_reporte_compras.getColumnModel().getColumnCount() > 0) {
            tabla_reporte_compras.getColumnModel().getColumn(0).setMinWidth(50);
            tabla_reporte_compras.getColumnModel().getColumn(0).setMaxWidth(70);
            tabla_reporte_compras.getColumnModel().getColumn(1).setMinWidth(80);
            tabla_reporte_compras.getColumnModel().getColumn(1).setMaxWidth(200);
            tabla_reporte_compras.getColumnModel().getColumn(2).setMinWidth(100);
            tabla_reporte_compras.getColumnModel().getColumn(2).setMaxWidth(200);
            tabla_reporte_compras.getColumnModel().getColumn(3).setMinWidth(250);
            tabla_reporte_compras.getColumnModel().getColumn(3).setMaxWidth(200);
            tabla_reporte_compras.getColumnModel().getColumn(4).setMinWidth(100);
            tabla_reporte_compras.getColumnModel().getColumn(4).setMaxWidth(200);
            tabla_reporte_compras.getColumnModel().getColumn(5).setMinWidth(120);
            tabla_reporte_compras.getColumnModel().getColumn(5).setMaxWidth(200);
            tabla_reporte_compras.getColumnModel().getColumn(6).setMinWidth(120);
            tabla_reporte_compras.getColumnModel().getColumn(6).setMaxWidth(200);
            tabla_reporte_compras.getColumnModel().getColumn(7).setMinWidth(120);
            tabla_reporte_compras.getColumnModel().getColumn(7).setMaxWidth(200);
            tabla_reporte_compras.getColumnModel().getColumn(8).setMinWidth(50);
            tabla_reporte_compras.getColumnModel().getColumn(8).setMaxWidth(70);
            tabla_reporte_compras.getColumnModel().getColumn(9).setMinWidth(60);
            tabla_reporte_compras.getColumnModel().getColumn(9).setMaxWidth(200);
            tabla_reporte_compras.getColumnModel().getColumn(10).setMinWidth(80);
            tabla_reporte_compras.getColumnModel().getColumn(10).setMaxWidth(200);
        }

        tabla_reporte_detalle_compas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabla_reporte_detalle_compas);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("DETALLE DE COMPRA");

        jButton1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/cross.png"))); // NOI18N
        jButton1.setText("CERRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jScrollPane2)
                        .addComponent(jScrollPane1)
                        .addComponent(jTabbedPane2)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscar_compra_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar_compra_fechaActionPerformed
        try {
            limpiar_tabla_formulario();
            CompraBD o_CompraBD = new CompraBD();
            SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
            
            if (dcFecha_final_fecha.getDate() != null) {
                if (dcFecha_inicio_fecha.getDate() != null) {
                    setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
                    String fechaInicio = dcn.format(dcFecha_inicio_fecha.getDate());
                    String fechaFinal = dcn.format(dcFecha_final_fecha.getDate());
                    DefaultTableModel tabla_temporal;
                    tabla_temporal = o_CompraBD.reporteCompraFecha(fechaInicio, fechaFinal);
                    
                    int cant = tabla_temporal.getRowCount();
                    for (int i = 0; i < cant; i++) {
                        String idcompra = tabla_temporal.getValueAt(i, 0).toString();
                        String fecha = tabla_temporal.getValueAt(i, 1).toString();
                        String ruc = tabla_temporal.getValueAt(i, 12).toString();
                        String proveedor = tabla_temporal.getValueAt(i, 2).toString();
                        String documento = tabla_temporal.getValueAt(i, 3).toString();
                        String correlativo = tabla_temporal.getValueAt(i, 4).toString();
                        String tipo_pago = tabla_temporal.getValueAt(i, 5).toString();
                        String forma_pago = tabla_temporal.getValueAt(i, 6).toString();
                        String total = tabla_temporal.getValueAt(i, 11).toString();
                        String tienda = Login_IU.tienda;
                        String uDni = Login_IU.dni_publico;
                        Object[] data = {idcompra, fecha, ruc, proveedor, documento, correlativo, tipo_pago, forma_pago, total, uDni, tienda};
                        tabla_temporal_compras.addRow(data);
                    }
                    tabla_reporte_compras.setModel(tabla_temporal_compras);
                    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                } else {
                    advertencia("Ingrese la fecha final");
                    dcFecha_inicio_fecha.requestFocus();
                }
            } else {
                advertencia("Ingrese la fecha inicio");
                dcFecha_final_fecha.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar compras por fecha", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscar_compra_fechaActionPerformed

    private void tabla_reporte_comprasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reporte_comprasMousePressed
        int fila_seleccionada = tabla_reporte_compras.getSelectedRow();
        DetalleCompraBD o_DetalleCompraBD = new DetalleCompraBD();
        int idcompra = Integer.parseInt(tabla_temporal_compras.getValueAt(fila_seleccionada, 0).toString());
        tabla_temporal_detalle_compras = o_DetalleCompraBD.buscarDetalleCompra(idcompra);
        tabla_reporte_detalle_compas.setModel(tabla_temporal_detalle_compras);
    }//GEN-LAST:event_tabla_reporte_comprasMousePressed

    private void btnBuscar_documentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar_documentoActionPerformed
        try {
            limpiar_tabla_formulario();
            CompraBD o_CompraBD = new CompraBD();
            SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
            if (dcFecha_inicio_documento.getDate() != null) {
                if (dcFecha_final_documento.getDate() != null) {
                    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                    String fechaInicio = dcn.format(dcFecha_inicio_documento.getDate());
                    String fechaFinal = dcn.format(dcFecha_final_documento.getDate());
                    String documento = cmbDocumento.getSelectedItem().toString();
                    DefaultTableModel tabla_temporal;
                    tabla_temporal = o_CompraBD.reporteCompraXdocumento(fechaInicio, fechaFinal, documento);
                    int cant = tabla_temporal.getRowCount();
                    
                    for (int i = 0; i < cant; i++) {
                        String idcompra = tabla_temporal.getValueAt(i, 0).toString();
                        String fecha = tabla_temporal.getValueAt(i, 1).toString();
                        String ruc = tabla_temporal.getValueAt(i, 12).toString();
                        String proveedor = tabla_temporal.getValueAt(i, 2).toString();
                        documento = tabla_temporal.getValueAt(i, 3).toString();
                        String correlativo = tabla_temporal.getValueAt(i, 4).toString();
                        String tipo_pago = tabla_temporal.getValueAt(i, 5).toString();
                        String forma_pago = tabla_temporal.getValueAt(i, 6).toString();
                        String total = tabla_temporal.getValueAt(i, 11).toString();
                        String tienda = Login_IU.tienda;
                        String uDni = Login_IU.dni_publico;
                        Object[] data = {idcompra, fecha, ruc, proveedor, documento, correlativo, tipo_pago, forma_pago, total, uDni, tienda};
                        tabla_temporal_compras.addRow(data);
                        tabla_reporte_compras.setModel(tabla_temporal_compras);
                        double total_compras_documento = dineroGastado();
                        BigDecimal numero = new BigDecimal(total_compras_documento);
                        BigDecimal decimal_compras = numero.setScale(2, RoundingMode.DOWN);
                        
                        txtTotal_compras_documento.setText("" + decimal_compras);
                        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                    }
                } else {
                    advertencia("Ingrese la fecha final");
                    dcFecha_final_documento.requestFocus();
                }
            } else {
                advertencia("Ingrese la fecha final");
                dcFecha_inicio_documento.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar compra por documento", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscar_documentoActionPerformed

    private void btnBuscar_compras_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar_compras_proveedorActionPerformed
        try {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            limpiar_tabla_formulario();
            CompraBD o_CompraBD = new CompraBD();
            SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
            if (dcFecha_inicio_proveedor.getDate() != null) {
                if (dcFecha_fin_proveedor.getDate() != null) {
                    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                    String fechaInicio = dcn.format(dcFecha_inicio_proveedor.getDate());
                    String fechaFinal = dcn.format(dcFecha_fin_proveedor.getDate());
                    String proveedor = cmbProveedor.getSelectedItem().toString();
                    DefaultTableModel tabla_temporal;
                    tabla_temporal = o_CompraBD.reporteCompraXproveedor(fechaInicio, fechaFinal, proveedor);
                    int cant = tabla_temporal.getRowCount();
                    
                    for (int i = 0; i < cant; i++) {
                        String idcompra = tabla_temporal.getValueAt(i, 0).toString();
                        String fecha = tabla_temporal.getValueAt(i, 1).toString();
                        String ruc = tabla_temporal.getValueAt(i, 12).toString();
                        proveedor = tabla_temporal.getValueAt(i, 2).toString();
                        String documento = tabla_temporal.getValueAt(i, 3).toString();
                        String correlativo = tabla_temporal.getValueAt(i, 4).toString();
                        String tipo_pago = tabla_temporal.getValueAt(i, 5).toString();
                        String forma_pago = tabla_temporal.getValueAt(i, 6).toString();
                        String total = tabla_temporal.getValueAt(i, 11).toString();
                        String tienda = Login_IU.tienda;
                        String uDni = Login_IU.dni_publico;
                        Object[] data = {idcompra, fecha, ruc, proveedor, documento, correlativo, tipo_pago, forma_pago, total, uDni, tienda};
                        tabla_temporal_compras.addRow(data);
                        tabla_reporte_compras.setModel(tabla_temporal_compras);
                        double total_compras_proveedor = dineroGastado();
                        BigDecimal numero = new BigDecimal(total_compras_proveedor);
                        BigDecimal decimal_compras = numero.setScale(2, RoundingMode.DOWN);
                        
                        txtTtal_compras_proveedor.setText("" + decimal_compras);
                        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                    }
                } else {
                    advertencia("Ingrese la fecha final");
                    dcFecha_fin_proveedor.requestFocus();
                }
            } else {
                advertencia("Ingrese la fecha inicio");
                dcFecha_inicio_proveedor.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar compra por proveedor", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscar_compras_proveedorActionPerformed

    private void btnRliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRliminarActionPerformed
        int fila_seleccionada = tabla_reporte_compras.getSelectedRow();
        int aviso = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de elimianr");
        if (fila_seleccionada > -1) {
            if (aviso == 0) {
                CompraBD o_CompraBD = new CompraBD();
                DetalleCompraBD o_DetalleCompraBD = new DetalleCompraBD();
                int idcompra = Integer.parseInt(tabla_reporte_compras.getValueAt(fila_seleccionada, 0).toString());
                boolean rpta1 = o_DetalleCompraBD.eliminarCompraXfecha(idcompra);
                boolean rpta = o_CompraBD.eliminarCompra(idcompra);
                if (rpta) {
                    advertencia("se elimino su compra");
                    limpiar_tabla_formulario();
                } else {
                    advertencia("Tienes problemas al eliminar" + rpta + rpta1);
                }
            }
        } else {
            advertencia("Seleccionar una fila para saber que la compra quiere eliminar...");
        }
    }//GEN-LAST:event_btnRliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbProveedorKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscar_compras_proveedor.requestFocus();
        }
    }//GEN-LAST:event_cmbProveedorKeyPressed

    private void btnBuscar_compras_proveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscar_compras_proveedorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscar_compras_proveedor.doClick();
        }
    }//GEN-LAST:event_btnBuscar_compras_proveedorKeyPressed

    private void cmbDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbDocumentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscar_documento.requestFocus();
        }
    }//GEN-LAST:event_cmbDocumentoKeyPressed

    private void btnBuscar_documentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscar_documentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscar_documento.doClick();
        }
    }//GEN-LAST:event_btnBuscar_documentoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar_compra_fecha;
    private javax.swing.JButton btnBuscar_compras_proveedor;
    private javax.swing.JButton btnBuscar_documento;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnImrpimir_documento;
    private javax.swing.JButton btnRliminar;
    private javax.swing.JButton btnimprimir_compra_Proveedor;
    private javax.swing.JComboBox<String> cmbDocumento;
    private javax.swing.JComboBox<String> cmbProveedor;
    private com.toedter.calendar.JDateChooser dcFecha_fin_proveedor;
    private com.toedter.calendar.JDateChooser dcFecha_final_documento;
    private com.toedter.calendar.JDateChooser dcFecha_final_fecha;
    private com.toedter.calendar.JDateChooser dcFecha_inicio_documento;
    private com.toedter.calendar.JDateChooser dcFecha_inicio_fecha;
    private com.toedter.calendar.JDateChooser dcFecha_inicio_proveedor;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tabla_reporte_compras;
    private javax.swing.JTable tabla_reporte_detalle_compas;
    private javax.swing.JTextField txtTotal_compras_documento;
    private javax.swing.JTextField txtTtal_compras_proveedor;
    // End of variables declaration//GEN-END:variables
}
