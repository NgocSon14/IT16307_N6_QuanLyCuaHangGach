package UI;

import DAO.DoanhThuDAO;
import Entity.DoanhThu;
import Entity.KhachHang;
import Entity.ThongKeKH;
import Entity.ThongKeSP;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ThongKeDoanhThu extends javax.swing.JPanel {

    DoanhThuDAO daoDt = new DoanhThuDAO();
    DefaultTableModel dtm;
    double Tong = 0;
    ArrayList<DoanhThu> listDt;
    Connection cn;
     ArrayList<ThongKeKH> Listkh= new ArrayList<>();
     ArrayList<ThongKeSP> ListSp= new ArrayList<>();
    

    public ThongKeDoanhThu() throws Exception {
        initComponents();
//        HienThiLenTableDTT();
        fillComboxNam();
//fillTableDoanhThu();
        fillComboBoxThang();
        cn=Helper.jdbcHelper.opConnection();
        fillKhachhang();
        filltbkhachhang();
        fillSanpham();
        filltbSP();

    }
//    private void HienThiLenTableDTT(){
//        dtm = (DefaultTableModel) this.tblDoanhThuThang.getModel();
//        dtm.setRowCount(0);
//        ArrayList<DoanhThu> listDt = daoDt.selectAll();
//        for (DoanhThu x : listDt) {
//            Object[] rowData = new Object[]{
//                x.getNgayXuat(),
//                x.getMaGach(),
//                x.getTenGach(),
//                x.getSoLuong(),
//                x.getGiaBan(),
//            };
//            dtm.addRow(rowData);
//        }
//    }

    void fillComboxNam() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbthang.getModel();
        this.cbbnam.removeAllItems();
        List<Object> list = daoDt.getNamDoanhThu(); //lấy đc dữ liệu 
        for (Object nam : list) { // tạo vòng for duyệt từ đầu đến cuối cái list 
            this.cbbnam.addItem(nam.toString());
        }
    }

    void fillComboBoxThang() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbthang.getModel();
        this.cbbthang.removeAllItems();
        String year = this.cbbnam.getSelectedItem() + "";
        if (year.equals("null")) {
            return;
        }
        int nam = Integer.parseInt(year);
        List<Object> list = daoDt.getThangDoanhThu(nam); //lấy đc dữ liệu 

        for (Object thang : list) { // tạo vòng for duyệt từ đầu đến cuối cái list 
            this.cbbthang.addItem(thang.toString());
        }
        fillTableDoanhThu();

    }

    void fillTableDoanhThu() {

        DefaultTableModel model = (DefaultTableModel) tblDoanhThuThang.getModel();
        model.setRowCount(0); // xóa toàn bộ dữ liệu có trong tabke
        String cbb = "";
        cbb = this.cbbthang.getSelectedItem() + "";
        String year = this.cbbnam.getSelectedItem() + "";
        if (cbb.equals("null") || year.equals("null")) {
            return;
        } else {
            System.out.println(cbbthang.getSelectedItem());

            int thang = Integer.parseInt(cbb);
            int nam = Integer.parseInt(year);

            List<DoanhThu> list = daoDt.getDoanhthu(thang, nam);  // tạo list đổ dữ liệu từ list vào model
            this.Tong = 0; // khai báo biến tổng =0 (Nếu k có nó sẽ cộng dồn)
            for (DoanhThu row : list) {
                Object[] object = new Object[]{
                    row.getNgayXuat(),
                    row.getMaGach(),
                    row.getTenGach(),
                    row.getSoLuong(),
                    row.getGiaBan()
                };
                model.addRow(object);
                this.Tong += row.getGiaBan(); // thực hiện cộng thành tiền
            }
        }
    }

    private void TongThang() {
        DecimalFormat x = new DecimalFormat("###,###,###");
        /*
        Tạo một biến x để đặt định dạng cho số,
        ở đây cứ 3 số nguyên sẽ được ngăn cách bằng 1 dấu phẩy,
        phần thập phân và phần nguyên được ngăn cách bởi dấu chấm,
         */
        //dùng để format (định dạng) ... decimal (số thập phân).
        int Tong = 0;
        for (int i = 0; i < tblDoanhThuThang.getRowCount(); i++) { // lấy dữ lệu ở các row
            Tong += Integer.parseInt(tblDoanhThuThang.getValueAt(i, 3).toString()); // thực hiện cộng
        }
        lblTien.setText("Tổng Doanh Thu : " + x.format(this.Tong) + " " + "VND");// Áp dụng mẫu x= "###,###.##" cho decimalFormat

    }
    void fillKhachhang(){
        try {
    cn=Helper.jdbcHelper.opConnection();
    String sql ="SELECT TOP 10 KHACHHANG.MAKHACHHANG,TENKHACHHANG,SODIENTHOAI,EMAIL FROM dbo.KHACHHANG JOIN dbo.PHIEUXUAT ON PHIEUXUAT.MAKHACHHANG = KHACHHANG.MAKHACHHANG GROUP BY KHACHHANG.MAKHACHHANG,TENKHACHHANG,SODIENTHOAI,EMAIL";
    Statement stm= cn.createStatement();
    ResultSet rs=stm.executeQuery(sql);
    while(rs.next()){
 Listkh.add(new ThongKeKH(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4))); 
    }
            System.out.println(Listkh);
         
    stm.close();
    rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void filltbkhachhang(){
    DefaultTableModel model = (DefaultTableModel) tblkhachhang.getModel();
    model.setRowCount(0);
        for (ThongKeKH x : Listkh) {
            Object[] rowData= new Object[]{x.getMaKH(),x.getTenKH(),x.getSDT(),x.getEmail()};
           model.addRow(rowData);
        }
    }
    void fillSanpham(){
        try {
             cn=Helper.jdbcHelper.opConnection();
             String sql="SELECT TOP 10 GACH.MAGACH,TENGACH,TENCHATLIEU,TENDONVI,TENNHACUNGCAP,GIABAN FROM dbo.GACH JOIN dbo.NHACUNGCAP ON NHACUNGCAP.MANHACUNGCAP = GACH.MANHACUNGCAP JOIN dbo.PHIEUXUAT ON PHIEUXUAT.TRANGTHAI = GACH.TRANGTHAI JOIN dbo.PHIEUXUATCHITIET ON PHIEUXUATCHITIET.MAGACH = GACH.MAGACH JOIN dbo.CHATLIEU ON CHATLIEU.MACHATLIEU = GACH.MACHATLIEU JOIN dbo.DONVITINH ON DONVITINH.MADONVI = GACH.MADONVI GROUP BY GACH.MAGACH,TENGACH,TENCHATLIEU,TENDONVI,TENNHACUNGCAP,GIABAN";
             Statement stm=cn.createStatement();
              ResultSet rs=stm.executeQuery(sql);
    while(rs.next()){
 ListSp.add(new ThongKeSP(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6))); 
    }
            System.out.println(ListSp);
         
    stm.close();
    rs.close();
             
        } catch (Exception e) {
        }
    }
    void filltbSP(){
 DefaultTableModel model = (DefaultTableModel) tblsanpham.getModel();
    model.setRowCount(0);
        for (ThongKeSP x : ListSp) {
            Object[] rowData= new Object[]{x.getMagach(),x.getTengach(),x.getTenchatlieu(),x.getTendv(),x.getTenncc(),x.getGiaban()};
           model.addRow(rowData);
        }
}

