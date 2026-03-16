package expenseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Monthly {

	static Monthly obj=null;
	
	public static Monthly getInstance()
	{
		if(obj==null)
		{
			obj=new Monthly();
			return obj;
		}
		return obj;
	}
	
	public boolean insert(String eName,double amount,int monthyear)
	{
		if(eName==null|| amount==0|| monthyear==0)
		{
			return false;
		}
		
		int rows=0;
		try
		{
		Connection con=MyConnectionDB.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into monthly (expenseName,amount,monthyear) values(?,?,?)");
		ps.setString(1, eName);
		ps.setDouble(2, amount);
		ps.setInt(3, monthyear);
	    rows= ps.executeUpdate();
	    con.close();
	    ps.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rows>0;
	}
}
