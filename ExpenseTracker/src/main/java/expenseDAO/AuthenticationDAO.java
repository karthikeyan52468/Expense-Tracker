package expenseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Details;

public class AuthenticationDAO {

	static AuthenticationDAO obj=null;
	public static AuthenticationDAO getInstance()
	{
		if(obj==null)
		{
			obj=new AuthenticationDAO();
			return obj;
		}
		return obj;
	}
	public boolean check(String email,String password) 
	{
		
		try {
			Connection con=MyConnectionDB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from details where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
			Details d=	Details.getInstance();
			d.setEmail(rs.getString("email"));
			d.setName(rs.getString("name"));
			d.setPassword(rs.getString("password"));
			d.setRole(rs.getString("role"));
			return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