//   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoanhThuThang = new javax.swing.JTable();
        lblTien = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbbnam = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbbthang = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblkhachhang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblsanpham = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblDoanhThuThang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ngày xuất", "Mã gạch", "Tên gach", "Số lượng bán", "Giá bán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDoanhThuThang);

        lblTien.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jLabel1.setText("Năm");

        cbbnam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbnamActionPerformed(evt);
            }
        });

        jLabel4.setText("Doanh thu theo tháng");

        cbbthang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbthangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(24, 609, Short.MAX_VALUE)
                        .addComponent(lblTien, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbnam, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cbbthang, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbbnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbbthang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTien, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DOANH THU  ", jPanel1);

        tblkhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "SĐT", "Email"
            }
        ));
        jScrollPane2.setViewportView(tblkhachhang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("KHACHHANG", jPanel2);

        tblsanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã gạch", "Tên gạch", "Tên chất liệu", "Tên đơn vị", "Tên nhà cung cấp", "Giá bán"
            }
        ));
        jScrollPane3.setViewportView(tblsanpham);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 67, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SANPHAM", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbthangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbthangActionPerformed
        fillTableDoanhThu();
        TongThang();// TODO add your handling code here:
    }//GEN-LAST:event_cbbthangActionPerformed

    private void cbbnamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbnamActionPerformed
        fillComboBoxThang();        // TODO add your handling code here:
    }//GEN-LAST:event_cbbnamActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ThongKeDoanhThu().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ThongKeDoanhThu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbnam;
    private javax.swing.JComboBox<String> cbbthang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblTien;
    private javax.swing.JTable tblDoanhThuThang;
    private javax.swing.JTable tblkhachhang;
    private javax.swing.JTable tblsanpham;
    // End of variables declaration//GEN-END:variables
}
