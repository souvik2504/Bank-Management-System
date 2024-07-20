import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


 public class BalanceEnquiry extends JFrame implements ActionListener{

    JButton back;
    String pinnumber;

    @SuppressWarnings("unlikely-arg-type")
    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        
        back = new JButton("BACK");
        back.setBounds(400, 500, 100, 30);
        back.addActionListener(this);
        image.add(back);

        Connect c = new Connect();
        int balance = 0;
        try {

            ResultSet rs = c.s.executeQuery("select * from bank where PIN_Number = '" + pinnumber + "'");

            while (rs.next()) {
                if (rs.getTime("Transaction_type").equals("Deposite")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Current Account Balance is Rs. "+balance);
        text.setBounds(200, 330, 700, 25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 15));
        image.add(text);

        
        setSize(880, 800);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        

        getContentPane().setBackground(Color.BLACK);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }



    public class StringToTimestampExampleOne { 


    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
       
    }
    
}
