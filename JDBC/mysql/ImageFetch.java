import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

class ImageFetch
{
	public static void main(String args[])throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Scanner Sc = new Scanner(System.in);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kiran", "root", "1234");
		
		String query = "select* from image where sid=?";
		ps = con.prepareStatement(query);
		System.out.println("Enter The Id to See Image:-");
		int sid = Sc.nextInt();
		ps.setInt(1,sid);
		rs = ps.executeQuery();
		rs.next();
		InputStream is = rs.getBinaryStream(4);						//returns Parent object 1.e InputStream obj
		FileOutputStream fos = new FileOutputStream("kiran.jpeg");
		IOUtils.copy(is,fos);										//copy method use to copy one Stream into another
		System.out.println("Image Fetched Succesfully !!!");
	}
}