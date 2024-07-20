import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{ 

    JButton deposite,withdrawl,fast,statement,pinchange,balance,exit;
    String pinnumber;

    FastCash(String pinnumber){

        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(235, 330, 700, 25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 15));
        image.add(text);

        deposite = new JButton("Rs. 100");
        deposite.setBounds(200, 423, 100, 25);
        deposite.addActionListener(this);
        image.add(deposite);
        
        withdrawl = new JButton("Rs. 500");
        withdrawl.setBounds(350, 423, 150, 25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fast = new JButton("Rs. 1000");
        fast.setBounds(200, 453, 100, 25);
        fast.addActionListener(this);
        image.add(fast);

        statement = new JButton("Rs. 2000");
        statement.setBounds(350, 453, 150, 25);
        statement.addActionListener(this);
        image.add(statement);

        pinchange = new JButton("Rs. 5000");
        pinchange.setBounds(200, 483, 105, 25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance = new JButton("Rs. 10000");
        balance.setBounds(350, 483, 150, 25);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("BACK");
        exit.setBounds(350, 510, 150, 20);
        exit.addActionListener(this);
        image.add(exit);



        setSize(880, 800);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        

        getContentPane().setBackground(Color.BLACK);


    }
    @SuppressWarnings("unlikely-arg-type")
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==exit){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else {

           String amount = ((JButton)ae.getSource()).getText().substring(4);

           Connect c = new Connect();
           try{

            ResultSet rs = c.s.executeQuery("select * from bank where PIN_Number = '"+pinnumber+"'"); 
            int balance = 0;
            while (rs.next()) {
                if(rs.getTime("Transaction_type").equals("Deposite")){
                    balance += Integer.parseInt(rs.getString("amount"));
                } else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
                
            }

            if(ae.getSource() != exit && balance <Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null, "INSUFFICIENT BALENCE");
                return;

            }

            Date date = new Date();
            String query = "insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rs" + amount + "Debited Successfully");
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
           }catch(Exception e){
            System.out.println(e);
           }
        }

    }

    public static void main(String[] args) {

        new FastCash("");
        
    }
    
}
