package atm.simulation.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener
{
	    String pin;
    	JButton back,b1,b2,b3,b4,b5,b6;
    	Fastcash(String pin)
		{
		   this.pin=pin;
		   setLayout(null);
				 
		   ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("a-atm.jpg"));
		   Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT );
		   ImageIcon i3=new ImageIcon(i2);
		   JLabel image=new JLabel(i3);
		   image.setBounds(0,0,900,900);
		   add(image);
				 
		   JLabel text=new JLabel("Please select withdrawal amount");
		   text.setForeground(Color.WHITE);
		   text.setFont(new Font("System",Font.BOLD,22));
		   text.setBounds(215,320,700,30);
		    image.add(text);
				 
			b1=new JButton("Rs 100");
			b1.setBounds(210, 400, 150, 22);
			b1.setBackground(Color.WHITE);
			b1.addActionListener(this);
			image.add(b1);
				 
			b2=new JButton("Rs 500");
			b2.setBounds(400, 400, 150, 22);
			b2.setBackground(Color.WHITE);
			b2.addActionListener(this);
			image.add(b2);
				 
			b3=new JButton("Rs 1000");
			b3.setBounds(210, 430, 150, 22);
			b3.setBackground(Color.WHITE);
			b3.addActionListener(this);
			image.add( b3);
				 
			b4=new JButton("Rs 2000");
			b4.setBounds(400, 430, 150, 22);
			b4.setBackground(Color.WHITE);
			b4.addActionListener(this);
			image.add( b4);
				 
			b5=new JButton("Rs 5000");
			b5.setBounds(210, 460, 150, 22);
			b5.setBackground(Color.WHITE);
			b5.addActionListener(this);
			image.add(b5);
				 
			b6=new JButton("Rs 10000");
			b6.setBounds(400, 460, 150, 22);
			b6.setBackground(Color.WHITE);
			b6.addActionListener(this);
			image.add( b6);
				 
			back=new JButton("Back");
			back.setBounds(400, 490, 150, 22);
			back.setBackground(Color.WHITE);
			back.addActionListener(this);
			image.add(back);
				 
			setSize(900,900);
			setLocation(300,0);
			setVisible(true);
			
		 }
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource()== back)
			{
			  setVisible(false);
			   new Transaction(pin).setVisible(true);  
			}
		   else 
			{
			 String amount =((JButton)e.getSource()).getText().substring(3);//Rs 500
			 Conn c = new Conn();
		try
		{
		  ResultSet rs=c.st.executeQuery("select * from bank where pin ='"+pin+"'");
		  int balance=0;
		  while(rs.next())
		  {
			  if(rs.getString("type").equals("deposit"))
			  {
				  balance=Integer.parseInt(balance+rs.getString("amount"));
			  }
			  else
			  {
				  balance=Integer.parseInt(rs.getString("amount"));
			  }
		   }
		  if(e.getSource()!=back && balance<Integer.parseInt(amount))
		  {
			  JOptionPane.showMessageDialog(null,"Insuffient balance");
			  return;
		  }
		  Date date=new Date();
		  String query="insert into bank values('"+pin+"','"+date+"','withdraw','"+amount+"')";
	      c.st.executeUpdate(query);
	      JOptionPane.showMessageDialog(null,"Rs "+amount+" debited successfully");
	      
	      setVisible(false);
	      new Transaction(pin).setVisible(true);
		}
		
	  catch(Exception e1)
	   {
		System.out.println(e1);
	    }
	}	
}
	public static void main(String[] args) {
				new Fastcash("");
		}
	}