/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RentalModel;
import Others.VehicleTableModel;
import Others.Vehicles;
import View.AddRentBikeView;
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
public class AddRentBikeController {
    AddRentBikeView ARBV;
    RentalModel RM;
    int cost,hours;
    String id;
    Vehicles v;
    List<Vehicles> list;
    VehicleTableModel table;
    public AddRentBikeController(AddRentBikeView ARBV, RentalModel RM) {
        this.ARBV = ARBV;
        this.RM = RM;
        showBikes();
        ARBV.btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddRentView ARV=new AddRentView();
                AddRentController ARC=new AddRentController(ARV,RM);
                ARV.setVisible(true);
                ARBV.dispose();
            }
        });
        ARBV.tablebike.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                int row = ARBV.tablebike.getSelectedRow();
                v=new Vehicles();
                id=String.valueOf(table.getValueAt(row, 0));
                String avail=String.valueOf(table.getValueAt(row, 5));
                if(avail.equals("Yes")){
                    ARBV.resetForm();
                    ARBV.setForm(id);
                }
                else{
                    JOptionPane.showMessageDialog(null,"The bike is unavailable!");
                }
            }
        });
        ARBV.rb6h.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(ARBV.rb6h.isSelected()){
                    updateCost();
                }
            }
        });
        ARBV.rb12h.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(ARBV.rb12h.isSelected()){
                    updateCost();
                }
            }
        });
        ARBV.rb24h.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(ARBV.rb24h.isSelected()){
                    updateCost();
                }
            }
        });
        ARBV.rbother.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(ARBV.rbother.isSelected()){
                    ARBV.sduration.setEnabled(true);
                    updateCost();
                }
                else{
                    ARBV.sduration.setEnabled(false);
                    updateCost();
                }
            }
        });
        ARBV.sduration.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                updateCost();
            }
        });
        ARBV.btnrent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCost();
                String name=ARBV.getAName();
                if(!(name.equals("")||cost==0)){
                    RM.addRent(id, name, hours, cost);
                    showBikes();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please fill the form correctly!");
                }
            }
        });
    }
    void updateCost(){
        if(ARBV.rb6h.isSelected()){
            hours=6;
        }else if(ARBV.rb12h.isSelected()){
            hours=12;
        }else if(ARBV.rb24h.isSelected()){
            hours=24;
        }else if(ARBV.rbother.isSelected()){
            hours=(Integer) ARBV.sduration.getValue()*24;
        }else{
            hours=0;
        }
        cost=RM.calculateCost(id, hours);
        ARBV.lcost.setText(Integer.toString(cost));
    }
    void showBikes(){
        list = RM.getVehicles("Bike");
        table = new VehicleTableModel(list);
        ARBV.tablebike.setModel(table);
    }
}
