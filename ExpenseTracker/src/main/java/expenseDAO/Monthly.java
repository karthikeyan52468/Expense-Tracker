package expenseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import service.MonthlyService;

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
		
		
		int rows=MonthlyService.insert(eName, amount, monthyear);
		return rows>0;
	}
}
