import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.sql.*;

public class SignupOne extends JFrame implements ActionListener {

    long Random;
    JTextField nameTextField, fnameTextField, dobTextField, emailTextField, addressTextField, cityTextField,
            stateTextField, pinTextField;
    JButton next, prev;
    JRadioButton male, female, oth, yes, no;
    JDateChooser dateChooser;

    SignupOne() {

        setLayout(null);

        Random ran = new Random();
        Random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO. " + Random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 50);
        formno.setForeground(Color.white);
        add(formno);

        JLabel prsonalDetails = new JLabel("PAGE 1: Personal Information. ");
        prsonalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        prsonalDetails.setBounds(260, 80, 300, 30);
        prsonalDetails.setForeground(Color.white);
        add(prsonalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        name.setBounds(100, 130, 100, 20);
        name.setForeground(Color.white);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        nameTextField.setBounds(300, 130, 400, 20);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 18));
        fname.setBounds(100, 170, 200, 20);
        fname.setForeground(Color.white);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        fnameTextField.setBounds(300, 170, 400, 20);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        dob.setBounds(100, 210, 150, 20);
        dob.setForeground(Color.white);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 210, 200, 20);
        dateChooser.setForeground(new Color(105, 150, 105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(100, 250, 200, 20);
        gender.setForeground(Color.white);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 250, 60, 20);
        male.setBackground(Color.BLACK);
        male.setForeground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 250, 80, 20);
        female.setBackground(Color.BLACK);
        female.setForeground(Color.WHITE);
        add(female);

        oth = new JRadioButton("Others");
        oth.setBounds(500, 250, 80, 20);
        oth.setBackground(Color.BLACK);
        oth.setForeground(Color.WHITE);
        add(oth);

        ButtonGroup gendeGroup = new ButtonGroup();
        gendeGroup.add(male);
        gendeGroup.add(female);
        gendeGroup.add(oth);

        JLabel email = new JLabel("Email - Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        email.setBounds(100, 290, 200, 20);
        email.setForeground(Color.white);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        emailTextField.setBounds(300, 290, 400, 20);
        add(emailTextField);

        JLabel married = new JLabel("Maretial Status:");
        married.setFont(new Font("Raleway", Font.BOLD, 18));
        married.setBounds(100, 330, 200, 20);
        married.setForeground(Color.white);
        add(married);

        yes = new JRadioButton("Yes");
        yes.setBounds(300, 330, 60, 20);
        yes.setBackground(Color.BLACK);
        yes.setForeground(Color.WHITE);
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(370, 330, 60, 20);
        no.setBackground(Color.BLACK);
        no.setForeground(Color.WHITE);
        add(no);

        ButtonGroup marriedGroup = new ButtonGroup();
        marriedGroup.add(yes);
        marriedGroup.add(no);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        address.setBounds(100, 370, 200, 20);
        address.setForeground(Color.white);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        addressTextField.setBounds(300, 370, 400, 20);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setBounds(100, 410, 200, 20);
        city.setForeground(Color.white);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        cityTextField.setBounds(300, 410, 400, 20);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        state.setBounds(100, 450, 200, 20);
        state.setForeground(Color.white);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        stateTextField.setBounds(300, 450, 400, 20);
        add(stateTextField);

        JLabel pin = new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds(100, 490, 200, 20);
        pin.setForeground(Color.white);
        add(pin);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        pinTextField.setBounds(300, 490, 400, 20);
        add(pinTextField);

        JButton next = new JButton("Next");
        next.setBounds(600, 550, 100, 40);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setBackground(Color.DARK_GRAY);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        prev = new JButton("Back");
        prev.setBounds(100, 550, 100, 40);
        prev.setFont(new Font("Raleway", Font.BOLD, 20));
        prev.setBackground(Color.DARK_GRAY);
        prev.setForeground(Color.WHITE);
        prev.addActionListener(this);
        add(prev);

        getContentPane().setBackground(Color.BLACK);

        setSize(850, 700);
        setLocation(300, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == prev) {

            setVisible(false);
            new login().setVisible(true);
        }

        // } else if(ae.getSource() == next){

        // setVisible(false);
        // new SignupTwo().setVisible(true);}

        else {
            String formno = "" + Random;
            String name = nameTextField.getText();
            String fname = fnameTextField.getText();
            String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String gender = null;
            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            } else if (oth.isSelected()) {
                gender = "Others";
            }

            String email = emailTextField.getText();
            String married = null;
            if (yes.isSelected()) {
                married = "yes";
            } else if (no.isSelected()) {
                married = "No";
            }
            String address = addressTextField.getText();
            String city = cityTextField.getText();
            String state = stateTextField.getText();
            String pin = pinTextField.getText();

            try {
                if (name.equals("")) {

                    JOptionPane.showMessageDialog(null, "name is required");

                } else if (dob.equals("")) {

                    JOptionPane.showMessageDialog(null, "Date of Birth is required");

                } else if (address.equals("")) {

                    JOptionPane.showMessageDialog(null, "Address is required");

                } else if (pin.equals("")) {

                    JOptionPane.showMessageDialog(null, "Pin Code is required");

                } else {

                    Connect c = new Connect();
                    System.out.print(c);
                    String query = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob
                            + "','" + gender + "','" + email + "','" + married + "','" + address + "','" + city + "','"
                            + state + "','" + pin + "')";
                    c.s.executeUpdate(query);

                    setVisible(false);
                    new SignupTwo(formno).setVisible(true);

                }
            } catch (Exception e) {

                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        new SignupOne();
    }

}
