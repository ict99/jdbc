import java.sql.*;

public class DemoClass {
	
	public static void main(String[] args) throws Exception{
		
		String url = "jdbc:mysql://localhost:3306/newbatch";
		String username = "root";
		String pass = "12345";
		int EmpID = 3;
		String uname = "hello";
		String query = "insert into login(EmpID,uname) values (?,?)";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,username,pass);

		
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(query);
		
		
//		rs.next();
//		String name = rs.getString("uname");		
//		System.out.println(name);
		
//		String userData = "";
//		
//		while(rs.next())
//		{
//			userData = rs.getInt(1) + " : " + rs.getString(2);
//			System.out.println(userData);
//		}
		
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, EmpID);
		st.setString(2, uname);
		int count = st.executeUpdate();
		
		System.out.println(count + "row/s affected");
		
		st.close();
		con.close();
		
		
		
		
	}

}
