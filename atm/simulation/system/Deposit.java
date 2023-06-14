package atm.simulation.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class Deposit extends JFrame implements ActionListener {

	JButton deposit,back;
	JTextField amount;
	String pinnumber;
	Deposit(String pinnumber)
	{
		this.pinnumber=pinnumber;
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("a-atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		 
		 JLabel text=new JLabel("Enter the amount you want to deposit");
		 text.setForeground(Color.WHITE);
		 text.setFont(new Font("System",Font.BOLD,16));
		 text.setBounds(215,320,700,30);
		 image.add(text);
		 
		 amount=new JTextField();
		 amount.setForeground(Color.black);
		 amount.setFont(new Font("System",Font.BOLD,14));
		 amount.setBounds(215,370,300,30);
		 image.add(amount);
		 
		 deposit=new JButton("Deposit");
		 deposit.setFont(new Font("System",Font.BOLD,12));
		 deposit.setBounds(420, 460, 120, 25);
		 deposit.addActionListener(this);
		 image.add(deposit);
		 
		 back=new JButton("Back");
		 back.setFont(new Font("System",Font.BOLD,12));
		 back.setBounds(420,490, 120, 25);
		 back.addActionListener(this);
		 image.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== deposit)
		{
		  String money=amount.getText();
		  Date date=new Date();
		  if(money.equals(""))
		  {
		    JOptionPane.showMessageDialog(null,"Please Enter the amount you want to deposite");
		  }
		  else {
			  try {
			  Conn c=new Conn();
			  String query="insert into bank values('"+pinnumber+"','"+date+"','deposit','"+money+"')";
			  c.st.executeUpdate(query);
			  JOptionPane.showMessageDialog(null,"Rs "+money+" deposited sucessfully" );
			  
			  setVisible(false);
			  new Transaction(pinnumber).setVisible(true);
			  }
			  catch(Exception e1)
			  {
				  System.out.println(e1);
			  }
		  }
		}
		else if(e.getSource()== back)
		{
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
		
	    }
	public static void main(String[] args) {
		new Deposit("");

	}
}
