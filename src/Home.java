import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.*;

public class Home
{   
    JFrame homepage;
    JPanel p1;
    JLabel l1,img1Labelm,plabel;
    JButton adminb,employeeb,userb;
    JMenu menu,exitmenu;
    JMenuItem admin,employee,user,exit;
    JMenuBar mb;

    Home()  throws SQLException
    {
        homescreen();
    }

    public void homescreen() throws SQLException
    {
        homepage=new JFrame("home");
        homepage.getContentPane().setBackground(Color.WHITE);

        p1=new JPanel();
        plabel=new JLabel();
        plabel.setText("Courier Management System ");
        plabel.setFont(new Font("Times new roman",1,28));

        plabel.setLocation(50, 10);

        p1.setSize(700, 50);  // Set the size of the panel
        p1.setLocation(0, 0); // Set the position of the panel within the JFrame

        p1.add(plabel);
        homepage.add(p1);


        mb=new JMenuBar();

        menu=new JMenu("login");

        admin=new JMenuItem("Admin");
        employee=new JMenuItem("employee");
        user=new JMenuItem("user");

        menu.add(admin);
        menu.add(employee);
        menu.add(user);
        

        
        


        exitmenu=new JMenu("exit");
        exit=new JMenuItem("exit");
        exitmenu.add(exit);
        mb.add(menu);
        mb.add(exitmenu);
        mb.setLocation(650, 50);
        p1.add(mb);
        
        

        // adminb.setBounds(100,300,150,20);
        // adminb.setBackground(Color.YELLOW);
        // adminb.setForeground(Color.BLACK);

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{

                    System.exit(0);
            
                }
                catch(Exception ex){
                    ex.printStackTrace();

                }
            }
        });
        

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/parcelservice1.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 700, 500);
        homepage.add(image);
        
        // adminb=new JButton("Admin Login");
        // adminb.setBounds(100,300,150,20);
        // adminb.setBackground(Color.YELLOW);
        // adminb.setForeground(Color.BLACK);
        admin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{

                    homepage.setVisible(false);
                    new AdminLogin();
            
                }
                catch(Exception ex){
                    ex.printStackTrace();

                }
            }
        });
        // employeeb=new JButton("Employee Login");
        // employeeb.setBounds(300,300,150,20);
        // employeeb.setBackground(Color.YELLOW);
        // employeeb.setForeground(Color.BLACK);
        employee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                
                homepage.setVisible(false);
                new EmployeeLogin().setVisible(true);
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        // userb=new JButton("User Login");
        // userb.setBounds(500,300,150,20);
        // userb.setBackground(Color.YELLOW);
        // userb.setForeground(Color.BLACK);
        user.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    homepage.setVisible(false);

                new UserLogin().setVisible(true);;
            
                }
                catch(Exception ex){
                    ex.printStackTrace();

                }
            }
        });
        // homepage.add(adminb);
        // homepage.add(employeeb);
        // homepage.add(userb);
        homepage.setLayout(null);
        homepage.setVisible(true);
        homepage.setSize(700, 500);
        homepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homepage.setLocationRelativeTo(null);
    }  
}