/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author John Brix Pomoy
 */

//libraries ng sql driver manager mo at joption pane

import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class database {
    
  
    java.sql.Connection connection = null;
    public static java.sql.Connection getConnection(){
    try {
           
            Class.forName("com.mysql.jdbc.Driver");
            
            //si java.sql.connection ay variable ng nasa itaas na naka null;
            // kaya nakaka insert ka dyan dahil sa imported libaries mo na java.sql.driverManager;
            //root ay username "" isa ay password
            //"jdbc:mysql://localhost/name of your database not table ha mali ko ksi", "root", ""
                                                                                    //localhost 
             java.sql.Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost/informatics", "root", "");
            
            //return value ni connection
            
            return connection;
            
            
            
    }catch(Exception e) {
            
           JOptionPane.showMessageDialog(null, "Not Connected!");
            return null;
            
            
                        }
    
                                    }
}
