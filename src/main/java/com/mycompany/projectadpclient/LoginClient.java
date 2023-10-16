/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.projectadpclient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Rabin Family
 */
public class LoginClient implements ActionListener{
    
    private static ObjectInputStream in;
    private static ObjectOutputStream out;
    private static JFrame frameAdminLogin=new JFrame(),frameStudentLoggedInPage=new JFrame(),frameAdminLoggedInPage=new JFrame(), frameStudentLogin=new JFrame();
    private static JPanel northPanel=new JPanel(),southPanel=new JPanel();
    private static JPanel n2nPanel=new JPanel(),n2sPanel=new JPanel();
    private static JPanel n3nPanel=new JPanel(),n3sPanel=new JPanel();
    private static JLabel lblStudentNum=new JLabel("Student Number: "),lblPassword=new JLabel("Password: "), lblAdminNum=new JLabel("Admin Number: "),
            lblNameSurname=new JLabel("Name and Surname: "), lblEmail=new JLabel("Email: "),lblMobNum=new JLabel("Mobile Number: "),
            lblConPass=new JLabel("Confirm Password: "),lblStudName=new JLabel("Student Name: "),
            lblNewStud=new JLabel("Add New Student "),
            lblStudSurname=new JLabel("Student Surname :"), lblNewStudPassw=new JLabel("Password: "),
            lblNewStudSubj=new JLabel("Subject: "),
            lblNewSubject=new JLabel("Add New Subject "), lblSubjName=new JLabel("Subject: "),
             lblSubjCode=new JLabel("Subject Code: ");
    private static JTextField txtStudentNum=new JTextField(20),txtPassword=new JTextField(20),
            txtNameSurname=new JTextField(20), txtAdminNum=new JTextField(20),
            txtEmail=new JTextField(20), txtMobNum=new JTextField(20),
            txtConPass=new JTextField(20),txtCourseID=new JTextField(20),  txtNewStudSurname=new JTextField(20),
              txtNewStudName=new JTextField(20),txtNewStudPassw=new JTextField(20),txtNewStudSubj=new JTextField(20),
            txtNewSubjName=new JTextField(20),txtNewSubjCode=new JTextField(20);
    private static JTextArea txtAreaRecords=new JTextArea(10,50);
    private static JButton btnLogin=new JButton("Login"),btnStudentSignUp1=new JButton("Sign Up"),btnExit=new JButton("Exit"),
            btnStudentSignUp2=new JButton("Sign Up"),btnAdminSignUp1=new JButton("Sign Up"),btnAllCourses=new JButton("All Courses"),
            btnEnrolledCourses=new JButton("Enrolled Courses"),btnEnroll=new JButton("Enroll"),
            btnUnenroll=new JButton("Unenroll"), btnAddNewStud=new JButton("Add New Student"),
            btnAddNewSubj=new JButton("Add New Subject");
    private static String[] Subject = { "Business & Management Studies", "Economics & Econometrics","Medicine","Law",
            "Accounting & Finance","Art & Design"," Engineering & Technology" };
    private static String[] User = { "Student", "Admin" };
    private static JComboBox<String> UserCbmBox = new JComboBox<>(User);
    private static JComboBox<String> SubjectCbmBox = new JComboBox<>(Subject);
    
    private static Socket server;
    private static ArrayList <Students> arrList=new ArrayList<>();
    private static Object object;
    

    
    
      public LoginClient(){
           
//            try{
//                server=new Socket("localhost",12345);
//            }
//            catch(IOException e){
//                e.printStackTrace();
//            }
//            try{
//                out= new ObjectOutputStream(server.getOutputStream());
//                out.flush();
//                in= new ObjectInputStream(server.getInputStream());
//            }
//            catch(IOException e){
//                System.out.println("Exception error in LoginClient() method: "+e.getMessage());
//            }            
//            createAndShowAdminPageGUI();
//            createAndShowStudentLoginGUI();
//            createAndShowAdminLoginGUI();
            createAndShowStudentPageGUI();


    }
      
