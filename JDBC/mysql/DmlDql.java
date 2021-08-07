import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;

class DmlDql
{
	public static void main(String args[])throws Exception
	{
		int choice,count;
		String query = "";
		String dbname = "";
		String tname = "";
		int sid;
		String sname = "";
		float sper;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		Statement St = null;
		ResultSet Rs = null;
		Scanner Sc = new Scanner(System.in);
		do
		{
			System.out.println("Enter the choice:-");
			System.out.print("1.Create Database & Create Table\n2.Insert Record\n3.Delete Record\n4.Display Record\n5.Update Record\n6.Search Record\n0.Exit\n\n=>");
			choice = Sc.nextInt();
			
			switch(choice)
			{
				case 1:
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","1234");
					St = con.createStatement();
					if(con == null)
					{
						System.out.println("Connection Not Established !!!");
					}
					else
					{
						System.out.println("Enter The DataBase Name:-");
						dbname = Sc.next();
						query = "CREATE DATABASE "+dbname;
						count = St.executeUpdate(query);
						if(count > 0)
						{
							System.out.println("DataBase Created Succesfully !!!");
							query = "USE "+dbname;
							St.executeUpdate(query);
							System.out.println("DataBase Changed !!!");
							
							System.out.println("Enter Table Name:-");
							tname = Sc.next();
							query = "CREATE TABLE "+tname+"(sid int primary key, sname varchar(20), sper float)";
							St.executeUpdate(query);
							System.out.println("Table Created Succesfully !!!\n");
						}
						
					}
					break;
				case 2:
					System.out.println("Enter The Student Information::");
					System.out.println("Enter The Id:-");
					sid = Sc.nextInt();
					System.out.println("Enter The Name:-");
					sname = Sc.next();
					System.out.println("Enter The Percentage:-");
					sper = Sc.nextFloat();
					
					query = "INSERT INTO "+tname+" VALUES("+sid+", '"+sname+"', "+sper+")";
					count = St.executeUpdate(query);
					if(count > 0)
					{
						System.out.println("Record Inserted Succesfully !!!\n");
					}
					else
					{
						System.out.println("Record Not Inserted !!!\n");
					}
					break;
				case 3:
					System.out.println("Enter The Id To Delete Record:-");
					sid = Sc.nextInt();
					query = "DELETE FROM "+tname+" WHERE sid="+sid;
					count = St.executeUpdate(query);
					if(count > 0)
					{
						System.out.println("Record Deleted Succesfully !!!\n");
					}
					else
					{
						System.out.println("Record Not Deleted !!!\n");
					}
					break;
				case 4:
					query = "SELECT* FROM "+tname;
					Rs = St.executeQuery(query);
					while(Rs.next() != false)
					{
						System.out.println(Rs.getInt(1)+"  "+Rs.getString(2)+"  "+Rs.getFloat(3));
					}
					System.out.println("\n");
					break;
				case 5:
					System.out.println("Enter The Student Id Whose Name You Want To Change::");
					System.out.println("Enter The Id:-");
					sid = Sc.nextInt();
					System.out.println("Enter The Name:-");
					sname = Sc.next();
					query = "UPDATE "+tname+" SET sname='"+sname+"' WHERE sid="+sid;
					count = St.executeUpdate(query);
					if(count > 0)
					{
						System.out.println("Record Updated Succesfully !!!\n");
					}
					else
					{
						System.out.println("Record Not Updated !!!\n");
					}
					break;
				case 6:
					System.out.println("Enter Student id to search:-");
					sid = Sc.nextInt();
					query = "SELECT* FROM studentinfo WHERE sid="+sid;
					Rs = St.executeQuery(query);
					if(Rs.next())
					{
						System.out.println("Recoed Found !!!");
						System.out.println(Rs.getInt(1)+" "+Rs.getString(2)+" "+Rs.getFloat(3)+"\n");
					}
					else
					{
						System.out.println("Recoed Not Found !!!\n");
					}
				case 0:
					break;
			}
			
		}while(choice!=0);
		
		
	}
}