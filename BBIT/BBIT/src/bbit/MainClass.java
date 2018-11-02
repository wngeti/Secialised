package bbit;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class MainClass extends JFrame{
    
     private  JPanel mainContentPane;
      JTable table;
     
    //creating constractor()
      
     public MainClass(){
    setFont(new Font("Calibri", Font.PLAIN, 14));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,500);
                setTitle("HOME");
                setVisible(true);
		setLocationRelativeTo(null);
		mainContentPane = new JPanel();
		mainContentPane.setBackground(Color.WHITE);
		mainContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainContentPane);
		mainContentPane.setLayout(null);
                
           ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                    new PieChart.Data("Female",40),
                   new PieChart.Data("Male",30),
                   new PieChart.Data("",5)
           );
           
           
           //Create pie chart and asign data to it
//           PieChart pChart = new PieChart(pieData);
//           Group root = new Group(pChart);
//           Scene scene = new Scene(root,400,400);
//           primaryStage.setTitle("Chart showing Gender distribution");
//           primaryStage.setScene(scene);
//           primaryStage.show();
           
           
                       
               JButton addButton = new JButton("Add User");
        addButton.setBounds(300,350,90,20);
         addButton.addActionListener((ActionEvent ae) -> {
             new AddUser();
             hide();
    });
        mainContentPane.add(addButton);
        
         //Logout Button
         JButton logoutButton = new JButton("Logout");
         logoutButton.setBounds(420,350,80,20);
         logoutButton.addActionListener((ActionEvent ae) -> {
             JOptionPane.showMessageDialog(mainContentPane,"Successfully logged out");
             
             hide();
    });
        mainContentPane.add(logoutButton);
                        
               
    }
     
     public static void main(String[] args){
 
        
EventQueue.invokeLater(new Runnable(){

    public void run(){
    try{
    MainClass frame=new MainClass();//create an instance of main frame
    frame.setVisible(true);
    frame.setTitle("HOME");
    }
    catch(Exception e){
    }
    
    }
});
    
    
}

    private class table extends JFrame {

        public table() {
            
            String [] columnNames = {"Name","Gender","Telephone","Date of Birth","Age"};
               
               
               Object[][] data={
                   {"Henry","Mwangi","0710008441","4/5/1987","36"},
                       {"John","Mbai","0719358441","7/11/1997","26"},
                       {"Grace","Kai","0719310141","12/3/2000","18"}
               };
               
                table  = new JTable(data,columnNames);
               table.setPreferredScrollableViewportSize(new Dimension(500,50));
               table.setFillsViewportHeight(true);
               
               JScrollPane scrollpane = new JScrollPane(table);
               add(scrollpane);
                       
               mainContentPane.add(scrollpane);
        }
    }
    
}