       private void createAndShowStudentLoginGUI() {
           frameStudentLogin.setTitle("Login");
        frameStudentLogin.setSize(600,400);
        frameStudentLogin.setVisible(true);
        frameStudentLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameStudentLogin.setLayout(new BorderLayout());
        frameStudentLogin.add(northPanel,BorderLayout.NORTH);
        frameStudentLogin.add(southPanel,BorderLayout.SOUTH);
        
        northPanel.setLayout(new BorderLayout());
        northPanel.add(n2nPanel,BorderLayout.NORTH);
        northPanel.add(n2sPanel,BorderLayout.SOUTH);
        
        n2nPanel.add(n3nPanel,BorderLayout.NORTH);
        n2sPanel.add(n3sPanel,BorderLayout.SOUTH);
        
        n3nPanel.setLayout(new GridLayout(4,2));
        n3nPanel.add(lblStudentNum);
        n3nPanel.add(txtStudentNum);
        n3nPanel.add(lblPassword);
        n3nPanel.add(txtPassword);
      
        
        n3sPanel.add(UserCbmBox);
         
        n3sPanel.add(btnLogin);
        
        n3sPanel.add(btnExit);
      
         btnLogin.addActionListener(this);
        btnStudentSignUp1.addActionListener(this);
        btnExit.addActionListener(this);     
           
       }
       
       private void createAndShowAdminLoginGUI() {
        frameAdminLogin.setTitle("Login");
        frameAdminLogin.setSize(600,400);
        frameAdminLogin.setVisible(true);
        frameAdminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAdminLogin.setLayout(new BorderLayout());
        frameAdminLogin.add(northPanel,BorderLayout.NORTH);
        frameAdminLogin.add(southPanel,BorderLayout.SOUTH);
        
        northPanel.setLayout(new BorderLayout());
        northPanel.add(n2nPanel,BorderLayout.NORTH);
        northPanel.add(n2sPanel,BorderLayout.SOUTH);
        
        n2nPanel.add(n3nPanel,BorderLayout.NORTH);
        n2sPanel.add(n3sPanel,BorderLayout.SOUTH);
        
        n3nPanel.setLayout(new GridLayout(4,2));
        n3nPanel.add(lblAdminNum);
        n3nPanel.add(txtAdminNum);
        n3nPanel.add(lblPassword);
        n3nPanel.add(txtPassword);
      
        
        n3sPanel.add(UserCbmBox);
         
        n3sPanel.add(btnLogin);
       
        n3sPanel.add(btnExit);
      
         btnLogin.addActionListener(this);
        btnAdminSignUp1.addActionListener(this);
        btnExit.addActionListener(this);     
           
       }
       private void createAndShowStudentPageGUI(){
        frameStudentLoggedInPage.setTitle("Student");
        frameStudentLoggedInPage.setSize(600,400);
        frameStudentLoggedInPage.setVisible(true);
        frameStudentLoggedInPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameStudentLoggedInPage.setLayout(new BorderLayout());
        
        frameStudentLoggedInPage.add(northPanel,BorderLayout.NORTH);
        frameStudentLoggedInPage.add(southPanel,BorderLayout.SOUTH);
        
        northPanel.setLayout(new BorderLayout());
        northPanel.add(n2nPanel,BorderLayout.NORTH);
        northPanel.add(n2sPanel,BorderLayout.SOUTH);
        
        n2nPanel.add(n3nPanel,BorderLayout.NORTH);
        n2sPanel.add(n3sPanel,BorderLayout.SOUTH);
        
        southPanel.add(txtAreaRecords);
        n3nPanel.setLayout(new GridLayout(4,4));
        n3nPanel.add(btnAllCourses);
        n3nPanel.add(btnEnrolledCourses);
         
        
        
        n3nPanel.add(SubjectCbmBox);
        n3nPanel.add(btnEnroll);
        btnUnenroll.setVisible(false);
        
        btnEnroll.addActionListener(this);
        btnAllCourses.addActionListener(this);
        btnEnrolledCourses.addActionListener(this);  
        
        
       }
       
