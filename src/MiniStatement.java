import java.awt.Color;
import java.sql.ResultSet;
import java.util.jar.JarEntry;

import javax.swing.*;

public class MiniStatement extends JFrame{

    MiniStatement(String pinnumber){

        setTitle("Mini Statement");

        setLayout(null);

        JLabel text = new JLabel();
        add(text);

        JLabel bank = new JLabel("State Bank Of India");
        bank.setBounds(130, 20, 150, 20);
        bank.setForeground(Color.WHITE);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(30,80,200,20);
        card.setForeground(Color.white);
        add(card);

        JLabel mini = new JLabel();
        mini.setBounds(30, 110, 400, 30);
        mini.setForeground(Color.white);
        add(mini);

        JLabel balance = new JLabel();
        balance.setBounds(30, 200, 100,20);
        add(balance);

        try{
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from login where PIN_Number  = '"+pinnumber+"'");
            while (rs.next()) {

                card.setText("Card Number: "+rs.getString("Card_Number").substring(0, 4)+ "XXXXXXXX" + rs.getString("Card_Number").substring(12));
                
            }
        }catch(Exception e){
            System.out.println(e);
        }

        try{

            Connect c = new Connect();
            int bal = 0;
            ResultSet rs = c.s.executeQuery("Select * from bank where PIN_Number = '"+pinnumber+"'");
            while(rs.next()){

                mini.setText(mini.getText() + "<html>" + rs.getString("Date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +  rs.getString("Transaction_Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Amount") + "<br><br><html>");
           
                if(rs.getTime("Transaction_type").equals("Deposite")){

                    bal += Integer.parseInt(rs.getString("amount"));
            } else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Rs. "+ bal);

        }catch(Exception e){
            System.out.println(e);
        }

        setSize(400,600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);

    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
