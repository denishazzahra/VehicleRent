/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.LoginController;
import Model.RentalModel;
import View.LoginView;

/**
 *
 * @author LENOVO
 */
public class Main {
    public static void main(String[] args) {
        LoginView LV=new LoginView();
        RentalModel RM=new RentalModel();
        LoginController LC=new LoginController(LV,RM);
        LV.setVisible(true);
    }
}
