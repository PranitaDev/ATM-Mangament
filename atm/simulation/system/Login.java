package atm.simulation.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener
{
	JButton login, clear, signup;
	JTextField cardTextField;
	JPasswordField pinTextField;
	Login()
	{
		setTitle("AUTOMATIC TELLER MACHINE");
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atmLogo.png"));
		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel label=new JLabel(i3);
		label.setBounds(70, 10, 100, 100);
		add(label);
		
		JLabel text=new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(200, 40, 400, 40);
		add(text);
		
		JLabel cardno=new JLabel("Card No");
		cardno.setFont(new Font("Raleway",Font.BOLD,20));
		cardno.setBounds(120, 150, 250, 30);
		add(cardno);
		
		cardTextField=new JTextField();
		cardTextField.setBounds(300, 150, 250, 30);
		cardTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(cardTextField);
		
		JLabel pin=new JLabel("PIN");
		pin.setFont(new Font("Raleway",Font.BOLD,20));
		pin.setBounds(120, 220, 250, 30);
		add(pin);
		
		pinTextField=new JPasswordField();
		pinTextField.setBounds(300, 220, 250, 30);
		pinTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(pinTextField);
		
	    login=new JButton("SIGN IN");
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		clear=new JButton("CLEAR");
		clear.setBounds(450, 300, 100, 30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signup=new JButton("SIGN UP");
		signup.setBounds(300, 350, 250, 30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(900,500);
		setVisible(true);
		setLocation(250,170);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==clear)
		{
			cardTextField.setText("");
			pinTextField.setText("");	
		}
		else if(e.getSource()==login)
		{
			Conn c=new Conn();
			String cardno=cardTextField.getText();
			String pin=pinTextField.getText();
			String query ="select * from login where cardnumber ='"+cardno+"' and pin='"+pin+"'";
			try
			{
			 ResultSet rs= c.st.executeQuery(query);
			 if(rs.next())
			 {
				 setVisible(false);
				 new Transaction(pin).setVisible(true);
				 
			 }else
			 {
				 JOptionPane.showMessageDialog(null,"Incorrect Card Number or pin");
			 }
			}catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
		else if(e.getSource()==signup)
		{
			setVisible(false);
		    new SignUp1().setVisible(true);
			
		}
		
	}

	public static void main(String[] args) 
	{
		new Login();
	}
}
