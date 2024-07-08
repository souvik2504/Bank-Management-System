import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.sql.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panTextField, aadharTextField;
    JButton next, prev;
    JRadioButton eyes, eno, syes, sno;
    JDateChooser dateChooser;
    JComboBox religion, catagory, income, education, occupation;
    String formno;

    SignupTwo(String formno) {

        this.formno = formno;
        setLayout(null);

        setTitle("NEW APPLICATION FORM");

        JLabel aditionalDetails = new JLabel("PAGE 2: Aditional Information. ");
        aditionalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        aditionalDetails.setBounds(260, 50, 300, 30);
        aditionalDetails.setForeground(Color.white);
        add(aditionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        name.setBounds(100, 130, 100, 20);
        name.setForeground(Color.white);
        add(name);

        String relval[] = { "Hindu", "Muslim", "Sikh", "Christan", "Others" };
        religion = new JComboBox(relval);
        religion.setFont(new Font("Raleway", Font.BOLD, 16));
        religion.setBounds(300, 130, 400, 25);
        religion.setBackground(Color.WHITE);
        religion.setForeground(Color.BLACK);
        add(religion);

        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 18));
        fname.setBounds(100, 170, 200, 20);
        fname.setForeground(Color.white);
        add(fname);

        String Catagoryval[] = { "General", "SC", "ST", "OBC" };
        catagory = new JComboBox(Catagoryval);
        catagory.setFont(new Font("Raleway", Font.BOLD, 16));
        catagory.setBounds(300, 170, 400, 25);
        catagory.setBackground(Color.WHITE);
        catagory.setForeground(Color.BLACK);
        add(catagory);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        dob.setBounds(100, 210, 150, 20);
        dob.setForeground(Color.white);
        add(dob);

        String incomeval[] = { "Null", "<1,00,000", "<2,50,000", "<5,00,000", "Upto 10,00,000" };
        income = new JComboBox(incomeval);
        income.setFont(new Font("Raleway", Font.BOLD, 16));
        income.setBounds(300, 210, 400, 25);
        income.setBackground(Color.WHITE);
        income.setForeground(Color.BLACK);
        add(income);

        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(100, 250, 200, 20);
        gender.setForeground(Color.white);
        add(gender);

        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        email.setBounds(100, 275, 200, 20);
        email.setForeground(Color.white);
        add(email);

        String educationval[] = { "Under Graduated", "Graduated", "Post Garduated", "PHD", "BTech", "MTech", "Other" };
        education = new JComboBox(educationval);
        education.setFont(new Font("Raleway", Font.BOLD, 16));
        education.setBounds(300, 270, 400, 25);
        education.setBackground(Color.WHITE);
        education.setForeground(Color.BLACK);
        add(education);

        JLabel married = new JLabel("Occupation:");
        married.setFont(new Font("Raleway", Font.BOLD, 18));
        married.setBounds(100, 315, 200, 20);
        married.setForeground(Color.white);
        add(married);

        String occupationval[] = { "Salaried", "Self Employed", "Bussiness Man", "Student", "Retired", "Other" };
        occupation = new JComboBox(occupationval);
        occupation.setFont(new Font("Raleway", Font.BOLD, 16));
        occupation.setBounds(300, 315, 400, 25);
        occupation.setBackground(Color.WHITE);
        occupation.setForeground(Color.BLACK);
        add(occupation);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 18));
        pan.setBounds(100, 360, 200, 20);
        pan.setForeground(Color.white);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        panTextField.setBounds(300, 360, 400, 25);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Nuber:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 18));
        aadhar.setBounds(100, 405, 200, 20);
        aadhar.setForeground(Color.white);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        aadharTextField.setBounds(300, 405, 400, 25);
        add(aadharTextField);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 18));
        senior.setBounds(100, 450, 200, 20);
        senior.setForeground(Color.white);
        add(senior);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 450, 60, 20);
        eyes.setBackground(Color.BLACK);
        eyes.setForeground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(370, 450, 60, 20);
        eno.setBackground(Color.BLACK);
        eno.setForeground(Color.WHITE);
        add(eno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(eyes);
        seniorGroup.add(eno);
        

        JLabel exacc = new JLabel("Existing Account:");
        exacc.setFont(new Font("Raleway", Font.BOLD, 18));
        exacc.setBounds(100, 490, 200, 20);
        exacc.setForeground(Color.white);
        add(exacc);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 490, 60, 20);
        syes.setBackground(Color.BLACK);
        syes.setForeground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(370, 490, 60, 20);
        sno.setBackground(Color.BLACK);
        sno.setForeground(Color.WHITE);
        add(sno);

        ButtonGroup exaccGroup = new ButtonGroup();
        exaccGroup.add(syes);
        exaccGroup.add(sno);

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
            new SignupOne().setVisible(true);
        } else {
            String sreligion = (String) religion.getSelectedItem();
            String scatagory = (String) catagory.getSelectedItem();
            String sincome = (String) income.getSelectedItem();
            String seducation = (String) education.getSelectedItem();
            String soccupation = (String) occupation.getSelectedItem();
            String senior = null;
            if (eyes.isSelected()) {
                senior = "Yes";
            } else if (eno.isSelected()) {
                senior = "No";
            }

            String pan = panTextField.getText();
            String exacc = null;
            if (syes.isSelected()) {
                exacc = "Yes";
            } else if (sno.isSelected()) {
                exacc = "No";
            }
            String aadhar = aadharTextField.getText();

            try {
                if (pan.equals("")) {

                    JOptionPane.showMessageDialog(null, "PAN Number is required");

                } else if (aadhar.equals("")) {

                    JOptionPane.showMessageDialog(null, "Aadhar Number is required");

                } else {

                    Connect c = new Connect();
                    System.out.print(c);
                    String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scatagory
                            + "','"
                            + sincome
                            + "','" + seducation + "','" + soccupation + "','" + pan + "','" + aadhar + "','"
                            + senior + "','"
                            + exacc + "')";
                    c.s.executeUpdate(query);

                    setVisible(false);
                    new SignupThree(formno).setVisible(true);

                }
            } catch (Exception e) {

                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        new SignupTwo("");
    }

}
