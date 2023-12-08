package JdbcConnecr;//created jdbcConnecr user-defined package
import java.sql.*;
import java.util.Scanner;

public class Mysqlconnect //mysqlconnect is user-defined class
{

	public static void main(String[] args) { //main method of the class
	int cus_id;
	String cus_name,cus_email,cus_mobile,cus_address;//variable declaration
	Scanner sc= new Scanner(System.in);//creating scanner class object for accessing data from user when it compiles
	System.out.println("Enter the customer's id");//print statement
	cus_id = sc.nextInt();//assign value to customer id
	System.out.println("Enter Customer's Name ");//print statement
	cus_name = sc.next();//assign value to customer name
	System.out.println("Enter Customer's Email id");//print statement
	cus_email = sc.next();//assign value to customer email
	System.out.println("Enter Customer's mobile Number");//print statement
	cus_mobile = sc.next();//assign value to customer mobile number
	System.out.println("Enter CUstomer's address");//print statement
	cus_address = sc.next();//assign value to customer address
	

	try {   //try block
		Class.forName("com.mysql.cj.jdbc.Driver");//location of the driver
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart","root","root");//connection to the database by using the given database URL
		String sql = "insert into customers values(?,?,?,?,?)";//inserting data into customer table 
		PreparedStatement ps = con.prepareStatement(sql);// It is used to execute parameterized query.
		ps.setInt(1, cus_id);
		ps.setString(2, cus_name);
		ps.setString(3, cus_email);
		ps.setString(4, cus_email);
		ps.setString(5, cus_address);
		int i = ps.executeUpdate();//the executeUpdate method returns a row count
		System.out.println(i);
		if(i>0) {
			System.out.println("Customer information is stored Successfully");//print statement stored
			}
		else {
			System.out.println("Customer Information is not stored SUccesfully");//print statement for not stored
		}
	}
	catch(Exception e) {
		e.printStackTrace();// handle exceptions and errors
		
	}
	}
}