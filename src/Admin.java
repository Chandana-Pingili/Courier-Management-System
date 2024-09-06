import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.SQLException;
import java.awt.*;

public class Admin {
    JFrame fa;
   
    JButton jButton1;
    JButton jButton2;
    JButton jButton3;
    JButton jButton4;
    JButton jButton5;
    JLabel jLabel1;
    
  

    public Admin(String s) {
        initComponents(s);
    }


     public void initComponents(String s) {
        fa=new JFrame("Admin Page");
           fa.setLayout(null);
        fa.getContentPane().setBackground(Color.gray);
        //JPanel p1=new JPanel();
        jLabel1=new JLabel();
        jLabel1.setText("welcome"+s);
        jLabel1.setFont(new Font("Times new roman",1,28));

        jLabel1.setBounds(20,20,300,50);
        jLabel1.setForeground(Color.BLACK);

        
        fa.add(jLabel1);
        jButton1=new JButton("Add");

        jButton1.setBackground(Color.decode("#013220"));
        jButton1.setBounds(250,100,200,75);
        jButton1.setForeground(Color.white);
        
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{

                    
                    new Order(s);
                
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
            }
        });



        jButton2 = new JButton("Pending Orders");
        jButton2.setBackground(Color.decode("#013220"));
        jButton2.setBounds(250,200,200,75);
        jButton2.setForeground(Color.white);
        




        

        
        jButton3 = new javax.swing.JButton("All Orders");
         jButton3.setBackground(Color.decode("#013220"));
        jButton3.setBounds(250,300,200,75);
        jButton3.setForeground(Color.white);
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{

                   new AllOrders(s);
                
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
            }
        });



          

        jButton4 = new javax.swing.JButton("exit");
        jButton4.setBackground(Color.decode("#013220"));
        jButton4.setBounds(200,400,100,50);
        jButton4.setForeground(Color.white);
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{

                   new AdminLogin();
                
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
            }
        });



        
        // jButton5 = new javax.swing.JButton();
        // jButton5.setBackground(Color.decode("#013220"));
        // jButton5.setBounds(300,250,100,50);
        // jButton5.setForeground(Color.white);
        // fa.add(jButton5);
        fa.add(jButton1);
        fa.add(jButton2);
        fa.add(jButton3);
        fa.add(jButton4);
        fa.pack();
        fa.setVisible(true);
        fa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fa.setSize(700,500);;
        fa.setLocationRelativeTo(null);


    // Variables declaration - do not modify                     
    
    // End of variables declaration                   

}


    
}
