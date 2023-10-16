/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectadpclient;

import java.io.Serializable;

/**
 *
 * @author Rabin Family
 */
public class Students implements Serializable {
    private String NameSurname;
    private String StudentNum;
    private String Email;
    private String MobNumber;
    private String Password;
    private String Subject;
    
public Students(String NameSurname, String StudentNum, String Email,String MobNumber,String Password,String Subject  ){
     this.StudentNum= StudentNum;
     this.NameSurname = NameSurname;
     this.Email=Email;
     this.MobNumber=MobNumber;
     this.Subject=Subject;
     this.Password=Password;
     }
 public String getStudentNum(){
     return StudentNum;
     
 }
 public String getNameSurname(){
     return NameSurname;
     
 }
 public String getEmail(){
     return Email;
     
 }
 public String getMobNumber(){
     return MobNumber;
     
 }
 public String getSubject(){
     return Subject;
     
 }
 public String getPassword(){
     return Password;
     
 }
 
  public void setStudentNum(String StudentNum){
     this.StudentNum= StudentNum;
  }
   public void setNameSurname(String NameSurname){
     this.NameSurname= NameSurname;
  }
    public void setEmail(String Email){
     this.Email= Email;
  }
     public void setSubject(String Subject){
     this.StudentNum= Subject;
  }
      public void setPassword(String Password){
     this.Password= Password;
  }
       public void setMobNumber(String MobNumber){
     this.MobNumber = MobNumber;
  }

    
    
    
    
    
    
    
    
    
    
    
    
    
}
