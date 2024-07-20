import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
public class Deposite extends JFrame implements ActionListener {
    private static final String Deposite = null;
    JTextField amount;
    JButton back,deposite;
    String pinnumber;

    Deposite(String pinnumber) {
        
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposite.");
        text.setBounds(200, 330, 700, 25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 15));
        image.add(text);

        amount = new JTextField();
        amount.setBounds(195, 360, 300, 25);
        amount.setFont(new Font("Raleway", Font.BOLD, 18));
        amount.setForeground(Color.BLACK);
        image.add(amount);

        deposite = new JButton("Deposite");
        deposite.setBounds(400, 480, 100, 20);
        deposite.setFont(new Font("Raleway", Font.BOLD, 15));
        deposite.addActionListener(this);
        image.add(deposite);

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

        if(ae.getSource() == deposite){
            String amo = amount.getText();
            Date date = new Date();
            if(amo.isEmpty()){
                JOptionPane.showMessageDialog(null, "Plese Enter The Amount.");
            }else{ 
                try{

                Connect c = new Connect();
                String query = "Insert into bank values('"+pinnumber+"','"+date+"','Deposite','"+amo+"')";          
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Rs"+amo+"Deposited Successfilly.");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);

                }catch(Exception e){

                    System.out.println(e);

                }

            }

        }else if(ae.getSource() == back){

            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposite("");
    }

}
