package UI;

import DAO.BangGiaDao;
import DAO.ChatLieuDao;
import DAO.DAO;
import DAO.GachDAO;
import DAO.KichThuocDAO;
import DAO.NhaCungCapDao;
import DAO.TheLoaiDao;
import java.util.ArrayList;
import Entity.BangGia;
import Entity.ChatLieu;
import Entity.KichThuoc;
import Entity.NhaCungCap;
import Entity.TheLoai;
import Helper.Check1;
import Helper.Image;
import Helper.MsgBox;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

public class BangGiaUI extends javax.swing.JFrame {

    DefaultTableModel model;
    BangGiaDao daobg = new BangGiaDao();
    int row = -1;
    GachDAO daogach = new GachDAO();
    NhaCungCapDao daoncc = new NhaCungCapDao();
    ChatLieuDao daochatlieu = new ChatLieuDao();
    TheLoaiDao daotheloai = new TheLoaiDao();
    KichThuocDAO daodonvi = new KichThuocDAO();

    public BangGiaUI() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(2);
        fillDS();
        showNCC();
        showtheloai();
        showdonvi();
        showchatlieu();
        this.txttennhacc.setEditable(false);
        this.txttenchatlieu.setEditable(false);
        this.txttendonvi.setEditable(false);
        this.txttentheloai.setEditable(false);

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
        jTable1 = new javax.swing.JTable();
        tabs = new javax.swing.JTabbedPane();
        tab1 = new javax.swing.JPanel();
        txtgiagach = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldanhsach = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btncapnhapgia = new javax.swing.JButton();
        txtmagach = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txttengach = new javax.swing.JTextField();
        lblanh = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbomadonvi = new javax.swing.JComboBox<>();
        cbochatlieu = new javax.swing.JComboBox<>();
        cbotheloai = new javax.swing.JComboBox<>();
        cbomancc = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txttennhacc = new javax.swing.JTextField();
        txttendonvi = new javax.swing.JTextField();
        txttenchatlieu = new javax.swing.JTextField();
        txttentheloai = new javax.swing.JTextField();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("B???ng Gi??");

