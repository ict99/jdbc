import java.sql.*;
import java.util.Scanner;

public class JdbcDao {
	
	public static void main(String[] args)
	{
		StudentDAO dao = new StudentDAO();
		Student s1 = dao.getStudent(1);
		System.out.println(s1.uname);
	}


}
class StudentDAO
{
	
	public Student getStudent(int EmpID)
	{
		try {
		    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter your Employee ID");
		    
		    String ch = myObj.nextLine(); 
			String query = "select uname from login where EmpID="+ch;
			Student s = new Student();
			s.EmpID = EmpID;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newbatch","root","12345");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			rs.next();
			String name = rs.getString(1);
			s.uname = name;
			return s;
		   }
			catch (Exception ex) {
				System.out.println(ex);
			}
			return null;
	}	
}

class Student{

	int EmpID;
	String uname;
	
	
}
