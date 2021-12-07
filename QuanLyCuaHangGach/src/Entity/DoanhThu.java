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
public class DoanhThu {
    private Date ngayXuat;
    private String maGach;
    private String tenGach;
    private int soLuong;
    private float giaBan;

    public DoanhThu() {
    }

    public DoanhThu(Date ngayXuat, String maGach, String tenGach, int soLuong, float giaBan) {
        this.ngayXuat = ngayXuat;
        this.maGach = maGach;
        this.tenGach = tenGach;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getMaGach() {
        return maGach;
    }

    public void setMaGach(String maGach) {
        this.maGach = maGach;
    }

    public String getTenGach() {
        return tenGach;
    }

    public void setTenGach(String tenGach) {
        this.tenGach = tenGach;
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
    
    
}
