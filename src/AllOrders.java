import javax.swing.*;
import javax.swing.table.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.*;

public class AllOrders {
    JButton View,back,Update;
        JTable detailstable;
        JLabel heading;
        JScrollPane jScrollPane1;
        JPanel panel1;
        JFrame f= new JFrame();
 
    public AllOrders(String s) {
        initComponents(s);
    }
                          
    void initComponents(String s) {
        f.setVisible(true);
        panel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailstable = new javax.swing.JTable();
        View = new javax.swing.JButton();
        back = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        heading = new javax.swing.JLabel();

        

       

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        f.setBackground(new java.awt.Color(0, 102, 102));
        f.setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        f.setSize(new java.awt.Dimension(700, 500));

        detailstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "From(Pin code)", "To(Pincode)", "From(Address)","To(Address)","Customer name","phone number","type of object","weight","Status"
            }
        ));
        jScrollPane1.setViewportView(detailstable);
        if (detailstable.getColumnModel().getColumnCount() > 0) {
            detailstable.getColumnModel().getColumn(0).setPreferredWidth(200);
            detailstable.getColumnModel().getColumn(1).setPreferredWidth(200);
            detailstable.getColumnModel().getColumn(2).setPreferredWidth(200);
            detailstable.getColumnModel().getColumn(3).setPreferredWidth(200);
            detailstable.getColumnModel().getColumn(4).setPreferredWidth(200);
            detailstable.getColumnModel().getColumn(5).setPreferredWidth(200);
            detailstable.getColumnModel().getColumn(6).setPreferredWidth(200);
            detailstable.getColumnModel().getColumn(7).setPreferredWidth(200);
            detailstable.getColumnModel().getColumn(8).setPreferredWidth(200);
        }

        View.setText("View");
        View.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreparedStatement p=null;                                    
            try{
                
            String url="jdbc:mysql://admin@localhost:3306/cms";
                        String user="admin";
                        String pass="1234";
        //Class.forName("com.mysql.jdbc.Driver");  
                        String query="select * from Orders";
                        Connection con=DriverManager.getConnection(url,user,pass);  
                        p=con.prepareStatement(query);
                        ResultSet rs=p.executeQuery();
                        while(rs.next())
                        {
                            String frompin=String.valueOf(rs.getString(1));
                            String topin=String.valueOf(rs.getString(2));
                            String froma=rs.getString(3);
                            String toa=rs.getString(4);
                            String name=rs.getString(5);
                            String phn=String.valueOf(rs.getString(6));
                            String type=rs.getString(7);
                            String weight=String.valueOf(rs.getString(8));
                            String status=rs.getString(9);
                            String tbdata[]={frompin,topin,froma,toa,name,phn,type,weight,status};
                            DefaultTableModel tblmodel=(DefaultTableModel)detailstable.getModel();
                            tblmodel.addRow(tbdata);
                            
                        }
                        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f.dispose();
               new Admin(s);
            }
        });

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new Update();  
            }
        });


        heading.setBackground(new java.awt.Color(0, 102, 102));
        heading.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        heading.setText("All Orders");
        
        GroupLayout layout = new GroupLayout(f.getContentPane());
        f.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(24, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(View, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(heading, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(View, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        f.setSize(700, 500);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);

        f.pack();
    }                       
                                  
   
    // void theader()
    // {
        
    //     JTableHeader head=detailstable.getTableHeader();
    //     head.setFont(new  Font("Tahome",Font.BOLD,14));
    //     TableColumn col1=detailstable.getColumnModel().getColumn(0);
    //     col1.setPreferredWidth(200);

    //     TableColumn col2=detailstable.getColumnModel().getColumn(1);
    //     col2.setPreferredWidth(100);
    //     TableColumn col3=detailstable.getColumnModel().getColumn(2);
    //     col3.setPreferredWidth(100);
    //     TableColumn col4=detailstable.getColumnModel().getColumn(3);
    //     col4.setPreferredWidth(100);
    //     TableColumn col5=detailstable.getColumnModel().getColumn(4);
    //     col5.setPreferredWidth(100);
    //     TableColumn col6=detailstable.getColumnModel().getColumn(5);
    //     col6.setPreferredWidth(100);
    //     TableColumn col7=detailstable.getColumnModel().getColumn(6);
    //     col7.setPreferredWidth(100);
    //     TableColumn col8=detailstable.getColumnModel().getColumn(7);
    //     col8.setPreferredWidth(100);
    //     TableColumn col9=detailstable.getColumnModel().getColumn(8);
    //     col9.setPreferredWidth(100);
    // }                   


    }                                    



