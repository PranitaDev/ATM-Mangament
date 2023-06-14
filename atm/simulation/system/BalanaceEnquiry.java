package atm.simulation.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class BalanaceEnquiry extends JFrame implements ActionListener{

		String pinnumber;
		JButton back;
		BalanaceEnquiry(String pinnumber)
		{
			this.pinnumber=pinnumber;
			setLayout(null);
			 
			 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("a-atm.jpg"));
			 Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT );
			 ImageIcon i3=new ImageIcon(i2);
			 JLabel image=new JLabel(i3);
			 image.setBounds(0,0,900,900);
			 add(image);
			  
			 back=new JButton("BACK");
			 back.setBounds(430,480,100, 30);
			 back.setBackground(Color.white);
			 back.setForeground(Color.black);
			 back.addActionListener(this);
			 image.add(back);
			 
		 Conn c = new Conn();
		 int balance=0;
		  try
		  {
			ResultSet rs=c.st.executeQuery("select * from bank where pin ='"+pinnumber+"'");
			
			while(rs.next())
			{
			  if(rs.getString("type").equals("Deposit"))
			   {
				balance=Integer.parseInt(balance + rs.getString("amount"));
			   }
			 else
			   {
				 balance=Integer.parseInt(rs.getString("amount"));//withdraw
			   }
			} 
		 }
		  catch(Exception e1)
		  {
			  System.out.println(e1);
		  }
		  
		  JLabel text=new JLabel("Your current balance is Rs "+balance);
		  text.setForeground(Color.WHITE);
		  text.setFont(new Font("Raleway",Font.BOLD,19));
		  text.setBounds(240, 340, 400, 30);
		  image.add(text);
			 
			 setSize(900,900);
			 setLocation(300,0);
			 setVisible(true);
			 setUndecorated(true);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) //as only one button no need if
		{
		    	setVisible(false);
		    	new Transaction(pinnumber).setVisible(true);
		}
		public static void main(String[] args) {
			new BalanaceEnquiry("").setVisible(true);;

		}
	}


