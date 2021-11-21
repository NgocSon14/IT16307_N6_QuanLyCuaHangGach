/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Asus
 */
public class PhieuXuat {
    private String maPhieuXuat;
    private String ngayXuat;
    private String maKhachHang;
    private Boolean trangThai;

    public PhieuXuat() {
    }

    public PhieuXuat(String maPhieuXuat, String ngayXuat, String maKhachHang, Boolean trangThai) {
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

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
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
