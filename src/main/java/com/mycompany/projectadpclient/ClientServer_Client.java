package com.mycompany.projectadpclient;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientServer_Client extends JFrame implements ActionListener
{
    private static ObjectInputStream in;
    private static ObjectOutputStream out;
    private static JFrame frmFrame;
    private static JPanel pnlMain, pnlBtn;
    private static JLabel lblID, lblPass;
    private static JTextField txtID, txtPass;
    private static JButton btnLogin, btnExit, btnSignUp;
    private static Socket socket;
    private static Object receivedObject;
   
    
    public ClientServer_Client()
        {
        super("Login");
        //Connect to Server:
        try
        {
            socket = new Socket("localhost", 12345);
        }
        catch (IOException ioe)
        {
            System.out.println("IO Exception: " + ioe.getMessage());
        }
        
        //IO Streams:
        try
        {
            out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(socket.getInputStream());
        }
        catch (IOException ioe)
        {
            System.out.println("IO Exception in Client getStream(): " + ioe.getMessage());
        }
        
        //Call GUI method :)
        createGUI();
                
        }
    
        public void createGUI()
        {
            frmFrame = new JFrame();
            frmFrame.setLayout(new BorderLayout());
            
            txtID = new JTextField();
            txtPass = new JTextField();
            
            lblID = new JLabel("ID:");
            lblPass = new JLabel("Password:");
            
            btnLogin = new JButton("Login");
                btnLogin.addActionListener(this);
            btnExit = new JButton("Exit");
                btnExit.addActionListener(this);
            btnSignUp = new JButton("Sign Up");
                btnSignUp.addActionListener(this);
                
            pnlMain = new JPanel();
            pnlMain.setLayout(new GridLayout(2, 2));
                pnlMain.add(lblID);
                pnlMain.add(txtID);
                pnlMain.add(lblPass);
                pnlMain.add(txtPass);
            pnlBtn = new JPanel();
            pnlBtn.setLayout(new GridLayout(1, 3));
                pnlBtn.add(btnLogin);
                pnlBtn.add(btnExit);
                pnlBtn.add(btnSignUp);
            
            frmFrame.add(pnlMain, BorderLayout.CENTER);    
            frmFrame.add(pnlBtn, BorderLayout.SOUTH);    
                
            frmFrame.setSize(600,200);
            frmFrame.setVisible(true);
            frmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        }
        
        private static void attemptLogin() 
        {
            //Send login details through to server, to attempt login.
            String strID = txtID.getText();
            String strPassword = txtPass.getText();
            //int ID = Double.parseDouble(strScore);
            int intID = Integer.parseInt(strID);
            String strFunction = "Login";

            User newUser = new User(intID, strPassword, strFunction);
            
            //Send Object:
            try
            {
                out.writeObject(newUser);
                out.flush();
            } catch (IOException ioe)
            {
                System.out.println("IOException in client send object: " + ioe.getMessage());
            }
        }
        
        public void LoggedIn(){
                try
                {
                    receivedObject = in.readObject();
                    if (receivedObject instanceof User)
                    {
                        User loggedIn = (User) receivedObject;
                        
                        if (loggedIn == null) {
                            JOptionPane.showMessageDialog(null, "The ID or Password is incorrect.");
                        } else if (loggedIn.isAdmin()) {
                            //Change GUI to admin GUI.
                            JOptionPane.showMessageDialog(null, "Welcome Admin");
                        } else if (loggedIn.isAdmin() == false) {
                            //Change GUI to student GUI.
                            JOptionPane.showMessageDialog(null, "Welcome Student.");
                        }
                    }
                    
                } catch (ClassNotFoundException cnfe)
                {
                    cnfe.printStackTrace();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
//            }
    }
        
        
        
        private static void closeConnection() 
        {
            //Send exit string:
            try
            {
                out.writeObject("exit");
                out.flush();
            }
            catch (IOException ioe)
            {
                System.out.println("IO Exception: " + ioe.getMessage());
            }

            //Close all connections:
            try
            {
                out.close();
                in.close();
                socket.close();
            }
            catch (IOException ioe)
            {
                System.out.println("IO Exception in closeConnections(): " + ioe.getMessage());
            }
        }
    
    public void actionPerformed(ActionEvent e) {
        //Code for the button handling.
        if (e.getSource() == btnLogin) 
        {   
            attemptLogin();
            LoggedIn();
        } else if (e.getSource() == btnExit)
        {
            closeConnection();
            System.exit(0);
        } else if (e.getSource() == btnSignUp)
        {
            try
            {
                out.writeObject("signup");
                out.flush();
            } catch (IOException ioe)
            {
                System.out.println("IOException in client send object: " + ioe.getMessage());
            }
            
        }    
    }
    
    public static void main(String[] args) {
        ClientServer_Client client = new ClientServer_Client();
    }
    
}
