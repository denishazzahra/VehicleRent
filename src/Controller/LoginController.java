/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RentalModel;
import View.DashboardView;
import View.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class LoginController {
    LoginView LV;
    RentalModel RM;
    public LoginController(LoginView LV, RentalModel RM) {
        this.LV = LV;
        this.RM = RM;
        LV.btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username=LV.getUsername();
                String password=LV.getPassword();
                if(RM.checkLogin(username, password)){
                    DashboardView DV=new DashboardView();
                    DashboardController DC=new DashboardController(DV,RM);
                    DV.setVisible(true);
                    LV.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Wrong username/password!");
                    LV.resetForm();
                }
            }
        });
    }
}
