/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.juanma.profitfront.interfaz.secondLayer;

import com.juanma.profitfront.Services.ApiClient;
import com.juanma.profitfront.interfaz.thirdLayer.DlgAgregarProducto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.juanma.profitfront.Models.response.ProductoResponse;
import javax.swing.table.DefaultTableModel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import com.juanma.profitfront.Models.response.ProductoResponse;
import java.lang.reflect.Type;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author juanm
 */
public class FrmProductos extends javax.swing.JFrame {

    private TableRowSorter<DefaultTableModel> sorter;
    
    /**
     * Creates new form FrmProductos
     */
    public FrmProductos() {
        initComponents();
        configurarTabla();
        configurarComboFiltrado();
        cargarProductos();
    }
    
    private void configurarTabla() {
        // Configurar modelo de tabla
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer la tabla no editable
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // Para que las columnas numéricas se alineen correctamente
                if (columnIndex == 0 || columnIndex == 4) {
                    return Integer.class;
                } else if (columnIndex == 6 || columnIndex == 7) {
                    return Double.class;
                }
                return String.class;
            }
        };
        
        model.addColumn("ID");
        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Descripción");
        model.addColumn("Stock");
        model.addColumn("Proveedor");
        model.addColumn("Precio Compra");
        model.addColumn("Precio Venta");
        model.addColumn("Categoría");
        model.addColumn("Disponible");
        
        JTableProductos.setModel(model);
        
        // Configurar sorter para búsqueda
        sorter = new TableRowSorter<>(model);
        JTableProductos.setRowSorter(sorter);
        
        // Ajustar anchos de columnas
        ajustarAnchosColumnas();
    }
    
    private void ajustarAnchosColumnas() {
        JTableProductos.getColumnModel().getColumn(0).setPreferredWidth(50);   // ID
        JTableProductos.getColumnModel().getColumn(1).setPreferredWidth(100);  // Código
        JTableProductos.getColumnModel().getColumn(2).setPreferredWidth(200);  // Nombre
        JTableProductos.getColumnModel().getColumn(3).setPreferredWidth(250);  // Descripción
        JTableProductos.getColumnModel().getColumn(4).setPreferredWidth(60);   // Stock
        JTableProductos.getColumnModel().getColumn(5).setPreferredWidth(150);  // Proveedor
        JTableProductos.getColumnModel().getColumn(6).setPreferredWidth(100);  // Precio Compra
        JTableProductos.getColumnModel().getColumn(7).setPreferredWidth(100);  // Precio Venta
        JTableProductos.getColumnModel().getColumn(8).setPreferredWidth(120);  // Categoría
        JTableProductos.getColumnModel().getColumn(9).setPreferredWidth(80);   // Disponible
    }
    
    private void configurarComboFiltrado() {
        jComboBoxFiltrado.removeAllItems();
        jComboBoxFiltrado.addItem("Todos");
        jComboBoxFiltrado.addItem("Código");
        jComboBoxFiltrado.addItem("Nombre");
        jComboBoxFiltrado.addItem("Descripción");
        jComboBoxFiltrado.addItem("Proveedor");
        jComboBoxFiltrado.addItem("Categoría");
    }
    
   public void cargarProductos() {
    try {
        String respuesta = ApiClient.get("/api/productos");
        
        if (respuesta != null && !respuesta.isEmpty()) {
            Gson gson = new Gson();
            
            // Usa TypeToken directamente para evitar conflictos con java.awt.Window.Type
            java.lang.reflect.Type tipoLista = new TypeToken<List<ProductoResponse>>(){}.getType();
            List<ProductoResponse> productos = gson.fromJson(respuesta, tipoLista);
            
            // Actualizar tabla
            DefaultTableModel model = (DefaultTableModel) JTableProductos.getModel();
            model.setRowCount(0); // Limpiar tabla
            
            for (ProductoResponse producto : productos) {
                model.addRow(new Object[]{
                    producto.getProductoId(),
                    producto.getCodigo() != null ? producto.getCodigo() : "",
                    producto.getNombre() != null ? producto.getNombre() : "",
                    producto.getDescripcion() != null ? producto.getDescripcion() : "",
                    producto.getStock() != null ? producto.getStock() : 0,
                    producto.getProveedor() != null ? producto.getProveedor() : "",
                    producto.getPrecioCompra() != null ? producto.getPrecioCompra() : 0.0,
                    producto.getPrecioVenta() != null ? producto.getPrecioVenta() : 0.0,
                    producto.getCategoria() != null ? producto.getCategoria().getNombre() : "Sin categoría",
                    producto.getDisponible() != null && producto.getDisponible() ? "Sí" : "No"
                });
            }
            
            ajustarAnchosColumnas();
        } else {
            System.out.println("No se recibieron productos o respuesta vacía");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, 
            "Error al cargar productos: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}
    
    private ProductoResponse obtenerProductoSeleccionado() {
    int filaSeleccionada = JTableProductos.getSelectedRow();
    if (filaSeleccionada >= 0) {
        try {
            // Convertir índice de vista a índice de modelo
            int modelIndex = JTableProductos.convertRowIndexToModel(filaSeleccionada);
            Long productoId = (Long) JTableProductos.getModel().getValueAt(modelIndex, 0);
            
            // Obtener producto completo del backend
            String respuesta = ApiClient.get("/api/productos/" + productoId);
            if (respuesta != null) {
                Gson gson = new Gson();
                return gson.fromJson(respuesta, ProductoResponse.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return null;
}
    
    private void buscarEnTabla() {
        String textoBusqueda = TxtBuscarEnTabla.getText().trim().toLowerCase();
        String filtroSeleccionado = (String) jComboBoxFiltrado.getSelectedItem();
        
        if (textoBusqueda.isEmpty() || "Todos".equals(filtroSeleccionado)) {
            sorter.setRowFilter(null);
        } else {
            try {
                int columna;
                switch (filtroSeleccionado) {
                    case "Código":
                        columna = 1;
                        break;
                    case "Nombre":
                        columna = 2;
                        break;
                    case "Descripción":
                        columna = 3;
                        break;
                    case "Proveedor":
                        columna = 5;
                        break;
                    case "Categoría":
                        columna = 8;
                        break;
                    default:
                        columna = -1; // Buscar en todas las columnas
                }
                
                if (columna >= 0) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + textoBusqueda, columna));
                } else {
                    List<RowFilter<Object, Object>> filters = new ArrayList<>();
                    DefaultTableModel model = (DefaultTableModel) JTableProductos.getModel();
                    for (int i = 0; i < model.getColumnCount(); i++) {
                        filters.add(RowFilter.regexFilter("(?i)" + textoBusqueda, i));
                    }
                    sorter.setRowFilter(RowFilter.orFilter(filters));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
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

        jPanel1 = new javax.swing.JPanel();
        TxtBuscarEnTabla = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBoxFiltrado = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnExportarExcel = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        JTableProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TxtBuscarEnTabla.setToolTipText("Busca");
        TxtBuscarEnTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBuscarEnTablaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-seo-text-35.png"))); // NOI18N
        jLabel1.setText("Búsqueda :");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-search-more-30.png"))); // NOI18N

        jComboBoxFiltrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxFiltrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFiltradoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(383, 383, 383)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtBuscarEnTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jComboBoxFiltrado, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFiltrado, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtBuscarEnTabla))
                .addGap(26, 26, 26))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnExportarExcel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnExportarExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-excel-35.png"))); // NOI18N
        btnExportarExcel.setText("EXPORTAR");

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-edit-35.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-refresh-35.png"))); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-delete-35.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-add-35.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-actions-30.png"))); // NOI18N
        jLabel2.setText("Acciones");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExportarExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(50, 50, 50)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExportarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        JTableProductos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTableProductos.setRowHeight(30);
        jScrollPane.setViewportView(JTableProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1284, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        DlgAgregarProducto productos = new DlgAgregarProducto(this, true);
        productos.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jComboBoxFiltradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFiltradoActionPerformed
       
    }//GEN-LAST:event_jComboBoxFiltradoActionPerformed

    private void TxtBuscarEnTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBuscarEnTablaActionPerformed
        
    }//GEN-LAST:event_TxtBuscarEnTablaActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableProductos;
    private javax.swing.JTextField TxtBuscarEnTabla;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExportarExcel;
    private javax.swing.JButton jButton1;
    public javax.swing.JComboBox<String> jComboBoxFiltrado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane;
    // End of variables declaration//GEN-END:variables
}
