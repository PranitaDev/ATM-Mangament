package atm.simulation.system;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class SignUp3 extends JFrame implements ActionListener{
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel;
	String formno;
	SignUp3(String formno)
	{
		this.formno=formno;
		setLayout(null);
		JLabel accountDetails=new JLabel("Page 3: Account Details");
		accountDetails.setFont(new Font("Raleway",Font.BOLD,22));
		accountDetails.setBounds(250,40,400,30);
		add(accountDetails);
		
		JLabel type=new JLabel("Account Type :");
		type.setFont(new Font("Raleway",Font.BOLD,19));
		type.setBounds(100,100,250,30);
		add(type);
		
		r1=new JRadioButton("SAVING ACCOUNT");
		r1.setFont(new Font("Raleway",Font.BOLD,14));
		r1.setBackground(Color.white);
		r1.setBounds(100, 130, 200, 20);
		add(r1);
		
		r2=new JRadioButton("Fixed Deposit ACCOUNT");
		r2.setFont(new Font("Raleway",Font.BOLD,14));
		r2.setBackground(Color.white);
		r2.setBounds(330, 130, 250, 20);
		add(r2);
		
		r3=new JRadioButton("CURRENT ACCOUNT");
		r3.setFont(new Font("Raleway",Font.BOLD,14));
		r3.setBackground(Color.white);
		r3.setBounds(100, 180, 200, 20);
		add(r3);
		
		r4=new JRadioButton("Recurring Deposit ACCOUNT");
		r4.setFont(new Font("Raleway",Font.BOLD,14));
		r4.setBackground(Color.white);
		r4.setBounds(330, 180, 250, 20);
		add(r4);
		
		ButtonGroup grpaccount=new ButtonGroup();
		grpaccount.add(r1);
		grpaccount.add(r2);
		grpaccount.add(r3);
		grpaccount.add(r4);
		
		JLabel card=new JLabel("Card Number :");
		card.setFont(new Font("Raleway",Font.BOLD,19));
		card.setBounds(100,220,200,30);
		add(card);
	
		JLabel number=new JLabel("XXXX XXXX XXXX 4167");
		 number.setFont(new Font("Raleway",Font.BOLD,19));
		 number.setBounds(330,220,250,30);
		add( number);
		
		JLabel carddetails=new JLabel("Your 16 Digit Card Number");
		 carddetails.setFont(new Font("Raleway",Font.BOLD,12));
		 carddetails.setBounds(100,240,250,30);
		add( carddetails);
		
		JLabel pin=new JLabel("PIN  :");
		 pin.setFont(new Font("Raleway",Font.BOLD,19));
		 pin.setBounds(100,270,200,30);
		add( pin);
	
		 JLabel pinnumber =new JLabel("XXXX");
		 pinnumber.setFont(new Font("Raleway",Font.BOLD,19));
		 pinnumber.setBounds(330,270,200,30);
		 add( pinnumber);
		
		 JLabel pindetails=new JLabel("Your 4 Digit pin Number");
		 pindetails.setFont(new Font("Raleway",Font.BOLD,12));
		 pindetails.setBounds(100,290,250,30);
		 add(pindetails);
	
		 JLabel services =new JLabel("Services Required");
		 services.setFont(new Font("Raleway",Font.BOLD,19));
		 services.setBounds(100,340,200,30);
		 add( services);
		 
		 c1=new JCheckBox("ATM Card");
		 c1.setBackground(Color.white);
		 c1.setFont(new Font("Raleway",Font.BOLD,17));
		 c1.setBounds(100,390,200,30);
		 add(c1);
		 
		 c2=new JCheckBox("Internet Banking");
		 c2.setBackground(Color.white);
		 c2.setFont(new Font("Raleway",Font.BOLD,17));
		 c2.setBounds(320,390,200,30);
		 add(c2);
		 
		 c3=new JCheckBox("Mobile Banking");
		 c3.setBackground(Color.white);
		 c3.setFont(new Font("Raleway",Font.BOLD,17));
		 c3.setBounds(100,430,200,30);
		 add(c3);
		 
		 c4=new JCheckBox("Email & SMS Alert");
		 c4.setBackground(Color.white);
		 c4.setFont(new Font("Raleway",Font.BOLD,17));
		 c4.setBounds(320,430,200,30);
		 add(c4);
		 
		 c5=new JCheckBox("Cheque Book");
		 c5.setBackground(Color.white);
		 c5.setFont(new Font("Raleway",Font.BOLD,17));
		 c5.setBounds(100,480,200,30);
		 add(c5);
		 
		 c6=new JCheckBox("E Statement");
		 c6.setBackground(Color.WHITE);
		 c6.setFont(new Font("Raleway",Font.BOLD,17));
		 c6.setBounds(320,480,200,30);
		 add(c6);
		 
		 c7=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
		 c7.setBackground(Color.WHITE);
		 c7.setFont(new Font("Raleway",Font.BOLD,14));
		 c7.setBounds(100,520,670,30);
		 add(c7);
		 
		 submit=new JButton("submit");
		 submit.setBackground(Color.BLACK);
		 submit.setForeground(Color.WHITE);
		 submit.setFont(new Font("Raleway",Font.BOLD,14));
		 submit.setBounds(280,590,100,30);
		 submit.addActionListener(this);
		 add(submit);
	
		 cancel=new JButton("cancel");
		 cancel.setBackground(Color.BLACK);
		 cancel.setForeground(Color.WHITE);
		 cancel.setFont(new Font("Raleway",Font.BOLD,14));
		 cancel.setBounds(390,590,100,30);
		 cancel.addActionListener(this);
		 add(cancel);
	
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,820);
		setLocation(300,10);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submit)
		{
			String accountType=null;
			if(r1.isSelected())
			{
				accountType ="Saving Account";
			}
			if(r2.isSelected())
			{
				accountType ="Fixed Deposit";
			}
			if(r3.isSelected())
			{
				accountType ="Current Account";
			}
			if(r4.isSelected())
			{
				accountType ="Recurring Deposit Account";
			}
			
			Random random=new Random();
			String number=""+Math.abs((random.nextLong() % 90000000L)+5040930000000000L);
		    String pin=""+Math.abs((random.nextLong()% 9000L)+1000L);
		    
		    String facility="";
		    if(c1.isSelected())
		    {
		    	facility=facility+" ATM Card";
		    }
		    else  if(c2.isSelected())
		    {
		    	facility=facility+" Internet Banking";
		    }
		    else  if(c3.isSelected())
		    {
		    	facility=facility+" Mobile Banking";
		    }
		    else  if(c4.isSelected())
		    {
		    	facility=facility+" Email & SMS alert";
		    }
		    else  if(c5.isSelected())
		    {
		    	facility=facility+" Cheque Book";
		    }
		    else if(c1.isSelected())
		    {
		    	facility=facility+" E statement";
		    }
		    
		    try 
		    {
		    	if(accountType.equals(""))
		    	{
		    		JOptionPane.showMessageDialog(null,"Account type is required");
		    	}else 
		    	{
		    		Conn c=new Conn();
		    		String query1="insert into signupthree values('"+formno+"','"+accountType+"','"+number+"','"+pin+"','"+facility+"')";
		    		String query2="insert into login values('"+formno+"','"+number+"','"+pin+"')";
		    		  c.st.executeUpdate(query1);
		    		  c.st.executeUpdate(query2);

		    	    
		    	    JOptionPane.showMessageDialog(null,"card Number "+number+"\npin "+pin);
		    	   
		    	    setVisible(false);
		    	    new Deposit(pin).setVisible(false);
		    	}
		    }
		    catch(Exception e1)
		    {
		    	System.out.println(e1);
		    }
		
		}
		else if(e.getSource() == cancel)
		{
			setVisible(false);
			new Login().setVisible(true);
		}
	}
	public static void main(String[] args) {
      new SignUp3("");
	}
}
