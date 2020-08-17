import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestJDBC {
	public static void main(String args[]){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","accolite123");  
			
			//here patient is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from patient order by P_ID Limit 5"); 
			System.out.println("P_ID \tP_ADDRESS \tP_NAME");
			while(rs.next())  
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));  
			con.close();  
		}catch(Exception e){ 
				System.out.println(e);
			}  
	}
}
