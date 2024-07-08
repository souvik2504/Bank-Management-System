import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener{ 

    JButton deposite,withdrawl,fast,statement,pinchange,balance,exit;
    String pinnumber;

    Transaction(String pinnumber){

        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(235, 330, 700, 25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 15));
        image.add(text);

        deposite = new JButton("Deposite");
        deposite.setBounds(200, 423, 100, 25);
        deposite.addActionListener(this);
        image.add(deposite);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(350, 423, 150, 25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fast = new JButton("Fast Cash");
        fast.setBounds(200, 453, 100, 25);
        fast.addActionListener(this);
        image.add(fast);

        statement = new JButton("Mini Statement");
        statement.setBounds(350, 453, 150, 25);
        statement.addActionListener(this);
        image.add(statement);

        pinchange = new JButton("PIN Change");
        pinchange.setBounds(200, 483, 105, 25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance = new JButton("Balance Enquery");
        balance.setBounds(350, 483, 150, 25);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(350, 510, 150, 25);
        exit.addActionListener(this);
        image.add(exit);



        setSize(880, 800);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        

        getContentPane().setBackground(Color.BLACK);


    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==exit){
        System.exit(0);
        }else if(ae.getSource() == deposite){

            setVisible(false);
            new Deposite(pinnumber).setVisible(true);

        }else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }

    }

    public static void main(String[] args) {

        new Transaction("");
        
    }
    
}