        tab1.setBackground(new java.awt.Color(255, 255, 255));
        tab1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtgiagach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgiagachActionPerformed(evt);
            }
        });

        tbldanhsach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M?? G???ch", "M?? nh?? cung c???p", "Gi?? G???ch", "T??n G???ch", "M?? ????n V???", "S??? L?????ng", "M?? ch???t li???u", "M?? th??? lo???i", "???nh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbldanhsach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldanhsachMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbldanhsach);

        jLabel4.setText("Gi?? G???ch");

        btncapnhapgia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Refresh.png"))); // NOI18N
        btncapnhapgia.setText("C???p nh???p gi??");
        btncapnhapgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncapnhapgiaActionPerformed(evt);
            }
        });

        txtmagach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmagachActionPerformed(evt);
            }
        });

        jLabel1.setText("M?? g???ch");

        jLabel2.setText("M?? nh?? cung c???p");

        jLabel3.setText("T??n g???ch");

        txttengach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttengachActionPerformed(evt);
            }
        });

        lblanh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblanhMouseClicked(evt);
            }
        });

        jLabel5.setText("S??? L?????ng");

        jLabel6.setText("M?? ????n v???");

        jLabel7.setText("M?? ch???t li???u");

        jLabel8.setText("M?? th??? lo???i");

        cbomadonvi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbomadonviItemStateChanged(evt);
            }
        });

        cbochatlieu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbochatlieuItemStateChanged(evt);
            }
        });

        cbotheloai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbotheloaiItemStateChanged(evt);
            }
        });

        cbomancc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbomanccItemStateChanged(evt);
            }
        });

        jLabel9.setText("T??n th??? lo???i");

        jLabel10.setText("T??n nh?? cung c???p");

        jLabel11.setText("T??n Ch???t li???u");

        jLabel12.setText("T??n ????n v???");

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblanh, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(63, 63, 63)))
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tab1Layout.createSequentialGroup()
                                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmagach, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtgiagach, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttengach, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tab1Layout.createSequentialGroup()
                                        .addGap(0, 47, Short.MAX_VALUE)
                                        .addComponent(jLabel2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))))
                            .addGroup(tab1Layout.createSequentialGroup()
                                .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)))
                        .addGap(18, 18, 18)
                        .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbotheloai, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbochatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbomancc, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbomadonvi, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9))
                        .addGap(31, 31, 31)
                        .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttentheloai, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttenchatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttendonvi, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttennhacc, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(228, Short.MAX_VALUE))
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addComponent(btncapnhapgia)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jScrollPane2)
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblanh, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmagach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(cbomancc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txttennhacc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbomadonvi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel12)
                                .addComponent(txttendonvi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txttengach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbochatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgiagach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)
                            .addComponent(txttenchatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbotheloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(txttentheloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btncapnhapgia)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabs.addTab("Danh S??ch", tab1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbldanhsachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldanhsachMouseClicked
        if (evt.getClickCount() == 1) {
            tabs.setSelectedIndex(0);
            row = tbldanhsach.getSelectedRow();
            setForm(daobg.selectByIDGACH(tbldanhsach.getValueAt(row, 0).toString()));
            updateStatus();
        }
    }//GEN-LAST:event_tbldanhsachMouseClicked

    private void txtgiagachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgiagachActionPerformed

    }//GEN-LAST:event_txtgiagachActionPerformed

    private void btncapnhapgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncapnhapgiaActionPerformed
        if (Check1.checkNullText(txttengach)
                && Check1.checkDiem(txtgiagach)
                && Check1.checkDiem(txtsoluong))
        them();
    }//GEN-LAST:event_btncapnhapgiaActionPerformed

    private void txtmagachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmagachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmagachActionPerformed

    private void txttengachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttengachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttengachActionPerformed

    private void lblanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblanhMouseClicked
        if (evt.getClickCount() == 2) {
            chonAnh();
        }
    }//GEN-LAST:event_lblanhMouseClicked

    private void cbomadonviItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbomadonviItemStateChanged
