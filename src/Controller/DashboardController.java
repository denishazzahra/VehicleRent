/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RentalModel;
import View.AddRentView;
import View.BikesView;
import View.CarsView;
import View.DashboardView;
import View.LoginView;
import View.ManageRentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author LENOVO
 */
public class DashboardController {
    DashboardView DV;
    RentalModel RM;
    public DashboardController(DashboardView DV, RentalModel RM) {
        this.DV = DV;
        this.RM = RM;
        DV.btnlogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginView LV=new LoginView();
                LoginController LC=new LoginController(LV,RM);
                LV.setVisible(true);
                DV.dispose();
            }
        });
        DV.btnbike.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BikesView BV=new BikesView();
                BikesController BC=new BikesController(BV,RM);
                BV.setVisible(true);
                DV.dispose();
            }
        });
        DV.btncar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarsView CV=new CarsView();
                CarsController BC=new CarsController(CV,RM);
                CV.setVisible(true);
                DV.dispose();
            }
        });
        DV.btnaddrent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddRentView ARV=new AddRentView();
                AddRentController ARC=new AddRentController(ARV,RM);
                ARV.setVisible(true);
                DV.dispose();
            }
        });
        DV.btnmanagerent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageRentView MRV=new ManageRentView();
                ManageRentController MRC=new ManageRentController(MRV,RM);
                MRV.setVisible(true);
                DV.dispose();
            }
        });
    }
    
}
