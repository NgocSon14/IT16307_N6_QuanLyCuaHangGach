/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author sktqu
 */
public class KichThuoc {
    private String maDonVi;
    private String tenDonVi;

    public KichThuoc() {
    }

    public KichThuoc(String maDonVi, String tenDonVi) {
        this.maDonVi = maDonVi;
        this.tenDonVi = tenDonVi;
    }

    public String getMaDonVi() {
        return maDonVi;
    }

    public void setMaDonVi(String maDonVi) {
        this.maDonVi = maDonVi;
    }

    public String getTenDonVi() {
        return tenDonVi;
    }

    public void setTenDonVi(String tenDonVi) {
        this.tenDonVi = tenDonVi;
    }

    @Override
    public String toString() {
        return "KichThuoc{" + "maDonVi=" + maDonVi + ", tenDonVi=" + tenDonVi + '}';
    }
    
}
