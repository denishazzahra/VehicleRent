/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class VehicleTableModel extends AbstractTableModel {

    List<Vehicles> list;

    public VehicleTableModel(List<Vehicles> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Brand";
            case 2:
                return "Type";
            case 3:
                return "License";
            case 4:
                return "Cost (1h)";
            case 5:
                return "Available";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getBrand();
            case 2:
                return list.get(rowIndex).getType();
            case 3:
                return list.get(rowIndex).getLicense();
            case 4:
                return list.get(rowIndex).getCost();
            case 5:
                return list.get(rowIndex).getAvailable();
            default:
                return null;
        }
    }
    @Override
    public boolean isCellEditable(int row, int column) {
       return false;
    }
}
