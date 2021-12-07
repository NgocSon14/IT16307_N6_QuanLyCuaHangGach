/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Administrator
 */
public class BangGia {
    private String  maGach,maNhaCungCap;
    private float gia;
    private String tenGach,maDonVI;
    private int soLuong;
    private String maChatLieu,maTheLoai,Anh;
   

    public BangGia() {
    }

    public BangGia(String maGach, String maNhaCungCap, float gia, String tenGach, String maDonVI, int soLuong, String maChatLieu, String maTheLoai, String Anh) {
        this.maGach = maGach;
        this.maNhaCungCap = maNhaCungCap;
        this.gia = gia;
        this.tenGach = tenGach;
        this.maDonVI = maDonVI;
        this.soLuong = soLuong;
        this.maChatLieu = maChatLieu;
        this.maTheLoai = maTheLoai;
        this.Anh = Anh;
    }

    public String getMaGach() {
        return maGach;
    }

    public void setMaGach(String maGach) {
        this.maGach = maGach;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getTenGach() {
        return tenGach;
    }

    public void setTenGach(String tenGach) {
        this.tenGach = tenGach;
    }

    public String getMaDonVI() {
        return maDonVI;
    }

    public void setMaDonVI(String maDonVI) {
        this.maDonVI = maDonVI;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaChatLieu() {
        return maChatLieu;
    }

    public void setMaChatLieu(String maChatLieu) {
        this.maChatLieu = maChatLieu;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String Anh) {
        this.Anh = Anh;
    }

  
   
   
    
}