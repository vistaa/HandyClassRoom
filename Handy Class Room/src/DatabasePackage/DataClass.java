/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabasePackage;

import java.util.*;
/**
 *
 * @author Xeron
 */
public class DataClass {
    public Database db=null;
    
    public DataClass(){
        this.db=new Database();
    }
    
    public boolean validation(String email, String password){
        if(this.db.createConnection().equals("1")){
            String sql="select * from users where email=\'"+email+"\' and password=\'"+password+"\'";
           List<Object> data=this.db.getData(sql);
           if(data.size()>0)
               return true;
           else 
               return false;
        }
        else{
        return false;
        }
    }
}
