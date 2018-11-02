package bbit;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


//JFrame is the class that represents the window in which graphics application run on java
public class Login extends JFrame{
    
    /**
     * Declaring java components
     * 'private' key word is an access modifier
     * 'final' key word is a non-access modifier used with variable, classes, methods
     **/
     private JPanel loginContentPanel;
     private final JLabel usernamelabel;
     private final JLabel passwordlabel;
     private final JTextField passwordField;
     private final JTextField usernameField;
     JButton clearButton,loginButton;
     
     //creating the constractor of the main class
     public Login() {
         
         //login frame properties
		setFont(new Font("Cambria", Font.PLAIN, 12));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,500);
                setVisible(true);
		setLocationRelativeTo(null);
                
                //Instantiate the panel to hold other  GUI components
		loginContentPanel = new JPanel();
		loginContentPanel.setBackground(Color.WHITE);
		loginContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                //contentpane is a container contained inside JFrame
		setContentPane(loginContentPanel);
		loginContentPanel.setLayout(null);
                
                //GUI Components for the login page
        //username Label and properties
        usernamelabel = new JLabel();
        usernamelabel.setText("Username");
        usernamelabel.setBounds(50,150,80,28);
        loginContentPanel.add(usernamelabel);
        //usename Text field and properties
        usernameField = new JTextField();
        usernameField.setBounds(120,150,180,28);
        loginContentPanel.add(usernameField);
        // password Label and properties
        passwordlabel = new JLabel();
        passwordlabel.setText("Password");
       passwordlabel.setBounds(50,200,80,28);
        loginContentPanel.add(passwordlabel);
        //password tetx field and properties
        passwordField = new JPasswordField();
        passwordField.setBounds(120,200,180,28);
        loginContentPanel.add(passwordField);
                //clear button and properties
                clearButton=new JButton("CLEAR");
                clearButton.setBounds(100,260,80,20);
                
                loginContentPanel.add(clearButton);
                clearButton.addActionListener((java.awt.event.ActionEvent ae) -> {
                    usernameField.setText("");
                    passwordField.setText("");
                    JOptionPane.showMessageDialog(loginContentPanel,"Field Cleared Successfully");
                });
                
         loginButton = new JButton("LOGIN");
         loginButton.setBounds(220,260,80,20);
         loginButton.addActionListener((java.awt.event.ActionEvent ae) -> {
             String uname=usernameField.getText();
             String password=passwordField.getText();
             
             if (uname.equals("admin") && password.equals("pass123")){
                 JOptionPane.showMessageDialog(loginContentPanel,"Access Granted! Welcome");
                 
                 hide();
                 new MainClass();
                 
                 
             }
             else{
                 JOptionPane.showMessageDialog(loginContentPanel,"Invalid Credentials!");
                 
             }
                });
        loginContentPanel.add(loginButton);
                
}
public static void main(String[] args){
EventQueue.invokeLater(() -> {
    try{
        Login frame=new Login();//create an instance of main frame
        frame.setVisible(true);
        frame.setTitle("Login");
    }
    catch(Exception e){
    }
});
  
}}