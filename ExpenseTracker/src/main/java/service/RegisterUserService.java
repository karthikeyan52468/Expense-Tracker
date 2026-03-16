package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import expenseDAO.MyConnectionDB;

public class RegisterUserService {

	static Connection con;
	static PreparedStatement ps;
	static int rows;
	
	public static  int insert(String name,String password,String email)
	{
try {
			
			rows=0;
			password=BCrypt.hashpw(password, BCrypt.gensalt());
			con = MyConnectionDB.getConnection();
			ps = con.prepareStatement("insert into details (name,password,role,email) values(?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, "user");
			ps.setString(4, email);
			rows = ps.executeUpdate();
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return 0;
		}

		finally {
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return rows;
	}
}
