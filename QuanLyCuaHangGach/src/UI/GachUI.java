/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.table.DefaultTableModel;
import DAO.GachDAO;
import DAO.NhaCungCapDao;
import DAO.ChatLieuDao;
import DAO.TheLoaiDao;
import DAO.KichThuocDAO;
import Entity.Gach;
import java.util.ArrayList;
import Entity.ChatLieu;
import Entity.TheLoai;
import Entity.DonViTinh;
import Entity.KichThuoc;
import Entity.NhaCungCap;
import Helper.Image;
import Helper.MsgBox;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Admin
 */
public class GachUI extends javax.swing.JFrame {

    DefaultTableModel modelGach;
    DefaultTableModel modelds;
    DefaultTableModel modelthungrac;
    GachDAO daogach = new GachDAO();
    NhaCungCapDao daoncc = new NhaCungCapDao();
    ChatLieuDao daochatlieu = new ChatLieuDao();
    TheLoaiDao daotheloai = new TheLoaiDao();
    KichThuocDAO daodonvi = new KichThuocDAO();
    int row = -1;

    public GachUI() {
        initComponents();
        init();
        fillDS();
        fillTG();
        showNCC();
        showchatlieu();
        showdonvi();
        showtheloai();

    }

    void init() {
        setTitle("QUẢN LÝ CỬA HÀNG GẠCH");
        tabs.setSelectedIndex(0);
        setDefaultCloseOperation(2);
        row = -1;
        prepareGui();
        setLocationRelativeTo(null);
        defaulform();
    }

