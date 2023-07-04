/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RentalModel;
import Others.Rent;
import Others.RentTableModel;
import View.ManageRentBikeView;
import View.ManageRentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class ManageRentBikeController {
    ManageRentBikeView MRBV;
    RentalModel RM;
    List<Rent> list;
    RentTableModel table;
    public ManageRentBikeController(ManageRentBikeView MRBV, RentalModel RM) {
        this.MRBV = MRBV;
        this.RM = RM;
        showBikes();
        MRBV.btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageRentView MRV=new ManageRentView();
                ManageRentController MRC=new ManageRentController(MRV,RM);
                MRV.setVisible(true);
                MRBV.dispose();
            }
        });
        MRBV.tablebike.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                int row = MRBV.tablebike.getSelectedRow();
                String id=String.valueOf(table.getValueAt(row, 0));
                String license=String.valueOf(table.getValueAt(row, 4));
                String return_date=String.valueOf(table.getValueAt(row, 7));
                if(return_date.equals("null")){
                    int input=JOptionPane.showConfirmDialog(null,"Return bike with ID '"+id+"'? You can't undo this action once you click 'Yes'.","Option",JOptionPane.YES_NO_OPTION);
                    if(input==0){
                        RM.updateRent(id, license);
                        showBikes();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"The bike is already returned!");
                }
            }
        });
        MRBV.btnexport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RM.exportRent("Bike");
            }
        });
    }
    
    void showBikes(){
        list = RM.getRent("Bike");
        table = new RentTableModel(list);
        MRBV.tablebike.setModel(table);
    }
}
