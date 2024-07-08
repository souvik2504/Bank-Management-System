import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SignupThree extends JFrame implements  ActionListener{

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    SignupThree(String formno) {     

        this.formno = formno;

        setLayout(null);

        JLabel l1 = new JLabel("PAGE3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(260, 40, 300, 30);
        l1.setForeground(Color.WHITE);
        add(l1);

        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 18));
        type.setBounds(100, 140, 150, 25);
        type.setForeground(Color.WHITE);
        add(type);

        r1 = new JRadioButton("Savings Account");
        r1.setBounds(300, 140, 200, 20);
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.BLACK);
        r1.setForeground(Color.white);
        add(r1);

        r2 = new JRadioButton("Fixed Deposite Account");
        r2.setBounds(500, 140, 250, 20);
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.BLACK);
        r2.setForeground(Color.white);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setBounds(300, 180, 200, 20);
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.BLACK);
        r3.setForeground(Color.white);
        add(r3);

        r4 = new JRadioButton("Recuring Deposite Account");
        r4.setBounds(500, 180, 250, 20);
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.BLACK);
        r4.setForeground(Color.white);
        add(r4);

        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(r1);
        typeGroup.add(r2);
        typeGroup.add(r3);
        typeGroup.add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 18));
        card.setBounds(100, 230, 150, 25);
        card.setForeground(Color.WHITE);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-2504");
        number.setFont(new Font("Raleway", Font.BOLD, 16));
        number.setBounds(300, 230, 200, 25);
        number.setForeground(Color.WHITE);
        add(number);

        JLabel info = new JLabel("Your 16 digit card number");
        info.setFont(new Font("Raleway", Font.BOLD, 12));
        info.setBounds(100, 250, 200, 25);
        info.setForeground(Color.DARK_GRAY);
        add(info);

        JLabel pin = new JLabel("PIN Number:");
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin.setBounds(100, 280, 150, 25);
        pin.setForeground(Color.WHITE);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 16));
        pnumber.setBounds(300, 280, 200, 25);
        pnumber.setForeground(Color.WHITE);
        add(pnumber);

        JLabel pinfo = new JLabel("Your 4 digit PIN number");
        pinfo.setFont(new Font("Raleway", Font.BOLD, 12));
        pinfo.setBounds(100, 300, 200, 25);
        pinfo.setForeground(Color.DARK_GRAY);
        add(pinfo);

        JLabel service = new JLabel("Service Required:");
        service.setFont(new Font("Raleway", Font.BOLD, 18));
        service.setBounds(100, 340, 200, 25);
        service.setForeground(Color.WHITE);
        add(service);

        c1 = new JCheckBox("ATM");
        c1.setBounds(100, 380, 100, 18);
        c1.setBackground(Color.BLACK);
        c1.setForeground(Color.WHITE);
        add(c1);

        c2 = new JCheckBox("Mobile Banking");
        c2.setBounds(300, 380, 150, 18);
        c2.setBackground(Color.BLACK);
        c2.setForeground(Color.WHITE);
        add(c2);

        c3 = new JCheckBox("Internet Banking");
        c3.setBounds(100, 410, 150, 18);
        c3.setBackground(Color.BLACK);
        c3.setForeground(Color.WHITE);
        add(c3);

        c4 = new JCheckBox("Email or SMS");
        c4.setBounds(300, 410, 100, 18);
        c4.setBackground(Color.BLACK);
        c4.setForeground(Color.WHITE);
        add(c4);

        c5 = new JCheckBox("Check Book");
        c5.setBounds(100, 440, 100, 18);
        c5.setBackground(Color.BLACK);
        c5.setForeground(Color.WHITE);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBounds(300, 440, 100, 18);
        c6.setBackground(Color.BLACK);
        c6.setForeground(Color.WHITE);
        add(c6);

        c7 = new JCheckBox("I here by declear that the above enter details are correct to the best of my knowladge.");
        c7.setBounds(100, 500, 400, 12);
        c7.setBackground(Color.BLACK);
        c7.setForeground(Color.WHITE);
        add(c7);

        submit = new JButton("Submit");
        submit.setBounds(600, 575, 100, 30);
        submit.setFont(new Font("Raleway", Font.BOLD, 20));
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(100, 575, 100, 30);
        cancel.setFont(new Font("Raleway", Font.BOLD, 20));
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.BLACK);

        setSize(850, 700);
        setLocation(300, 10);
        setVisible(true);

    }

     public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {

            String AccountType = null;

            if (r1.isSelected()) {
                AccountType = "Savings Account";
            } else if (r2.isSelected()) {
                AccountType = "Fixed Deposite Account";
            } else if (r3.isSelected()) {
                AccountType = "Current Account";
            } else if (r4.isSelected()) {
                AccountType = "Recurring Deposite Account";
            }

            Random rand = new Random();
            String cardnumber = "" + Math.abs((rand.nextLong() % 90000000L) + 1709040300000000L);

            String pinnumber = "" + Math.abs((rand.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (c1.isSelected()) {

                facility = facility + (" ATM");
            }
            if (c2.isSelected()) {

                facility = facility + (" Mobile banking");
            }
            if (c3.isSelected()) {

                facility = facility + (" Internet Banking");
            }
            if (c4.isSelected()) {

                facility = facility + (" Email or SMS");
            }
            if (c5.isSelected()) {

                facility = facility + (" Check Book");
            }
            if (c6.isSelected()) {

                facility = facility + (" E-Statement");
            }

            try {

                if (AccountType.equals("")) {

                    // JOptionPane.showMessageDialog(null, "Acocunt Type is required");
                    JOptionPane.showMessageDialog(null, "Acocunt Type is required");

                } else {

                    Connect c = new Connect();
                    System.out.print(c);
                    String query1 = "insert into signupthree values('" + formno + "','" + AccountType + "','"
                            + cardnumber + "','" + pinnumber + "','"+ facility +"')";

                    String query2 = "insert into login values('" + formno + "','"+ cardnumber + "','" + pinnumber + "')";
                    
                    c.s.executeUpdate(query2); 
                    c.s.executeUpdate(query1); 
                    JOptionPane.showMessageDialog(null," Card Number:" + cardnumber + "\n" + "PIN Number:" +pinnumber);

                }

                    setVisible(false);
                    new Deposite(pinnumber).setVisible(false);

            } catch (Exception e) {

                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {

            setVisible(false);
            new login().setVisible(true);

        }

    }

    public static void main(String[] args) {
        new SignupThree("");      
    }

  
}
