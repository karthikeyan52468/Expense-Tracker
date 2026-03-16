package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import Model.Details;
import expenseDAO.MyConnectionDB;

public class AuthenticationService {

	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;
	
	public static boolean check(String email,String password) throws SQLException {
		
		try {
			 con=MyConnectionDB.getConnection();
			 ps = con.prepareStatement("select * from details where BINARY  email=?");
			ps.setString(1, email);
			
		  rs= ps.executeQuery();
			if(rs.next())
			{
				if(BCrypt.checkpw(password,rs.getString("password")))
				{
					Details d=	Details.getInstance();
					d.setEmail(rs.getString("email"));
					d.setName(rs.getString("name"));
					d.setPassword(rs.getString("password"));
					d.setRole(rs.getString("role"));
				
					return true;
				}
		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		return false;
		}
		finally {
			ps.close();
			rs.close();
			con.close();
		}
		return false;
	}
}
