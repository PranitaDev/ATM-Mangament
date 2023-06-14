package atm.simulation.system;
	import java.awt.*;
	import java.awt.event.*;
	import java.util.Random;
	import javax.swing.*;

	import com.toedter.calendar.JDateChooser;

	public class SignUp2 extends JFrame implements ActionListener
	{
		String formno;
		JComboBox category, religion, occupation, qualification,income;
		JRadioButton yes, no , eyes,eno ;
		JTextField panTextField;
		JButton next;
		
	
		SignUp2(String formno)
		{
			this.formno=formno;
			setLayout(null);
			setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
			
			JLabel additionalDetails=new JLabel("Page 2: Additional Details");
			additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
			additionalDetails.setBounds(290, 80,400,30);
			add(additionalDetails);
			
			JLabel religion1=new JLabel("Religion :");
			religion1.setFont(new Font("Raleway",Font.BOLD,19));
			religion1.setBounds(100, 140,400,30);
			add(religion1);

			String valReligion[]= {"Hindu","muslim", "sikh","christian","other"};
			religion =new JComboBox(valReligion);
			religion.setBounds(300, 140,400,30);
			religion.setBackground(Color.WHITE);
			add(religion);
			
			JLabel category1=new JLabel(" Category :");
			category1.setFont(new Font("Raleway",Font.BOLD,19));
			category1.setBounds(100,190,400,30);
			add(category1);
			
			String valcategory[]= {"General","OBC","SC","ST","other"};
			category =new JComboBox(valcategory);
			category.setBackground(Color.WHITE);
			category.setBounds(300,190,400,30);
			add(category);
			
			JLabel income1=new JLabel("Income:");
			income1.setFont(new Font("Raleway",Font.BOLD,19));
			income1.setBounds(100, 240,400,30);
			add(income1);
			
			String valIncome[]= {"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
			income =new JComboBox(valIncome);
			income.setBackground(Color.WHITE);
			income.setBounds(300,240,400,30);
			add(income);
			
			JLabel qualification1=new JLabel("Qualification:");
			qualification1.setFont(new Font("Raleway",Font.BOLD,19));
			qualification1.setBounds(100, 290,400,30);
			add(qualification1);
			
			String valqualification[]= {"10th","12th","Graduate","Post-Graduate","doctrate","other"};
			qualification =new JComboBox(valqualification);
			qualification.setBackground(Color.white);
			qualification.setBounds(300, 290,400,30);
			add(qualification);
			
			JLabel occupation1=new JLabel("Occupation :");
			occupation1.setFont(new Font("Raleway",Font.BOLD,19));
			occupation1.setBounds(100, 340,400,30);
			add(occupation1);
			
			String valoccupation[]= {"student","employeed","Un employeed","self employeed","Bussiness","other"};
			occupation =new JComboBox(valoccupation);
			occupation.setBackground(Color.white);
			occupation.setBounds(300,340,400,30);
			add(occupation);
			
			JLabel pan=new JLabel("PAN no :");
			pan.setFont(new Font("Raleway",Font.BOLD,19));
			pan.setBounds(100, 390,400,30);
			add(pan);
			
			panTextField=new JTextField();
			panTextField.setFont(new Font("Raleway",Font.BOLD,14));
			panTextField.setBounds(300,390,400,30);
			add(panTextField);
			
			JLabel citizen=new JLabel("senior citizen :");
			citizen.setFont(new Font("Raleway",Font.BOLD,19));
			citizen.setBounds(100, 440,400,30);
			add(citizen);
			
			yes=new JRadioButton("Yes");
			yes.setBounds(300,440,60,30);
			yes.setBackground(Color.white);
			add(yes);
			no=new JRadioButton("NO");
			no.setBounds(500,440,60,30);
			no.setBackground(Color.white);
			add(no);
			
			ButtonGroup citgroup=new ButtonGroup();
			citgroup.add(yes);
			citgroup.add(no);
			
			JLabel ExistingAccount=new JLabel("Exiting Account :");
			ExistingAccount.setFont(new Font("Raleway",Font.BOLD,19));
			ExistingAccount.setBounds(100, 490,400,30);
			add(ExistingAccount);
			
			eyes=new JRadioButton("Yes");
			eyes.setBounds(300,490,60,30);
			eyes.setBackground(Color.white);
			add(eyes);
			eno=new JRadioButton("NO");
			eno.setBounds(500,490,60,30);
			eno.setBackground(Color.white);
			add(eno);
			
			ButtonGroup accgroup=new ButtonGroup();
			accgroup.add(eyes);
			accgroup.add(eno);
			
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
			
			String sreligion=(String)religion.getSelectedItem();
			String scategory=(String)category.getSelectedItem();
			String sincome=(String)income.getSelectedItem();
			String squalification=(String)qualification.getSelectedItem();
			String soccupation=(String)occupation.getSelectedItem();
			
			
			String seniorcitizen=null;
		    if(yes.isSelected())
		    {
		    	seniorcitizen="YES";
		    }
		    else if(no.isSelected())
		    {
		    	seniorcitizen="NO";
		    }
		    
		    String sExistingAccount=null;
		    if(eyes.isSelected())
		    {
		    	sExistingAccount="YES";
		    }
		    else if(eno.isSelected())
		    {
		    	sExistingAccount="NO";
		    }
		    String span=panTextField.getText();
		    try
		    {
		    	Conn c=new Conn();
		    	String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+squalification+"','"+soccupation+"','"+span+"','"+seniorcitizen+"','"+sExistingAccount+"')";
		    	c.st.executeUpdate(query);
		    	//signup3 obj 
		    	setVisible(false);
		    	new SignUp3(formno).setVisible(true);
		    }
		    catch(Exception e1)
		    {
		    	System.out.println(e1);
		    }
		}
		public static void main(String[] args) {
			new SignUp2("");

		}
	}