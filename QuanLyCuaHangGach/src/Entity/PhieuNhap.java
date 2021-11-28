
package Entity;

import java.util.Date;


public class PhieuNhap {
    private String maPhieuNhap,maNhaCungCap;
    private boolean trangThai;
    private Date ngayNhap;
    public PhieuNhap() {
    }

    public PhieuNhap(String maPhieuNhap, Date ngayNhap, String maNhaCungCap, boolean trangThai) {
        this.maPhieuNhap = maPhieuNhap;
        this.ngayNhap = ngayNhap;
        this.maNhaCungCap = maNhaCungCap;
        this.trangThai = trangThai;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "PhieuNhap{" + "maPhieuNhap=" + maPhieuNhap + ", ngayNhap=" + ngayNhap + ", maNhaCungCap=" + maNhaCungCap + ", trangThai=" + trangThai + '}';
    }
    
}
