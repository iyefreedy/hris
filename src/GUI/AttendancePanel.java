/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import custompanel.ImagePanel;
import databases.DBConnection;
import java.awt.event.ItemEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import utils.UserSession;

/**
 *
 * @author iyefreed
 */
public class AttendancePanel extends ImagePanel {
    Connection conn = new DBConnection().connect();
    Date date = new Date();
    LocalDate localDate = date.toInstant().atZone(ZoneId.of("Asia/Jakarta")).toLocalDate();
    String bulan = localDate.getMonth().getDisplayName(TextStyle.FULL, new Locale("id", "ID"));
    String tahun = Integer.toString(localDate.getYear());

    /**
     * Creates new form AttendancePanel
     */
    public AttendancePanel() {
        super(new ImageIcon("src\\assets\\images\\hris_background.png").getImage());
        initComponents();
        initComboMonth();
        initComboYear();
        initAttendance(bulan, tahun);
        
        comboBulan.addItemListener((ItemEvent e) -> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                bulan = e.getItem().toString();
                initAttendance(bulan, tahun);
            }
        });
        
        comboTahun.addItemListener((ItemEvent e) -> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                tahun = e.getItem().toString();
                initAttendance(bulan, tahun);
            }
        });
    }
    
    private void initAttendance(String bulan, String tahun) {
        System.out.println(bulan+tahun);
        Object[] tHead = {"No", "Hari", "Tanggal", "Jam Masuk", "Jam Keluar", "Deskripsi Pekerjaan"};
        DefaultTableModel tableModel = new DefaultTableModel(null, tHead);
        tableAttendance.setModel(tableModel);
        
        String querySet = "SET @@lc_time_names = 'id_ID'";
        String query = "SELECT *, DAYNAME(t_absen.tanggal) AS hari FROM t_absen JOIN t_pegawai WHERE t_absen.pegawai_id=t_pegawai.id AND t_pegawai.id=? AND YEAR(t_absen.tanggal)=? AND MONTHNAME(t_absen.tanggal)=? ORDER BY tanggal ASC";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            PreparedStatement stm = conn.prepareStatement(querySet);
            stm.execute();
            stmt.setString(1, UserSession.getId());
            stmt.setString(2, tahun);
            stmt.setString(3, bulan);
            ResultSet result = stmt.executeQuery();
            
            int i = 1;
            while(result.next()) {
                
                String b = result.getString("hari");
                String c = result.getString("tanggal");
                String d = result.getString("jam_masuk");
                String e = result.getString("jam_keluar");
                String f = result.getString("job_desc");
                
                Object[] data = {i, b, c, d, e, f};
                tableModel.addRow(data);
                i++;
            }
        } catch(SQLException e) {
            System.err.println(e.toString());
            Object[] data = {"Tidak ada data ditemukan"};
            tableModel.addRow(data);
        }
    }
    
    private void initComboMonth() {
        String querySet = "SET @@lc_time_names = 'id_ID'";
        String query = "SELECT DISTINCT MONTHNAME(tanggal) AS bulan FROM t_absen WHERE pegawai_id=? ORDER BY tanggal DESC";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            PreparedStatement stm = conn.prepareStatement(querySet);
            stm.execute();
            stmt.setString(1, UserSession.getId());
            
            ResultSet result = stmt.executeQuery();
            
            while(result.next()) {
                comboBulan.addItem(result.getString("bulan"));
            }
        } catch(SQLException e) {
            System.err.println(e.toString());
        }
    }
    
    private void initComboYear() {
        String querySet = "SET @@lc_time_names = 'id_ID'";
        String query = "SELECT DISTINCT YEAR(tanggal) AS tahun FROM t_absen WHERE pegawai_id=? ORDER BY tanggal DESC";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            PreparedStatement stm = conn.prepareStatement(querySet);
            stm.execute();
            stmt.setString(1, UserSession.getId());
            
            ResultSet result = stmt.executeQuery();
            
            while(result.next()) {
                comboTahun.addItem(result.getString("tahun"));
                
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

        comboBulan = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAttendance = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        comboTahun = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();

        comboBulan.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N

        tableAttendance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tanggal", "Status", "Jadwal Absen", "Jam Masuk", "Jam Keluar", "Total Jam", "C/in Awal", "Keterlambatan", "Keterangan", "Status", "Aksi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAttendance.setEnabled(false);
        jScrollPane1.setViewportView(tableAttendance);

        jButton1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton1.setText("C/out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton2.setText("C/in");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        comboTahun.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N

        jButton4.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton4.setText("Print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 335, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Object[] items = {"WFH", "WFO"};
        JComboBox statusCombo = new JComboBox(items);
        final JComponent[] inputs = new JComponent[] {
            new JLabel("Status"),
            statusCombo
        };
        
        int result = JOptionPane.showConfirmDialog(null, inputs, "Check-in", JOptionPane.PLAIN_MESSAGE);
        if(result == JOptionPane.OK_OPTION) {
            SimpleDateFormat fJam = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat fTangggal = new SimpleDateFormat("yyyy-MM-dd");
            String query = "INSERT INTO t_absen(pegawai_id, jam_masuk, tanggal, status) VALUES (?, ?, ?, ?)";
            String jamMasuk = fJam.format(date);
            String tanggal = fTangggal.format(date);

            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, UserSession.getId());
                stmt.setString(2, jamMasuk);
                stmt.setString(3, tanggal);
                stmt.setString(4, statusCombo.getSelectedItem().toString());
                stmt.execute();

                JOptionPane.showMessageDialog(this, "Data absen berhasil di input");
                initAttendance(bulan, tahun);
            } catch (SQLException e) {
                System.err.println(e.toString());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JTextArea descJob = new JTextArea();
        final JComponent[] inputs = new JComponent[] {
            new JLabel("Deskripsi Pekerjaan"),
            descJob
        };
        
        int result = JOptionPane.showConfirmDialog(null, inputs, "Check-in", JOptionPane.PLAIN_MESSAGE);
        
        if(result == JOptionPane.OK_OPTION) {
            // Update query
            String query = "UPDATE t_absen SET jam_keluar=?, job_desc=? WHERE tanggal=? AND pegawai_id=?";

            // Format jam
            SimpleDateFormat fJam = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat fTangggal = new SimpleDateFormat("yyyy-MM-dd");
            String jamKeluar = fJam.format(date);
            String fTanggal = fTangggal.format(date);

            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, jamKeluar);
                stmt.setString(2, descJob.getText());
                stmt.setString(3, fTanggal);
                stmt.setString(4, UserSession.getId());

                stmt.execute();

                JOptionPane.showMessageDialog(this, "Berhasil Check Out");
                initAttendance(bulan, tahun);
            } catch(SQLException e) {
                System.err.println(e.toString());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            String fileName = "src/report/report_absen.jasper";
//            Map<String, Object> params = new HashMap<>();
            HashMap params = new HashMap();
            params.put("pegawai_id", UserSession.getId());
            params.put("bulan", comboBulan.getSelectedItem().toString());
            params.put("tahun", comboTahun.getSelectedItem().toString());
            File file = new File(fileName);

            JasperReport reportAbsen = (JasperReport) JRLoader.loadObject(file);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportAbsen, params, conn);
            JasperViewer.viewReport(jasperPrint);
        } catch(JRException e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBulan;
    private javax.swing.JComboBox<String> comboTahun;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAttendance;
    // End of variables declaration//GEN-END:variables
}
