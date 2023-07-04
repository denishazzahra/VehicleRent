/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RentalModel;
import Others.BikeBrands;
import Others.VehicleTableModel;
import Others.Vehicles;
import View.BikesView;
import View.DashboardView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class BikesController {
    BikesView BV;
    RentalModel RM;
    List<Vehicles> list;
    VehicleTableModel table;
    Vehicles v;
    int id=0,row=-1;
    public BikesController(BikesView BV, RentalModel RM) {
        this.BV = BV;
        this.RM = RM;
        list=RM.getVehicles("Bike");
        setBrand();
        showBikes();
        BV.tablebike.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                int row = BV.tablebike.getSelectedRow();
                v=new Vehicles();
                id=Integer.parseInt(String.valueOf(table.getValueAt(row, 0)));
                v.setId(id);
                v.setBrand(String.valueOf(table.getValueAt(row, 1)));
                v.setType(String.valueOf(table.getValueAt(row, 2)));
                v.setLicense(String.valueOf(table.getValueAt(row, 3)));
                v.setCost(Integer.parseInt(String.valueOf(table.getValueAt(row, 4))));
                BV.setForm(v);
            }
        });
        BV.btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getData();
                if(!(v.getBrand().equals("")||v.getType().equals("")||v.getLicense().equals(""))){
                    RM.addVehicle(v, "Bike");
                    showBikes();
                    BV.resetForm();
                    resetSelected();
                }
            }
        });
        BV.btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardView DV=new DashboardView();
                DashboardController DC=new DashboardController(DV,RM);
                DV.setVisible(true);
                BV.dispose();
            }
        });
        BV.btnedit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(id!=0){
                    int input=JOptionPane.showConfirmDialog(null,"Edit bike with ID '"+id+"'?","Option",JOptionPane.YES_NO_OPTION);
                    if(input==0){
                        getData();
                        v.setId(id);
                        RM.editVehicle(v);
                        showBikes();
                        BV.resetForm();
                        resetSelected();
                    }
                }
            }
        });
        BV.btndelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(id!=0){
                    int input=JOptionPane.showConfirmDialog(null,"Delete bike with ID '"+id+"'?","Option",JOptionPane.YES_NO_OPTION);
                    if(input==0){
                        RM.deleteData(id);
                        showBikes();
                        BV.resetForm();
                        resetSelected();
                    }
                }
            }
        });
        BV.btnexport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RM.exportVehicle("Bike");
            }
        });
    }
    void getData(){
        v=new Vehicles();
        v.setBrand(BV.getBrand());
        v.setType(BV.getAType());
        v.setLicense(BV.getLicense());
        v.setCost(BV.getCost());
    }
    void resetSelected(){
        id=0;
        row=-1;
    }
    void setBrand(){
        BV.cbbrands.setModel(new DefaultComboBoxModel(BikeBrands.values()));
        BV.cbbrands.setSelectedIndex(-1);
    }
    void showBikes(){
        list = RM.getVehicles("Bike");
        table = new VehicleTableModel(list);
        BV.tablebike.setModel(table);
    }
}
