package atm.simulation.system;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class SignUp1 extends JFrame implements ActionListener
{
	long random;
	JTextField nameTextField, fnameTextField,dobTextField,genTextField;
	JTextField emailTextField,addressTextField,cityTextField,stateTextField;
	JRadioButton male, female ;
	JButton next;  JDateChooser datechooser;
	
	SignUp1()
	{
		setLayout(null);
		
		Random ran=new Random();
		random=Math.abs((ran.nextLong()%9000L)+1000L);
		
		
		JLabel formno=new JLabel("APPLICATION FORM NO "+random);
		formno.setFont(new Font("Raleway",Font.BOLD,30));
		formno.setBounds(140, 20,600,40);
		add(formno);
		
		JLabel PersonalDetails=new JLabel("Page 1: Personal Details");
		PersonalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		PersonalDetails.setBounds(290, 80,400,30);
		add(PersonalDetails);
		
		JLabel name=new JLabel("Name :");
		name.setFont(new Font("Raleway",Font.BOLD,19));
		name.setBounds(100, 140,400,30);
		add(name);
		
		nameTextField=new JTextField();
		nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
		nameTextField.setBounds(300, 140,400,30);
		add(nameTextField);
	
		JLabel fname=new JLabel(" Father's Name :");
		fname.setFont(new Font("Raleway",Font.BOLD,19));
		fname.setBounds(100,190,400,30);
		add(fname);
		
		fnameTextField=new JTextField();
		fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
		fnameTextField.setBounds(300,190,400,30);
		add(fnameTextField);
		
		JLabel dob=new JLabel("Date of Birth :");
		dob.setFont(new Font("Raleway",Font.BOLD,19));
		dob.setBounds(100, 240,400,30);
		add(dob);
		
		datechooser=new JDateChooser();
		datechooser.setFont(new Font("Raleway",Font.BOLD,14));
		datechooser.setBounds(300,240,400,30);
		add(datechooser);
		
		JLabel gender=new JLabel("Gender :");
		gender.setFont(new Font("Raleway",Font.BOLD,19));
		gender.setBounds(100, 290,400,30);
		add(gender);
		
		male=new JRadioButton("Male");
		male.setBounds(300, 290,60,30);
		male.setBackground(Color.white);
		add(male);
		female=new JRadioButton("Female");
		female.setBounds(500, 290,100,30);
		female.setBackground(Color.white);
		add(female);
		
		ButtonGroup gengroup=new ButtonGroup();
		gengroup.add(male);
		gengroup.add(female);
		
		JLabel email=new JLabel("Email Address :");
		email.setFont(new Font("Raleway",Font.BOLD,19));
		email.setBounds(100, 340,400,30);
		add(email);
		
		emailTextField=new JTextField();
		emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
		emailTextField.setBounds(300,340,400,30);
		add(emailTextField);
		
		JLabel address=new JLabel("Address :");
		address.setFont(new Font("Raleway",Font.BOLD,19));
		address.setBounds(100, 390,400,30);
		add(address);
		
		addressTextField=new JTextField();
		addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
		addressTextField.setBounds(300,390,400,30);
		add(addressTextField);
		
		JLabel city=new JLabel("City :");
		city.setFont(new Font("Raleway",Font.BOLD,19));
		city.setBounds(100, 440,400,30);
		add(city);
		
		cityTextField=new JTextField();
		cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
		cityTextField.setBounds(300,440,400,30);
		add(cityTextField);
		
		JLabel state=new JLabel("State :");
		state.setFont(new Font("Raleway",Font.BOLD,19));
		state.setBounds(100, 490,400,30);
		add(state);
		
		stateTextField=new JTextField();
		stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
		stateTextField.setBounds(300,490,400,30);
		add(stateTextField);
		
		next=new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setBounds(620,560,80,30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800,700);
		setVisible(true);
		setLocation(350,10);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String formno=""+random;
		String name=nameTextField.getText();
		String fname=fnameTextField.getText();
		String dob=((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
	    String gender =null;
	    if(male.isSelected())
	    {
	    	gender="male";
	    }
	    else if(female.isSelected())
	    {
	    	gender="Female";
	    }
	    
	    String email=emailTextField.getText();
	    String address=addressTextField.getText();
	    String city=cityTextField.getText();
	    String state=stateTextField.getText();
	    
	    try
	    {
	    	if(name.equals(""))
	    	{
	    	  JOptionPane.showMessageDialog(null,"Name is required");
	    	}
	    	else
	    	{
	    		Conn c=new Conn();
	    		String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+address+"','"+city+"','"+state+"')";
	    	    c.st.executeUpdate(query);
	    	    
	    	    setVisible(false);
	    	    new SignUp2(formno).setVisible(true);
	    	}
	    }
	    catch(Exception e1)
	    {
	    	System.out.println(e1);
	    }
	}
	public static void main(String[] args) {
		new SignUp1();

	}
}
