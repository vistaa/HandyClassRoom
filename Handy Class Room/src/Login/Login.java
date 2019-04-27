/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.util.*;

import DatabasePackage.*;
import Users.*;
/**
 *
 * @author Xeron
 */
public class Login {
    public String email;
    public String password;
    public DataClass db;
    public UserClass userClass;
    //my name is abid
    //name Changed
    public Login(){
        //empty constructor
        this.email=null;
        this.password=null;
        this.db=new DataClass();
    }
    
    public int checkValidation(){
        if(this.email.isEmpty() || this.password.isEmpty()){
        return 0;
        }
        else{
            String sql="select * from users where email=\'"+this.email+"\' and password=\'"+this.password+"\'";
           // this.db.createConnection();
            
            UserClass user=this.db.UserData(sql);
            
            if(user!=null){
               this.userClass=new UserClass();
                this.userClass=user;
                return 1;
            }
            else{
                return 2;
            }
            
            
        }
        
    }
}
