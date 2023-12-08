package JdbcConnecr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Deleteop {

	public static void main(String[] args) {
		
		int customer_id;
		Scanner din = new Scanner(System.in);
		System.out.println("Enter Customer Id To Delete");
		customer_id = din.nextInt();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");
			String sql="delete from customers where cid='"+customer_id+"'";
			PreparedStatement ps = con.prepareStatement(sql);
			int i=ps.executeUpdate();
			if(i==1)
			{
				System.out.println("Customer data deleted");
			}
			else
			{
				System.out.println("Customer data is not deleted");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}

