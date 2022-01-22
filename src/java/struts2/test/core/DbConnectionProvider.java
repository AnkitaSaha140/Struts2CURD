/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2.test.core;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class DbConnectionProvider {
    
    public static DbConnectionProvider dbConnectionProvider;
    // This is a class variable, it can be shared by all object of this type
    
    private DbConnectionProvider()
    {
        //I will do some job here 
        System.out.println("Message from constructor");
    }
    
    public static DbConnectionProvider getInstance()
    {
        if(dbConnectionProvider==null)
        {
            dbConnectionProvider = new DbConnectionProvider(); //calling the constructor
        }
        return dbConnectionProvider;
    }
    
    public void getDbConnection()
    {
        // here I will write some code for connection
        System.out.println("You can get a DB Connection by calling this method");
        //First I need the DB parameters
        ConfigFileReader configFileReader = new ConfigFileReader();
        ConfigParam configParam = configFileReader.getConfigParam();
        System.out.println("userid ="+configParam.getUserid());
    }
    
}
