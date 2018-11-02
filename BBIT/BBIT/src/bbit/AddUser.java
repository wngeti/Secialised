package bbit;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddUser extends JFrame {
    
     private  JPanel userPanel;
     JLabel firstnamelabel,lastnameLabel,phoneLabel,birthLabel,genderLabel,femaleLabel,maleLabel;
     JTextField firstnameField,lastnameField,phoneField,birthField;
     JButton UserClearButton,saveButton;
     JRadioButton female,male;
     public Connection userConnection;
     public Statement usersStatement;
     
     public AddUser()
     {
         
         setFont(new Font("Cambria", Font.PLAIN, 12));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(500,400);
                setTitle("Add User Form");
                setVisible(true);
		setLocationRelativeTo(null);
		userPanel = new JPanel();
		userPanel.setBackground(Color.WHITE);
		userPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(userPanel);
		userPanel.setLayout(null);
                
                
                //firstname Label
        firstnamelabel = new JLabel();
        firstnamelabel.setText("First Name");
        firstnamelabel.setBounds(50,80,80,28);
        userPanel.add(firstnamelabel);
        //first name Text field
        firstnameField = new JTextField();
        firstnameField.setBounds(120,80,180,28);
        userPanel.add(firstnameField);
        //last name Label
        lastnameLabel = new JLabel();
        lastnameLabel.setText("Last Name");
        lastnameLabel.setBounds(50,120,80,28);
        userPanel.add(lastnameLabel);
        //last name tetx field
         lastnameField = new JTextField();
         lastnameField.setBounds(120,120,180,28);
         userPanel.add(lastnameField);
         //Telephone Label
         phoneLabel = new JLabel();
         phoneLabel.setText("Telephone");
         phoneLabel.setBounds(50,160,80,28);
        userPanel.add(phoneLabel);
        //phone number tetx field
         phoneField = new JTextField();
         phoneField.setBounds(120,160,180,28);
        userPanel.add(phoneField);
         //Date of birth Label
         birthLabel = new JLabel();
         birthLabel.setText("Date of Birth");
         birthLabel.setBounds(50,200,80,28);
         userPanel.add(birthLabel);
        //birth day tetx field
         birthField = new JTextField();
         birthField.setBounds(120,200,180,28);
         userPanel.add(birthField);
        
        //Gender buttons
         genderLabel = new JLabel();
         genderLabel.setText("Gender");
         genderLabel.setBounds(50,240,80,28);
         userPanel.add(genderLabel);
        
         female= new JRadioButton();
         female.setBounds(160,240,20,28);
         userPanel.add(female);
        
        femaleLabel = new JLabel();
        femaleLabel.setText("Female");
        femaleLabel.setBounds(200,240,80,28);
        userPanel.add(femaleLabel);
        
        male= new JRadioButton();
        male.setBounds(250,240,20,28);
        male.setSelected(true);
        userPanel.add(male);
        
          maleLabel = new JLabel();
         maleLabel.setText("Male");
         maleLabel.setBounds(280,240,80,28);
         userPanel.add(maleLabel);
        //Button group
             ButtonGroup genderGroup = new ButtonGroup();
             genderGroup.add(male);
             genderGroup.add(female);
//        //Clear Button
         UserClearButton = new JButton("CLEAR");
         UserClearButton.setBounds(100,280,80,20);
         UserClearButton.addActionListener((ActionEvent ae) -> {
            //Clearing input text fields
            firstnameField.setText("");
            lastnameField.setText("");
            phoneField.setText("");
            birthField.setText("");
            
            JOptionPane.showMessageDialog(userPanel,"Field Cleared successfully");
         });
        userPanel.add(UserClearButton);
        //save user Button
          saveButton = new JButton("SAVE USER");
          saveButton.setBounds(200,280,110,20);
          saveButton.addActionListener((ActionEvent ae) -> {
             
             String fname=firstnameField.getText();
             String lname=lastnameField.getText();
             String mobile=phoneField.getText();
             String birthname=birthField.getText();
             String sex = male.getText();
             
             
             if (fname.equals("") && lname.equals("") && mobile.equals("") && birthname.equals("")){
                 JOptionPane.showMessageDialog(userPanel,"Fields Cannot be empty!!");
             }
             else if(fname.equals("")){
            JOptionPane.showMessageDialog(userPanel,"First name cannot be Empty");

             }
             
              else if(lname.equals("")){
            JOptionPane.showMessageDialog(userPanel,"Last name cannot be Empty");

             }
              
               else if(mobile.equals("")){
            JOptionPane.showMessageDialog(userPanel,"Phone Number cannot be Empty");

             }
                 else if(birthname.equals("")){
            JOptionPane.showMessageDialog(userPanel,"Birth date cannot be Empty");

             }
             else{
                     try{
                         //Class.forName("com.mysql.jdbc.Driver");
                         //userConnection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?zeroDateTimeBehavior=convertToNull","root","");
                         //usersStatement=(Statement) userConnection.createStatement();
                         //String dataSql="INSERT INTO users (firstname, lastname, telephone, dob, gender)" + " VALUES (' "+fname+"',' "+lname+" ',' "+mobile+" ',' "+birthname+" ','"+sex+"');";
                         //usersStatement.executeUpdate(dataSql);
                          JOptionPane.showMessageDialog(userPanel,"User Addedd Successfully");
                          hide();
                          new MainClass();
                     } catch(Exception e){
                          JOptionPane.showMessageDialog(userPanel,"Unable to connect!");
                     }
                
             }
         });
         userPanel.add(saveButton);
 
     }
  
}