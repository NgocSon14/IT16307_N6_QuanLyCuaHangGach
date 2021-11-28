/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Entity.TaiKhoan;

/**
 *
 * @author Asus
 */
public class ShareUser {

    public static TaiKhoan user = null;

    public static void clear() {
        ShareUser.user = null;
    }

    public static boolean isLogin() {
        return ShareUser.user != null;
    }
}
