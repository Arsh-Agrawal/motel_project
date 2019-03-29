import java.sql.*;

class Connect
{
	public static void main(String args[])
	{

		try
		{

			Class.forproject("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost: ","","")
		}

		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}