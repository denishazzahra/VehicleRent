/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author LENOVO
 */
public class ManageRentBikeView extends javax.swing.JFrame {

    /**
     * Creates new form ManageRentBikeView
     */
    public ManageRentBikeView() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablebike = new javax.swing.JTable();
        btnback = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnexport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Rent (Bike)");

        tablebike.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tablebike.setForeground(new java.awt.Color(53, 24, 90));
        tablebike.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Renter", "Brand", "Type", "License", "Rent From", "Rent Due", "Return Date", "Cost", "Fine"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablebike.setRowHeight(20);
        tablebike.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablebike);
        if (tablebike.getColumnModel().getColumnCount() > 0) {
            tablebike.getColumnModel().getColumn(1).setResizable(false);
            tablebike.getColumnModel().getColumn(2).setResizable(false);
            tablebike.getColumnModel().getColumn(3).setResizable(false);
            tablebike.getColumnModel().getColumn(4).setResizable(false);
            tablebike.getColumnModel().getColumn(5).setResizable(false);
            tablebike.getColumnModel().getColumn(6).setResizable(false);
            tablebike.getColumnModel().getColumn(7).setResizable(false);
            tablebike.getColumnModel().getColumn(8).setResizable(false);
            tablebike.getColumnModel().getColumn(9).setResizable(false);
        }

        btnback.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnback.setForeground(new java.awt.Color(53, 24, 90));
        btnback.setText("< Back");
        btnback.setBorderPainted(false);
        btnback.setContentAreaFilled(false);
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(53, 24, 90));
        jLabel1.setText("Manage Bike Rent");

        btnexport.setBackground(new java.awt.Color(53, 24, 90));
        btnexport.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnexport.setForeground(new java.awt.Color(255, 255, 255));
        btnexport.setText("EXPORT TO CSV");
        btnexport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnback)
                        .addGap(287, 287, 287)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnexport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(btnback))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnexport, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnexportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnexportActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnback;
    public javax.swing.JButton btnexport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablebike;
    // End of variables declaration//GEN-END:variables
}
