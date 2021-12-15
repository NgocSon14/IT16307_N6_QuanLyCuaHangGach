package UI;

import DAO.BangGiaDao;
import DAO.GachDAO;
import DAO.KhachHangDao;
import DAO.NhaCungCapDao;
import DAO.PhieuXuatChiTietDAO;
import DAO.PhieuXuatDAO;
import Entity.BangGia;
import Entity.Gach;
import Entity.KhachHang;
import Entity.NhaCungCap;
import Entity.PhieuNhapChiTiet;
import Entity.PhieuXuat;
import Entity.PhieuXuatChiTiet;
import Helper.MsgBox;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class PhieuXuatUI extends javax.swing.JFrame {

    PhieuXuatDAO daoPx = new PhieuXuatDAO();
    PhieuXuatChiTietDAO daoPxct = new PhieuXuatChiTietDAO();
    KhachHangDao daoKh = new KhachHangDao();
    BangGiaDao daoBg = new BangGiaDao();
    GachDAO daoGach = new GachDAO();
    NhaCungCapDao daoNcc = new NhaCungCapDao();
    DefaultTableModel dtm;
    String keyId;

    public PhieuXuatUI() {
        initComponents();
        setDefaultCloseOperation(2);
        this.setLocationRelativeTo(null);
        HienThiLenTablePhieuXuat();
        HienThiLenTableThungRacPn();
        this.txtMaPhieuXuat1.setEnabled(false);
        this.txtMaPhieuXuatCT.setEnabled(false);
        this.cbbNccNew();
        this.cbbGach();
        this.txtSoHangCoTrongKho.setEnabled(false);
        HienThiKhachHang();
    }

    private void LayMaPx() {
        ArrayList<PhieuXuat> listPx = daoPx.selectAll();
        for (PhieuXuat x : listPx) {
            keyId = x.getMaPhieuXuat();
        }
        this.txtMaPhieuXuat1.setText(keyId);
    }

    private void cbbNccNew() {
        ArrayList<NhaCungCap> listNcc = daoNcc.selectAll();
        for (NhaCungCap x : listNcc) {
            cbbNcc.addItem(x.getMaNhaCungCap());
        }
    }

    private void cbbGach() {
        ArrayList<Gach> listGach = daoGach.selectAll();
        for (Gach x : listGach) {
            cbbgach.addItem(x.getMaGach());
        }
    }

    private void HienThiKhachHang() {
        dtm = (DefaultTableModel) this.tblKh.getModel();
        dtm.setRowCount(0);
        ArrayList<KhachHang> listKh = daoKh.selectAll();
        for (KhachHang x : listKh) {
            Object[] rowData = new Object[]{
                x.getMaKhachHang(),
                x.getTenKhachHang(),};
            dtm.addRow(rowData);
        }
    }

    private void HienThiLenTablePhieuXuat() {
        DefaultTableModel dtm = (DefaultTableModel) this.tblPhieuNhap.getModel();
        dtm.setRowCount(0);

        ArrayList<PhieuXuatChiTiet> listPxct = daoPxct.selectAll();
        for (PhieuXuatChiTiet y : listPxct) {

            if (y.isTrangThai()) {
                Object[] rowData = new Object[]{
                    y.getMaPhieuXuat(),
                    y.getMaPhieuXuatChiTiet(),
                    y.getNgayXuat(),
                    y.getMaKh(),
                    y.getNhaCungCap(),
                    y.getMaGach(),
                    y.getSoLuong(),
                    y.getGiaBan(),};
                dtm.addRow(rowData);
            }

        }
    }

    private void hienThiGia() {
        String ma = this.txtTenGach.getText();
        float soLuong = Integer.parseInt(this.txtSoLuong.getText());
        BangGia bg = daoBg.selectByID(ma);
        float gia = soLuong * bg.getGia();
        this.txtGiaBan.setText(String.valueOf(gia));
    }

    private void HienThiLenTableThungRacPn() {
        DefaultTableModel dtm = (DefaultTableModel) this.tblThungRacPn.getModel();
        dtm.setRowCount(0);
        ArrayList<PhieuXuatChiTiet> listPxct = daoPxct.selectAll();
        for (PhieuXuatChiTiet y : listPxct) {

            if (!y.isTrangThai()) {
                Object[] rowData = new Object[]{
                    y.getMaPhieuXuat(),
                    y.getMaPhieuXuatChiTiet(),
                    y.getNgayXuat(),
                    y.getMaKh(),
                    y.getNhaCungCap(),
                    y.getMaGach(),
                    y.getSoLuong(),
                    y.getGiaBan(),};
                dtm.addRow(rowData);
            }

        }
    }

    private PhieuXuat getFormPx() {
        PhieuXuat px = new PhieuXuat();
        px.setMaKhachHang(txtMaKhachHang.getText());
        px.setNgayXuat(txtNgayXuat.getDate());
        px.setTrangThai(true);
        return px;
    }

    private void themPxct() {
        if (txtMaPhieuXuatCT.getText().equals("") || txtSoLuong.getText().equals("") || txtGiaBan.getText().equals("")) {
            MsgBox.alert(this, "Không được để trống");
            return;
        }
        PhieuXuatChiTiet pxct = getFormPxct();
        try {
            daoPxct.them(pxct);
            MsgBox.alert(this, "Thêm phiếu xuất thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void themPx() {
        if (txtMaPhieuXuat1.getText().equals("") || txtNgayXuat.getDateFormatString().equals("") || txtMaKhachHang.getText().equals("")) {
            MsgBox.alert(this, "Không được để trống");
            return;
        }
        PhieuXuat px = getFormPx();
        try {
            daoPx.them(px);
            MsgBox.alert(this, "Thêm phiếu xuất thành công");
        } catch (Exception e) {
            e.printStackTrace();
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
        XuatHang = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txtTimKiemXH = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKh = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtMaPhieuXuat1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNgayXuat = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        txtMaPhieuXuatCT = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnXoaForm = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtTenGach = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtSoHangCoTrongKho = new javax.swing.JTextField();
        cbbgach = new javax.swing.JComboBox<>();
        cbbNcc = new javax.swing.JComboBox<>();
        lblTenNcc = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuNhap = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblThungRacPn = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        XuatHang.setBackground(new java.awt.Color(255, 255, 255));
        XuatHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XuatHangMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("TÌM KIẾM"));

        jButton1.setText("Tìm kiếm ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiemXH, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(572, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemXH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("THÔNG TIN KHÁCH HÀNG"));

        tblKh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng"
            }
        ));
        jScrollPane2.setViewportView(tblKh);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("THÔNG TIN PHIẾU XUẤT"));

        jLabel6.setText("Mã phiếu xuất ");

        jLabel7.setText("Mã khách hàng ");

        txtMaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKhachHangActionPerformed(evt);
            }
        });

        jLabel8.setText("Ngày xuất ");

        jLabel10.setText("Mã phiếu xuất chi tiết : ");

        jLabel11.setText("Mã gạch : ");

        jLabel12.setText("Mã nhà cung cấp : ");

        jLabel13.setText("Số lượng mua: ");

        txtSoLuong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoHangCoTrongKhoFocusLost(evt);
            }
        });

        jLabel14.setText("Giá bán : ");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Euro.png"))); // NOI18N
        btnXoa.setText("Xuất");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnXoaForm.setText("Xóa form");
        btnXoaForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaFormActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel9.setText("Tên gạch : ");

        jLabel15.setText("Số lượng hàng trong kho :");

        txtSoHangCoTrongKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoHangCoTrongKhoActionPerformed(evt);
            }
        });

        cbbgach.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbgachItemStateChanged(evt);
            }
        });

        cbbNcc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbNccItemStateChanged(evt);
            }
        });

        lblTenNcc.setForeground(new java.awt.Color(255, 51, 51));

        jLabel17.setText("Tên nhà cung cấp :");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMaPhieuXuat1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNgayXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(124, 124, 124)
                                        .addComponent(txtMaPhieuXuatCT, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel15))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(49, 49, 49)
                                        .addComponent(cbbgach, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)
                                .addComponent(btnXoaForm, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblTenNcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbNcc, 0, 151, Short.MAX_VALUE)
                                    .addComponent(txtTenGach))
                                .addGap(34, 34, 34))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSoHangCoTrongKho, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMaPhieuXuat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtMaPhieuXuatCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(cbbgach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(lblTenNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtNgayXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSoHangCoTrongKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(txtTenGach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(79, 79, 79)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa)
                    .addComponent(btnThem)
                    .addComponent(btnXoaForm)
                    .addComponent(btnThoat))
                .addGap(26, 26, 26))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("DANH SÁCH PHIẾU XUẤT"));

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu xuất ", "Mã phiếu xuất chi tiết", "Ngày xuất", "Mã khách hàng", "Mã nhà cung cấp", "Mã gạch", "Số lượng", "Giá bán"
            }
        ));
        tblPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuNhap);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247))
        );

        XuatHang.addTab("Xuất hàng ", jPanel3);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tblThungRacPn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu xuất", "Mã phiếu xuất chi tiết ", "Ngày xuất", "Mã khách hàng", "Mã nhà cung cấp", "Mã gạch", "Số lượng ", "Giá bán"
            }
        ));
        jScrollPane3.setViewportView(tblThungRacPn);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1404, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                .addContainerGap())
        );

        XuatHang.addTab("Lịch sử xuất hàng", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(XuatHang)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(XuatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void XuatHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XuatHangMouseClicked
        HienThiLenTablePhieuXuat();
        HienThiLenTableThungRacPn();
    }//GEN-LAST:event_XuatHangMouseClicked

    private void btnXoaFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaFormActionPerformed
        this.XoaForm();
    }//GEN-LAST:event_btnXoaFormActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (MsgBox.confirm(this, "Bạn có muốn xuất hàng không")) {
        }
        String maPx = this.txtMaPhieuXuat1.getText();
        String maPxct1 = this.txtMaPhieuXuatCT.getText();
        try {
            daoPx.capNhatTrangThai(maPx);
            daoPxct.capNhatTrangThai(maPxct1);
            HienThiLenTablePhieuXuat();
            HienThiLenTableThungRacPn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXoaActionPerformed
    private Gach getFormGach() {
        Gach g = new Gach();
        g.setMaGach(this.cbbgach.getSelectedItem().toString());
        g.setSoLuong(this.txtSoHangCoTrongKho.getText());
        return g;
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (txtMaKhachHang.getText().equals("") || this.txtNgayXuat.getDateFormatString().equals("") || this.txtSoLuong.getText().equals("")) {
            MsgBox.alert(this, "Không được để trống");
        }
        if (this.txtMaPhieuXuat1.getText().equals("")) {
            PhieuXuat px = getFormPx();
            try {
                daoPx.them(px);
                MsgBox.alert(this, "Thêm phiếu xuất thành công");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.LayMaPx();
            PhieuXuatChiTiet pxct = getFormPxct();
            try {
                daoPxct.them(pxct);
                MsgBox.alert(this, "Thêm phiếu xuất chi tiết thành công");
                HienThiLenTablePhieuXuat();
                HienThiLenTableThungRacPn();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Gach g = getFormGach();
            try {
                daoGach.capNhatSoLuong(g);
            } catch (Exception e) {
            }
        } else {
            PhieuXuatChiTiet pxct = getFormPxct();
            try {
                daoPxct.them(pxct);
                MsgBox.alert(this, "Thêm phiếu xuất chi tiết thành công");
                HienThiLenTablePhieuXuat();
                HienThiLenTableThungRacPn();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Gach g = getFormGach();
            try {
                daoGach.capNhatSoLuong(g);
            } catch (Exception e) {
            }
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void tblPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhapMouseClicked

        DefaultTableModel dtm = (DefaultTableModel) tblPhieuNhap.getModel();
        int index = tblPhieuNhap.getSelectedRow();
        if (index < 0) {
            return;
        }
        this.txtMaPhieuXuat1.setText(dtm.getValueAt(index, 0).toString());
        this.txtMaPhieuXuatCT.setText(dtm.getValueAt(index, 1).toString());
        this.txtNgayXuat.setDate((Date) dtm.getValueAt(index, 2));
        this.txtMaKhachHang.setText(dtm.getValueAt(index, 3).toString());
        this.cbbNcc.setSelectedItem(dtm.getValueAt(index, 4).toString());
        this.cbbgach.setSelectedItem(dtm.getValueAt(index, 5).toString());
        this.txtSoLuong.setText(dtm.getValueAt(index, 6).toString());
        this.txtGiaBan.setText(dtm.getValueAt(index, 7).toString());
    }//GEN-LAST:event_tblPhieuNhapMouseClicked

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void txtSoHangCoTrongKhoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoHangCoTrongKhoFocusLost

        int soLuongMua = Integer.parseInt(this.txtSoLuong.getText());
        int tongHang = Integer.parseInt(this.txtSoHangCoTrongKho.getText());
        int SoHangConLai = tongHang - soLuongMua;
        this.txtSoHangCoTrongKho.setText(String.valueOf(SoHangConLai));
    }//GEN-LAST:event_txtSoHangCoTrongKhoFocusLost

    private void txtSoHangCoTrongKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoHangCoTrongKhoActionPerformed

    }//GEN-LAST:event_txtSoHangCoTrongKhoActionPerformed

    private void cbbgachItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbgachItemStateChanged
        String ma = this.cbbgach.getSelectedItem().toString();
        Gach g = daoGach.selectByID(ma);
        if (g.getMaGach().trim().equals(ma)) {
            this.txtTenGach.setText(g.getTenGach());
            this.txtSoHangCoTrongKho.setText(String.valueOf(g.getSoLuong()));
            this.cbbNcc.setSelectedItem(g.getMaNhaCungCap());
        }
//       BangGia bg = daoBg.selectByID(ma);
//       if(bg.getMaGach().trim().equals(ma)){
//           this.txtGiaBan.setText(String.valueOf(bg.getGia()));
//       }
    }//GEN-LAST:event_cbbgachItemStateChanged

    private void cbbNccItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbNccItemStateChanged
        String ma = this.cbbNcc.getSelectedItem().toString();
        NhaCungCap Ncc = daoNcc.selectByID(ma);
        if (Ncc.getMaNhaCungCap().trim().equals(ma)) {
            lblTenNcc.setText(Ncc.getTenNhaCungCap());
        }
    }//GEN-LAST:event_cbbNccItemStateChanged

    private void txtMaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKhachHangActionPerformed
        ArrayList<KhachHang> listKhachHang = daoKh.selectAll();
        dtm.setRowCount(0);
        for (KhachHang x : listKhachHang) {
            if (x.getMaKhachHang().toString().contains(this.txtMaKhachHang.getText().trim()) || x.getTenKhachHang().toString().contains(this.txtMaKhachHang.getText().trim())) {
                dtm.addRow(new Object[]{
                    x.getMaKhachHang(),
                    x.getTenKhachHang(),});
            } else {
                if (MsgBox.confirm(this, "Khách hàng không tồn tại vui lòng thêm khách hàng")) {
                    QuanLyKhacHang qlkh = new QuanLyKhacHang();
                    qlkh.setVisible(true);
                }

            }

        }
    }//GEN-LAST:event_txtMaKhachHangActionPerformed

    private PhieuXuatChiTiet getFormPxct() {
        PhieuXuatChiTiet pxct = new PhieuXuatChiTiet();
        pxct.setMaPhieuXuat(this.txtMaPhieuXuat1.getText());
        pxct.setMaGach(cbbgach.getSelectedItem().toString());
        pxct.setNhaCungCap(cbbNcc.getSelectedItem().toString());
        pxct.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        pxct.setGiaBan(Float.parseFloat(txtGiaBan.getText()));
        return pxct;
    }

    private void XoaFormPx() {
        this.txtTenGach.setText("");
        this.txtMaPhieuXuatCT.setText("");
        this.txtSoLuong.setText("");
        this.txtGiaBan.setText("");
    }

    private void XoaForm() {
        this.txtMaPhieuXuat1.setText("");
        this.txtMaKhachHang.setText("");
        this.txtTenGach.setText("");
        this.txtMaPhieuXuatCT.setText("");
        this.txtSoLuong.setText("");
        this.txtGiaBan.setText("");
    }

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
            java.util.logging.Logger.getLogger(PhieuXuatUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhieuXuatUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhieuXuatUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhieuXuatUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhieuXuatUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane XuatHang;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaForm;
    private javax.swing.JComboBox<String> cbbNcc;
    private javax.swing.JComboBox<String> cbbgach;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTenNcc;
    private javax.swing.JTable tblKh;
    private javax.swing.JTable tblPhieuNhap;
    private javax.swing.JTable tblThungRacPn;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtMaPhieuXuat1;
    private javax.swing.JTextField txtMaPhieuXuatCT;
    private com.toedter.calendar.JDateChooser txtNgayXuat;
    private javax.swing.JTextField txtSoHangCoTrongKho;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenGach;
    private javax.swing.JTextField txtTimKiemXH;
    // End of variables declaration//GEN-END:variables
}
