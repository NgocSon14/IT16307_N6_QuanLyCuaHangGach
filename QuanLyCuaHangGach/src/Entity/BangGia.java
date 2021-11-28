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

    public BangGia() {
    }

    public BangGia(String maGach, String maNhaCungCap, float gia) {
        this.maGach = maGach;
        this.maNhaCungCap = maNhaCungCap;
        this.gia = gia;
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

    @Override
    public String toString() {
        return "BangGia{" + "maGach=" + maGach + ", maNhaCungCap=" + maNhaCungCap + ", gia=" + gia + '}';
    }

   

   
    
    
}
