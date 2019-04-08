/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;
import DatabasePackage.*;
/**
 *
 * @author Xeron
 */
public class Login {
    public String email;
    public String password;
    public DataClass dataClass;
    public Login(){
        //empty constructor
        this.email=null;
        this.password=null;
        this.dataClass=new DataClass();
    }
    
    public int checkValidation(){
        if(this.email.isEmpty() || this.password.isEmpty()){
        return 0;
        }
        else if(this.dataClass.validation(this.email, this.password)){
            return 1;
        }
        else
            return 2;
    }
}
