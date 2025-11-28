/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.juanma.profitfront;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

/**
 *
 * @author juanm
 */
public class FrmPrincipal extends javax.swing.JFrame {

    

    public FrmPrincipal() {
        initComponents();
        
    }

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        menuBar3 = new java.awt.MenuBar();
        menu5 = new java.awt.Menu();
        menu6 = new java.awt.Menu();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnCancelarVenta = new javax.swing.JButton();
        btnBusquedaRapida = new javax.swing.JButton();
        btnReimprimirUltimoTicket = new javax.swing.JButton();
        btnEditarVenta = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        buttonBuscarProducto = new javax.swing.JButton();
        txtBuscarProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCobrar = new javax.swing.JButton();
        txtDescuentoEnPorcentaje = new javax.swing.JTextField();
        txtDescuentoEnPesos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtMostrarTotalVenta = new javax.swing.JTextField();
        chekboxAplicarDescuentoPorcentaje = new javax.swing.JCheckBox();
        chekboxAplicarDescuentoPesos = new javax.swing.JCheckBox();
        jCheckboxActivarVueltoCliente = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jlblMostrarCajeroEnTurno = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabelMostrarHoraTiempoReal = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableVentaDeProductos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        Productos = new javax.swing.JMenu();
        jMenuItemProductos = new javax.swing.JMenuItem();
        jMenuItemCigarrillos = new javax.swing.JMenuItem();
        jMenuItemBebidas = new javax.swing.JMenuItem();
        jMenuItemAlimentos = new javax.swing.JMenuItem();
        Ventas = new javax.swing.JMenu();
        jMenuItemVentas = new javax.swing.JMenuItem();
        jMenuItemCaja = new javax.swing.JMenuItem();
        jMenuItemEgresos = new javax.swing.JMenuItem();
        Proveedores = new javax.swing.JMenu();
        jMenuItemProveedores = new javax.swing.JMenuItem();
        jMenuItemTelefonos = new javax.swing.JMenuItem();
        jMenuItemLocales = new javax.swing.JMenuItem();
        Clientes = new javax.swing.JMenu();
        jMenuItemClientes = new javax.swing.JMenuItem();
        jMenuItemProductosMasVendidos = new javax.swing.JMenuItem();
        jMenuItemPedidos = new javax.swing.JMenuItem();
        Agenda = new javax.swing.JMenu();
        jMenuItemAgenda = new javax.swing.JMenuItem();
        jMenuItemListaDeSupermercado = new javax.swing.JMenuItem();
        jMenuItemRecordatorios = new javax.swing.JMenuItem();
        Ajustes = new javax.swing.JMenu();
        jMenuItemAjustes = new javax.swing.JMenuItem();
        jMenuItemInformacionDeUsuario = new javax.swing.JMenuItem();
        jMenuItemSoporte = new javax.swing.JMenuItem();
        Extras = new javax.swing.JMenu();
        jMenuItemExtras = new javax.swing.JMenuItem();
        jMenuItemPaginaWeb = new javax.swing.JMenuItem();
        jMenuItemCreditos = new javax.swing.JMenuItem();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        menu5.setLabel("File");
        menuBar3.add(menu5);

