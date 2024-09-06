
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.*;


public class AdminLogin {
    JFrame loginf;
    JLabel usernamel,passwordl,header;
    JTextField usernamet,passwordt;
    JButton loginb;
    AdminLogin() throws SQLException
    {
        this.show();
    }

    public void show() throws SQLException
    {
        loginf=new JFrame("login");
        loginf.setLayout(null);
        usernamel=new JLabel("UserName");
        usernamel.setFont(new Font("Calibri",Font.PLAIN,24));
        usernamel.setBounds(100,50,150,100);

        passwordl=new JLabel("Password");
        passwordl.setFont(new Font("Calibri",Font.PLAIN,24));
        passwordl.setBounds(100,100,150,100);

        header =new JLabel("LOGIN PAGE");
        header.setFont(new Font("Times New Roman",Font.PLAIN,28));
        header.setBounds(150,20,500,50);

        usernamet=new JTextField();
        usernamet.setBounds(250,90,150,30);
        
        passwordt=new JTextField();
        passwordt.setBounds(250,130,150,30);

        loginb=new JButton("Login");
        loginb.setBounds(240,200,100,20);
        loginb.setBackground(Color.YELLOW);
        loginb.setForeground(Color.BLACK);
        loginb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (usernamet.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter username", "Error", JOptionPane.ERROR_MESSAGE);
                 }
             
                 else if (passwordt.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter password", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    PreparedStatement p=null;
                    try{
                        String url="jdbc:mysql://localhost:3306/courier";
                        String user="admin";
                        String pass="1234";
        //Class.forName("com.mysql.jdbc.Driver");  
                        String query="select * from admin where username=?";
                        Connection con=DriverManager.getConnection(url,user,pass);  
                        p=con.prepareStatement(query);
                        String uname=usernamet.getText();
                        String lpass=passwordt.getText();
                        p.setString(1, uname);
                        
                        ResultSet rs= p.executeQuery();

                            if(rs.next())
                            {

                                String getpass=rs.getString(2);
                                if(lpass.equals(getpass))
                                {
                                JOptionPane.showMessageDialog(loginf,"Login Successfull", "Login",  JOptionPane.INFORMATION_MESSAGE);
                            
                                new Admin(usernamet.getText());
                                }
                                else{
                                    
                                JOptionPane.showMessageDialog(null," password incorrect", "Invalid Credentials",  JOptionPane.ERROR_MESSAGE);
                            
                                }
            
                            } 
                            else{
                                    
                                JOptionPane.showMessageDialog(loginf,"User name or password incorrect", "Invalid Credentials",  JOptionPane.ERROR_MESSAGE);
                            
                                 }
            
                            
                        }
                
                        catch(Exception ex)
                        {
                            ex.printStackTrace();
                        }  
                     
                }
                        
                

            }
        });

        
        JButton bb=new JButton("Back");
        bb.setBackground(Color.YELLOW);
        bb.setForeground(Color.BLACK);
        bb.setBounds(120,200,100,20);
        bb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{

                    loginf.setVisible(false);
                    new Home();
                
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
    
                    }
            }
        });
        loginf.add(usernamel);
        loginf.add(passwordl);
        loginf.add(usernamet);
        loginf.add(passwordt);
        loginf.add(header);
        loginf.add(loginb);
        loginf.add(bb);

        loginf.setResizable(true);
        loginf.setVisible(true);
        loginf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginf.setSize(700,500);
        loginf.setLocationRelativeTo(null);

    }

    
}
