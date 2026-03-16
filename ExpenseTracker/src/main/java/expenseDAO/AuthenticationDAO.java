package expenseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Details;
import service.AuthenticationSerice;

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
			return AuthenticationSerice.check(email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
}
