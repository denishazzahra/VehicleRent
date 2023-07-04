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
public class RentTableModel extends AbstractTableModel{
    List<Rent> list;

    public RentTableModel(List<Rent> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Renter";
            case 2:
                return "Brand";
            case 3:
                return "Type";
            case 4:
                return "License";
            case 5:
                return "Rent From";
            case 6:
                return "Rent Due";
            case 7:
                return "Return Date";
            case 8:
                return "Cost";
            case 9:
                return "Fine";
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
                return list.get(rowIndex).getRenter();
            case 2:
                return list.get(rowIndex).getBrand();
            case 3:
                return list.get(rowIndex).getType();
            case 4:
                return list.get(rowIndex).getLicense();
            case 5:
                return list.get(rowIndex).getRentFrom();
            case 6:
                return list.get(rowIndex).getRentDue();
            case 7:
                return list.get(rowIndex).getReturnDate();
            case 8:
                return list.get(rowIndex).getCost();
            case 9:
                return list.get(rowIndex).getFine();
            default:
                return null;
        }
    }
    @Override
    public boolean isCellEditable(int row, int column) {
       return false;
    }
}
