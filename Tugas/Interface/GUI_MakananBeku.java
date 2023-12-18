/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tugas.Interface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class GUI_MakananBeku extends javax.swing.JFrame {

    /**
     * Creates new form GUI_MakananBeku
     */
    public GUI_MakananBeku() {
        initComponents();
        tampil();
    }
    
    public Connection conn;
    
    public void batal() {
        txt_nama.setText("");
        txt_harga.setText("");
        txt_berat.setText("");
        txt_produksi.setText("");
        txt_jenis.setText("");
        txt_kemasan.setText("");
        txt_varian.setText("");
        txt_sertif.setText("");
    }
    
    public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/OOP_2218106?user=root&password=");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_MakananBeku.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(GUI_MakananBeku.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(GUI_MakananBeku.class.getName()).log(Level.SEVERE, null, es);
        }
    }
    String nama1, harga1, berat1, produksi1, jenis1, kemasan1, varian1, sertifikasi1;
    public void itempilih() {
        txt_nama.setText(nama1);
        txt_harga.setText(harga1);
        txt_berat.setText(berat1);
        txt_produksi.setText(produksi1);
        txt_jenis.setText(jenis1);
        txt_kemasan.setText(kemasan1);
        txt_varian.setText(varian1);
        txt_sertif.setText(sertifikasi1);
    }
    
    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("NAMA MAKANAN");
        tabelhead.addColumn("HARGA");
        tabelhead.addColumn("BERAT");
        tabelhead.addColumn("PRODUKSI");
        tabelhead.addColumn("JENIS");
        tabelhead.addColumn("KEMASAN");
        tabelhead.addColumn("VARIAN");
        tabelhead.addColumn("SERTIFIKASI");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_makananbeku";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9),});
            }
            table_data_makanan.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }
    
    public void delete() {
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE FROM tb_makananbeku WHERE nim='" + txt_nama.getText() + "'";
                java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
                batal();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di hapus");
            }
        }
        refresh();
    }
    
    public void cari() {
        try {
            try ( Statement statement = conn.createStatement()) {
                String sql = "SELECT * FROM tb_makananbeku WHERE `nim`  LIKE '%" + txt_search.getText() + "%'";
                ResultSet rs = statement.executeQuery(sql); //menampilkan data dari sql query
                if (rs.next()) // .next() = scanner method
                {
                    txt_nama.setText(rs.getString(2));
                    txt_harga.setText(rs.getString(3));
                    txt_berat.setText(rs.getString(4));
                    txt_produksi.setText(rs.getString(5));
                    txt_jenis.setText(rs.getString(6));
                    txt_kemasan.setText(rs.getString(7));
                    txt_varian.setText(rs.getString(8));
                    txt_sertif.setText(rs.getString(9));
                } else {
                    JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
                }
            }
        } catch (Exception ex) {
            System.out.println("Error." + ex);
        }
    }
    
    public void update() {
        String Nama = txt_nama.getText();
        String Harga = txt_harga.getText();
        String Berat = txt_berat.getText();
        String Produksi = txt_produksi.getText();
        String Jenis = txt_jenis.getText();
        String Kemasan = txt_kemasan.getText();
        String Varian = txt_varian.getText();
        String Sertif = txt_sertif.getText();
        String Namalama = nama1;
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_makananbeku SET nama='" + Nama + "'," + "harga='" + Harga + "',"
                    + "berat='" + Berat + "'" + ",produksi='" + Produksi + "',jenis='" + Jenis + "',kemasan='"
                    + Kemasan + "',varian='" + Varian + "',sertif='"+ Sertif +"' WHERE nama = '" + Namalama + "'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Makanan Berhasil!");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        refresh();
    }
    
    public void refresh() {
        new GUI_MakananBeku().setVisible(true);
        this.setVisible(false);
    }
    
    public void insert() {
        String Nama = txt_nama.getText();
        String Harga = txt_harga.getText();
        String Berat = txt_berat.getText();
        String Produksi = txt_produksi.getText();
        String Jenis = txt_jenis.getText();
        String Kemasan = txt_kemasan.getText();
        String Varian = txt_varian.getText();
        String Sertif = txt_sertif.getText();
        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_makananbeku (nama, harga,berat, produksi, jenis,alamat)"
                    + "VALUES('" + Nama + "','" + Harga + "','" + Berat + "','" + Produksi + "','" + Jenis + "','" + Kemasan + "','" + Varian + "','" + Sertif + "')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Makanan!" + "\n" + Jenis);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
        refresh();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        txt_harga = new javax.swing.JTextField();
        txt_berat = new javax.swing.JTextField();
        txt_produksi = new javax.swing.JTextField();
        txt_jenis = new javax.swing.JTextField();
        txt_kemasan = new javax.swing.JTextField();
        txt_varian = new javax.swing.JTextField();
        txt_sertif = new javax.swing.JTextField();
        btnsimpan = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_data_makanan = new javax.swing.JTable();
        btnbatal = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("DATA MAKANAN");

        jLabel2.setText("Nama Makanan");

        jLabel3.setText("Harga Makanan");

        jLabel4.setText("Berat Makanan");

        jLabel5.setText("Produksi Makanan");

        jLabel6.setText("Jenis Makanan");

        jLabel7.setText("Jenis Kemasan");

        jLabel8.setText("Varian Makanan");

        jLabel9.setText("Sertifikasi Makanan");

        txt_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaActionPerformed(evt);
            }
        });

        txt_kemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kemasanActionPerformed(evt);
            }
        });

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        table_data_makanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama", "Harga", "Berat", "Produksi", "Jenis", "Kemasan", "Varian", "Sertifikasi"
            }
        ));
        table_data_makanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_data_makananMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_data_makanan);

        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        jButton1.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nama, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(txt_harga)
                    .addComponent(txt_berat)
                    .addComponent(txt_produksi)
                    .addComponent(txt_jenis)
                    .addComponent(txt_kemasan)
                    .addComponent(txt_varian)
                    .addComponent(txt_sertif))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnsimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnhapus)
                                .addGap(80, 80, 80)
                                .addComponent(btnbatal)
                                .addGap(80, 80, 80)
                                .addComponent(btnClose)
                                .addGap(15, 15, 15))
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_berat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_produksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_jenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_kemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_varian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_sertif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClose)
                            .addComponent(btnbatal)
                            .addComponent(btnhapus)
                            .addComponent(btnsimpan))))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namaActionPerformed

    private void txt_kemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kemasanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kemasanActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_btnbatalActionPerformed

    private void table_data_makananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_data_makananMouseClicked
        // TODO add your handling code here:
        int tabel = table_data_makanan.getSelectedRow();
        nama1 = table_data_makanan.getValueAt(tabel, 0).toString();
        harga1 = table_data_makanan.getValueAt(tabel, 1).toString();
        berat1 = table_data_makanan.getValueAt(tabel, 2).toString();
        produksi1 = table_data_makanan.getValueAt(tabel, 3).toString();
        jenis1 = table_data_makanan.getValueAt(tabel, 4).toString();
        kemasan1 = table_data_makanan.getValueAt(tabel, 5).toString();
        varian1 = table_data_makanan.getValueAt(tabel, 6).toString();
        sertifikasi1 = table_data_makanan.getValueAt(tabel, 7).toString();
        itempilih();
    }//GEN-LAST:event_table_data_makananMouseClicked

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
            java.util.logging.Logger.getLogger(GUI_MakananBeku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_MakananBeku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_MakananBeku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_MakananBeku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_MakananBeku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_data_makanan;
    private javax.swing.JTextField txt_berat;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_jenis;
    private javax.swing.JTextField txt_kemasan;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_produksi;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_sertif;
    private javax.swing.JTextField txt_varian;
    // End of variables declaration//GEN-END:variables
}
