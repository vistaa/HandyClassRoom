/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users.Teacher;
import java.util.*;

import Users.*;
import DatabasePackage.*;
import Course.*;
/**
 *
 * @author Xeron
 */
public class TeacherClass extends UserClass {
    public int teacherId;
    public int numberOfCourseCreated;
    public String userName;
    
    public DataClass dataClass;
    public List<CourseClass> courses;
    public List<String>sections;
    
   public TeacherClass(){
       this.dataClass=new DataClass();
   }
    
   public void setCourseFromDb(int id){
       this.teacherId=id;
      this.courses=this.dataClass.getCourses(this.teacherId);
      System.out.println(this.teacherId);
      if(this.courses!=null){
          this.numberOfCourseCreated=this.courses.size();
      }else
          this.numberOfCourseCreated=0;
   }
   
   public List<String> setSections(String cid){
       List<String>data=this.dataClass.getSections(this.teacherId, Integer.parseInt(cid));
       if(data!=null)
           return data;
      return null;
   }
}