        private void createAndShowAdminPageGUI(){
            
        frameAdminLoggedInPage.setTitle("Admin");
        frameAdminLoggedInPage.setSize(600,400);
        frameAdminLoggedInPage.setVisible(true);
        frameAdminLoggedInPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAdminLoggedInPage.setLayout(new BorderLayout());
        frameAdminLoggedInPage.add(northPanel,BorderLayout.NORTH);
        frameAdminLoggedInPage.add(southPanel,BorderLayout.SOUTH);
        
        northPanel.setLayout(new BorderLayout());
        northPanel.add(n2nPanel,BorderLayout.NORTH);
        northPanel.add(n2sPanel,BorderLayout.SOUTH);
        
        n2nPanel.add(n3nPanel,BorderLayout.NORTH);
       n2sPanel.add(n3sPanel,BorderLayout.SOUTH);
            
        n3nPanel.add(lblNewStud); 
        n2sPanel.add(lblStudName);
        n2sPanel.add(txtNewStudName);
        n2sPanel.add(lblStudSurname);
        n2sPanel.add(txtNewStudSurname);
        n2sPanel.add(lblNewStudPassw);
        n2sPanel.add(txtNewStudPassw);
        n2sPanel.add(lblNewStudSubj);
        n2sPanel.add(txtNewStudSubj);
        n2sPanel.add(btnAddNewStud);
        
         n3nPanel.add(lblNewSubject); 
        n3nPanel.add(lblSubjName);
        n3nPanel.add(txtNewSubjName);
        n3nPanel.add(lblSubjCode);
        n3nPanel.add(txtNewSubjCode);
         n2sPanel.add(btnAddNewSubj);
        }
       
        private void resetStudentLoginForm() {
        txtStudentNum.setText("");
        txtPassword.setText("");
        
    }
//         private void resetStudentSignUpForm() {
//        txtStudentNum.setText("");
//        txtPassword.setText("");
//        txtEmail.setText("");
//        txtMobNum.setText("");
//        txtNameSurname.setText("");
//        
//    }
        
    private void CheckStudentLoginDetails() throws IOException, ClassNotFoundException{
      out.writeObject(txtStudentNum.getText());
        out.flush();
        String item=(String)in.readObject();
        if(item.equals("Invalid")){
            JOptionPane.showMessageDialog(null, "Student does not exist");
        }  else{
           frameStudentLogin.setVisible(false); 
          createAndShowStudentPageGUI();
           
        } 
        
    }  
    private void CheckAdminDetails() throws IOException, ClassNotFoundException{
      out.writeObject(txtAdminNum.getText());
        out.flush();
        String item=(String)in.readObject();
        if(item.equals("Invalid")){
            JOptionPane.showMessageDialog(null, "Student does not exist");
        }  else{
           frameAdminLogin.setVisible(false);
           //go to page after loggin admin in
           
           
        } 
        
    }
      private void AllCourses(ArrayList courseList) throws IOException, ClassNotFoundException{
          for(int i =0;i<courseList.size();i++){
            txtAreaRecords.append(courseList.get(i).toString()+"\n");            
        }
        txtAreaRecords.append("------------------------------------------"+"\n");
            
      }
      
      private void EnrolledCourses(ArrayList enrolledCourseList) throws IOException, ClassNotFoundException{
           for(int i =0;i<enrolledCourseList.size();i++){
            txtAreaRecords.append(enrolledCourseList.get(i).toString()+"\n");            
        }
        txtAreaRecords.append("------------------------------------------"+"\n");
      }
    
    private void Enrolling(String Subject) throws IOException, ClassNotFoundException{
        try{
            Students sub=new Students(txtNameSurname.getText(),txtStudentNum.getText(),txtEmail.getText(),
                 txtMobNum.getText(),txtPassword.getText(),SubjectCbmBox.getSelectedItem().toString());
            object=sub;
            out.writeObject(object);
            out.flush();
        }
        catch(IOException e){
            System.out.println("Exception error in addStudentRecord() method: "+e.getMessage());
        }   
    }
    
     private void Unenrolling(String Subject) throws IOException, ClassNotFoundException{
        for (Students stud : arrList) {
//            Subject. (stud);
        } 
     }
    
    
//    private void MoveToStudentSignUp(){
//        frameStudentLogin.setVisible(false);
//         createAndShowStudentSignUpGUI();
//    }
    
     private void AddStudentDetials(){
         Students stud=new Students(txtNameSurname.getText(),txtStudentNum.getText(),txtEmail.getText(),
                 txtMobNum.getText(),txtPassword.getText(),SubjectCbmBox.getSelectedItem().toString());
//            object=stud;
//            out.writeObject(object);
//            out.flush();
       //resetStudentSignUpForm();
       // frameStudentSignUp.setVisible(false);
         frameStudentLogin.setVisible(true);
     }
    
        
        
        
        
        
      @Override
    public void actionPerformed(ActionEvent e) {  
       if(e.getSource()==btnLogin){            
            ;
        } else if (e.getSource()==btnStudentSignUp1){
           // MoveToStudentSignUp();
        }else if (e.getSource()==btnStudentSignUp2){
            // AddStudentDetials();
        }
       
       
    } 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        LoginClient client=new LoginClient();
    }
    
}
