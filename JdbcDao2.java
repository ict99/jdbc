import java.sql.*;

public class JdbcDao2 {
	
	public static void main(String[] args)
	{
		StudDAO dao = new StudDAO();
		
		Stud s = new Stud();
		s.EmpID = 11;
		s.uname = "chetan";
		s.pass = "2456";
		dao.connect();
		dao.addStud(s);
	}


}
class StudDAO
{
	Connection con=null;
	public void connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newbatch","root","12345");
		}
		catch (Exception E) {
			System.out.println(E);
		}

	}	
	
	public Stud getStud(int EmpID)
	{
		try {
			String query = "select uname from login where EmpID="+EmpID;
			Stud s = new Stud();
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
	
	public void addStud(Stud s) {
		String query = "insert into login values (?,?,?)";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, s.EmpID);
			pst.setString(2,s.uname);
			pst.setString(3, s.pass);
			pst.executeUpdate();
		}
		catch (Exception E) {
			System.out.println(E);
		}
	}
}

class Stud{

	String pass;
	int EmpID;
	String uname;
	
}
