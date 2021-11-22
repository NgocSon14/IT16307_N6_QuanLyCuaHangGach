/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Admin
 */
public class PhieuNhapChiTiet {
    private String MaPhieuNhapChiTiet;
    private String MaPhieuNhap;
    private String MaGach;
    private int Soluong;
    private float GiaNhap;
    private float GiaBan;

    @Override
    public String toString() {
        return "PhieuNhapChiTiet{" + "MaPhieuNhapChiTiet=" + MaPhieuNhapChiTiet + ", MaPhieuNhap=" + MaPhieuNhap + ", MaGach=" + MaGach + ", Soluong=" + Soluong + ", GiaNhap=" + GiaNhap + ", GiaBan=" + GiaBan + '}';
    }

    public String getMaPhieuNhapChiTiet() {
        return MaPhieuNhapChiTiet;
    }

    public void setMaPhieuNhapChiTiet(String MaPhieuNhapChiTiet) {
        this.MaPhieuNhapChiTiet = MaPhieuNhapChiTiet;
    }

    public String getMaPhieuNhap() {
        return MaPhieuNhap;
    }

    public void setMaPhieuNhap(String MaPhieuNhap) {
        this.MaPhieuNhap = MaPhieuNhap;
    }

    public String getMaGach() {
        return MaGach;
    }

    public void setMaGach(String MaGach) {
        this.MaGach = MaGach;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public float getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(float GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public float getGiaBan() {
        return GiaBan;
    }


    public PhieuNhapChiTiet() {
    }

    public void setGiaBan(float GiaBan) {
        this.GiaBan = GiaBan;
    }

    public PhieuNhapChiTiet(String MaPhieuNhapChiTiet, String MaPhieuNhap, String MaGach, int Soluong, float GiaNhap, float GiaBan) {
        this.MaPhieuNhapChiTiet = MaPhieuNhapChiTiet;
        this.MaPhieuNhap = MaPhieuNhap;
        this.MaGach = MaGach;
        this.Soluong = Soluong;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
    }
}
