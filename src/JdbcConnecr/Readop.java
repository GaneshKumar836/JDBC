package JdbcConnecr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Readop{

	public static void main(String[] args) {
		
		int customer_id;
		String customer_name;
		String customer_email;
		String customer_mobile;
		String customer_address;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");
			String query="select * from customers";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query); // table contains data 
			while(rs.next()) // false
			{
				customer_id = rs.getInt(1);
				customer_name = rs.getString(2);
				customer_email = rs.getString(3);
				customer_mobile = rs.getString(4);
				customer_address = rs.getString(5);
				System.out.println(customer_id+"\t"+customer_name+"\t"+customer_email+"\t"+customer_mobile+"\t"+customer_address);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Program End");
		}

	}

}
