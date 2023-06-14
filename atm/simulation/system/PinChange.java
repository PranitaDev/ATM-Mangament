package atm.simulation.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class PinChange extends JFrame implements ActionListener{

	String pinnumber;
	JButton back,change;
	JPasswordField pin,repin;
	PinChange(String pinnumber)
	{
		this.pinnumber=pinnumber;
		setLayout(null);
		 
		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("a-atm.jpg"));
		 Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT );
		 ImageIcon i3=new ImageIcon(i2);
		 JLabel image=new JLabel(i3);
		 image.setBounds(0,0,900,900);
		 add(image);
		 
		 JLabel text=new JLabel("CHANGE YOUR PIN");
		 text.setForeground(Color.white);
		 text.setFont(new Font("System",Font.BOLD,18));
		 text.setBounds(280, 320, 500, 25);
		 image.add(text);
		 
		 JLabel pintext=new JLabel("New PIN");
		 pintext.setForeground(Color.white);
		 pintext.setFont(new Font("System",Font.BOLD,16));
		 pintext.setBounds(250, 370, 100, 25);
		 image.add(pintext);
		 
		 pin=new JPasswordField();
		 pin.setForeground(Color.white);
		 pin.setFont(new Font("Raleway",Font.BOLD,16));
		 pin.setBounds(400, 370, 100, 25);
		 image.add(pin);
		 
		 
		 JLabel repintext=new JLabel("Re Enter New PIN");
		 repintext.setForeground(Color.white);
		 repintext.setFont(new Font("System",Font.BOLD,16));
		 repintext.setBounds(250, 400, 500, 25);
		 image.add(repintext);
		 
		 repin=new JPasswordField();
		 repin.setBackground(Color.white);
		 repin.setFont(new Font("Raleway",Font.BOLD,16));
		 repin.setBounds(400, 400, 100, 25);
		 image.add(repin);
		 
		 change=new JButton("CHANGE");
		 change.setBounds(270, 450,100, 30);
		 change.setBackground(Color.white);
		 change.setForeground(Color.black);
		 change.addActionListener(this);
		 image.add(change);
		 
		 back=new JButton("BACK");
		 back.setBounds(390, 450,100, 30);
		 back.setBackground(Color.white);
		 back.setForeground(Color.black);
		 back.addActionListener(this);
		 image.add(back);
		 
		 setSize(900,900);
		 setLocation(300,0);
		 setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    if(e.getSource()== change)
	    {
	    	try
	    	{
				String npin= pin.getText();
				String rpin=repin.getText();
				
				  if(!npin.equals(rpin))
				  {
					JOptionPane.showMessageDialog(null, "Entered pin does not matched");
					return;
				  }
				  if(npin.equals(""))
				  {
						JOptionPane.showMessageDialog(null, "Please Enter new pin");
						return;
				  }
				  if(rpin.equals(""))
				  {
						JOptionPane.showMessageDialog(null, "Please re Enter new pin");
						return;
				  }
				  
				  Conn c=new Conn();
				  //as pin is in bank, signupthree and login
				  String query1="update bank set pin ='"+rpin+"' where pin='"+pinnumber+"'";
				  String query2="update login set pin ='"+rpin+"' where pin='"+pinnumber+"'";
				  String query3="update signupthree set pin ='"+rpin+"' where pin='"+pinnumber+"'";
				  
				  c.st.executeUpdate(query1);
				  c.st.executeUpdate(query2);
				  c.st.executeUpdate(query3);
				  
				  JOptionPane.showMessageDialog(null, "PIN changed successfully");
				  setVisible(false);
				  new Transaction(rpin).setVisible(true);
				  
	    	}
	    	catch(Exception e1)
	    	{
	    		System.out.println(e1);
	    	}
	    	
	   }
	    else if(e.getSource()== back)
	    {
			setVisible(false);
		    new Transaction(pinnumber).setVisible(true);
	     }
		
	}
	public static void main(String[] args) {
		new PinChange("").setVisible(true);;

	}
}
