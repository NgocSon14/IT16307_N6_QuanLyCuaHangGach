package UI;

import DAO.DoanhThuDAO;
import Entity.DoanhThu;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ThongKeDoanhThu extends javax.swing.JPanel {

    DoanhThuDAO daoDt = new DoanhThuDAO();
    DefaultTableModel dtm;
    double Tong = 0;
    ArrayList<DoanhThu> listDt;

    public ThongKeDoanhThu() {
        initComponents();
//        HienThiLenTableDTT();
        fillComboxNam();
//fillTableDoanhThu();
        fillComboBoxThang();

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
        lblTien.setText("Tổng Doanh Thu Của Tháng: " + x.format(this.Tong) + " " + "VND");// Áp dụng mẫu x= "###,###.##" cho decimalFormat

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
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbbnam = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbbthang = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();

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

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("TỔNG :");

        jButton2.setText("BIỂU ĐỒ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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
                        .addGap(24, 24, 24)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 388, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("DOANH THU THÁNG ", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1174, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("DOANH THU CÁC NĂM ", jPanel2);

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
                new ThongKeDoanhThu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbnam;
    private javax.swing.JComboBox<String> cbbthang;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblTien;
    private javax.swing.JTable tblDoanhThuThang;
    // End of variables declaration//GEN-END:variables
}