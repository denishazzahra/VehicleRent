/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RentalModel;
import Others.VehicleTableModel;
import Others.Vehicles;
import View.AddRentCarView;
import View.AddRentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author LENOVO
 */
public class AddRentCarController {
    AddRentCarView ARCV;
    RentalModel RM;
    int cost,hours;
    String id;
    Vehicles v;
    List<Vehicles> list;
    VehicleTableModel table;
    public AddRentCarController(AddRentCarView ARCV, RentalModel RM) {
        this.ARCV = ARCV;
        this.RM = RM;
        showCars();
        ARCV.btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddRentView ARV=new AddRentView();
                AddRentController ARC=new AddRentController(ARV,RM);
                ARV.setVisible(true);
                ARCV.dispose();
            }
        });
        ARCV.tablecar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                int row = ARCV.tablecar.getSelectedRow();
                v=new Vehicles();
                id=String.valueOf(table.getValueAt(row, 0));
                String avail=String.valueOf(table.getValueAt(row, 5));
                if(avail.equals("Yes")){
                    ARCV.resetForm();
                    ARCV.setForm(id);
                }
                else{
                    JOptionPane.showMessageDialog(null,"The car is unavailable!");
                }
            }
        });
        ARCV.rb6h.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(ARCV.rb6h.isSelected()){
                    updateCost();
                }
            }
        });
        ARCV.rb12h.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(ARCV.rb12h.isSelected()){
                    updateCost();
                }
            }
        });
        ARCV.rb24h.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(ARCV.rb24h.isSelected()){
                    updateCost();
                }
            }
        });
        ARCV.rbother.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(ARCV.rbother.isSelected()){
                    ARCV.sduration.setEnabled(true);
                    updateCost();
                }
                else{
                    ARCV.sduration.setEnabled(false);
                    updateCost();
                }
            }
        });
        ARCV.sduration.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                updateCost();
            }
        });
        ARCV.btnrent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCost();
                String name=ARCV.getAName();
                if(!(name.equals("")||cost==0)){
                    RM.addRent(id, name, hours, cost);
                    showCars();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please fill the form correctly!");
                }
            }
        });
    }
    void updateCost(){
        if(ARCV.rb6h.isSelected()){
            hours=6;
        }else if(ARCV.rb12h.isSelected()){
            hours=12;
        }else if(ARCV.rb24h.isSelected()){
            hours=24;
        }else if(ARCV.rbother.isSelected()){
            hours=(Integer) ARCV.sduration.getValue()*24;
        }else{
            hours=0;
        }
        cost=RM.calculateCost(id, hours);
        ARCV.lcost.setText(Integer.toString(cost));
    }
    void showCars(){
        list = RM.getVehicles("Car");
        table = new VehicleTableModel(list);
        ARCV.tablecar.setModel(table);
    }
}
