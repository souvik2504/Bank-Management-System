import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  

public class PinChange extends JFrame implements ActionListener{

    JButton change, back;
    JPasswordField pin, repin;
    String pinnumber;

    PinChange(String pinnumber){
        this.pinnumber = pinnumber;

         setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Change Your PIN");
        text.setBounds(280, 330, 700, 25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 15));
        image.add(text);

        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(200, 380, 500, 25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 15));
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Ralewaly", Font.BOLD, 20));
        pin.setBounds(330, 380, 150, 25);
        image.add(pin);

        JLabel repintext = new JLabel("Re-enter the PIN:");
        repintext.setBounds(200, 420, 500, 25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 15));
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Ralewaly", Font.BOLD, 20));
        repin.setBounds(330, 420, 150, 25);
        image.add(repin);

        change = new JButton("Change");
        change.setBounds(400, 480, 100, 20);
        change.setFont(new Font("Raleway", Font.BOLD, 14));
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(400, 505, 100, 20);
        back.setFont(new Font("Raleway", Font.BOLD, 15));
        back.addActionListener(this);
        image.add(back);


        getContentPane().setBackground(Color.BLACK);

        setSize(880, 800);
        setLocation(300, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try{

            String npin = pin.getText();
            String rpin = repin.getText();

                if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN dose't matched.");
                return;
                }

                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter new PIN");
                }

                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter new PIN");
                }

                Connect c = new Connect();
                String query1 = "update bank set PIN_Number = '"+rpin+"' where PIN_Number =  '"+pinnumber+"'";
                String query2 = "update login set PIN_Number = '"+rpin+"' where PIN_Number =  '"+pinnumber+"'";
                String query3 = "update signupthree set PIN_Number = '"+rpin+"' where PIN_Number =  '"+pinnumber+"'";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Updated Successfully");

                setVisible(false);
                new Transaction(rpin).setVisible(true);

        

            }catch(Exception e){
            System.out.println(e);
            }
         }else{
            setVisible(false);
            new Transaction(getName()).setVisible(true);

     }

         }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
    
}
