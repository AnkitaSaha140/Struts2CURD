/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2.test.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class ConnectionManager {
    

    public static Connection getConnection() 
    {
        ConfigFileReader configFileReader = new ConfigFileReader();
        Connection con=null;
        ConfigParam configParam = configFileReader.getConfigParam();
        try {
            //Here We need to load the SQL Driver Manager
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(configParam.getHost()+":"+configParam.getPort()+"/"
                    +configParam.getDbName(),configParam.getUserid(),configParam.getPassword());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        
        // the URL needs to be in a proper format
        // DriverManager.getConnection(localhost:3306/dbname, userid, password)
        
        //   System.out.println("userid ="+configParam.getUserid());
        
        
        return con;
    }
}
    
