/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.juanma.profitfront.interfaz.thirdLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public abstract class DlgFormularioAgregarBase extends javax.swing.JDialog {

    protected JPanel panelPrincipal;
    protected JButton btnAceptar;
    protected JButton btnCancelar;
    protected Map<String, JComponent> componentes;
    private JScrollPane scrollPane;
    
    // Variables para manejar placeholders
    private Map<String, String> placeholders = new HashMap<>();
    protected Color placeholderColor = Color.GRAY;
    protected Color normalColor = Color.BLACK;

    public DlgFormularioAgregarBase(java.awt.Frame parent, boolean modal, String titulo) {
        super(parent, modal);
        setTitle(titulo);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);
        setMinimumSize(new Dimension(500, 400));
        
        componentes = new HashMap<>();
        initComponentsBase();
         setIconImage(new ImageIcon (getClass().getResource("/LogoProfit.png")).getImage());
        setLocationRelativeTo(null);
        pack();
    }
    protected void establecerTexto(String nombreCampo, String texto) {
    try {
        JTextField campo = (JTextField) componentes.get(nombreCampo);
        if (campo != null) {
            campo.setText(texto);
            campo.setForeground(normalColor);
        }
    } catch (ClassCastException e) {
        // No es un JTextField, no hacemos nada
    }
}
    protected boolean validarCamposObligatorios(String... nombresCampos) {
        for (String nombre : nombresCampos) {
            String valor = "";
            
            if (componentes.get(nombre) instanceof JTextField) {
                valor = obtenerTextoReal(nombre);
            } 
            else if (componentes.get(nombre) instanceof JComboBox) {
                valor = obtenerCombo(nombre);
            }
            
            if (valor == null || valor.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    private void initComponentsBase() {
        setLayout(new BorderLayout(10, 10));
        
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(0, 2, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        scrollPane = new JScrollPane(panelPrincipal);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Datos del formulario"));
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");
        
        btnAceptar.setBackground(new Color(59, 89, 182));
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setFocusPainted(false);
        btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        btnCancelar.setBackground(new Color(200, 55, 55));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));

        btnAceptar.addActionListener(e -> aceptar());
        btnCancelar.addActionListener(e -> cancelar());
        
        panelBotones.add(btnCancelar);
        panelBotones.add(btnAceptar);
        add(panelBotones, BorderLayout.SOUTH);
        
        getRootPane().setDefaultButton(btnAceptar);
    }

    // Versión sobrecargada para compatibilidad con diálogos existentes
    protected void agregarCampo(String nombreCampo, String etiqueta, JComponent componente) {
        agregarCampo(nombreCampo, etiqueta, componente, "");
    }

    // Versión completa con placeholder
    protected void agregarCampo(String nombreCampo, String etiqueta, JComponent componente, String placeholder) {
        JLabel label = new JLabel(etiqueta);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 10));
        
        panelPrincipal.add(label);
        panelPrincipal.add(componente);
        
        if (componente instanceof JTextField) {
            JTextField textField = (JTextField) componente;
            textField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(192, 192, 192)),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
            ));
            
            placeholders.put(nombreCampo, placeholder);
            textField.setToolTipText(placeholder);
            
            if (!placeholder.isEmpty()) {
                textField.setText(placeholder);
                textField.setForeground(placeholderColor);
                
                textField.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        if (textField.getText().equals(placeholder)) {
                            textField.setText("");
                            textField.setForeground(normalColor);
                        }
                    }
                    
                    @Override
                    public void focusLost(FocusEvent e) {
                        if (textField.getText().isEmpty()) {
                            textField.setText(placeholder);
                            textField.setForeground(placeholderColor);
                        }
                    }
                });
            }
            
            textField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        e.consume();
                        Component next = findNextFocusableComponent(textField);
                        if (next != null) {
                            next.requestFocus();
                        } else {
                            btnAceptar.doClick();
                        }
                    }
                }
            });
        }
        else if (componente instanceof JComboBox) {
            ((JComboBox<?>) componente).setFont(new Font("Segoe UI", Font.PLAIN, 13));
        }
        
        componentes.put(nombreCampo, componente);
        revalidate();
        repaint();
    }
    
    private Component findNextFocusableComponent(Component current) {
        Container container = current.getParent();
        FocusTraversalPolicy policy = container.getFocusTraversalPolicy();
        Component next = policy.getComponentAfter(container, current);
        if (next == null || next instanceof JButton) {
            return null;
        }
        return next;
    }

    protected String obtenerTexto(String nombreCampo) {
        try {
            JTextField campo = (JTextField) componentes.get(nombreCampo);
            return campo != null ? campo.getText().trim() : "";
        } catch (ClassCastException e) {
            return "";
        }
    }
    
    protected String obtenerTextoReal(String nombreCampo) {
        String text = obtenerTexto(nombreCampo);
        String placeholder = placeholders.get(nombreCampo);
        return (placeholder != null && text.equals(placeholder)) ? "" : text;
    }

    protected int obtenerEntero(String nombreCampo) {
        try {
            return Integer.parseInt(obtenerTextoReal(nombreCampo));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    protected double obtenerDouble(String nombreCampo) {
        try {
            return Double.parseDouble(obtenerTextoReal(nombreCampo));
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    protected String obtenerCombo(String nombreCampo) {
        try {
            JComboBox<String> combo = (JComboBox<String>) componentes.get(nombreCampo);
            return combo != null ? (String) combo.getSelectedItem() : "";
        } catch (ClassCastException e) {
            return "";
        }
    }

    private void aceptar() {
        if (validarCampos()) {
            guardarRegistro();
            dispose();
        }
    }

    private void cancelar() {
        dispose();
    }

    // Métodos abstractos
    protected abstract void guardarRegistro();
    protected abstract boolean validarCampos();
    protected abstract void configurarCampos();
    
    public void mostrar() {
        configurarCampos();
        pack();
        setLocationRelativeTo(getParent());
        setVisible(true);
    }



    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregarGenerico = new javax.swing.JButton();
        btnCancelarGenerico = new javax.swing.JButton();
        txtGenerico6 = new javax.swing.JTextField();
        txtGenerico3 = new javax.swing.JTextField();
        txtGenerico7 = new javax.swing.JTextField();
        txtGenerico5 = new javax.swing.JTextField();
        txtGenerico8 = new javax.swing.JTextField();
        txtGenerico4 = new javax.swing.JTextField();
        txtGenerico2 = new javax.swing.JTextField();
        txtGenerico1 = new javax.swing.JTextField();
        lblGenerico1 = new javax.swing.JLabel();
        lblGenerico7 = new javax.swing.JLabel();
        lblGenerico8 = new javax.swing.JLabel();
        lblGenerico3 = new javax.swing.JLabel();
        lblGenerico6 = new javax.swing.JLabel();
        lblGenerico5 = new javax.swing.JLabel();
        lblGenerico4 = new javax.swing.JLabel();
        lblGenerico2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAgregarGenerico.setText("Agregar");

        btnCancelarGenerico.setText("Cancelar");

        txtGenerico6.setText("jTextField1");

        txtGenerico3.setText("jTextField1");

        txtGenerico7.setText("jTextField1");

        txtGenerico5.setText("jTextField1");

        txtGenerico8.setText("jTextField1");

        txtGenerico4.setText("jTextField1");

        txtGenerico2.setText("jTextField1");

        txtGenerico1.setText("jTextField1");
        txtGenerico1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblGenerico1.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        lblGenerico1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGenerico1.setText("Default");
        lblGenerico1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblGenerico7.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        lblGenerico7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGenerico7.setText("Default");
        lblGenerico7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblGenerico8.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        lblGenerico8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGenerico8.setText("Default");
        lblGenerico8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblGenerico3.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        lblGenerico3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGenerico3.setText("Default");
        lblGenerico3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblGenerico6.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        lblGenerico6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGenerico6.setText("Default");
        lblGenerico6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblGenerico5.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        lblGenerico5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGenerico5.setText("Default");
        lblGenerico5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblGenerico4.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        lblGenerico4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGenerico4.setText("Default");
        lblGenerico4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblGenerico2.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        lblGenerico2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGenerico2.setText("Default");
        lblGenerico2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGenerico3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGenerico7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGenerico3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtGenerico5)
                    .addComponent(txtGenerico7)
                    .addComponent(btnAgregarGenerico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                    .addComponent(txtGenerico1)
                    .addComponent(lblGenerico1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGenerico5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGenerico6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGenerico2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelarGenerico, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(txtGenerico8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                    .addComponent(txtGenerico6)
                    .addComponent(txtGenerico4)
                    .addComponent(lblGenerico8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGenerico4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGenerico2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenerico1)
                    .addComponent(lblGenerico2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGenerico2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGenerico1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenerico3)
                    .addComponent(lblGenerico4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGenerico4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGenerico3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenerico6)
                    .addComponent(lblGenerico5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGenerico6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGenerico5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenerico7)
                    .addComponent(lblGenerico8))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGenerico8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGenerico7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarGenerico)
                    .addComponent(btnCancelarGenerico))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarGenerico;
    private javax.swing.JButton btnCancelarGenerico;
    private javax.swing.JLabel lblGenerico1;
    private javax.swing.JLabel lblGenerico2;
    private javax.swing.JLabel lblGenerico3;
    private javax.swing.JLabel lblGenerico4;
    private javax.swing.JLabel lblGenerico5;
    private javax.swing.JLabel lblGenerico6;
    private javax.swing.JLabel lblGenerico7;
    private javax.swing.JLabel lblGenerico8;
    private javax.swing.JTextField txtGenerico1;
    private javax.swing.JTextField txtGenerico2;
    private javax.swing.JTextField txtGenerico3;
    private javax.swing.JTextField txtGenerico4;
    private javax.swing.JTextField txtGenerico5;
    private javax.swing.JTextField txtGenerico6;
    private javax.swing.JTextField txtGenerico7;
    private javax.swing.JTextField txtGenerico8;
    // End of variables declaration//GEN-END:variables
}