        menu6.setLabel("Edit");
        menuBar3.add(menu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Profit");
        setBackground(java.awt.SystemColor.activeCaption);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        setFocusTraversalPolicyProvider(true);
        setMinimumSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnCancelarVenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-delete-35.png"))); // NOI18N
        btnCancelarVenta.setText(" Cancelar Venta");
        btnCancelarVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCancelarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVentaActionPerformed(evt);
            }
        });

        btnBusquedaRapida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBusquedaRapida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-lightning-bolt-35.png"))); // NOI18N
        btnBusquedaRapida.setText("F-10- Busqueda rapida");
        btnBusquedaRapida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBusquedaRapida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBusquedaRapida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaRapidaActionPerformed(evt);
            }
        });

        btnReimprimirUltimoTicket.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReimprimirUltimoTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-send-to-printer-35.png"))); // NOI18N
        btnReimprimirUltimoTicket.setText("Reimprimir ultimo ticket");
        btnReimprimirUltimoTicket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnReimprimirUltimoTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReimprimirUltimoTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReimprimirUltimoTicketActionPerformed(evt);
            }
        });

        btnEditarVenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-edit-35.png"))); // NOI18N
        btnEditarVenta.setText("  Editar Venta");
        btnEditarVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEditarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarVentaActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-search-more-30.png"))); // NOI18N
        buttonBuscarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarProductoActionPerformed(evt);
            }
        });

        txtBuscarProducto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtBuscarProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarProductoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-seo-text-35.png"))); // NOI18N
        jLabel3.setText("Buscar productos de venta:");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonBuscarProducto)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBusquedaRapida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReimprimirUltimoTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancelarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addComponent(btnEditarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBusquedaRapida, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReimprimirUltimoTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        btnCobrar.setBackground(new java.awt.Color(153, 255, 153));
        btnCobrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-caja-registradora-40.png"))); // NOI18N
        btnCobrar.setText("F-12 COBRAR");
        btnCobrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-discount-20.png"))); // NOI18N
        jLabel5.setText("Desc. Gral:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("%");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("$");

        txtMostrarTotalVenta.setBackground(new java.awt.Color(0, 0, 0));
        txtMostrarTotalVenta.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        txtMostrarTotalVenta.setForeground(new java.awt.Color(102, 255, 0));
        txtMostrarTotalVenta.setText("0,00");
        txtMostrarTotalVenta.setToolTipText("");
        txtMostrarTotalVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMostrarTotalVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMostrarTotalVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMostrarTotalVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        chekboxAplicarDescuentoPorcentaje.setText("Aplicar descuento");
        chekboxAplicarDescuentoPorcentaje.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chekboxAplicarDescuentoPorcentaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chekboxAplicarDescuentoPorcentajeActionPerformed(evt);
            }
        });

        chekboxAplicarDescuentoPesos.setText("Aplicar descuento");
        chekboxAplicarDescuentoPesos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chekboxAplicarDescuentoPesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chekboxAplicarDescuentoPesosActionPerformed(evt);
            }
        });

        jCheckboxActivarVueltoCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jCheckboxActivarVueltoCliente.setText("Activar Vuelto");
        jCheckboxActivarVueltoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckboxActivarVueltoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckboxActivarVueltoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckboxActivarVueltoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCobrar, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDescuentoEnPorcentaje)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDescuentoEnPesos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(chekboxAplicarDescuentoPorcentaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(chekboxAplicarDescuentoPesos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescuentoEnPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(chekboxAplicarDescuentoPorcentaje))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescuentoEnPesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(chekboxAplicarDescuentoPesos))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckboxActivarVueltoCliente)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jlblMostrarCajeroEnTurno.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlblMostrarCajeroEnTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-avatar-40.png"))); // NOI18N
        jlblMostrarCajeroEnTurno.setText("Cajero en turno :");

        jLabelMostrarHoraTiempoReal.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelMostrarHoraTiempoReal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMostrarHoraTiempoReal.setText("07:51:40 am");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMostrarHoraTiempoReal, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabelMostrarHoraTiempoReal, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jlblMostrarCajeroEnTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlblMostrarCajeroEnTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(102, 153, 255));
        jPanel5.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-package-35.png"))); // NOI18N
        jLabel2.setText("VENTA DE PRODUCTOS");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jScrollPane2.setToolTipText("");

        jTableVentaDeProductos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTableVentaDeProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableVentaDeProductos.setRowHeight(30);
        jScrollPane2.setViewportView(jTableVentaDeProductos);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuBar1.setToolTipText("ProfitMenu");
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar1.setMaximumSize(new java.awt.Dimension(1151, 32769));
        jMenuBar1.setMinimumSize(new java.awt.Dimension(1151, 67));

        Productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-shopping-cart-50.png"))); // NOI18N
        Productos.setText("Productos");
        Productos.setBorderPainted(false);
        Productos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Productos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Productos.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        Productos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Productos.setMargin(new java.awt.Insets(3, 20, 3, 20));
        Productos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Productos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItemProductos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Stock.png"))); // NOI18N
        jMenuItemProductos.setText("Productos");
        jMenuItemProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItemProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProductosActionPerformed(evt);
            }
        });
        Productos.add(jMenuItemProductos);

        jMenuItemCigarrillos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemCigarrillos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-joint-30.png"))); // NOI18N
        jMenuItemCigarrillos.setText("Cigarrillos");
        jMenuItemCigarrillos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItemCigarrillos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCigarrillosActionPerformed(evt);
            }
        });
        Productos.add(jMenuItemCigarrillos);

        jMenuItemBebidas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemBebidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-wine-bottle-26.png"))); // NOI18N
        jMenuItemBebidas.setText("Bebidas");
        jMenuItemBebidas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItemBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBebidasActionPerformed(evt);
            }
        });
        Productos.add(jMenuItemBebidas);

        jMenuItemAlimentos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemAlimentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Alimentos.png"))); // NOI18N
        jMenuItemAlimentos.setText("Alimentos");
        jMenuItemAlimentos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItemAlimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAlimentosActionPerformed(evt);
            }
        });
        Productos.add(jMenuItemAlimentos);

        jMenuBar1.add(Productos);

        Ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-cash-register-50 (1).png"))); // NOI18N
        Ventas.setText("Ventas");
        Ventas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Ventas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Ventas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Ventas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Ventas.setMargin(new java.awt.Insets(3, 20, 3, 20));
        Ventas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Ventas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItemVentas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Caja.png"))); // NOI18N
        jMenuItemVentas.setText("Ventas");
        jMenuItemVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItemVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVentasActionPerformed(evt);
            }
        });
        Ventas.add(jMenuItemVentas);

        jMenuItemCaja.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-cash-register-30.png"))); // NOI18N
        jMenuItemCaja.setText("Caja");
        jMenuItemCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItemCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCajaActionPerformed(evt);
            }
        });
        Ventas.add(jMenuItemCaja);

        jMenuItemEgresos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemEgresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-sell-30.png"))); // NOI18N
        jMenuItemEgresos.setText("Egresos");
        jMenuItemEgresos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItemEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEgresosActionPerformed(evt);
            }
        });
        Ventas.add(jMenuItemEgresos);

        jMenuBar1.add(Ventas);

        Proveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-supplier-50.png"))); // NOI18N
        Proveedores.setText("Proveedores");
        Proveedores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Proveedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Proveedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Proveedores.setMargin(new java.awt.Insets(3, 20, 3, 20));
        Proveedores.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Proveedores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItemProveedores.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-supplier-32.png"))); // NOI18N
        jMenuItemProveedores.setText("Proveedores");
        jMenuItemProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItemProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProveedoresActionPerformed(evt);
            }
        });
        Proveedores.add(jMenuItemProveedores);

        jMenuItemTelefonos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemTelefonos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-call-24.png"))); // NOI18N
        jMenuItemTelefonos.setText("Telefonos");
        jMenuItemTelefonos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItemTelefonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTelefonosActionPerformed(evt);
            }
        });
        Proveedores.add(jMenuItemTelefonos);

        jMenuItemLocales.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemLocales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-country-32.png"))); // NOI18N
        jMenuItemLocales.setText("Locales");
        jMenuItemLocales.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItemLocales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLocalesActionPerformed(evt);
            }
        });
        Proveedores.add(jMenuItemLocales);

        jMenuBar1.add(Proveedores);

        Clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-client-50.png"))); // NOI18N
        Clientes.setText("Clientes");
        Clientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Clientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Clientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Clientes.setMargin(new java.awt.Insets(3, 20, 3, 20));
        Clientes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Clientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItemClientes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-client-30.png"))); // NOI18N
        jMenuItemClientes.setText("Clientes");
        jMenuItemClientes.setContentAreaFilled(false);
        jMenuItemClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClientesActionPerformed(evt);
            }
        });
        Clientes.add(jMenuItemClientes);

        jMenuItemProductosMasVendidos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemProductosMasVendidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-stock-32.png"))); // NOI18N
        jMenuItemProductosMasVendidos.setText("Productos mas vendidos");
        jMenuItemProductosMasVendidos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItemProductosMasVendidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProductosMasVendidosActionPerformed(evt);
            }
        });
        Clientes.add(jMenuItemProductosMasVendidos);

        jMenuItemPedidos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-supermarket-30.png"))); // NOI18N
        jMenuItemPedidos.setText("Pedidos");
        jMenuItemPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPedidosActionPerformed(evt);
            }
        });
        Clientes.add(jMenuItemPedidos);

        jMenuBar1.add(Clientes);

        Agenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-agenda-50.png"))); // NOI18N
        Agenda.setText("Agenda");
        Agenda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Agenda.setHideActionText(true);
        Agenda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Agenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Agenda.setMargin(new java.awt.Insets(3, 20, 3, 20));
        Agenda.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Agenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItemAgenda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Calendario 30x30.png"))); // NOI18N
        jMenuItemAgenda.setText("Agenda");
        jMenuItemAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgendaActionPerformed(evt);
            }
        });
        Agenda.add(jMenuItemAgenda);

        jMenuItemListaDeSupermercado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemListaDeSupermercado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-supermarket-30.png"))); // NOI18N
        jMenuItemListaDeSupermercado.setText("Lista de Supermercado");
        jMenuItemListaDeSupermercado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListaDeSupermercadoActionPerformed(evt);
            }
        });
        Agenda.add(jMenuItemListaDeSupermercado);

        jMenuItemRecordatorios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemRecordatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-list-view-30.png"))); // NOI18N
        jMenuItemRecordatorios.setText("Recordatorios");
        jMenuItemRecordatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRecordatoriosActionPerformed(evt);
            }
        });
        Agenda.add(jMenuItemRecordatorios);

        jMenuBar1.add(Agenda);

        Ajustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-settings-50 (1).png"))); // NOI18N
        Ajustes.setText("Ajustes");
        Ajustes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Ajustes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Ajustes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Ajustes.setMargin(new java.awt.Insets(3, 20, 3, 20));
        Ajustes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Ajustes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItemAjustes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemAjustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-settings-30.png"))); // NOI18N
        jMenuItemAjustes.setText("Ajustes");
        jMenuItemAjustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAjustesActionPerformed(evt);
            }
        });
        Ajustes.add(jMenuItemAjustes);

        jMenuItemInformacionDeUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemInformacionDeUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-user-30.png"))); // NOI18N
        jMenuItemInformacionDeUsuario.setText("Información de usuario");
        jMenuItemInformacionDeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInformacionDeUsuarioActionPerformed(evt);
            }
        });
        Ajustes.add(jMenuItemInformacionDeUsuario);

        jMenuItemSoporte.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemSoporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-gears-30.png"))); // NOI18N
        jMenuItemSoporte.setText("Soporte");
        jMenuItemSoporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSoporteActionPerformed(evt);
            }
        });
        Ajustes.add(jMenuItemSoporte);

        jMenuBar1.add(Ajustes);

        Extras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-extra 50 .png"))); // NOI18N
        Extras.setText("Extras");
        Extras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Extras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Extras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Extras.setMargin(new java.awt.Insets(3, 20, 3, 20));
        Extras.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Extras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItemExtras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemExtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Extra.png"))); // NOI18N
        jMenuItemExtras.setText("Extras");
        jMenuItemExtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExtrasActionPerformed(evt);
            }
        });
        Extras.add(jMenuItemExtras);

        jMenuItemPaginaWeb.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemPaginaWeb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-web-30.png"))); // NOI18N
        jMenuItemPaginaWeb.setText("Pagina Web");
        jMenuItemPaginaWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPaginaWebActionPerformed(evt);
            }
        });
        Extras.add(jMenuItemPaginaWeb);

        jMenuItemCreditos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItemCreditos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-list-30.png"))); // NOI18N
        jMenuItemCreditos.setText("Creditos");
        jMenuItemCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCreditosActionPerformed(evt);
            }
        });
        Extras.add(jMenuItemCreditos);

        jMenuBar1.add(Extras);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVentasActionPerformed
     
    }//GEN-LAST:event_jMenuItemVentasActionPerformed

    private void jMenuItemProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProveedoresActionPerformed
      
    }//GEN-LAST:event_jMenuItemProveedoresActionPerformed

    private void jMenuItemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClientesActionPerformed

    }//GEN-LAST:event_jMenuItemClientesActionPerformed

    private void jMenuItemProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProductosActionPerformed
       
    }//GEN-LAST:event_jMenuItemProductosActionPerformed

    private void jMenuItemListaDeSupermercadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListaDeSupermercadoActionPerformed

    }//GEN-LAST:event_jMenuItemListaDeSupermercadoActionPerformed

    private void jMenuItemSoporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSoporteActionPerformed

    }//GEN-LAST:event_jMenuItemSoporteActionPerformed

    private void jMenuItemCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCreditosActionPerformed

    }//GEN-LAST:event_jMenuItemCreditosActionPerformed

    private void jMenuItemCigarrillosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCigarrillosActionPerformed
     
    }//GEN-LAST:event_jMenuItemCigarrillosActionPerformed

    private void jMenuItemBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBebidasActionPerformed
       
    }//GEN-LAST:event_jMenuItemBebidasActionPerformed

    private void jMenuItemAlimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAlimentosActionPerformed

    }//GEN-LAST:event_jMenuItemAlimentosActionPerformed

    private void jMenuItemCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCajaActionPerformed
       
    }//GEN-LAST:event_jMenuItemCajaActionPerformed

    private void jMenuItemEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEgresosActionPerformed
     
    }//GEN-LAST:event_jMenuItemEgresosActionPerformed

    private void jMenuItemTelefonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTelefonosActionPerformed

    }//GEN-LAST:event_jMenuItemTelefonosActionPerformed

    private void jMenuItemLocalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLocalesActionPerformed

    }//GEN-LAST:event_jMenuItemLocalesActionPerformed

    private void jMenuItemProductosMasVendidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProductosMasVendidosActionPerformed

    }//GEN-LAST:event_jMenuItemProductosMasVendidosActionPerformed

    private void jMenuItemPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPedidosActionPerformed

    }//GEN-LAST:event_jMenuItemPedidosActionPerformed

    private void jMenuItemAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgendaActionPerformed

    }//GEN-LAST:event_jMenuItemAgendaActionPerformed

    private void jMenuItemRecordatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRecordatoriosActionPerformed

    }//GEN-LAST:event_jMenuItemRecordatoriosActionPerformed

    private void jMenuItemAjustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAjustesActionPerformed

    }//GEN-LAST:event_jMenuItemAjustesActionPerformed

    private void jMenuItemInformacionDeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInformacionDeUsuarioActionPerformed

    }//GEN-LAST:event_jMenuItemInformacionDeUsuarioActionPerformed

    private void jMenuItemExtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExtrasActionPerformed

    }//GEN-LAST:event_jMenuItemExtrasActionPerformed

    private void jMenuItemPaginaWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPaginaWebActionPerformed
     
    }//GEN-LAST:event_jMenuItemPaginaWebActionPerformed

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
     
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void btnCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVentaActionPerformed
   


    }//GEN-LAST:event_btnCancelarVentaActionPerformed

    private void btnEditarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarVentaActionPerformed
        
    }//GEN-LAST:event_btnEditarVentaActionPerformed

    private void txtMostrarTotalVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMostrarTotalVentaActionPerformed

    }//GEN-LAST:event_txtMostrarTotalVentaActionPerformed

    private void btnBusquedaRapidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaRapidaActionPerformed
       
    }//GEN-LAST:event_btnBusquedaRapidaActionPerformed

    private void btnReimprimirUltimoTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReimprimirUltimoTicketActionPerformed
     
    }//GEN-LAST:event_btnReimprimirUltimoTicketActionPerformed

    private void chekboxAplicarDescuentoPorcentajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chekboxAplicarDescuentoPorcentajeActionPerformed
  
    }//GEN-LAST:event_chekboxAplicarDescuentoPorcentajeActionPerformed

    private void chekboxAplicarDescuentoPesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chekboxAplicarDescuentoPesosActionPerformed
       
    }//GEN-LAST:event_chekboxAplicarDescuentoPesosActionPerformed

    private void jCheckboxActivarVueltoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckboxActivarVueltoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckboxActivarVueltoClienteActionPerformed

    private void txtBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarProductoActionPerformed
      
    }//GEN-LAST:event_txtBuscarProductoActionPerformed

    private void buttonBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarProductoActionPerformed
     
    }//GEN-LAST:event_buttonBuscarProductoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Agenda;
    private javax.swing.JMenu Ajustes;
    private javax.swing.JMenu Clientes;
    private javax.swing.JMenu Extras;
    private javax.swing.JMenu Productos;
    private javax.swing.JMenu Proveedores;
    private javax.swing.JMenu Ventas;
    private javax.swing.JButton btnBusquedaRapida;
    private javax.swing.JButton btnCancelarVenta;
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton btnEditarVenta;
    private javax.swing.JButton btnReimprimirUltimoTicket;
    private javax.swing.JButton buttonBuscarProducto;
    private javax.swing.JCheckBox chekboxAplicarDescuentoPesos;
    private javax.swing.JCheckBox chekboxAplicarDescuentoPorcentaje;
    private javax.swing.JCheckBox jCheckboxActivarVueltoCliente;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelMostrarHoraTiempoReal;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAgenda;
    private javax.swing.JMenuItem jMenuItemAjustes;
    private javax.swing.JMenuItem jMenuItemAlimentos;
    private javax.swing.JMenuItem jMenuItemBebidas;
    private javax.swing.JMenuItem jMenuItemCaja;
    private javax.swing.JMenuItem jMenuItemCigarrillos;
    private javax.swing.JMenuItem jMenuItemClientes;
    private javax.swing.JMenuItem jMenuItemCreditos;
    private javax.swing.JMenuItem jMenuItemEgresos;
    private javax.swing.JMenuItem jMenuItemExtras;
    private javax.swing.JMenuItem jMenuItemInformacionDeUsuario;
    private javax.swing.JMenuItem jMenuItemListaDeSupermercado;
    private javax.swing.JMenuItem jMenuItemLocales;
    private javax.swing.JMenuItem jMenuItemPaginaWeb;
    private javax.swing.JMenuItem jMenuItemPedidos;
    private javax.swing.JMenuItem jMenuItemProductos;
    private javax.swing.JMenuItem jMenuItemProductosMasVendidos;
    private javax.swing.JMenuItem jMenuItemProveedores;
    private javax.swing.JMenuItem jMenuItemRecordatorios;
    private javax.swing.JMenuItem jMenuItemSoporte;
    private javax.swing.JMenuItem jMenuItemTelefonos;
    private javax.swing.JMenuItem jMenuItemVentas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableVentaDeProductos;
    private javax.swing.JLabel jlblMostrarCajeroEnTurno;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.Menu menu5;
    private java.awt.Menu menu6;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private java.awt.MenuBar menuBar3;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtDescuentoEnPesos;
    private javax.swing.JTextField txtDescuentoEnPorcentaje;
    private javax.swing.JTextField txtMostrarTotalVenta;
    // End of variables declaration//GEN-END:variables
}
