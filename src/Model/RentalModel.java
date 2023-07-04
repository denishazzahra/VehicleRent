/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Others.Rent;
import Others.Vehicles;
import java.io.File;
import java.io.RandomAccessFile;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class RentalModel extends Connector implements CalculateInterface {
    public boolean checkLogin(String username, String password){
        try{
            String query = "Select COUNT(*) as total from admins WHERE username='"+username+"' and password=BINARY '"+password+"'";
            statement = connection.createStatement();
            ResultSet result=statement.executeQuery(query);
            while(result.next())
            {
                if(result.getString("total").equals("1"))
                {
                    return true;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }
    public List<Vehicles> getVehicles(String vtype) {
        List<Vehicles> list = null;
        try {
            list = new ArrayList<>();
            String query = "SELECT * FROM vehicles where vehicle='"+vtype+"'";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Vehicles v = new Vehicles();
                v.setId(rs.getInt("id"));
                v.setBrand(rs.getString("brand"));
                v.setType(rs.getString("type"));
                v.setLicense(rs.getString("license"));
                v.setCost(rs.getInt("cost"));
                v.setAvailable(rs.getString("available"));
                list.add(v);
            }
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return list;
    }
    public void addVehicle(Vehicles v,String vtype){
        try{
            String query="INSERT INTO vehicles VALUES ('0','"+vtype+"','"+v.getBrand()+"','"+v.getType()+"','"+v.getLicense()+"','"+v.getCost()+"','Yes')";
            statement=connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data added successfully!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    public void editVehicle(Vehicles v){
        try{
            String query="UPDATE vehicles set brand='"+v.getBrand()+"', type='"+v.getType()+"',license='"+v.getLicense()+"',cost='"+v.getCost()+"' WHERE id='"+v.getId()+"'";
            statement=connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data edited successfully!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    public void deleteData(int id){
        try{
            String query="SET FOREIGN_KEY_CHECKS=0;";
            statement=connection.createStatement();
            statement.executeUpdate(query);
            String query1="DELETE from vehicles WHERE id='"+id+"'";
            statement=connection.createStatement();
            statement.executeUpdate(query1);
            JOptionPane.showMessageDialog(null,"Data deleted successfully!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    public void exportVehicle(String vtype) {
        String filePath = vtype+".csv";
        List<Vehicles> list=getVehicles(vtype);
        try {
            RandomAccessFile file = new RandomAccessFile(filePath, "rw");
            file.setLength(0);
            String columnData = "id, brand, type, license, cost_per_hour, available";
            file.writeBytes(columnData);
            file.writeBytes(System.lineSeparator());
            for (int i = 0; i < list.size(); i++) {
                String id=Integer.toString(list.get(i).getId());
                String brand=list.get(i).getBrand();
                String type=list.get(i).getType();
                String license=list.get(i).getLicense();
                String cost=Integer.toString(list.get(i).getCost());
                String available=list.get(i).getAvailable();
                String data = "" + id + ", " + brand + ", " + type + ", " + license + ", " + cost + ", " +available;
                file.writeBytes(data);
                file.writeBytes(System.lineSeparator());
            }
            file.close();
            JOptionPane.showMessageDialog(null, "Data exported to \""+vtype+".csv\" successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public int calculateCost(String id, int hours) {
        int cost=0;
        try{
            String query="SELECT cost from vehicles where id='"+id+"'";
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                cost=Integer.parseInt(rs.getString("cost"))*hours;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return cost;
    }

    @Override
    public int calculateFine(String id) {
        int fine=0;
        int hours=getLate(id);
        System.out.println(hours);
        try{
            String query="SELECT cost from rent where id='"+id+"'";
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                fine=Integer.parseInt(rs.getString("cost"))*hours/10;
                System.out.println(fine);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return fine;
    }
    
    public int getLate(String id){
        int hours=0;
        try{
            String query="SELECT TIMESTAMPDIFF(HOUR,rent_due,return_date) as late from rent where id='"+id+"'";
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                hours=Integer.parseInt(rs.getString("late"));
                if(hours<=0){
                    return 0;
                }
                else{
                    return hours;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return hours;
    }
    public void addRent(String id,String name,int hours,int cost){
        try{
            String query="INSERT INTO rent VALUES (null,'"+name+"','"+id+"',current_timestamp(),DATE_ADD(current_timestamp(), INTERVAL "+hours+" HOUR),null,'"+cost+"',0)";
            statement=connection.createStatement();
            statement.executeUpdate(query);
            String query1="UPDATE vehicles set available='No' where id='"+id+"'";
            statement=connection.createStatement();
            statement.executeUpdate(query1);
            JOptionPane.showMessageDialog(null,"Rent added successfully!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    public void updateRent(String rent_id,String license){
        try{
            String query="UPDATE rent set return_date=now() where id='"+rent_id+"'";
            statement=connection.createStatement();
            statement.executeUpdate(query);
            String query1="UPDATE rent set fine='"+calculateFine(rent_id)+"' where id='"+rent_id+"'";
            statement=connection.createStatement();
            statement.executeUpdate(query1);
            String query2="UPDATE vehicles set available='Yes' where license='"+license+"'";
            statement=connection.createStatement();
            statement.executeUpdate(query2);
            JOptionPane.showMessageDialog(null,"Rent updated successfully!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    public List<Rent> getRent(String vtype) {
        List<Rent> list = null;
        try {
            list = new ArrayList<>();
            String query = "SELECT rent.id as id,renter,brand,type,license,rent_from,rent_due,return_date,rent.cost as cost,fine FROM rent INNER JOIN vehicles on rent.vehicles_id=vehicles.id where vehicle='"+vtype+"'";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Rent r = new Rent();
                r.setId(rs.getInt("id"));
                r.setRenter(rs.getString("renter"));
                r.setBrand(rs.getString("brand"));
                r.setType(rs.getString("type"));
                r.setLicense(rs.getString("license"));
                r.setRentFrom(rs.getString("rent_from"));
                r.setRentDue(rs.getString("rent_due"));
                r.setReturnDate(rs.getString("return_date"));
                r.setCost(rs.getInt("cost"));
                r.setFine(rs.getInt("fine"));
                list.add(r);
            }
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return list;
    }
    public void exportRent(String vtype) {
        String filePath = "Rent"+vtype+".csv";
        List<Rent> list=getRent(vtype);
        try {
            RandomAccessFile file = new RandomAccessFile(filePath, "rw");
            file.setLength(0);
            String columnData = "id, renter, brand, type, license, rent_from, rent_due, return_date, cost, fine";
            file.writeBytes(columnData);
            file.writeBytes(System.lineSeparator());
            for (int i = 0; i < list.size(); i++) {
                String id=Integer.toString(list.get(i).getId());
                String renter=list.get(i).getRenter();
                String brand=list.get(i).getBrand();
                String type=list.get(i).getType();
                String license=list.get(i).getLicense();
                String rent_from=list.get(i).getRentFrom();
                String rent_due=list.get(i).getRentDue();
                String return_date=list.get(i).getReturnDate();
                String cost=Integer.toString(list.get(i).getCost());
                String fine=Integer.toString(list.get(i).getFine());
                String data = "" + id + ", " + renter + ", " + brand + ", " + type + ", " + license + ", " + rent_from + ", " +rent_due+ ", " + return_date + ", " + cost + ", " + fine;
                file.writeBytes(data);
                file.writeBytes(System.lineSeparator());
            }
            file.close();
            JOptionPane.showMessageDialog(null, "Data exported to \"Rent"+vtype+".csv\" successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
