/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class MsgBox {
    public static void alert(Component parent,String mess){
        JOptionPane.showMessageDialog(parent, mess,"Hệ thống quản lý gạch",JOptionPane.INFORMATION_MESSAGE);
    }
    public static boolean confirm(Component parent,String mess){
        int result =JOptionPane.showConfirmDialog(parent, mess,"Hệ thống quản lý gạch",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        return result==JOptionPane.YES_OPTION;
    }
    public static String promt(Component parent,String mess){
        return JOptionPane.showInputDialog(parent,mess,"Hệ thống quản lý gạch",JOptionPane.INFORMATION_MESSAGE);
    }
}
