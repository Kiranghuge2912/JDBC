import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
class Demo1
{
	public static void main(String args[])throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = null;
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kiran","root","1234");
		if(con == null)
		{
			System.out.println("Connection Not Established");
		}
		else
		{
		System.out.println("Connection Established");
		Statement st = con.createStatement();
		String Query;
		Query = "SELECT* FROM STUDENTINFO";
		ResultSet rs = st.executeQuery(Query);
		while(rs.next()!=false)
		{
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
		
		System.out.println();
		
		Query = "INSERT INTO studentinfo VALUES(6, 'VAIBHAV GHULE', 26)";
		st.executeUpdate(Query);
		
		Query = "SELECT* FROM STUDENTINFO";
		rs = st.executeQuery(Query);
		
		while(rs.next()!=false)
		{
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
		
		}
	}
}