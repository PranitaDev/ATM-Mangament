package atm.simulation.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdraw  extends JFrame implements ActionListener {

	JButton withdraw,back;
	JTextField amount;
	String pin;
	Withdraw(String pin)
	{
		this.pin=pin;
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("a-atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		 add(image);
		 
		 JLabel text=new JLabel("Enter the amount you want to withdraw");
		 text.setForeground(Color.WHITE);
		 text.setFont(new Font("System",Font.BOLD,16));
		 text.setBounds(215,320,700,30);
		 image.add(text);
		 
		 amount=new JTextField();
		 amount.setForeground(Color.black);
		 amount.setFont(new Font("System",Font.BOLD,14));
		 amount.setBounds(215,370,300,30);
		 image.add(amount);
		 
		 withdraw=new JButton("withdraw");
		 withdraw.setFont(new Font("System",Font.BOLD,12));
		 withdraw.setBounds(420, 460, 120, 25);
		 withdraw.addActionListener(this);
		 image.add(withdraw);
		 
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
		if(e.getSource()== withdraw)
		{
		  String money=amount.getText();
		  Date date=new Date();
		  if(money.equals(""))
		  {
			  JOptionPane.showMessageDialog(null,"Please Enter the amount you want to withdraw");
		  }
		  else {
			  try {
			  Conn c=new Conn();
			  String query="insert into bank values('"+pin+"','"+date+"','withdraw','"+money+"')";
			  c.st.executeUpdate(query);
			  JOptionPane.showMessageDialog(null,"Rs "+money+" withdrawn sucessfully" );
			  
			  setVisible(false);
			  new Transaction(pin).setVisible(true);
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
			new Transaction(pin).setVisible(true);
		}
		
	    }
	public static void main(String[] args) {
		new Withdraw("");

	}
}