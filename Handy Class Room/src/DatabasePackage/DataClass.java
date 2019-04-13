/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabasePackage;

import java.util.*;
import java.sql.*;
import Users.*;
import Users.Teacher.*;
import Users.Student.*;
import Course.*;

/**
 *
 * @author Xeron
 */


public class DataClass extends Database{
   
    
    public DataClass(){
       
    }
    
    public UserClass UserData (String sql){
      
      ResultSet data =this.getData(sql);
       System.out.println(data);
      ResultSet res;
      if(data!=null){
          
          System.out.println(data);
          UserClass user=new UserClass();
          try{  
              while(data.next()){
             user.userId=data.getInt("id");
             user.email=data.getString("email");
             user.role=data.getString("role");
             this.conn.close();
             return user;
          }
          }catch(Exception e){
              System.out.println(e.toString());
          }
          
          }
          
       
          return null;
      
      
    }
    
    public List<CourseClass> getCourses(int tid){
        String sql="SELECT * FROM `courses` WHERE tid="+tid;
      
        ResultSet data =this.getData(sql);
       
        if(data!=null){
            List<CourseClass> courses=new ArrayList<CourseClass>(); 
            
            try{
            while(data.next()){
                CourseClass course=new CourseClass();
                course.courseId=data.getInt("cid");
                course.courseTitle=data.getString("courseTitle");
                course.studentNumbers=data.getInt("studentNumber");
                course.section=data.getString("section");
                course.maxStudent=data.getInt("maxStudent");
                course.discussionId=data.getInt("discussionId");
                course.teacherId=tid;
                
                courses.add(course);
                  
            }
            this.conn.close();
            return courses;
            }catch(Exception e){
                System.out.println(e.toString());
            }
            
        }
        System.out.println(tid);
        return null;
    }
    
       public List<String> getSections(int tid,int cid){
           
           String sql="SELECT * FROM `courses` WHERE tid="+tid+" and cid="+cid;
           ResultSet data =this.getData(sql);
           
           if(data!=null){
               List<String>sections=new ArrayList<String>();
               try{
               while(data.next()){
                   sections.add(data.getString("section"));
               }
               return sections;
               }catch(Exception e){
                   System.out.println(e.toString());
               }
               
           }
           return null;
           }
       
  }
    
 

