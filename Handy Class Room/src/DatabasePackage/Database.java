/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DatabasePackage;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Xeron
 */
public class Database {
    
    //attributes
    public String serverName=null;
    public String dbName=null;
    public String userName=null;
    public String password=null;
    public String connnectionString=null;
    public Connection conn=null;
    public Statement stmt=null;
    
    //methods
    
    //empty constructor
    public Database(){
      
        this.serverName="jdbc:mysql://localhost:3306/";
        this.dbName="classroomdb";
        this.userName="root";
        this.password="";
    }
    
    public String createConnection(){
        this.connnectionString=this.serverName+this.dbName;
        try{
            Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection(this.connnectionString,this.userName,this.password);
                        this.stmt = conn.createStatement();
                        return "1";
        }catch(Exception e){
            return e.toString();
        }
     
    }
    
    public ResultSet getData(String sql){
        this.createConnection();
        ResultSet data;
       
        try{
       data= this.stmt.executeQuery(sql);
 
        return data;
        }catch(Exception e){
            data=null;
           
            return data;
        }
        
        
    }
    
    public boolean execute(String sql){
        try{
            this.stmt.executeUpdate(sql);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
