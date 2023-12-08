package JdbcConnecr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Updateop {

	public static void main(String[] args) {
		int customer_id;
		String customer_email;
		Scanner din = new Scanner(System.in);
		System.out.println("Enter Customer id");
		customer_id = din.nextInt();
		System.out.println("Enter Customer Email To change");
		customer_email = din.next();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");
			String sql="update customers set cmail='"+customer_email+"' where cid='"+customer_id+"'";
			PreparedStatement ps = con.prepareStatement(sql);
			int i = ps.executeUpdate();
			if(i==1)
			{
				System.out.println("Customer Information Updated Success");
			}
			else
			{
				System.out.println("Updation Failed");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}

