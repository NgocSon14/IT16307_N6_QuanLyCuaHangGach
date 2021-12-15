package UI;

import DAO.ChatLieuDao;
import DAO.GachDAO;
import DAO.KichThuocDAO;
import DAO.NhaCungCapDao;
import DAO.PhieuNhapChiTietDAO;
import DAO.PhieuNhapDAO;
import Entity.ChatLieu;
import Entity.Gach;
import Entity.KichThuoc;
import Entity.NhaCungCap;
import Entity.PhieuNhap;
import Entity.PhieuNhapChiTiet;
import Helper.Check1;
import Helper.MsgBox;
import Helper.XDate;
import Helper.jdbcHelper;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class NhapHangUI extends javax.swing.JFrame {

    DefaultTableModel dtm, dtmTr;
    PhieuNhapDAO daoPn = new PhieuNhapDAO();
    PhieuNhapChiTietDAO daoPnct = new PhieuNhapChiTietDAO();
    NhaCungCapDao daoNcc = new NhaCungCapDao();
    GachDAO daoGach = new GachDAO();
    ChatLieuDao daoCl = new ChatLieuDao();
    KichThuocDAO daoKt = new KichThuocDAO();
    int soLuongGach;
    String KeyId;

    public NhapHangUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        HienThiLenTablePhieuNhap();
        HienThiLenThungRac();
        this.txtMaPhieuNhap.setEnabled(false);
        this.txtMaPhieuNhapCT1.setEnabled(false);
        this.txtNhaCungCap.setEnabled(false);
        this.txtTenGach.setEnabled(false);
        this.txtChatLieu.setEnabled(false);
        this.txtKichThuoc.setEnabled(false);
        this.NewCbbNcc();
        this.NewCbbGach();
        HienThiNhaCc();
    }

    private void LayMa() {
        ArrayList<PhieuNhap> listPn = daoPn.selectAll();
        for (PhieuNhap x : listPn) {
            KeyId = x.getMaPhieuNhap();
        }
        this.txtMaPhieuNhap.setText(KeyId);
    }

    private void NewCbbNcc() {
        ArrayList<NhaCungCap> listNcc = daoNcc.selectAll();
        for (NhaCungCap x : listNcc) {
            cbbTenNhaCC.addItem(x.getTenNhaCungCap());
        }
    }

    private void NewCbbGach() {
        ArrayList<Gach> listGach = daoGach.selectAll();
        for (Gach x : listGach) {
            cbbMaGach.addItem(x.getMaGach());
        }
    }

    private void HienThiNhaCc() {
        DefaultTableModel dtmNcc = (DefaultTableModel) this.tblNcc.getModel();
        dtmNcc.setRowCount(0);
        ArrayList<NhaCungCap> listNcc = daoNcc.selectAll();
        for (NhaCungCap x : listNcc) {
            Object[] rowData = new Object[]{
                x.getMaNhaCungCap(),
                x.getTenNhaCungCap(),};
            dtmNcc.addRow(rowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Tab1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblNcc = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        txtMaPhieuNhap = new javax.swing.JTextField();
        txtNhaCungCap = new javax.swing.JTextField();
        txtNgayNhap = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        Nhập = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txtMaPhieuNhapCT1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtSoLuong1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtSoLuonghangTrongKho = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtTenGach = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbbTenNhaCC = new javax.swing.JComboBox<>();
        cbbMaGach = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtChatLieu = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtKichThuoc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuNhap = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblThungRacPn = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtTimKiem1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 153, 0))); // NOI18N

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Search.png"))); // NOI18N
        jLabel8.setText("Tìm kiếm :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(433, 433, 433))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtTimKiem)))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NHẬP THÔNG TIN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 153, 0))); // NOI18N

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin nhà cung cấp"));

        tblNcc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhà cung cấp ", "Tên Nhà cung cấp "
            }
        ));
        jScrollPane3.setViewportView(tblNcc);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin phiếu nhập"));

        txtNhaCungCap.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNhaCungCapFocusLost(evt);
            }
        });
        txtNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhaCungCapActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã phiếu nhập :");

        jLabel3.setText("Mã nhà cung cấp :");

        jLabel2.setText("Ngày nhập :");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Add.png"))); // NOI18N
        jButton3.setText("Thêm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Nhập.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Add to basket.png"))); // NOI18N
        Nhập.setText("Nhập");
        Nhập.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NhậpActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Application form.png"))); // NOI18N
        jButton6.setText("Xóa form");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel14.setText("Mã phiếu nhập chi tiết ");

        txtSoLuong1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoLuong1FocusLost(evt);
            }
        });

        jLabel16.setText("Số lượng hàng nhập :  ");

        jLabel17.setText("Mã gạch");

        jLabel18.setText("Số lượng hàng có trong kho :");

        jLabel20.setText("Tên gạch : ");

        jLabel4.setText("Tên nhà cung cấp : ");

        cbbTenNhaCC.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbTenNhaCCItemStateChanged(evt);
            }
        });

        cbbMaGach.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMaGachItemStateChanged(evt);
            }
        });

        jLabel5.setText("Chất liệu : ");

        txtChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChatLieuActionPerformed(evt);
            }
        });

        jLabel6.setText("Kích thước : ");

        jLabel7.setText("Giá nhập : ");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Delete.png"))); // NOI18N
        jButton2.setText("Xóa ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(245, 245, 245)
                                .addComponent(txtSoLuong1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSoLuonghangTrongKho, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(Nhập, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel20)
                                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(25, 25, 25)))
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtChatLieu)
                                            .addComponent(txtTenGach)
                                            .addComponent(cbbMaGach, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jButton6))))
                    .addComponent(txtMaPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbTenNhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(2, 2, 2)
                                .addComponent(txtMaPhieuNhapCT1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(txtMaPhieuNhapCT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(cbbMaGach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbbTenNhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20)
                    .addComponent(txtTenGach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuonghangTrongKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(Nhập)
                        .addComponent(jButton6)))
                .addGap(49, 49, 49))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DANH SÁCH PHIẾU NHẬP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 153, 0))); // NOI18N

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu nhập", "Mã phiếu nhập chi tiết", "Ngày nhập", "Mã nhà cung cấp ", "Mã gạch", "Số lượng", "Giá nhập"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuNhap);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1412, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout Tab1Layout = new javax.swing.GroupLayout(Tab1);
        Tab1.setLayout(Tab1Layout);
        Tab1Layout.setHorizontalGroup(
            Tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1442, Short.MAX_VALUE)
        );
        Tab1Layout.setVerticalGroup(
            Tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tab1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Phiếu nhập ", Tab1);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Thùng rác phiếu nhập\n"));

        tblThungRacPn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu nhập", "Mã phiếu nhập chi tiết ", "Ngày nhập", "Mã nhà cung cấp", "Mã gạch", "Số lượng", "Giá nhập"
            }
        ));
        jScrollPane5.setViewportView(tblThungRacPn);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Search.png"))); // NOI18N
        jLabel9.setText("Tìm kiếm :");

        txtTimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiem1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1430, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(432, 432, 432)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtTimKiem1)))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Lịch sử nhập hàng ", jPanel12);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1447, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void HienThiLenTablePhieuNhap() {
        dtm = (DefaultTableModel) this.tblPhieuNhap.getModel();
        dtm.setRowCount(0);
        try {

            ArrayList<PhieuNhapChiTiet> listPhieuNhapChiTiet = this.daoPnct.selectAll();
            for (PhieuNhapChiTiet pnct : listPhieuNhapChiTiet) {
                if (pnct.isTrangThai()) {
                    Object[] rowData = new Object[]{
                        pnct.getMaPhieuNhap(),
                        pnct.getMaPhieuNhapChiTiet(),
                        pnct.getNgayNhap(),
                        pnct.getMaNhaCungCap(),
                        pnct.getMaGach(),
                        pnct.getSoluong(),
                        pnct.getGiaNhap(),};
                    dtm.addRow(rowData);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void HienThiLenThungRac() {
        dtmTr = (DefaultTableModel) this.tblThungRacPn.getModel();
        dtmTr.setRowCount(0);
        try {

            ArrayList<PhieuNhapChiTiet> listPhieuNhapChiTiet = this.daoPnct.selectAll();
            for (PhieuNhapChiTiet pnct : listPhieuNhapChiTiet) {
                if (!pnct.isTrangThai()) {
                    Object[] rowData = new Object[]{
                        pnct.getMaPhieuNhap(),
                        pnct.getMaPhieuNhapChiTiet(),
                        pnct.getNgayNhap(),
                        pnct.getMaNhaCungCap(),
                        pnct.getMaGach(),
                        pnct.getSoluong(),
                        pnct.getGiaNhap(),};
                    dtmTr.addRow(rowData);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private PhieuNhap getForm() {
        PhieuNhap pn = new PhieuNhap();
        pn.setNgayNhap(txtNgayNhap.getDate());
        pn.setMaNhaCungCap(txtNhaCungCap.getText());
        pn.setTrangThai(true);
        return pn;
    }

    private Gach getFormGach() {
        Gach g = new Gach();
        g.setMaGach(this.cbbMaGach.getSelectedItem().toString());
        g.setSoLuong(this.txtSoLuonghangTrongKho.getText());
        return g;
    }

    private void ThemPn() {
        if (this.txtNgayNhap.getDateFormatString().equals("") || this.txtSoLuong1.getText().equals("") || this.txtGiaNhap.getText().equals("")) {
            MsgBox.alert(this, "Không được để trống");
            return;
        }
        if (this.txtMaPhieuNhap.getText().equals("")) {
            PhieuNhap pn = getForm();
            try {
                daoPn.them(pn);
                MsgBox.alert(this, "Thêm phiếu nhập thành công");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.LayMa();
            PhieuNhapChiTiet pnct = getFormPnct();
            try {
                daoPnct.them(pnct);
                MsgBox.alert(this, "Đã thêm phiếu nhập chi tiết");
                HienThiLenTablePhieuNhap();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Gach g = getFormGach();
            try {
                daoGach.capNhatSoLuong(g);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.LayMa();
            PhieuNhapChiTiet pnct = getFormPnct();
            try {
                daoPnct.them(pnct);
                MsgBox.alert(this, "Đã thêm phiếu nhập chi tiết");
                HienThiLenTablePhieuNhap();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Gach g = getFormGach();
            try {
                daoGach.capNhatSoLuong(g);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void SuaPn() {
        if (MsgBox.confirm(this, "Bạn có muốn sửa phiếu nhập này không")) {
        }
        PhieuNhap pn = getForm();
        PhieuNhapChiTiet pnct = getFormPnct();
        try {
            daoPn.capNhat(pn);
            daoPnct.capNhat(pnct);
            HienThiLenTablePhieuNhap();
            MsgBox.alert(this, "Cập nhật thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại");
            e.printStackTrace();
        }
    }

    private void XoaPn() {
        if (MsgBox.confirm(this, "Xác nhận phiếu nhập")) {
            String ma = this.txtMaPhieuNhapCT1.getText();
            String maPn = this.txtMaPhieuNhap.getText();
            try {
                daoPnct.xoa(ma);
                this.HienThiLenTablePhieuNhap();
                this.HienThiLenThungRac();
                MsgBox.alert(this, "Nhập thành công");
                this.XoaFormPm();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void HienThiLenFormPhieuNhap() {
        int index = tblPhieuNhap.getSelectedRow();
        if (index == -1) {
            return;
        }
        DefaultTableModel dtm = (DefaultTableModel) this.tblPhieuNhap.getModel();
        this.txtMaPhieuNhap.setText(dtm.getValueAt(index, 0).toString());
        this.txtNgayNhap.setDate((Date) dtm.getValueAt(index, 2));
        this.txtMaPhieuNhapCT1.setText(dtm.getValueAt(index, 1).toString());
        this.txtNhaCungCap.setText(dtm.getValueAt(index, 3).toString());
        this.cbbMaGach.setSelectedItem(dtm.getValueAt(index, 4).toString());
        this.txtSoLuong1.setText(dtm.getValueAt(index, 5).toString());
        this.txtGiaNhap.setText(dtm.getValueAt(index, 6).toString());
    }


    private void tblPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhapMouseClicked
        this.HienThiLenFormPhieuNhap();
        String maGach = this.cbbMaGach.getSelectedItem().toString();
        Gach gach = daoGach.selectByID(maGach);
        if (maGach.trim().equals(gach.getMaGach().trim())) {
            this.txtTenGach.setText(gach.getTenGach());
            this.txtSoLuonghangTrongKho.setText(gach.getSoLuong());
        }
    }//GEN-LAST:event_tblPhieuNhapMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (Check1.checkName(txttenncc)
                &&Check1.checkNullText(txtdiachi)
                &&Check1.checkEmail(txtemail)
                && Check1.checkSDT(txtsdt)
                )
        ThemPn();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        XoaFormPm();
    }//GEN-LAST:event_jButton6ActionPerformed
    private void XoaFormPm() {
        this.txtMaPhieuNhap.setText("");
        this.txtNgayNhap.setDateFormatString("");
        this.txtNhaCungCap.setText("");
        this.XoaFormPnct();
    }


    private void txtNhaCungCapFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNhaCungCapFocusLost

    }//GEN-LAST:event_txtNhaCungCapFocusLost
    private void XoaFormPnct() {
        this.txtMaPhieuNhapCT1.setText("");
        this.txtSoLuong1.setText("");
        this.txtGiaNhap.setText("");
    }
    private void NhậpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NhậpActionPerformed
        this.XoaPn();
    }//GEN-LAST:event_NhậpActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        HienThiLenTablePhieuNhap();
        HienThiLenThungRac();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        ArrayList<PhieuNhapChiTiet> listPnct = daoPnct.selectAll();
        DefaultTableModel dtm = (DefaultTableModel) this.tblPhieuNhap.getModel();
        dtm.setRowCount(0);
        for (PhieuNhapChiTiet pnct : listPnct) {
            if (pnct.isTrangThai() && (pnct.getMaPhieuNhap().toString().contains(txtTimKiem.getText().trim())
                    || pnct.getMaPhieuNhapChiTiet().toString().contains(txtTimKiem.getText().trim())
                    || pnct.getMaPhieuNhapChiTiet().toString().contains(txtTimKiem.getText().trim())
                    || pnct.getNgayNhap().toString().contains(txtTimKiem.getText().trim())
                    || pnct.getMaNhaCungCap().toString().contains(txtTimKiem.getText().trim())
                    || pnct.getMaGach().toString().contains(txtTimKiem.getText().trim()))) {
                dtm.addRow(new Object[]{
                    pnct.getMaPhieuNhap(),
                    pnct.getMaPhieuNhapChiTiet(),
                    pnct.getNgayNhap(),
                    pnct.getMaNhaCungCap(),
                    pnct.getMaGach(),
                    pnct.getSoluong(),
                    pnct.getGiaNhap(),});
            }
        }
    }//GEN-LAST:event_txtTimKiemActionPerformed
    private PhieuNhapChiTiet getFormPnct() {
        PhieuNhapChiTiet pnct = new PhieuNhapChiTiet();
        pnct.setMaPhieuNhap(this.txtMaPhieuNhap.getText());
        pnct.setMaGach(cbbMaGach.getSelectedItem().toString());
        pnct.setSoluong(Integer.parseInt(txtSoLuong1.getText()));
        pnct.setGiaNhap(Integer.parseInt(txtGiaNhap.getText()));
        return pnct;
    }
    private void txtNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhaCungCapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhaCungCapActionPerformed

    private void cbbTenNhaCCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbTenNhaCCItemStateChanged
        String ma = this.cbbTenNhaCC.getSelectedItem().toString();
        NhaCungCap ncc = daoNcc.selectByName(ma);
        dtm = (DefaultTableModel) this.tblNcc.getModel();
        dtm.setRowCount(0);
        if (ncc.getTenNhaCungCap().trim().equals(ma)) {
            this.txtNhaCungCap.setText(ncc.getMaNhaCungCap());
            dtm.addRow(new Object[]{
                ncc.getMaNhaCungCap(),
                ncc.getTenNhaCungCap(),});
        }
    }//GEN-LAST:event_cbbTenNhaCCItemStateChanged

    private void cbbMaGachItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMaGachItemStateChanged
        String ma = this.cbbMaGach.getSelectedItem().toString();
        Gach g = daoGach.selectByID(ma);
        if (g.getMaGach().trim().equals(ma)) {
            this.txtTenGach.setText(g.getTenGach());
            this.txtNhaCungCap.setText(g.getMaNhaCungCap());
            this.txtSoLuonghangTrongKho.setText(g.getSoLuong());
        }
        ChatLieu cl = daoCl.selectByID(g.getMaChatLieu());
        this.txtChatLieu.setText(cl.getTenChatLieu());
        KichThuoc kt = daoKt.selectByID(g.getMaDv());
        this.txtKichThuoc.setText(kt.getTenDonVi());
    }//GEN-LAST:event_cbbMaGachItemStateChanged

    private void txtChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChatLieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChatLieuActionPerformed

    private void txtSoLuong1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoLuong1FocusLost
        int SoLuongNhap = Integer.parseInt(this.txtSoLuong1.getText());
        int SLHang = Integer.parseInt(this.txtSoLuonghangTrongKho.getText());
        int SLMoi = SoLuongNhap + SLHang;
        this.txtSoLuonghangTrongKho.setText(String.valueOf(SLMoi));
    }//GEN-LAST:event_txtSoLuong1FocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String key = this.txtMaPhieuNhapCT1.getText();
        try {
            daoPnct.XoaPnct(key);
            HienThiLenTablePhieuNhap();
            MsgBox.alert(this, "Xóa thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtTimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiem1ActionPerformed
        ArrayList<PhieuNhapChiTiet> listPnct = daoPnct.selectAll();
        DefaultTableModel dtm = (DefaultTableModel) this.tblThungRacPn.getModel();
        dtm.setRowCount(0);
        for (PhieuNhapChiTiet pnct : listPnct) {
            if (!pnct.isTrangThai() && (pnct.getMaPhieuNhap().toString().contains(txtTimKiem.getText().trim())
                    || pnct.getMaPhieuNhapChiTiet().toString().contains(txtTimKiem.getText().trim())
                    || pnct.getMaPhieuNhapChiTiet().toString().contains(txtTimKiem.getText().trim())
                    || pnct.getNgayNhap().toString().contains(txtTimKiem.getText().trim())
                    || pnct.getMaNhaCungCap().toString().contains(txtTimKiem.getText().trim())
                    || pnct.getMaGach().toString().contains(txtTimKiem.getText().trim()))) {
                dtm.addRow(new Object[]{
                    pnct.getMaPhieuNhap(),
                    pnct.getMaPhieuNhapChiTiet(),
                    pnct.getNgayNhap(),
                    pnct.getMaNhaCungCap(),
                    pnct.getMaGach(),
                    pnct.getSoluong(),
                    pnct.getGiaNhap(),});
            }
        }
    }//GEN-LAST:event_txtTimKiem1ActionPerformed

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
            java.util.logging.Logger.getLogger(NhapHangUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhapHangUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhapHangUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhapHangUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhapHangUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Nhập;
    private javax.swing.JPanel Tab1;
    private javax.swing.JComboBox<String> cbbMaGach;
    private javax.swing.JComboBox<String> cbbTenNhaCC;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblNcc;
    private javax.swing.JTable tblPhieuNhap;
    private javax.swing.JTable tblThungRacPn;
    private javax.swing.JTextField txtChatLieu;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtKichThuoc;
    private javax.swing.JTextField txtMaPhieuNhap;
    private javax.swing.JTextField txtMaPhieuNhapCT1;
    private com.toedter.calendar.JDateChooser txtNgayNhap;
    private javax.swing.JTextField txtNhaCungCap;
    private javax.swing.JTextField txtSoLuong1;
    private javax.swing.JTextField txtSoLuonghangTrongKho;
    private javax.swing.JTextField txtTenGach;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiem1;
    // End of variables declaration//GEN-END:variables
}
