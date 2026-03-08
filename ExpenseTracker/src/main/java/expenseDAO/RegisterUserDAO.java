package expenseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Details;

public class RegisterUserDAO {

	static RegisterUserDAO obj=null;
	
	public static RegisterUserDAO getInstance()
	{
		if(obj==null)
			obj=new RegisterUserDAO();
		return obj;
	}
	
	public boolean insert(String name,String password,String email)
	{
		int rows =0;
		try {
			
			Connection con = MyConnectionDB.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into details (name,password,role,email) values(?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, "user");
			ps.setString(4, "email");
			rows = ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows>0;
	}
}
