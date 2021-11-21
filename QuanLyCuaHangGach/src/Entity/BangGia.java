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
    private String maNhaCungCap, maGach;
    private double gia;

    public BangGia() {
    }

    public BangGia(String maNhaCungCap, String maGach, double gia) {
        this.maNhaCungCap = maNhaCungCap;
        this.maGach = maGach;
        this.gia = gia;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getMaGach() {
        return maGach;
    }

    public void setMaGach(String maGach) {
        this.maGach = maGach;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "BangGia{" + "maNhaCungCap=" + maNhaCungCap + ", maGach=" + maGach + ", gia=" + gia + '}';
    }
    
    
}
