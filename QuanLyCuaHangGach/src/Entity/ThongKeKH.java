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
public class ThongKeKH {
    private String maKH,tenKH,SDT,Email;

    @Override
    public String toString() {
        return "ThongKeKH{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", SDT=" + SDT + ", Email=" + Email + '}';
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public ThongKeKH(String maKH, String tenKH, String SDT, String Email) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.SDT = SDT;
        this.Email = Email;
    }

    public ThongKeKH() {
    }
}
