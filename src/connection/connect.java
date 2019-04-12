package connection;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
public class connect{
	
	public Connection con;
    public connect()
    {	
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.
            getConnection("jdbc:oracle:thin:@localhost:1521:xe","user","password");

//            Statement stm = con.createStatement();

//            System.out.println("Created DB Connection....");
        }

        catch (ClassNotFoundException e) 
        {
        
            e.printStackTrace();

        } 

        catch (SQLException e) 
        {
          
            e.printStackTrace();
        }
    }
}
