/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import custompanel.ImagePanel;
import databases.DBConnection;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author iyefreed
 */
public class AdmReimbursePanel extends ImagePanel {
    Connection conn = new DBConnection().connect();
    String status;

    /**
     * Creates new form AdmReimbursePanel
     */
    public AdmReimbursePanel() {
        super(new ImageIcon("src\\assets\\images\\hris_background.png").getImage());
        initComponents();
        status = comboStatus.getSelectedItem().toString();
        initTable(status);
        
        comboStatus.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                 if(e.getStateChange() == ItemEvent.SELECTED) {
                     status = e.getItem().toString();
                     initTable(status);
                 }
            }
        });
    }
    
    private void initTable(String status) {
        Object[] tHead = {"No.", "Nominal", "Keterangan", "Tanggal", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(null, tHead);
        admReimburseTable.setModel(tableModel);
        
        String query = "SELECT * FROM t_reimburse WHERE status=?";
        if(status.equals("SEMUA")) query = "SELECT * FROM t_reimburse";
        
        try {
            DecimalFormat kurs = (DecimalFormat) DecimalFormat.getCurrencyInstance();
            DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
            formatRp.setCurrencySymbol("Rp. ");
            formatRp.setMonetaryDecimalSeparator(',');
            formatRp.setGroupingSeparator('.');
            kurs.setDecimalFormatSymbols(formatRp);
            
            PreparedStatement stmt = conn.prepareStatement(query);
            if(!status.equals("SEMUA")) stmt.setString(1, status);
            ResultSet result = stmt.executeQuery();
            
            int i = 1;
            while(result.next()) {
                
                String b = kurs.format(Double.parseDouble(result.getString("nominal")));
                String c = result.getString("keterangan");
                String d = result.getString("created_at");
                String e = result.getString("status");
                
                Object[] data = {i, b, c, d, e};
                
                tableModel.addRow(data);
                i++;
            }
        } catch(SQLException e) {
            System.err.println(e.toString());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        admReimburseTable = new javax.swing.JTable();
        buttonDeny = new javax.swing.JButton();
        buttonAcc = new javax.swing.JButton();
        comboStatus = new javax.swing.JComboBox<>();
        buttonPrint = new javax.swing.JButton();

        setOpaque(false);

        admReimburseTable.setModel(new javax.swing.table.DefaultTableModel(
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
        admReimburseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admReimburseTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(admReimburseTable);

        buttonDeny.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        buttonDeny.setText("Tolak");
        buttonDeny.setEnabled(false);
        buttonDeny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDenyActionPerformed(evt);
            }
        });

        buttonAcc.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        buttonAcc.setText("Setujui");
        buttonAcc.setEnabled(false);
        buttonAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAccActionPerformed(evt);
            }
        });

        comboStatus.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SEMUA", "MENUNGGU", "SETUJU", "BATAL" }));

        buttonPrint.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        buttonPrint.setText("Print");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonAcc)
                        .addGap(18, 18, 18)
                        .addComponent(buttonDeny))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonPrint)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPrint))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDeny)
                    .addComponent(buttonAcc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAccActionPerformed
        String query = "UPDATE t_reimburse SET status='SETUJU' WHERE id=?";
        
        try {
            int row = admReimburseTable.getSelectedRow();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, admReimburseTable.getValueAt(row, 0).toString());
            
            stmt.execute();
            JOptionPane.showMessageDialog(this, "Pengajuan Ditolak");
            initTable(status);
        } catch(SQLException e) {
            System.err.println(e.toString());
        }
    }//GEN-LAST:event_buttonAccActionPerformed

    private void admReimburseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admReimburseTableMouseClicked
        buttonAcc.setEnabled(true);
        buttonDeny.setEnabled(true);
    }//GEN-LAST:event_admReimburseTableMouseClicked

    private void buttonDenyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDenyActionPerformed
        String query = "UPDATE t_reimburse SET status='BATAL' WHERE id=?";
        
        try {
            int row = admReimburseTable.getSelectedRow();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, admReimburseTable.getValueAt(row, 0).toString());
            
            stmt.execute();
            JOptionPane.showMessageDialog(this, "Pengajuan Ditolak");
            initTable(status);
        } catch(SQLException e) {
            System.err.println(e.toString());
        }
    }//GEN-LAST:event_buttonDenyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable admReimburseTable;
    private javax.swing.JButton buttonAcc;
    private javax.swing.JButton buttonDeny;
    private javax.swing.JButton buttonPrint;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
