import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class login extends JFrame implements ActionListener {

    JButton login, clear, sign;
    JTextField cardTextField;
    JPasswordField pinTextField;

    login() {

        setTitle("ATM");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(110, 30, 50, 50);
        add(label);

        JLabel text = new JLabel("WELCOMEE TO 24/7 ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 500, 40);
        add(text);

        JLabel card = new JLabel("CARD No:");
        card.setFont(new Font("Raleway", Font.BOLD, 28));
        card.setBounds(120, 150, 400, 40);
        add(card);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 40);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 16));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 400, 40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 250, 40);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 16));
        add(pinTextField);

        login = new JButton("LOGIN");
        login.setBounds(300, 300, 100, 40);
        login.setForeground(Color.WHITE);
        login.setBackground(Color.DARK_GRAY);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(450, 300, 100, 40);
        clear.setForeground(Color.WHITE);
        clear.setBackground(Color.DARK_GRAY);
        clear.addActionListener(this);
        add(clear);

        sign = new JButton("SIGN UP");
        sign.setBounds(300, 360, 250, 40);
        sign.setForeground(Color.WHITE);
        sign.setBackground(Color.DARK_GRAY);
        sign.addActionListener(this);
        add(sign);

        getContentPane().setBackground(Color.BLACK);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == login) {

            Connect c = new Connect();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * From login where Card_Number = '" + cardnumber + "'and PIN_Number = '" + pinnumber
                    + "'";

            try {

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Enter valid card number or pin");
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == clear) {

            cardTextField.setText("");
            pinTextField.setText("");

        } else if (ae.getSource() == sign) {

            setVisible(false);
            new SignupOne().setVisible(true);

        }

    }

    public static void main(String[] args) {

        new login();
    }
}
