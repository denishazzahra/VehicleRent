/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RentalModel;
import Others.CarBrands;
import Others.VehicleTableModel;
import Others.Vehicles;
import View.CarsView;
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
public class CarsController {
    CarsView CV;
    RentalModel RM;
    List<Vehicles> list;
    VehicleTableModel table;
    Vehicles v;
    int id=0,row=-1;
    public CarsController(CarsView CV, RentalModel RM) {
        this.CV = CV;
        this.RM = RM;
        list=RM.getVehicles("Car");
        setBrand();
        showCars();
        CV.tablecar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                int row = CV.tablecar.getSelectedRow();
                v=new Vehicles();
                id=Integer.parseInt(String.valueOf(table.getValueAt(row, 0)));
                v.setId(id);
                v.setBrand(String.valueOf(table.getValueAt(row, 1)));
                v.setType(String.valueOf(table.getValueAt(row, 2)));
                v.setLicense(String.valueOf(table.getValueAt(row, 3)));
                v.setCost(Integer.parseInt(String.valueOf(table.getValueAt(row, 4))));
                CV.setForm(v);
            }
        });
        CV.btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getData();
                if(!(v.getBrand().equals("")||v.getType().equals("")||v.getLicense().equals(""))){
                    RM.addVehicle(v, "Car");
                    showCars();
                    CV.resetForm();
                    resetSelected();
                }
            }
        });
        CV.btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardView DV=new DashboardView();
                DashboardController DC=new DashboardController(DV,RM);
                DV.setVisible(true);
                CV.dispose();
            }
        });
        CV.btnedit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(id!=0){
                    int input=JOptionPane.showConfirmDialog(null,"Edit car with ID '"+id+"'?","Option",JOptionPane.YES_NO_OPTION);
                    if(input==0){
                        getData();
                        v.setId(id);
                        RM.editVehicle(v);
                        showCars();
                        CV.resetForm();
                        resetSelected();
                    }
                }
            }
        });
        CV.btndelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(id!=0){
                    int input=JOptionPane.showConfirmDialog(null,"Delete car with ID '"+id+"'?","Option",JOptionPane.YES_NO_OPTION);
                    if(input==0){
                        RM.deleteData(id);
                        showCars();
                        CV.resetForm();
                        resetSelected();
                    }
                }
            }
        });
        CV.btnexport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RM.exportVehicle("Car");
            }
        });
    }
    void getData(){
        v=new Vehicles();
        v.setBrand(CV.getBrand());
        v.setType(CV.getAType());
        v.setLicense(CV.getLicense());
        v.setCost(CV.getCost());
    }
    void resetSelected(){
        id=0;
        row=-1;
    }
    void setBrand(){
        CV.cbbrands.setModel(new DefaultComboBoxModel(CarBrands.values()));
        CV.cbbrands.setSelectedIndex(-1);
    }
    void showCars(){
        list = RM.getVehicles("Car");
        table = new VehicleTableModel(list);
        CV.tablecar.setModel(table);
    }
}
