package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {
	
	private static Connection con; 
	
	public Connection getConnection() {   

		try {   
			Class.forName("net.sourceforge.jtds.jdbc.Driver");   
			con = DriverManager   
			.getConnection(   
					"jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=sorteioso;namedPipe=true",   
					"sa", "1234");   
//			System.out.println("Conexao ok");   

		} catch (ClassNotFoundException e) {   
			e.printStackTrace();   
		} catch (SQLException e) {   
			e.printStackTrace();   
		} catch (Exception e) {   
			e.printStackTrace();   
		}   

		return con;   

	}   
}