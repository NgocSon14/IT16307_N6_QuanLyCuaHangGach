/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class PhieuNhapChiTiet {

    private String MaPhieuNhapChiTiet;
    private String maPhieuNhap;
    private String maGach;
    private int soluong;
    private float giaNhap;
    private float giaBan;
    private String maNhaCungCap;
    private Date ngayNhap;
    private boolean trangThai;

    public PhieuNhapChiTiet() {
    }

    public PhieuNhapChiTiet(String MaPhieuNhapChiTiet, String maPhieuNhap, String maGach, int soluong, float giaNhap, float giaBan, String maNhaCungCap, Date ngayNhap, boolean trangThai) {
        this.MaPhieuNhapChiTiet = MaPhieuNhapChiTiet;
        this.maPhieuNhap = maPhieuNhap;
        this.maGach = maGach;
        this.soluong = soluong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.maNhaCungCap = maNhaCungCap;
        this.ngayNhap = ngayNhap;
        this.trangThai = trangThai;
    }

    public String getMaPhieuNhapChiTiet() {
        return MaPhieuNhapChiTiet;
    }

    public void setMaPhieuNhapChiTiet(String MaPhieuNhapChiTiet) {
        this.MaPhieuNhapChiTiet = MaPhieuNhapChiTiet;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public String getMaGach() {
        return maGach;
    }

    public void setMaGach(String maGach) {
        this.maGach = maGach;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

}
