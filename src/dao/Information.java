/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Personal;
import util.database;

/**
 *
 * @author User
 */
public class Information {
    Connection connection;
    
    public void saveInformation(Personal personal){      
          connection = database.getConnection();
            PreparedStatement ps;
        try{ 
            ps = connection.prepareStatement("INSERT INTO `info_table`(`First_Name`, `Last_Name`, `Age`, `Gender`) VALUES (?,?,?,?)");

             ps.setString(1, personal.getFirstname() );
             ps.setString(2, personal.getLastname());
             ps.setInt(3, personal.getAge());
             ps.setString(4, personal.getGender());
             ps.executeUpdate();
            
            }catch (SQLException ex) {
            System.out.print(ex);
            ex.printStackTrace();


        }
      
    }
    public void updateInformation(Personal personal){
            String UpdateQuery = null;
            connection = database.getConnection();
             PreparedStatement ps=null;
       try 
        {     
            
            UpdateQuery ="UPDATE `info_table` SET `First_Name`=?,`Last_Name`=?,`Age`=?,`Gender`=? WHERE ID =?";
            ps = connection.prepareStatement(UpdateQuery);
            ps.setString(1, personal.getFirstname());
            ps.setString(2, personal.getLastname());
            ps.setInt(3, personal.getAge() );
            ps.setString(4, personal.getGender());
            ps.setInt(5, personal.getId());

            ps.executeUpdate();
       
            
        } catch (SQLException ex) {
            System.out.print(ex);
           ex.printStackTrace();
        }
       
    }
    public void deleteInformation(Personal personal){
        try {
                //Connection_Var_drivers.getconnection tinatawag mo ito sa ibang class mo kung saan andun mga varibles nun
                
                connection= database.getConnection();
                PreparedStatement ps = connection.prepareStatement("DELETE FROM info_table WHERE ID = ?");
              
                ps.setInt(1, personal.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
              e.printStackTrace();
            }
    }
    
    public ArrayList<Personal> displayInformation() {
        ArrayList<Personal> get = new ArrayList<Personal>();
        
        connection = database.getConnection();
        String query = "SELECT * FROM `info_table";

        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Personal userss;
            while (rs.next()) {
                //dito ay ididisplay nya na sa java ang naka line table mo sa GUI java
                userss = new Personal(rs.getInt("id"), rs.getString("First_Name"),
                        rs.getString("Last_Name"), rs.getInt("Age"), rs.getString("Gender"));
                       
                get.add(userss);
            }
            

        } catch (SQLException ex) {
            
            Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return get;
      }

  
}
