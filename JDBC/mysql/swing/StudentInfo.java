import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.io.FileInputStream;

class DemoFrame implements ActionListener
{
	private JFrame frame = null;
	private JLabel lbName = null;
	private JTextField tfName = null;
	private JLabel lbMb = null;
	private JTextField tfMb = null;
	private JLabel lbDOB = null;
	private JTextField tfDOB = null;
	private JLabel lbPhoto = null;
	private JTextField tfPhoto = null;
	
	private JButton jbSubmit = null;
	private JButton jbCancel = null;
	private Connection Con = null;
	private PreparedStatement Ps = null;
	private ResultSet Rs = null;
	
	DemoFrame()
	{
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(java.awt.Color.GREEN);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLocation(400,100);
		frame.setLayout(null);
		initComponent();
	}
	
	void initComponent()
	{
		lbName = new JLabel("Name:");
		frame.add(lbName);
		lbName.setBounds(120,50,100,20);
		
		tfName = new JTextField();
		frame.add(tfName);
		tfName.setBounds(220,50,150,20);
		
		lbMb = new JLabel("MobileNo:");
		frame.add(lbMb);
		lbMb.setBounds(120,90,100,20);
		
		tfMb = new JTextField();
		frame.add(tfMb);
		tfMb.setBounds(220,90,150,20);
		
		lbDOB = new JLabel("DateOfBirth:");
		frame.add(lbDOB);
		lbDOB.setBounds(120,130,100,20);
		
		tfDOB = new JTextField();
		frame.add(tfDOB);
		tfDOB.setBounds(220,130,150,20);
		
		lbPhoto = new JLabel("PhotoPath:");
		frame.add(lbPhoto);
		lbPhoto.setBounds(120,170,100,20);
		
		tfPhoto = new JTextField();
		frame.add(tfPhoto);
		tfPhoto.setBounds(220,170,150,20);
		
		jbSubmit = new JButton("SUBMIT");
		frame.add(jbSubmit);
		jbSubmit.setBounds(130,210,80,20);
		jbSubmit.addActionListener(this);
		
		jbCancel = new JButton("CANCEL");
		frame.add(jbCancel);
		jbCancel.setBounds(230,210,80,20);
		jbCancel.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == jbSubmit)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kiran2","root","1234");
				String Query = "INSERT INTO STUDENTINFO VALUES(?,?,?,?)";
				Ps = Con.prepareStatement(Query);
				Ps.setString(1,tfName.getText());
				Ps.setString(2,tfMb.getText());
				
				//Date
				String DOB = tfDOB.getText();
				SimpleDateFormat SDF = new SimpleDateFormat("dd/mm/yyyy");
				java.util.Date jDate = SDF.parse(DOB);		//converting into java.util.Date format from String
				long ms = jDate.getTime();
				java.sql.Date sDate = new java.sql.Date(ms);
				Ps.setDate(3,sDate);
				
				//Photo
				String path = tfPhoto.getText();
				FileInputStream fis = new FileInputStream(path);
				Ps.setBinaryStream(4,fis);
				
				int count = Ps.executeUpdate();
				if(count == 1)
				{
					System.out.println("Record Inserted !!!");
				}
				else
				{
					System.out.println("Record Not Inserted !!!");
				}
			}
			catch(Exception E)
			{
				System.out.println("Sql Exception Occured !!!");
			}
		}
		else if(ae.getSource() == jbCancel)
		{
			frame.setVisible(false);
		}
	}
}

class StudentInfo
{
	public static void main(String args[])
	{
		DemoFrame D = new DemoFrame();
	}
}