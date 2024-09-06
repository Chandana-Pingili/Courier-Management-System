import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
public class Order{
    JFrame o;
    JButton e,p,c;
    JLabel origin,destination,w,con,from,to,m,sender,receiver,sname,sphn,status;
    JTextField ot,dt,wt,ft,tt,st,snt,sphnt;
    Order(String s)
    { 
        PlaceOrder(s);
    }
    public void PlaceOrder(String s)
    {
        o=new JFrame(" Place Order here");

        m =new JLabel("Courier Management System");
        m.setFont(new Font("Times New Roman",Font.PLAIN,32 ));
        m.setBounds(100,20,500,50);

        sender=new JLabel("Sender");
        sender.setBounds(200,40,150,100);

        receiver=new JLabel("Receiver");
        receiver.setBounds(500,40,150,100);


        origin=new JLabel("pincode(from)");
        origin.setBounds(75,70,150,100);

        destination=new JLabel("pincode(to)");
        destination.setBounds(380,70,150,100);

        from=new JLabel("Address(from)");
        from.setBounds(75,100,150,100);
        

        to=new JLabel("Address(to)");
        to.setBounds(380,100,100,100);

        sname=new JLabel("sender name");
        sname.setBounds(75,130,150,100);

        sphn=new JLabel("Phone number");
        sphn.setBounds(75,160,150,100);

        con=new JLabel("Type of Object");
        con.setBounds(75, 190, 150, 100);

        w=new JLabel("Weight");
        w.setBounds(75,220,150,100);

        status=new JLabel("Status");
        status.setBounds(75, 250, 150, 100);
    
        ot=new JTextField();
        ot.setBounds(200,110,150,20);
        
        ft=new JTextField();
        ft.setBounds(200,140,150,20);


        dt=new JTextField();
        dt.setBounds(450,110,150,20);

        tt=new JTextField();
        tt.setBounds(450,140,150,20);

        snt=new JTextField();
        snt.setBounds(200, 170, 150, 20);


        sphnt=new JTextField();
        sphnt.setBounds(200,200,150,20);

        wt=new JTextField();
        wt.setBounds(200,260,150,20);

        String[] items = {"Clothing", "Documents", "Electronics", "Food","Furniture"};
        JComboBox<String> comboBox = new JComboBox<>(items);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> source = (JComboBox<String>) e.getSource();
                String selected = (String) source.getSelectedItem();
                System.out.println("Selected item: " + selected);
            }
        });
        comboBox.setBounds(200,230,100,20);

        String[] statuslist = {"pending", "in_transit", "Delivered"};
        JComboBox<String> comboBox2 = new JComboBox<>(statuslist);

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> source2 = (JComboBox<String>) e.getSource();
                String selected2 = (String) source2.getSelectedItem();
                System.out.println("Selected item: " + selected2);
            }
        });
        comboBox2.setBounds(200,290,100,20);

        

        e=new JButton("Exit");
        e.setBounds(100,350,75,20);
        e.setBackground(Color.YELLOW);
        e.setForeground(Color.BLACK);
        e.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
               new Admin(s);


                
            }
        });
        p=new JButton("Confirm");
        p.setBounds(180,350,90,20);
        p.setBackground(Color.YELLOW);
        p.setForeground(Color.BLACK);
        p.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
              PreparedStatement ps=null;
              {
                try {
                    String url="jdbc:mysql://localhost:3306/cms";
                    String user="admin";
                    String pass="1234";
                    Connection con = DriverManager.getConnection(url,user,pass);
                    String query="insert into Orders values(?,?,?,?,?,?,?,?,?)";
                    ps=con.prepareStatement(query);
                    ps.setInt(1,Integer.parseInt(ot.getText()));
                    ps.setInt(2,Integer.parseInt(dt.getText()));
                    ps.setString(3,ft.getText() );
                    ps.setString(4,tt.getText ());
                    ps.setString(5,snt.getText() );
                    ps.setLong(6,Long.parseLong(sphnt.getText()));
                    ps.setString(7, (String)comboBox.getSelectedItem());
                    ps.setInt(8, Integer.parseInt(wt.getText()));
                    ps.setString(9, (String)comboBox2.getSelectedItem());

                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "New Order Added Successfully","Order Success",JOptionPane.INFORMATION_MESSAGE);

                    ot.setText("");
                    ft.setText("");

                    dt.setText("");
                    tt.setText("");

                    wt.setText("");
                    snt.setText("");
                
                    sphnt.setText("");


                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
              }
                
            }
            
        });
        c=new JButton("Clear");
        c.setBounds(275,350,75,20);
        c.setBackground(Color.YELLOW);
        c.setForeground(Color.BLACK);
        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ot.setText("");
                ft.setText("");

                dt.setText("");
                tt.setText("");

                wt.setText("");
                snt.setText("");
                
                sphnt.setText("");

            }
        });

        
        

        // String[] weights = {"kg","gm"};
        // JComboBox<String> comboBox2 = new JComboBox<>(weights);

        // comboBox2.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         JComboBox<String> source = (JComboBox<String>) e.getSource();
        //         String selected = (String) source.getSelectedItem();
        //         System.out.println("Selected item: " + selected);
        //     }
        // });
        // comboBox2.setBounds(360,200,40,18);
        // o.add(comboBox2);
        
        
        
        
        o.add(sender);
        o.add(receiver);
        o.add(m);
        o.add(origin);
        o.add(destination);
        o.add(from);
        o.add(to);
        o.add(sname);
        o.add(sphn);
        o.add(con);
        o.add(w);
        o.add(status);
        
        
        o.add(ot);
        o.add(ft);
        o.add(dt);
        o.add(tt);
        o.add(snt);
        o.add(sphnt);
        o.add(wt);

        o.add(comboBox);
        o.add(comboBox2);
        o.add(e);
        o.add(p);
        o.add(c);
        

        
      

        o.setLayout(null);
        o.setVisible(true);
        o.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        o.setSize(700,500);
        o.setLocationRelativeTo(null);


    }
}

