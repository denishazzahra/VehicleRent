/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RentalModel;
import View.DashboardView;
import View.ManageRentBikeView;
import View.ManageRentCarView;
import View.ManageRentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author LENOVO
 */
public class ManageRentController {
    ManageRentView MRV;
    RentalModel RM;

    public ManageRentController(ManageRentView MRV, RentalModel RM) {
        this.MRV = MRV;
        this.RM = RM;
        MRV.btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardView DV=new DashboardView();
                DashboardController DC=new DashboardController(DV,RM);
                DV.setVisible(true);
                MRV.dispose();
            }
        });
        MRV.btnbike.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageRentBikeView MRBV=new ManageRentBikeView();
                ManageRentBikeController MRBC=new ManageRentBikeController(MRBV,RM);
                MRBV.setVisible(true);
                MRV.dispose();
            }
        });
        MRV.btncar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageRentCarView MRCV=new ManageRentCarView();
                ManageRentCarController MRCC=new ManageRentCarController(MRCV,RM);
                MRCV.setVisible(true);
                MRV.dispose();
            }
        });
    }
    
}
