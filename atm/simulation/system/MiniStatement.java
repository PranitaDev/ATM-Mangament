package atm.simulation.system;

import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;

public class MiniStatement extends JFrame {

		JButton back;
		MiniStatement(String pinnumber)
		{
		  setTitle("Mini Statement");
		  setLayout(null);
			
		  JLabel bname=new JLabel("ICICI Bank ");
		  bname.setFont(new Font("Raleway",Font.BOLD,16));
		  bname.setBounds(150,20,200,30);
		  add(bname);
		  
		  JLabel card=new JLabel();
		  card.setBounds(20,80,300,20);
		  card.setFont(new Font("Raleway",Font.BOLD,14));
		  add(card);
		  
		  JLabel mini=new  JLabel();
		  mini.setBounds(10,50,500,300);
		  mini.setFont(new Font("Raleway",Font.BOLD,12));
		  add(mini);
		  
		try
		 {  
			Conn c=new Conn();
			ResultSet rs= c.st.executeQuery("select * from login where pin='"+pinnumber+"'");  
		    while(rs.next())
		    {
		    card.setText("Card Number : "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
		    }
		 }
		 catch(Exception e)
		 {
			  System.out.println(e);
		 }
		  
		  try
		  {
			Conn c=new Conn();
			ResultSet rs= c.st.executeQuery("select * from bank where pin='"+pinnumber+"'"); 
			while(rs.next())
			{
		    mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br>");  
			//settext override the data and gettext appends the data
		    if(rs.next()== false)
			 {
				 mini.setText("NO Transaction");
			 }
			}
			 
		  }catch(Exception e1)
		  {
			  System.out.println(e1);
		  }
			 setSize(400,600);
			 setLocation(20,20);
			 getContentPane().setBackground(Color.white);
			 setVisible(true);
		}
		
		public static void main(String[] args) {
			new MiniStatement("");
		}
	}





