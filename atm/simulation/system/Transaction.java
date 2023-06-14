package atm.simulation.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Transaction extends JFrame implements ActionListener{
     String pinnumber;
	JButton deposit,withdraw,exit,pinchange,balance,ministatement,fastcash;
	 Transaction(String pinnumber)
	 {
		 this.pinnumber=pinnumber;
		 setLayout(null);
		 
		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("a-atm.jpg"));
		 Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT );
		 ImageIcon i3=new ImageIcon(i2);
		 JLabel image=new JLabel(i3);
		 image.setBounds(0,0,900,900);
		 add(image);
		 
		 JLabel text=new JLabel("Please select Your Transaction");
		 text.setForeground(Color.WHITE);
		 text.setFont(new Font("System",Font.BOLD,22));
		 text.setBounds(215,320,700,30);
		 image.add(text);
		 
		 deposit=new JButton("Deposit");
		 deposit.setBounds(210, 400, 150, 22);
		 deposit.setBackground(Color.WHITE);
		 deposit.addActionListener(this);
		 image.add(deposit);
		 
		 withdraw=new JButton("Withdraw");
		 withdraw.setBounds(400, 400, 150, 22);
		 withdraw.setBackground(Color.WHITE);
		 withdraw.addActionListener(this);
		 image.add(withdraw);
		 
		 fastcash=new JButton("Fast Cash");
		 fastcash.setBounds(210, 430, 150, 22);
		 fastcash.setBackground(Color.WHITE);
		 fastcash.addActionListener(this);
		 image.add(fastcash);
		 
		 ministatement=new JButton("Mini Statement");
		 ministatement.setBounds(400, 430, 150, 22);
		 ministatement.setBackground(Color.WHITE);
		 ministatement.addActionListener(this);
		 image.add(ministatement);
		 
		 balance=new JButton("Balance Enquiry");
		 balance.setBounds(210, 460, 150, 22);
		 balance.setBackground(Color.WHITE);
		 balance.addActionListener(this);
		 image.add(balance);
		 
		 pinchange=new JButton("Pin Change");
		 pinchange.setBounds(400, 460, 150, 22);
		 pinchange.setBackground(Color.WHITE);
		 pinchange.addActionListener(this);
		 image.add(pinchange);
		 
		 exit=new JButton("Exit");
		 exit.setBounds(400, 490, 150, 22);
		 exit.setBackground(Color.WHITE);
		 exit.addActionListener(this);
		 image.add(exit);
		 
		 setSize(900,900);
		 setLocation(300,0);
		 setVisible(true);
	 }
	public static void main(String[] args) {
		new  Transaction("");

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== exit)
		{
		  System.exit(0);	
		}
		else if(e.getSource()== deposit)
		{
			setVisible(false);
		    new Deposit(pinnumber).setVisible(true);
		}
		else if(e.getSource()== withdraw)
		{
			setVisible(false);
		    new Withdraw(pinnumber).setVisible(true);
		}
		else if(e.getSource()== fastcash)
		{
			setVisible(false);
			new Fastcash(pinnumber).setVisible(true);
		}
		else if(e.getSource()== pinchange)
		{
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);
		}
		else if(e.getSource() == balance)
		{
			setVisible(false);
			new BalanaceEnquiry(pinnumber).setVisible(true);
		}
		else if(e.getSource()== ministatement)
		{
			new MiniStatement(pinnumber).setVisible(true);
		}
	}

}
