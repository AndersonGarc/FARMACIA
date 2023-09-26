package CapaPresentacion;

import CapaDatos.Categoria;
import CapaDatos.Marca;
import CapaDatos.Medida;
import CapaDatos.Producto;
import CapaNegocio.CategoriaBD;
import CapaNegocio.MarcaBD;
import CapaNegocio.MedidaBD;
import CapaNegocio.ProductoBD;
import static CapaPresentacion.Menu_IU.escritorio;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDER
 */
public class Producto_IU extends javax.swing.JInternalFrame {
    
    List<Categoria> lista_categoria;
    List<Marca> lista_marca;
    List<Medida> lista_medida;
    
    public Producto_IU() {
        initComponents();
        cargar_categoria();
        cargar_marca();
        cargar_medida();
        txtCategoria.setEnabled(false);
        txtMarca.setEnabled(false);
        txtMedida.setEnabled(false);
        txtCantidad.setEnabled(false);
        reportar();
        desabilitar_botones();
    }
    
    private void desabilitar_botones() {
        btnRegistrar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    private void habilitar_botones() {
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnBuscar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }
    
    public void limpiar() {
        cmbCategoria.setSelectedIndex(0);
        cmbMedida.setSelectedIndex(0);
        cmbLaboratorio.setSelectedIndex(0);
        
        txtSerie.setText("");
        txtDescripcion.setText("");
        txtObservacion.setText("");
        txtDigemi.setText("");
        txtCategoria.setText("");
        txtMarca.setText("");
        txtMedida.setText("");
    }
    
    private void cargar_categoria() {
        try {
            cmbCategoria.removeAllItems();
            CategoriaBD o_CategoriaBD = new CategoriaBD();
            lista_categoria = o_CategoriaBD.reportarCategoria();
            
            cmbCategoria.addItem("Seleccionar");
            for (int i = 0; i < lista_categoria.size(); i++) {
                
                String nombre = lista_categoria.get(i).getCaNombre();
                
                cmbCategoria.addItem(nombre);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error al cargar la categoria", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limpiar_tabla_formulario() {
        DefaultTableModel tabla_temporal_productos = (DefaultTableModel) tabla_reporte_producto.getModel();
        tabla_temporal_productos.setRowCount(0);
    }
    
    private void cargar_marca() {
        try {
            cmbLaboratorio.removeAllItems();
            MarcaBD o_MarcaBD = new MarcaBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = o_MarcaBD.reportarMarca();
            
            lista_marca = new ArrayList<>();
            
            cmbLaboratorio.addItem("Seleccionar");
            for (int i = 0; i < tabla_temporal.getRowCount(); i++) {
                
                int codigo = Integer.valueOf(tabla_temporal.getValueAt(i, 0).toString());
                String nombre = String.valueOf(tabla_temporal.getValueAt(i, 1));
                
                lista_marca.add(new Marca(codigo, nombre));
                cmbLaboratorio.addItem(nombre);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error al cargar la marca", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cargar_medida() {
        try {
            cmbMedida.removeAllItems();
            MedidaBD o_MarcaBD = new MedidaBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = o_MarcaBD.reportarMedida();
            
            lista_medida = new ArrayList<>();
            
            cmbMedida.addItem("Seleccionar");
            for (int i = 0; i < tabla_temporal.getRowCount(); i++) {
                
                int codigo = Integer.valueOf(tabla_temporal.getValueAt(i, 0).toString());
                String presentacion = String.valueOf(tabla_temporal.getValueAt(i, 1));
                String equivalencia = String.valueOf(tabla_temporal.getValueAt(i, 2));
                
                lista_medida.add(new Medida(codigo, presentacion, equivalencia));
                cmbMedida.addItem(presentacion);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error al cargar la medida", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void reportar() {
        try {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            limpiar_tabla_formulario();
            DefaultTableModel tabla_temporal;
            ProductoBD o_ProductoBD = new ProductoBD();
            tabla_temporal = o_ProductoBD.reportarProducto();
            int cantidad_productos_encontrados = tabla_temporal.getRowCount();
            txtCantidad.setText("" + cantidad_productos_encontrados);
            DefaultTableModel tabla_temporal_productos = (DefaultTableModel) this.tabla_reporte_producto.getModel();
            for (int i = 0; i < cantidad_productos_encontrados; i++) {
                String serie = tabla_temporal.getValueAt(i, 0).toString();
                String descripcion = tabla_temporal.getValueAt(i, 1).toString();
                String observacion = tabla_temporal.getValueAt(i, 2).toString();
                String digemi = tabla_temporal.getValueAt(i, 3).toString();
                String condicion = tabla_temporal.getValueAt(i, 4).toString();
                String categoria = tabla_temporal.getValueAt(i, 5).toString();
                String marca = tabla_temporal.getValueAt(i, 6).toString();
                String medida = tabla_temporal.getValueAt(i, 7).toString();
                
                Object[] data = {serie, descripcion, observacion, digemi, condicion, categoria, marca, medida};
                tabla_temporal_productos.addRow(data);
            }
            tabla_reporte_producto.setModel(tabla_temporal_productos);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            e.printStackTrace();
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtObservacion = new javax.swing.JTextField();
        txtDigemi = new javax.swing.JTextField();
        cmbCategoria = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbCondicion = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_producto = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        cmbLaboratorio = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbMedida = new javax.swing.JComboBox<>();
        txtCategoria = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtMedida = new javax.swing.JTextField();
        btnComposicion = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("MANTENIMIENTO DE PRODUCTOS");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("SERIE");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("DESCRIPCION");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("OBSERVACION");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("DIGEMI");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("CATEGORIA");

        txtSerie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSerieFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSerieFocusLost(evt);
            }
        });
        txtSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerieActionPerformed(evt);
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

        txtDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescripcionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescripcionFocusLost(evt);
            }
        });
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        txtObservacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtObservacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtObservacionFocusLost(evt);
            }
        });
        txtObservacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtObservacionKeyTyped(evt);
            }
        });

        txtDigemi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDigemiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDigemiFocusLost(evt);
            }
        });
        txtDigemi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDigemiActionPerformed(evt);
            }
        });

        cmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoriaItemStateChanged(evt);
            }
        });
        cmbCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbCategoriaKeyPressed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Productos"));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("PRODUCTO");

        txtProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductoFocusLost(evt);
            }
        });
        txtProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductoActionPerformed(evt);
            }
        });
        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProducto)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("CONDICION");

        cmbCondicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORMAL" }));
        cmbCondicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbCondicionKeyPressed(evt);
            }
        });

        tabla_reporte_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SERIE", "DESCRIPCION", "OBSERVACION", "DIGEMI", "CONDICION", "CATEGORIA", "MARCA", "MEDIDA"
            }
        ));
        jScrollPane1.setViewportView(tabla_reporte_producto);

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("LABORATORIO");

        cmbLaboratorio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbLaboratorioItemStateChanged(evt);
            }
        });
        cmbLaboratorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbLaboratorioKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("MEDIDA");

        cmbMedida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMedidaItemStateChanged(evt);
            }
        });
        cmbMedida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbMedidaKeyPressed(evt);
            }
        });

        btnComposicion.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnComposicion.setText("COMPOSICION");
        btnComposicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComposicionActionPerformed(evt);
            }
        });

        jLabel10.setText("CANTIDAD");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNuevo.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/application.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/report_1.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/report_1.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/bin_empty_1.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCerrar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/cross_1.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/report_magnify.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRegistrar)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnComposicion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(11, 11, 11))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(23, 23, 23)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtObservacion)
                                .addComponent(txtDescripcion)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtDigemi, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(30, 30, 30)
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cmbCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cmbLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cmbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDigemi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(cmbCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(cmbLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(cmbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnComposicion)
                        .addComponent(jLabel10)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoriaItemStateChanged
        try {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                String textoSeleccionado = (String) cmbCategoria.getSelectedItem();
                
                if (textoSeleccionado.equals("Seleccionar")) {
                    txtCategoria.setText("");
                } else {
                    int i = cmbCategoria.getSelectedIndex() - 1;
                    txtCategoria.setText("" + lista_categoria.get(i).getIdCategoria());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "HUBO PROBLEMAS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmbCategoriaItemStateChanged

    private void cmbLaboratorioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbLaboratorioItemStateChanged
        try {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                
                String texto_Seleccionado = (String) cmbLaboratorio.getSelectedItem();
                if (texto_Seleccionado.equals("Seleccionar")) {
                    txtMarca.setText("");
                } else {
                    int i = cmbLaboratorio.getSelectedIndex() - 1;
                    txtMarca.setText("" + lista_marca.get(i).getIdmarca());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "HUBO PROBLEMILLAS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmbLaboratorioItemStateChanged

    private void cmbMedidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMedidaItemStateChanged
        try {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                
                String texto_Seleccionado = (String) cmbMedida.getSelectedItem();
                if (texto_Seleccionado.equals("Seleccionar")) {
                    txtMedida.setText("");
                } else {
                    int i = cmbMedida.getSelectedIndex() - 1;
                    txtMedida.setText("" + lista_medida.get(i).getIdmedida());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "HUBO PROBLEMILLAS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmbMedidaItemStateChanged

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            if (txtSerie.getText().length() > 0) {
                if (txtDescripcion.getText().length() > 0) {
                    if (txtCategoria.getText().length() > 0) {
                        if (txtMarca.getText().length() > 0) {
                            if (txtMedida.getText().length() > 0) {
                                Producto o_Producto = new Producto();
                                ProductoBD o_ProductoBD = new ProductoBD();
                                o_Producto.setpSerie(txtSerie.getText().trim());
                                o_Producto.setpDescripcion(txtDescripcion.getText().toUpperCase().trim());
                                o_Producto.setpObservacion(txtObservacion.getText().toUpperCase());
                                o_Producto.setDigemi(txtDigemi.getText().toUpperCase());
                                o_Producto.setpCondicion(cmbCondicion.getSelectedItem().toString());
                                o_Producto.setIdCategoria(Integer.parseInt(txtCategoria.getText()));
                                o_Producto.setIdmarca(Integer.parseInt(txtMarca.getText()));
                                o_Producto.setIdmedida(Integer.parseInt(txtMedida.getText()));
                                
                                boolean rpta = o_ProductoBD.registrarProducto(o_Producto);
                                if (rpta) {
                                    exito("Se registro con exito");
                                    reportar();
                                    limpiar();
                                    habilitar_botones();
                                    txtSerie.requestFocus();
                                } else {
                                    error("Tienes problemas");
                                }
                                
                            } else {
                                advertencia("Ingese una medida");
                            }
                        } else {
                            advertencia("Ingrse una marca");
                        }
                    } else {
                        advertencia("Ingrese una categoria");
                    }
                } else {
                    advertencia("Ingrese descripcion");
                    txtDescripcion.requestFocus();
                }
            } else {
                advertencia("Ingrese serie");
                txtSerie.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "HUBO PROBLEMILLAS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerieActionPerformed

    private void txtSerieFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerieFocusGained
        txtSerie.setBackground(Color.yellow);
    }//GEN-LAST:event_txtSerieFocusGained

    private void txtSerieFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerieFocusLost
        txtSerie.setBackground(Color.white);
    }//GEN-LAST:event_txtSerieFocusLost

    private void txtDescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionFocusGained
        txtDescripcion.setBackground(Color.yellow);
    }//GEN-LAST:event_txtDescripcionFocusGained

    private void txtDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionFocusLost
        txtDescripcion.setBackground(Color.white);
    }//GEN-LAST:event_txtDescripcionFocusLost

    private void txtObservacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtObservacionFocusGained
        txtObservacion.setBackground(Color.yellow);
    }//GEN-LAST:event_txtObservacionFocusGained

    private void txtObservacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtObservacionFocusLost
        txtObservacion.setBackground(Color.white);
    }//GEN-LAST:event_txtObservacionFocusLost

    private void txtDigemiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDigemiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDigemiActionPerformed

    private void txtDigemiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDigemiFocusGained
        txtDigemi.setBackground(Color.yellow);
    }//GEN-LAST:event_txtDigemiFocusGained

    private void txtDigemiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDigemiFocusLost
        txtDigemi.setBackground(Color.white);
    }//GEN-LAST:event_txtDigemiFocusLost

    private void txtSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtSerie.getText().length() >= 13) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSerieKeyTyped

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            if (txtSerie.getText().length() > 0) {
                String serie = txtSerie.getText();
                DefaultTableModel tabla_temporal;
                ProductoBD o_ProductoBD = new ProductoBD();
                tabla_temporal = o_ProductoBD.buscarProducto(serie);
                int cantidad_productos_encontrados = tabla_temporal.getRowCount();
                txtCantidad.setText("" + cantidad_productos_encontrados);
                limpiar_tabla_formulario();
                
                if (cantidad_productos_encontrados > 0) {
                    txtDescripcion.setText(tabla_temporal.getValueAt(0, 1).toString());
                    txtObservacion.setText(tabla_temporal.getValueAt(0, 2).toString());
                    txtDigemi.setText(tabla_temporal.getValueAt(0, 3).toString());
                    cmbCondicion.setSelectedItem(tabla_temporal.getValueAt(0, 4).toString());
                    cmbMedida.setSelectedItem(tabla_temporal.getValueAt(0, 7).toString());
                    cmbLaboratorio.setSelectedItem(tabla_temporal.getValueAt(0, 6).toString());
                    cmbCategoria.setSelectedItem(tabla_temporal.getValueAt(0, 5).toString());
                    txtMedida.setText(tabla_temporal.getValueAt(0, 10).toString());
                    txtCategoria.setText(tabla_temporal.getValueAt(0, 8).toString());
                    txtMarca.setText(tabla_temporal.getValueAt(0, 9).toString());
                    
                    DefaultTableModel tabla_temporal_producto = (DefaultTableModel) this.tabla_reporte_producto.getModel();
                    
                    for (int i = 0; i < cantidad_productos_encontrados; i++) {
                        serie = tabla_temporal.getValueAt(i, 0).toString();
                        String descripcion = tabla_temporal.getValueAt(i, 1).toString();
                        String observacion = tabla_temporal.getValueAt(i, 2).toString();
                        String digemi = tabla_temporal.getValueAt(i, 3).toString();
                        String condicion = tabla_temporal.getValueAt(i, 4).toString();
                        String categoria = tabla_temporal.getValueAt(i, 5).toString();
                        String marca = tabla_temporal.getValueAt(i, 6).toString();
                        String medida = tabla_temporal.getValueAt(i, 7).toString();
                        
                        Object[] data = {serie, descripcion, observacion, digemi, condicion, categoria, marca, medida};
                        tabla_temporal_producto.addRow(data);
                        txtSerie.requestFocus();
                        
                    }
                    tabla_reporte_producto.setModel(tabla_temporal_producto);
                } else {
                    error("no se encontraron los productos");
                }
                
            } else {
            }
        } catch (Exception e) {
            error("ingrese serie");
            txtSerie.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            if (txtSerie.getText().length() > 0) {
                if (txtDescripcion.getText().length() > 0) {
                    if (txtCategoria.getText().length() > 0) {
                        if (txtMarca.getText().length() > 0) {
                            if (txtMedida.getText().length() > 0) {
                                Producto o_Producto = new Producto();
                                ProductoBD o_ProductoBD = new ProductoBD();
                                
                                o_Producto.setpSerie(txtSerie.getText().trim());
                                o_Producto.setpDescripcion(txtDescripcion.getText().toUpperCase().trim());
                                o_Producto.setpObservacion(txtObservacion.getText().toUpperCase());
                                o_Producto.setDigemi(txtDigemi.getText().toUpperCase());
                                o_Producto.setpCondicion(cmbCondicion.getSelectedItem().toString());
                                o_Producto.setIdCategoria(Integer.parseInt(txtCategoria.getText()));
                                o_Producto.setIdmarca(Integer.parseInt(txtMarca.getText()));
                                o_Producto.setIdmedida(Integer.parseInt(txtMedida.getText()));
                                
                                boolean rpta = o_ProductoBD.modificarProducto(o_Producto);
                                if (rpta) {
                                    exito("Se modifico con exito");
                                    reportar();
                                    limpiar();
                                    desabilitar_botones();
                                    txtSerie.requestFocus();
                                } else {
                                    error("Tienes problemas");
                                }
                                
                            } else {
                                advertencia("Ingese una medida");
                            }
                        } else {
                            advertencia("Ingrse una marca");
                        }
                    } else {
                        advertencia("Ingrese una categoria");
                    }
                } else {
                    advertencia("Ingrese descripcion");
                    txtDescripcion.requestFocus();
                }
            } else {
                advertencia("Ingrese serie");
                txtSerie.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "HUBO PROBLEMILLAS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if (txtSerie.getText().length() > 0) {
                String serie = txtSerie.getText();
                int avsio = JOptionPane.showConfirmDialog(rootPane, "estas seguro de eliminar","CONFIRMACION",JOptionPane.YES_NO_OPTION);
                if (avsio == 0) {
                    ProductoBD o_ProductoBD = new ProductoBD();
                    boolean rpta = o_ProductoBD.eliminarProducto(serie);
                    if (rpta) {
                        exito("Se elimino con exito");
                        reportar();
                        limpiar();
                        desabilitar_botones();
                        txtSerie.requestFocus();
                    } else {
                        error("Tienes problemas");
                    }
                    
                } else {
                    txtSerie.requestFocus();
                }
                
            } else {
                error("falta el codigo del producto");
                txtSerie.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "HUBO PROBLEMILLAS PAPU", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyPressed
        limpiar_tabla_formulario();
        String descripcion = txtProducto.getText();
        DefaultTableModel tabla_temporal;
        DefaultTableModel tabla_temporal_producto = (DefaultTableModel) tabla_reporte_producto.getModel();
        ProductoBD o_ProductoBD = new ProductoBD();
        tabla_temporal = o_ProductoBD.buscarProductoDescripcion(descripcion);
        int cant = tabla_temporal.getRowCount();
        
        for (int i = 0; i < cant; i++) {
            String serie = tabla_temporal.getValueAt(i, 0).toString();
            descripcion = tabla_temporal.getValueAt(i, 1).toString();
            String observacion = tabla_temporal.getValueAt(i, 2).toString();
            String digemi = tabla_temporal.getValueAt(i, 3).toString();
            String condicion = tabla_temporal.getValueAt(i, 4).toString();
            String categoria = tabla_temporal.getValueAt(i, 5).toString();
            String marca = tabla_temporal.getValueAt(i, 6).toString();
            String medida = tabla_temporal.getValueAt(i, 7).toString();
            
            Object[] data = {serie, descripcion, observacion, digemi, condicion, categoria, marca, medida};
            tabla_temporal_producto.addRow(data);
        }
        tabla_reporte_producto.setModel(tabla_temporal_producto);
        txtCantidad.setText("" + cant);
    }//GEN-LAST:event_txtProductoKeyPressed

    private void txtProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductoFocusGained
        txtProducto.setBackground(Color.yellow);
    }//GEN-LAST:event_txtProductoFocusGained

    private void txtProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductoFocusLost
        txtProducto.setBackground(Color.white);
    }//GEN-LAST:event_txtProductoFocusLost

    private void txtObservacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObservacionKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtObservacionKeyTyped

    private void txtProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtProductoKeyTyped

    private void txtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        habilitar_botones();
        txtSerie.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
            char validar = evt.getKeyChar();
            if (Character.isDigit(validar)) {
                getToolkit().beep();
                evt.consume();
            }
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtSerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtDescripcion.requestFocus();
        }
    }//GEN-LAST:event_txtSerieKeyPressed

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cmbCategoria.requestFocus();
        }
    }//GEN-LAST:event_txtDescripcionKeyPressed

    private void cmbCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbCategoriaKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cmbCondicion.requestFocus();
        }
    }//GEN-LAST:event_cmbCategoriaKeyPressed

    private void cmbCondicionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbCondicionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cmbLaboratorio.requestFocus();
        }
    }//GEN-LAST:event_cmbCondicionKeyPressed

    private void cmbLaboratorioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbLaboratorioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cmbMedida.requestFocus();
        }
    }//GEN-LAST:event_cmbLaboratorioKeyPressed

    private void cmbMedidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbMedidaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
        }
    }//GEN-LAST:event_cmbMedidaKeyPressed

    private void btnRegistrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRegistrarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.doClick();
        }
    }//GEN-LAST:event_btnRegistrarKeyPressed

    private void btnComposicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComposicionActionPerformed
        TipoUsuario_IU frame = new TipoUsuario_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension framesize = frame.getSize();
        frame.setLocation((desktopSize.width - framesize.width) / 2, (desktopSize.height - framesize.height) / 2);
        frame.show();
    }//GEN-LAST:event_btnComposicionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnComposicion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbCondicion;
    private javax.swing.JComboBox<String> cmbLaboratorio;
    private javax.swing.JComboBox<String> cmbMedida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_producto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDigemi;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMedida;
    private javax.swing.JTextField txtObservacion;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
