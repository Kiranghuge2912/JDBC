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
class DemoFrame implements ActionListener
{
	private JFrame frame = new JFrame("Login App");
	private JLabel lbUsername = null;
	private JTextField tfUsername = null;
	private JLabel lbPassword = null;
	private JPasswordField jpPassword = null;
	private JButton jbLogin = null;
	private JButton jbCancel = null;
	private Connection Con = null;
	private PreparedStatement Ps = null;
	private ResultSet Rs = null;
	DemoFrame()
	{
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
		lbUsername = new JLabel("Username:");
		//lbUsername.setText("User Name");
		frame.add(lbUsername);
		lbUsername.setBounds(130,50,100,20);
		
		tfUsername = new JTextField();
		frame.add(tfUsername);
		tfUsername.setBounds(220,50,100,20);
		
		lbPassword = new JLabel("Password:");
		frame.add(lbPassword);
		lbPassword.setBounds(130,90,100,20);
		
		jpPassword = new JPasswordField();
		frame.add(jpPassword);
		jpPassword.setBounds(220,90,100,20);
		
		jbLogin = new JButton("LOGIN");
		frame.add(jbLogin);
		jbLogin.setBounds(140,130,80,20);
		jbLogin.addActionListener(this);
		
		jbCancel = new JButton("CANCEL");
		frame.add(jbCancel);
		jbCancel.setBounds(230,130,80,20);
		jbCancel.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == jbLogin)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kiran2","root","1234");
				if(Con != null)
				{
					String Query = "SELECT COUNT(*) FROM user where username=? and password=?";
					Ps = Con.prepareStatement(Query);
					Ps.setString(1,tfUsername.getText());
					Ps.setString(2,jpPassword.getText());
					Rs = Ps.executeQuery();
					Rs.next();
					if(Rs.getInt(1) == 1)
					{
						System.out.println("Login Successful !!!");
					}
					else
					{
						System.out.println("Login Failed !!!");
					}
				}
					
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
		else if(ae.getSource() == jbCancel)
		{
			frame.setVisible(false);
		}
	}
	
	
	class Demo extends KeyAdapter
	{
		
		
	}
	
}


class LoginApp
{
	public static void main(String args[])
	{
		DemoFrame D = new DemoFrame();
	}

}