    void prepareGui() {
        String[] h = {"Mã gạch", "Tên gạch", "Đơn vị", "Số lượng", "Chất liệu", "Thể loại", "Nhà cung cấp", "Ảnh"};
        modelds = new DefaultTableModel(h, 0) {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        modelthungrac = new DefaultTableModel(h, 0) {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        tblDS.setModel(modelds);
        tblthungrac.setModel(modelthungrac);
    }

    void fillDS() {
        ArrayList<Gach> list = daogach.selectAll();
        modelds.setRowCount(0);
        for (Gach gach : list) {
            if (gach.isTrangThai()) {
                modelds.addRow(new Object[]{gach.getMaGach(), gach.getTenGach(), gach.getMaDv(), gach.getSoLuong(), gach.getMaChatLieu(), gach.getMaTheLoai(), gach.getMaNhaCungCap(), gach.getAnh(), true});
            }
        }

    }

    void fillTG() {
        ArrayList<Gach> list = daogach.selectAll();
        modelthungrac.setRowCount(0);
        for (Gach gach : list) {
            if (!gach.isTrangThai()) {
                modelthungrac.addRow(new Object[]{gach.getMaGach(), gach.getTenGach(), gach.getMaDv(), gach.getSoLuong(), gach.getMaChatLieu(), gach.getMaTheLoai(), gach.getMaNhaCungCap(), gach.getAnh(), true});
            }
        }

    }

    void showNCC() {
        ArrayList<NhaCungCap> listncc = daoncc.selectAll();
        cbbncc.removeAllItems();
        for (NhaCungCap ncc : listncc) {
            cbbncc.addItem(ncc.getMaNhaCungCap() + "");
        }
        fillDS();
    }

    void showchatlieu() {
        ArrayList<ChatLieu> listdaochatlieu = daochatlieu.selectAll();
        cbbchatlieu.removeAllItems();
        for (ChatLieu ncc : listdaochatlieu) {
            cbbchatlieu.addItem(ncc.getMaChatLieu() + "");
        }
        fillDS();
    }

    void showtheloai() {
        ArrayList<TheLoai> listtheloai = daotheloai.selectAll();
        cbbtheloai.removeAllItems();
        for (TheLoai ncc : listtheloai) {
            cbbtheloai.addItem(ncc.getMaTheLoai() + "");
        }
        fillDS();
    }

    void showdonvi() {
        ArrayList<KichThuoc> listdonvi = daodonvi.selectAll();
        cbbkichthuoc.removeAllItems();
        for (KichThuoc ncc : listdonvi) {
            cbbkichthuoc.addItem(ncc.getMaDonVi() + "");
        }
        fillDS();
    }

    void setform(Gach gach) {
        tftmagach.setText(gach.getMaGach());
        tfttengach.setText(gach.getTenGach());
        cbbkichthuoc.setSelectedItem(gach.getMaDv());
        tftsoluong.setText(gach.getSoLuong());
        cbbchatlieu.setSelectedItem(gach.getMaChatLieu());
        cbbncc.setSelectedItem(gach.getMaNhaCungCap());
        cbbtheloai.setSelectedItem(gach.getMaTheLoai());
        if (gach.getAnh() != null) {
            lblhinhanh.setIcon(Image.read(gach.getAnh()));
        }

    }

    Gach getform() {
        Gach gach = new Gach();
        gach.setMaGach(tftmagach.getText());
        gach.setTenGach(tfttengach.getText());
        gach.setMaDv(cbbkichthuoc.getSelectedItem() + "");
        gach.setSoLuong(tftsoluong.getText());
        gach.setMaChatLieu(cbbchatlieu.getSelectedItem() + "");
        gach.setMaNhaCungCap(cbbncc.getSelectedItem() + "");
        gach.setMaTheLoai(cbbtheloai.getSelectedItem() + "");
        gach.setAnh(lblhinhanh.getToolTipText());
        return gach;
    }

    void defaulform() {
        row = -1;
        tftmagach.setText("");
        tfttengach.setText("");
        cbbkichthuoc.setSelectedItem("");
        tftsoluong.setText("");
        cbbchatlieu.setSelectedItem("");
        cbbncc.setSelectedItem("");
        cbbtheloai.setSelectedItem("");
        lblhinhanh.setIcon(null);
        lblhinhanh.setText("");
    }

    void updateStatus() {
        boolean click = row >= 0;
        btnxoa.setEnabled(click);
        btnchinhsua.setEnabled(click);
        tftmagach.setEnabled(!click);
    }

    void insert() {
        Gach gach = getform();
        try {
            daogach.them(gach);
            fillDS();
            fillTG();
            defaulform();
            MsgBox.alert(this, "Thêm sản phẩm gạch thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm thất bại");
        }
    }

    void xoa() {
        if (MsgBox.confirm(this, "Bạn có muốn xoá không?")) {
            daogach.xoa(tftmagach.getText());
            fillDS();
            fillTG();
            defaulform();
            updateStatus();
            tabs.setSelectedIndex(1);

        }

    }

    void khoiphuc() {

        if (MsgBox.confirm(this, "Bạn có muốn khôi phục không không?")) {

        }
        Gach gachdao = daogach.selectByID(tblthungrac.getValueAt(tblthungrac.getSelectedRow(), 0).toString());
        gachdao.setTrangThai(true);
        daogach.capNhat(gachdao);
        fillDS();
        fillTG();
        defaulform();
        updateStatus();
        tabs.setSelectedIndex(0);

    }

    void chinhsua() {

        if (MsgBox.confirm(this, "Bạn có muốn chỉnh sửa không không?")) {

        }
        daogach.capNhat(getform());
        fillDS();
        defaulform();
        updateStatus();
        tabs.setSelectedIndex(0);

    }

    void chonAnh() {
        JFileChooser jfc = new JFileChooser("logos");
        if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            Image.save(file);
            lblhinhanh.setToolTipText(file.getName());
            lblhinhanh.setIcon(Image.read(file.getName()));
        }
    }

    void timkiem() {
        ArrayList<Gach> list = daogach.selectAll();
        modelds.setRowCount(0);
        for (Gach ncc : list) {
            if (ncc.isTrangThai() && (ncc.getMaGach().toString().contains(tfttimkiem.getText().trim())
                    || ncc.getTenGach().toString().contains(tfttimkiem.getText().trim())
                    || ncc.getMaChatLieu().toString().contains(tfttimkiem.getText().trim())
                    || ncc.getMaDv().toString().contains(tfttimkiem.getText().trim())
                    || ncc.getMaTheLoai().toString().contains(tfttimkiem.getText().trim())
                    || ncc.getSoLuong().toString().contains(tfttimkiem.getText().trim()))) {
                modelds.addRow(new Object[]{ncc.getMaGach(), ncc.getTenGach(), ncc.getMaDv(), ncc.getSoLuong(), ncc.getMaChatLieu(), ncc.getMaNhaCungCap(), ncc.getMaTheLoai(), ncc.getAnh(), true});
            }
        }

    }

    boolean check() {
        try {
            
            
            if (tftmagach.getText().equals("")) {
                MsgBox.alert(this, "Không để trống mã gạch");
                tftmagach.requestFocus();
                return false;
            } else {
                if (tfttengach.getText().equals("")) {
                    MsgBox.alert(this, "Không để trống tên gạch");
                    tfttengach.requestFocus();
                    return false;
                } else {
                    if (tftsoluong.getText().equals("")) {
                        MsgBox.alert(this, "Không để trống số lượng");
                    }
                    else{
                        try {
                            int t1=Integer.parseInt(tftsoluong.getText());
                            if(t1<=0){
                            MsgBox.alert(this, "Số lượng phải là số nguyên dương");
                            tftsoluong.requestFocus();
                            return false;
                            }
                        } catch (Exception e) {
                            MsgBox.alert(this, "Số lượng phải là số");
                            tftsoluong.requestFocus();
                            return false;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return true;
    }
    boolean checktrung(){
      Gach gach=daogach.selectByID(tftmagach.getText());
      if(gach!=null){
      MsgBox.alert(this, "Mã gạch đã tồn tại");
      return false;
      }
      return true;
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
        tabDS = new javax.swing.JPanel();
        lblhinhanh = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tftmagach = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfttengach = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbbchatlieu = new javax.swing.JComboBox<>();
        cbbtheloai = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbbkichthuoc = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbbncc = new javax.swing.JComboBox<>();
        btnchinhsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfttimkiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDS = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        tftsoluong = new javax.swing.JTextField();
        btnthem = new javax.swing.JButton();
        tabThungrac = new javax.swing.JPanel();
        btnkhoiphuc = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblthungrac = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblhinhanh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblhinhanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblhinhanhMouseClicked(evt);
            }
        });

        jLabel2.setText("QUẢN LÝ GẠCH");

        jLabel3.setText("Mã gạch:");

        jLabel4.setText("Tên gạch:");

        jLabel7.setText("Chất liệu:");

        jLabel9.setText("Thể loại:");

        jLabel10.setText("Đơn vị");

        jLabel8.setText("Nhà cung cấp:");

        btnchinhsua.setText("Chỉnh sửa");
        btnchinhsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchinhsuaActionPerformed(evt);
            }
        });

        btnxoa.setText("Xoá");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        jLabel6.setText("TÌM KIẾM");

        tfttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfttimkiemActionPerformed(evt);
            }
        });

        tblDS.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDS);

        jLabel11.setText("Số lượng:");

        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabDSLayout = new javax.swing.GroupLayout(tabDS);
        tabDS.setLayout(tabDSLayout);
        tabDSLayout.setHorizontalGroup(
            tabDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDSLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(tabDSLayout.createSequentialGroup()
                .addGroup(tabDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDSLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel2))
                    .addGroup(tabDSLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lblhinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(tabDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabDSLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addGroup(tabDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(tabDSLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(tftmagach, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(tabDSLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfttengach, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(tabDSLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbkichthuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(tabDSLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(tftsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(66, 66, 66)
                                .addGroup(tabDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(tabDSLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbchatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(tabDSLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbtheloai, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(tabDSLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbncc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(tabDSLayout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(btnthem)
                                .addGap(32, 32, 32)
                                .addComponent(btnchinhsua)
                                .addGap(78, 78, 78)
                                .addComponent(btnxoa))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabDSLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(295, 295, 295)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        tabDSLayout.setVerticalGroup(
            tabDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDSLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(tabDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tabDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabDSLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabDSLayout.createSequentialGroup()
                                .addGroup(tabDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(tftmagach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(cbbchatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(tabDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(tfttengach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(cbbncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(tabDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(cbbtheloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(cbbkichthuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(tabDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(tftsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(tabDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnchinhsua)
                                    .addComponent(btnxoa)
                                    .addComponent(btnthem)))
                            .addComponent(lblhinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Danh sách", tabDS);

        btnkhoiphuc.setText("Khôi phục");
        btnkhoiphuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkhoiphucActionPerformed(evt);
            }
        });

        tblthungrac.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblthungrac);

        javax.swing.GroupLayout tabThungracLayout = new javax.swing.GroupLayout(tabThungrac);
        tabThungrac.setLayout(tabThungracLayout);
        tabThungracLayout.setHorizontalGroup(
            tabThungracLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabThungracLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabThungracLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnkhoiphuc)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 927, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        tabThungracLayout.setVerticalGroup(
            tabThungracLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabThungracLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnkhoiphuc)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Thùng rác", tabThungrac);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        if (check()&&checktrung()) {
            insert();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnchinhsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchinhsuaActionPerformed
        chinhsua();        // TODO add your handling code here:
    }//GEN-LAST:event_btnchinhsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        xoa();        // TODO add your handling code here:
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnkhoiphucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkhoiphucActionPerformed
        khoiphuc();        // TODO add your handling code here:
    }//GEN-LAST:event_btnkhoiphucActionPerformed

    private void tblDSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSMouseClicked
        if (evt.getClickCount() == 2) {
            tabs.setSelectedIndex(0);
            row = tblDS.getSelectedRow();
            setform(daogach.selectByID(tblDS.getValueAt(row, 0).toString()));
            updateStatus();
        }        //         // TODO add your handling code here:
    }//GEN-LAST:event_tblDSMouseClicked

    private void lblhinhanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhinhanhMouseClicked
        if (evt.getClickCount() == 2) {
            chonAnh();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_lblhinhanhMouseClicked

    private void tfttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfttimkiemActionPerformed
        timkiem();        // TODO add your handling code here:
    }//GEN-LAST:event_tfttimkiemActionPerformed

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
            java.util.logging.Logger.getLogger(GachUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GachUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GachUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GachUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GachUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnchinhsua;
    private javax.swing.JToggleButton btnkhoiphuc;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<String> cbbchatlieu;
    private javax.swing.JComboBox<String> cbbkichthuoc;
    private javax.swing.JComboBox<String> cbbncc;
    private javax.swing.JComboBox<String> cbbtheloai;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblhinhanh;
    private javax.swing.JPanel tabDS;
    private javax.swing.JPanel tabThungrac;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblDS;
    private javax.swing.JTable tblthungrac;
    private javax.swing.JTextField tftmagach;
    private javax.swing.JTextField tftsoluong;
    private javax.swing.JTextField tfttengach;
    private javax.swing.JTextField tfttimkiem;
    // End of variables declaration//GEN-END:variables
}
