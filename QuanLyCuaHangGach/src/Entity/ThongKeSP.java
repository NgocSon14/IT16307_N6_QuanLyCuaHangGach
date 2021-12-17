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
public class ThongKeSP {
    private String magach,tengach,tenchatlieu,tendv,tenncc;

    public ThongKeSP(String magach, String tengach, String tenchatlieu, String tendv, String tenncc) {
        this.magach = magach;
        this.tengach = tengach;
        this.tenchatlieu = tenchatlieu;
        this.tendv = tendv;
        this.tenncc = tenncc;
    }

    public ThongKeSP() {
    }

    public String getMagach() {
        return magach;
    }

    public void setMagach(String magach) {
        this.magach = magach;
    }

    public String getTengach() {
        return tengach;
    }

    public void setTengach(String tengach) {
        this.tengach = tengach;
    }

    public String getTenchatlieu() {
        return tenchatlieu;
    }

    public void setTenchatlieu(String tenchatlieu) {
        this.tenchatlieu = tenchatlieu;
    }

    public String getTendv() {
        return tendv;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

    public String getTenncc() {
        return tenncc;
    }

    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }

    @Override
    public String toString() {
        return "ThongKeSP{" + "magach=" + magach + ", tengach=" + tengach + ", tenchatlieu=" + tenchatlieu + ", tendv=" + tendv + ", tenncc=" + tenncc + '}';
    }

   
}
