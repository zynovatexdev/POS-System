/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.zx.shopmanagementsystem.forms;

import com.zx.shopmanagementsystem.table.TableCustom;

/**
 *
 * @author User
 */
public class InventoryManagement extends javax.swing.JPanel {

    /**
     * Creates new form Home
     */
    public InventoryManagement() {
        initComponents();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder2 = new com.raven.swing.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        iconLbl = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1015, 738));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setOpaque(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 970, 490));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\InventoryManagement.png")); // NOI18N
        iconLbl.setPreferredSize(new java.awt.Dimension(1015, 738));
        add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.raven.swing.PanelBorder panelBorder2;
    // End of variables declaration//GEN-END:variables
}
