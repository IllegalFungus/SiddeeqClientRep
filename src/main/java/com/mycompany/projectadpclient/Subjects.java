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
public class Subjects  implements Serializable {
     private String SubjectName;
    private String SubjectCode; 
    
    public Subjects(String SubjectName,String SubjectCode){
        this.SubjectName= SubjectName;
     this.SubjectCode = SubjectCode; 
        
    }
    
    public String getSubjectName(){
     return SubjectName;
     
 }
    public String getSubjectCode(){
     return SubjectCode;
     
 }
    
     public void setSubjectName(String SubjectCode){
     this.SubjectName= SubjectName;
  }
      public void setSubjectCode(String SubjectCode){
     this.SubjectCode= SubjectCode;
  }
    
    
    
    
    
    
    
    
    
    
}
