/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RentalModel;
import View.AddRentBikeView;
import View.AddRentCarView;
import View.AddRentView;
import View.DashboardView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author LENOVO
 */
public class AddRentController {
    AddRentView ARV;
    RentalModel RM;

    public AddRentController(AddRentView ARV, RentalModel RM) {
        this.ARV = ARV;
        this.RM = RM;
        ARV.btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                DashboardView DV=new DashboardView();
                DashboardController DC=new DashboardController(DV,RM);
                DV.setVisible(true);
                ARV.dispose();
            }
        });
        ARV.btnbike.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                AddRentBikeView ARBV=new AddRentBikeView();
                AddRentBikeController ARBC=new AddRentBikeController(ARBV,RM);
                ARBV.setVisible(true);
                ARV.dispose();
            }
        });
        ARV.btncar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                AddRentCarView ARCV=new AddRentCarView();
                AddRentCarController ARCC=new AddRentCarController(ARCV,RM);
                ARCV.setVisible(true);
                ARV.dispose();
            }
        });
    }
    
}
