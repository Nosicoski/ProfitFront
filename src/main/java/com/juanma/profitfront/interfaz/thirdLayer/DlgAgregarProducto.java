package com.juanma.profitfront.interfaz.thirdLayer;

import com.juanma.profitfront.Services.ApiClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.juanma.profitfront.Models.request.ProductoRequest;
import com.juanma.profitfront.Models.response.CategoriaResponse;
import com.juanma.profitfront.Models.response.ProductoResponse;
import javax.swing.*;
import java.lang.reflect.Type;
import java.util.List;

public class DlgAgregarProducto extends DlgFormularioAgregarBase {
    
    private ProductoResponse productoExistente;
    private boolean modoEdicion;
    private List<CategoriaResponse> categorias;
    
    public DlgAgregarProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal, "Agregar Nuevo Producto");
        this.modoEdicion = false;
        cargarCategorias();
        configurarCampos();
    }
    
    public DlgAgregarProducto(java.awt.Frame parent, boolean modal, ProductoResponse producto) {
        super(parent, modal, "Editar Producto");
        this.productoExistente = producto;
        this.modoEdicion = true;
        cargarCategorias();
        configurarCampos();
    }
    
   private void cargarCategorias() {
    try {
        String respuesta = ApiClient.get("/api/categorias");
        if (respuesta != null) {
            Gson gson = new Gson();
            // Usa TypeToken directamente
            List<CategoriaResponse> categoriasList = gson.fromJson(
                respuesta, 
                new TypeToken<List<CategoriaResponse>>(){}.getType()
            );
            this.categorias = categoriasList;
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al cargar categorías: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}
    
    @Override
    protected void configurarCampos() {
        // Limpiar panel primero
        panelPrincipal.removeAll();
        componentes.clear();
        
        // Agregar campos al formulario
        agregarCampo("codigo", "Código:", new JTextField(), "Ej: PROD001");
        agregarCampo("nombre", "Nombre:", new JTextField(), "Nombre del producto");
        agregarCampo("descripcion", "Descripción:", new JTextField(), "Descripción detallada");
        
        // Campo de stock
        JTextField txtStock = new JTextField();
        agregarCampo("stock", "Stock:", txtStock, "0");
        
        // Campo de proveedor
        agregarCampo("proveedor", "Proveedor:", new JTextField(), "Nombre del proveedor");
        
        // Campos de precios
        JTextField txtPrecioCompra = new JTextField();
        agregarCampo("precioCompra", "Precio Compra ($):", txtPrecioCompra, "0.00");
        
        JTextField txtPrecioVenta = new JTextField();
        agregarCampo("precioVenta", "Precio Venta ($):", txtPrecioVenta, "0.00");
        
        // Combo para categoría
        JComboBox<String> comboCat = new JComboBox<>();
        comboCat.addItem("-- Seleccione Categoría --");
        if (categorias != null) {
            for (CategoriaResponse cat : categorias) {
                if (cat.getActiva() != null && cat.getActiva()) {
                    comboCat.addItem(cat.getNombre() + " (ID: " + cat.getCategoriaId() + ")");
                }
            }
        }
        agregarCampo("categoria", "Categoría:", comboCat, "");
        
        // Checkbox para disponibilidad
        JCheckBox chkDisponible = new JCheckBox("Disponible");
        chkDisponible.setSelected(true);
        agregarCampo("disponible", "Disponibilidad:", chkDisponible);
        
        // Si es modo edición, llenar campos con datos existentes
        if (modoEdicion && productoExistente != null) {
            establecerTexto("codigo", productoExistente.getCodigo());
            establecerTexto("nombre", productoExistente.getNombre());
            establecerTexto("descripcion", productoExistente.getDescripcion());
            establecerTexto("stock", String.valueOf(productoExistente.getStock()));
            establecerTexto("proveedor", productoExistente.getProveedor());
            establecerTexto("precioCompra", String.valueOf(productoExistente.getPrecioCompra()));
            establecerTexto("precioVenta", String.valueOf(productoExistente.getPrecioVenta()));
            
            // Seleccionar categoría
            if (productoExistente.getCategoria() != null) {
                for (int i = 0; i < comboCat.getItemCount(); i++) {
                    String item = comboCat.getItemAt(i);
                    if (item.contains("ID: " + productoExistente.getCategoria().getCategoriaId())) {
                        comboCat.setSelectedIndex(i);
                        break;
                    }
                }
            }
            
            // Configurar disponibilidad
            if (productoExistente.getDisponible() != null) {
                chkDisponible.setSelected(productoExistente.getDisponible());
            }
        }
        
        // Revalidar y repintar
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }
    
    @Override
    protected boolean validarCampos() {
        // Validar campos obligatorios
        String[] camposObligatorios = {"codigo", "nombre", "descripcion", "stock", "proveedor", "precioCompra", "precioVenta"};
        if (!validarCamposObligatorios(camposObligatorios)) {
            JOptionPane.showMessageDialog(this, 
                "Todos los campos son obligatorios", 
                "Validación", 
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        // Validar que el código no esté vacío
        String codigo = obtenerTextoReal("codigo");
        if (codigo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "El código no puede estar vacío", 
                "Validación", 
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        // Validar que stock sea número positivo
        try {
            int stock = obtenerEntero("stock");
            if (stock < 0) {
                JOptionPane.showMessageDialog(this, 
                    "El stock no puede ser negativo", 
                    "Validación", 
                    JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "El stock debe ser un número válido", 
                "Validación", 
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        // Validar precios positivos
        try {
            double precioCompra = obtenerDouble("precioCompra");
            double precioVenta = obtenerDouble("precioVenta");
            
            if (precioCompra < 0) {
                JOptionPane.showMessageDialog(this, 
                    "El precio de compra no puede ser negativo", 
                    "Validación", 
                    JOptionPane.WARNING_MESSAGE);
                return false;
            }
            
            if (precioVenta < 0) {
                JOptionPane.showMessageDialog(this, 
                    "El precio de venta no puede ser negativo", 
                    "Validación", 
                    JOptionPane.WARNING_MESSAGE);
                return false;
            }
            
            if (precioVenta < precioCompra) {
                int respuesta = JOptionPane.showConfirmDialog(this,
                    "El precio de venta es menor que el precio de compra. ¿Desea continuar?",
                    "Advertencia de precio",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
                return respuesta == JOptionPane.YES_OPTION;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Los precios deben ser números válidos", 
                "Validación", 
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        // Validar categoría seleccionada
        String categoriaSeleccionada = obtenerCombo("categoria");
        if (categoriaSeleccionada.equals("-- Seleccione Categoría --")) {
            JOptionPane.showMessageDialog(this, 
                "Debe seleccionar una categoría", 
                "Validación", 
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    @Override
    protected void guardarRegistro() {
        try {
            // Obtener ID de categoría del texto seleccionado
            String categoriaCombo = obtenerCombo("categoria");
            Long categoriaId = null;
            if (categoriaCombo.contains("ID: ")) {
                String idStr = categoriaCombo.substring(categoriaCombo.indexOf("ID: ") + 4, categoriaCombo.indexOf(")"));
                categoriaId = Long.parseLong(idStr);
            }
            
            // Crear objeto ProductoRequest
            ProductoRequest producto = new ProductoRequest();
            producto.setCodigo(obtenerTextoReal("codigo"));
            producto.setNombre(obtenerTextoReal("nombre"));
            producto.setDescripcion(obtenerTextoReal("descripcion"));
            producto.setStock(obtenerEntero("stock"));
            producto.setProveedor(obtenerTextoReal("proveedor"));
            producto.setPrecioCompra(obtenerDouble("precioCompra"));
            producto.setPrecioVenta(obtenerDouble("precioVenta"));

            
            // Obtener disponibilidad del checkbox
            JCheckBox chkDisponible = (JCheckBox) componentes.get("disponible");
            producto.setDisponible(chkDisponible.isSelected());
            
            // Convertir a JSON
            Gson gson = new Gson();
            String jsonBody = gson.toJson(producto);
            
            System.out.println("JSON enviado: " + jsonBody);
            
            String respuesta;
            if (modoEdicion && productoExistente != null) {
                // Modo edición: PUT
                respuesta = ApiClient.put("/api/productos/" + productoExistente.getProductoId(), jsonBody);
            } else {
                // Modo creación: POST
                respuesta = ApiClient.post("/api/productos", jsonBody, true);
            }
            
            if (respuesta != null) {
                JOptionPane.showMessageDialog(this, 
                    modoEdicion ? "Producto actualizado correctamente" : "Producto creado correctamente", 
                    "Éxito", 
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Error al " + (modoEdicion ? "actualizar" : "crear") + " el producto", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Error: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DlgAgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgAgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgAgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgAgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgAgregarProducto dialog = new DlgAgregarProducto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
