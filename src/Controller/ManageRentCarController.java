/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RentalModel;
import Others.Rent;
import Others.RentTableModel;
import View.ManageRentCarView;
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
public class ManageRentCarController {
    ManageRentCarView MRCV;
    RentalModel RM;
    List<Rent> list;
    RentTableModel table;
    public ManageRentCarController(ManageRentCarView MRCV, RentalModel RM) {
        this.MRCV = MRCV;
        this.RM = RM;
        showCars();
        MRCV.btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageRentView MRV=new ManageRentView();
                ManageRentController MRC=new ManageRentController(MRV,RM);
                MRV.setVisible(true);
                MRCV.dispose();
            }
        });
        MRCV.tablecar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                int row = MRCV.tablecar.getSelectedRow();
                String id=String.valueOf(table.getValueAt(row, 0));
                String license=String.valueOf(table.getValueAt(row, 4));
                String return_date=String.valueOf(table.getValueAt(row, 7));
                if(return_date.equals("null")){
                    int input=JOptionPane.showConfirmDialog(null,"Return car with ID '"+id+"'? You can't undo this action once you click 'Yes'.","Option",JOptionPane.YES_NO_OPTION);
                    if(input==0){
                        RM.updateRent(id, license);
                        showCars();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"The car is already returned!");
                }
            }
        });
        MRCV.btnexport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RM.exportRent("Car");
            }
        });
    }
    
    void showCars(){
        list = RM.getRent("Car");
        table = new RentTableModel(list);
        MRCV.tablecar.setModel(table);
    }
}
