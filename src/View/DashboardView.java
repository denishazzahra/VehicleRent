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
public class DashboardView extends javax.swing.JFrame {

    /**
     * Creates new form DashboardAdminView
     */
    public DashboardView() {
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

        btnbike = new javax.swing.JButton();
        btncar = new javax.swing.JButton();
        btnaddrent = new javax.swing.JButton();
        btnlogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnmanagerent = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");

        btnbike.setBackground(new java.awt.Color(53, 24, 90));
        btnbike.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnbike.setForeground(new java.awt.Color(255, 255, 255));
        btnbike.setText("BIKE LIST");

        btncar.setBackground(new java.awt.Color(53, 24, 90));
        btncar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btncar.setForeground(new java.awt.Color(255, 255, 255));
        btncar.setText("CAR LIST");

        btnaddrent.setBackground(new java.awt.Color(53, 24, 90));
        btnaddrent.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnaddrent.setForeground(new java.awt.Color(255, 255, 255));
        btnaddrent.setText("ADD RENT");

        btnlogout.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnlogout.setForeground(new java.awt.Color(53, 24, 90));
        btnlogout.setText("Logout >");
        btnlogout.setBorderPainted(false);
        btnlogout.setContentAreaFilled(false);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(53, 24, 90));
        jLabel1.setText("Menu");

        btnmanagerent.setBackground(new java.awt.Color(53, 24, 90));
        btnmanagerent.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnmanagerent.setForeground(new java.awt.Color(255, 255, 255));
        btnmanagerent.setText("MANAGE RENT");
        btnmanagerent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmanagerentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnlogout))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnaddrent, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbike, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnmanagerent, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel1)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnlogout)
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(btnbike, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btncar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnaddrent, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnmanagerent, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnmanagerentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmanagerentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmanagerentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnaddrent;
    public javax.swing.JButton btnbike;
    public javax.swing.JButton btncar;
    public javax.swing.JButton btnlogout;
    public javax.swing.JButton btnmanagerent;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
