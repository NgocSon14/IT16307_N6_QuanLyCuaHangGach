/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.table.DefaultTableModel;
import DAO.NhaCungCapDao;
import Entity.NhaCungCap;
import Helper.MsgBox;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class NhaCungCapUI extends javax.swing.JFrame {

    int row = -1;
    DefaultTableModel modelNCC;
    DefaultTableModel modelds;
    DefaultTableModel modellt;
    NhaCungCapDao daoncc = new NhaCungCapDao();

    public NhaCungCapUI() {
        initComponents();
        init();
        prepareGui();
        fillDS();
        fillLT();

    }

    void init() {
        setTitle("Quản lí nhà cung cấp");
        setLocationRelativeTo(null);
        setResizable(false);
        tabs.setSelectedIndex(0);
        setDefaultCloseOperation(2);
        defaullform();
    }

    void prepareGui() {
        String[] h = {"Mã NCC", "Tên NCC", "Địa Chỉ", "SĐT", "Email", "Thông tin khác"};
        modelds = new DefaultTableModel(h, 0) {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        modellt = new DefaultTableModel(h, 0) {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };

        tblDS.setModel(modelds);
        tblLT.setModel(modellt);
    }

    void fillDS() {
        ArrayList<NhaCungCap> list = daoncc.selectAll();
        modelds.setRowCount(0);
        for (NhaCungCap ncc : list) {
            if (ncc.isTrangThai()) {
                modelds.addRow(new Object[]{ncc.getMaNhaCungCap(), ncc.getTenNhaCungCap(), ncc.getDiaChi(), ncc.getSDT(), ncc.getEmail(), ncc.getThongTinKhac(), true});
            }
        }
    }

    void fillLT() {
        ArrayList<NhaCungCap> list = daoncc.selectAll();
        modellt.setRowCount(0);
        for (NhaCungCap ncc : list) {
            if (!ncc.isTrangThai()) {
                modellt.addRow(new Object[]{ncc.getMaNhaCungCap(), ncc.getTenNhaCungCap(), ncc.getDiaChi(), ncc.getSDT(), ncc.getEmail(), ncc.getThongTinKhac(), true});
            }
        }
    }

    void setform(NhaCungCap ncc) {
        txtmancc.setText(ncc.getMaNhaCungCap());
        txttenncc.setText(ncc.getTenNhaCungCap());
        txtdiachi.setText(ncc.getDiaChi());
        txtsdt.setText(ncc.getSDT());
        txtemail.setText(ncc.getEmail());
        txtthongtinkhac.setText(ncc.getThongTinKhac());

    }

    NhaCungCap getform() {
        NhaCungCap ncc = new NhaCungCap();
        ncc.setMaNhaCungCap(txtmancc.getText());
        ncc.setTenNhaCungCap(txttenncc.getText());
        ncc.setDiaChi(txtdiachi.getText());
        ncc.setSDT(txtsdt.getText());
        ncc.setEmail(txtemail.getText());
        ncc.setThongTinKhac(txtthongtinkhac.getText());
        ncc.setTrangThai(true);
        return ncc;
    }

    void defaullform() {
        row = -1;
        txtmancc.setText("");
        txttenncc.setText("");
        txtdiachi.setText("");
        txtsdt.setText("");
        txtemail.setText("");
        txtthongtinkhac.setText("");
        btnxoa.setEnabled(false);
        btnchinhsua.setEnabled(false);
    }

    void updateStatus() {
        boolean click = row >= 0;
        btnxoa.setEnabled(click);
        btnchinhsua.setEnabled(click);
        txtmancc.setEnabled(!click);

    }

    void xoa() {

        if (MsgBox.confirm(this, "Bạn có muốn xoá không?")) {
            daoncc.xoa(txtmancc.getText());
            fillDS();
            fillLT();
            defaullform();
            updateStatus();
            tabs.setSelectedIndex(2);

        }

    }

    void khoiphuc() {

        if (MsgBox.confirm(this, "Bạn có muốn khôi phục không không?")) {

        }
        NhaCungCap nccdao = daoncc.selectByID(tblLT.getValueAt(tblLT.getSelectedRow(), 0).toString());
        nccdao.setTrangThai(true);
        daoncc.capNhat(nccdao);
        fillDS();
        fillLT();
        defaullform();
        updateStatus();
        tabs.setSelectedIndex(0);

    }

    void chinhsua() {

        if (MsgBox.confirm(this, "Bạn có muốn chỉnh sửa không không?")) {

        }
        daoncc.capNhat(getform());
        fillDS();
        fillLT();
        defaullform();
        updateStatus();
        tabs.setSelectedIndex(0);

    }

    void timkiem() {
        ArrayList<NhaCungCap> list = daoncc.selectAll();
        modelds.setRowCount(0);
        for (NhaCungCap ncc : list) {
            if (ncc.isTrangThai() &&  (ncc.getThongTinKhac().toString().contains(txtTimKiem.getText().trim())
                    || ncc.getMaNhaCungCap().toString().contains(txtTimKiem.getText().trim())
                    || ncc.getTenNhaCungCap().toString().contains(txtTimKiem.getText().trim())
                    || ncc.getDiaChi().toString().contains(txtTimKiem.getText().trim())
                    || ncc.getSDT().toString().contains(txtTimKiem.getText().trim())
                    || ncc.getEmail().toString().contains(txtTimKiem.getText().trim()))) {
                modelds.addRow(new Object[]{ncc.getMaNhaCungCap(), ncc.getTenNhaCungCap(), ncc.getDiaChi(), ncc.getSDT(), ncc.getEmail(), ncc.getThongTinKhac(), true});
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
        tabs = new javax.swing.JTabbedPane();
        tab1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDS = new javax.swing.JTable();
        tab2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtmancc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttenncc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtdiachi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtthongtinkhac = new javax.swing.JTextArea();
        btnxoa = new javax.swing.JButton();
        btnchinhsua = new javax.swing.JButton();
        tab3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLT = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tìm kiếm");

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        tblDS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã NCC", "Tên NCC", "Địa chỉ", "SĐT", "Email", "Thông tin khác"
            }
        ));
        tblDS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDS);

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tabs.addTab("Danh sách", tab1);

        jLabel2.setText("Mã NCC:");

        jLabel3.setText("Tên NCC:");

        jLabel4.setText("Địa chỉ:");

        jLabel5.setText("SĐT:");

        jLabel6.setText("Email");

        jLabel7.setText("Thông tin khác");

        txtthongtinkhac.setColumns(20);
        txtthongtinkhac.setRows(5);
        jScrollPane3.setViewportView(txtthongtinkhac);

        btnxoa.setText("Xoá");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnchinhsua.setText("Chỉnh sửa");
        btnchinhsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchinhsuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tab2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(42, 42, 42)
                                .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tab2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(42, 42, 42)
                                .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tab2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(42, 42, 42)
                                .addComponent(txttenncc, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tab2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(42, 42, 42)
                                .addComponent(txtmancc, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tab2Layout.createSequentialGroup()
                                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(42, 42, 42)
                                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(tab2Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(btnxoa)
                        .addGap(33, 33, 33)
                        .addComponent(btnchinhsua)))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtmancc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txttenncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(tab2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnxoa)
                    .addComponent(btnchinhsua))
                .addContainerGap(139, Short.MAX_VALUE))
        );

        tabs.addTab("Thông tin", tab2);

        tblLT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã NCC", "Tên NCC", "Địa chỉ", "SĐT", "Email", "Thông tin khác"
            }
        ));
        jScrollPane2.setViewportView(tblLT);

        jButton1.setText("Khôi phục");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tabs.addTab("Lưu trữ", tab3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSMouseClicked
        if (evt.getClickCount() == 2) {
            tabs.setSelectedIndex(1);
            row = tblDS.getSelectedRow();
            setform(daoncc.selectByID(tblDS.getValueAt(row, 0).toString()));
            updateStatus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_tblDSMouseClicked

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        xoa();        // TODO add your handling code here:
    }//GEN-LAST:event_btnxoaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        khoiphuc();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnchinhsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchinhsuaActionPerformed
        chinhsua();        // TODO add your handling code here:
    }//GEN-LAST:event_btnchinhsuaActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        timkiem();
    }//GEN-LAST:event_txtTimKiemKeyReleased

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
            java.util.logging.Logger.getLogger(NhaCungCapUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhaCungCapUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhaCungCapUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhaCungCapUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhaCungCapUI().setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnchinhsua;
    private javax.swing.JButton btnxoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblDS;
    private javax.swing.JTable tblLT;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtmancc;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txttenncc;
    private javax.swing.JTextArea txtthongtinkhac;
    // End of variables declaration//GEN-END:variables
}
