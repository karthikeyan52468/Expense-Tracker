package expenseDAO;

import service.RegisterUserService;

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
		if(name==null || password==null || email==null)
		{
			return false;
		}
		int rows =RegisterUserService.insert(name, password, email);
		
		
		return rows>0;
	}
}