String ma = this.cbomadonvi.getSelectedItem().toString();
        KichThuoc cl = daodonvi.selectByID(ma);
        if (cl.getMaDonVi().trim().equals(ma)) {
            this.txttendonvi.setText(cl.getTenDonVi());
        }      
    }//GEN-LAST:event_cbomadonviItemStateChanged

    private void cbomanccItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbomanccItemStateChanged
      String ma = this.cbomancc.getSelectedItem().toString();
        NhaCungCap ncc = daoncc.selectByID(ma);
        if (ncc.getMaNhaCungCap().trim().equals(ma)) {
            this.txttennhacc.setText(ncc.getTenNhaCungCap());
        }
    }//GEN-LAST:event_cbomanccItemStateChanged

    private void cbochatlieuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbochatlieuItemStateChanged
       String ma = this.cbochatlieu.getSelectedItem().toString();
        ChatLieu cl = daochatlieu.selectByID(ma);
        if (cl.getMaChatLieu().trim().equals(ma)) {
            this.txttenchatlieu.setText(cl.getTenChatLieu());
        }
    }//GEN-LAST:event_cbochatlieuItemStateChanged

    private void cbotheloaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbotheloaiItemStateChanged
      String ma = this.cbotheloai.getSelectedItem().toString();
        TheLoai tl = daotheloai.selectByID(ma);
        if(tl.getMaTheLoai().trim().equals(ma)){
            this.txttentheloai.setText(tl.getTenTheLoai());
        }
        
    }//GEN-LAST:event_cbotheloaiItemStateChanged

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
            java.util.logging.Logger.getLogger(BangGiaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BangGiaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BangGiaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BangGiaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BangGiaUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncapnhapgia;
    private javax.swing.JComboBox<String> cbochatlieu;
    private javax.swing.JComboBox<String> cbomadonvi;
    private javax.swing.JComboBox<String> cbomancc;
    private javax.swing.JComboBox<String> cbotheloai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblanh;
    private javax.swing.JPanel tab1;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbldanhsach;
    private javax.swing.JTextField txtgiagach;
    private javax.swing.JTextField txtmagach;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txttenchatlieu;
    private javax.swing.JTextField txttendonvi;
    private javax.swing.JTextField txttengach;
    private javax.swing.JTextField txttennhacc;
    private javax.swing.JTextField txttentheloai;
    // End of variables declaration//GEN-END:variables

    void fillDS() {
        model = (DefaultTableModel) tbldanhsach.getModel();
        ArrayList<BangGia> listbg = daobg.selectAllGACH();
        model.setRowCount(0);
        for (BangGia x : listbg) {
            model.addRow(new Object[]{x.getMaGach(), x.getMaNhaCungCap(), x.getGia(), x.getTenGach(), x.getMaDonVI(), x.getSoLuong(), x.getMaChatLieu(), x.getMaTheLoai(), x.getAnh()});
        }
    }

    private void setForm(BangGia bg) {
        txtmagach.setText(bg.getMaGach());
        cbomancc.setSelectedItem(bg.getMaNhaCungCap());
        txtgiagach.setText(bg.getGia() + "");
        txttengach.setText(bg.getTenGach());
       cbomadonvi.setSelectedItem(bg.getMaDonVI());
        txtsoluong.setText(bg.getSoLuong() + "");
       cbochatlieu.setSelectedItem(bg.getMaChatLieu());
      cbotheloai.setSelectedItem(bg.getMaTheLoai());
        if (bg.getAnh() != null) {
            lblanh.setIcon(Image.read(bg.getAnh()));
        }
    }

    void updateStatus() {
        boolean click = row >= 0;
        txtmagach.setEnabled(!click);
        txttengach.setEnabled(!click);
        txtsoluong.setEnabled(!click);
        
    }

    private void them() {
        BangGia bg = getform();
        try {
            daobg.them(bg);
            fillDS();

            MsgBox.alert(this, "Th??m gi?? g???ch th??nh c??ng");
        } catch (Exception e) {
            MsgBox.alert(this, "Th??m gi?? g???ch th???t b???i");
            e.printStackTrace();
        }
    }

    public BangGia getform() {
        BangGia bg = new BangGia();
        bg.setMaGach(txtmagach.getText());
        bg.setMaNhaCungCap(cbomancc.getSelectedItem().toString());
        bg.setGia(Float.parseFloat(txtgiagach.getText()));

        return bg;
    }

    void chonAnh() {
        JFileChooser jfc = new JFileChooser("logos");
        if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            Image.save(file);
            lblanh.setToolTipText(file.getName());
            lblanh.setIcon(Image.read(file.getName()));
        }
    }

  

    void showNCC() {
        ArrayList<NhaCungCap> listncc = daoncc.selectAll();
        cbomancc.removeAllItems();
        for (NhaCungCap ncc : listncc) {
            cbomancc.addItem(ncc.getMaNhaCungCap() + "");
        }
        fillDS();
    }

      void showchatlieu() {
        ArrayList<ChatLieu> listdaochatlieu = daochatlieu.selectAll();
        cbochatlieu.removeAllItems();
        for (ChatLieu ncc : listdaochatlieu) {
            cbochatlieu.addItem(ncc.getMaChatLieu() + "");
        }
        fillDS();
    }

    void showtheloai() {
        ArrayList<TheLoai> listtheloai = daotheloai.selectAll();
        cbotheloai.removeAllItems();
        for (TheLoai ncc : listtheloai) {
            cbotheloai.addItem(ncc.getMaTheLoai() + "");
        }
        fillDS();
    }

    void showdonvi() {
        ArrayList<KichThuoc> listdonvi = daodonvi.selectAll();
        cbomadonvi.removeAllItems();
        for (KichThuoc ncc : listdonvi) {
            cbomadonvi.addItem(ncc.getMaDonVi() + "");
        }
        fillDS();
    }

    
}
