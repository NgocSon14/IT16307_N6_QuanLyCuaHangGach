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
    private String tengach;
    private float gianhap;
    private String anh;

    public BangGia() {
    }

    public BangGia(String maGach, String maNhaCungCap, float gia, String tengach, float gianhap, String anh) {
        this.maGach = maGach;
        this.maNhaCungCap = maNhaCungCap;
        this.gia = gia;
        this.tengach = tengach;
        this.gianhap = gianhap;
        this.anh = anh;
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

    public String getTengach() {
        return tengach;
    }

    public void setTengach(String tengach) {
        this.tengach = tengach;
    }

    public float getGianhap() {
        return gianhap;
    }

    public void setGianhap(float gianhap) {
        this.gianhap = gianhap;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    @Override
    public String toString() {
        return "BangGia{" + "maGach=" + maGach + ", maNhaCungCap=" + maNhaCungCap + ", gia=" + gia + ", tengach=" + tengach + ", gianhap=" + gianhap + ", anh=" + anh + '}';
    }

    
}
