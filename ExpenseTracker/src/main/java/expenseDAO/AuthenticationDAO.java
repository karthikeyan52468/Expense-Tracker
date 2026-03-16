package expenseDAO;

import java.sql.SQLException;

import service.AuthenticationService;

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
			return AuthenticationService.check(email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
}
