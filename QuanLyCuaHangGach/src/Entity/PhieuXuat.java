/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class PhieuXuat {
    private String maPhieuXuat;
    private Date ngayXuat;
    private String maKhachHang;
    private Boolean trangThai;

    public PhieuXuat() {
    }

    public PhieuXuat(String maPhieuXuat, Date ngayXuat, String maKhachHang, Boolean trangThai) {
        this.maPhieuXuat = maPhieuXuat;
        this.ngayXuat = ngayXuat;
        this.maKhachHang = maKhachHang;
        this.trangThai = trangThai;
    }

    public String getMaPhieuXuat() {
        return maPhieuXuat;
    }

    public void setMaPhieuXuat(String maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "PhieuXuat{" + "maPhieuXuat=" + maPhieuXuat + ", ngayXuat=" + ngayXuat + ", maKhachHang=" + maKhachHang + ", trangThai=" + trangThai + '}';
    }
    
    
}
