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
public class PhieuXuatChiTiet {
    private String maPhieuXuatChiTiet,maPhieuXuat,maGach,nhaCungCap;
    private int soLuong;
    private float giaBan;

    public PhieuXuatChiTiet() {
    }

    public PhieuXuatChiTiet(String maPhieuXuatChiTiet, String maPhieuXuat, String maGach, String nhaCungCap, int soLuong, float giaBan) {
        this.maPhieuXuatChiTiet = maPhieuXuatChiTiet;
        this.maPhieuXuat = maPhieuXuat;
        this.maGach = maGach;
        this.nhaCungCap = nhaCungCap;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public String getMaPhieuXuatChiTiet() {
        return maPhieuXuatChiTiet;
    }

    public void setMaPhieuXuatChiTiet(String maPhieuXuatChiTiet) {
        this.maPhieuXuatChiTiet = maPhieuXuatChiTiet;
    }

    public String getMaPhieuXuat() {
        return maPhieuXuat;
    }

    public void setMaPhieuXuat(String maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }

    public String getMaGach() {
        return maGach;
    }

    public void setMaGach(String maGach) {
        this.maGach = maGach;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "PhieuXuatChiTiet{" + "maPhieuXuatChiTiet=" + maPhieuXuatChiTiet + ", maPhieuXuat=" + maPhieuXuat + ", maGach=" + maGach + ", nhaCungCap=" + nhaCungCap + ", soLuong=" + soLuong + ", giaBan=" + giaBan + '}';
    }
    
    
}
