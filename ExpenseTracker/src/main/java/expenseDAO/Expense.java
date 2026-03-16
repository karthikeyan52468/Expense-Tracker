package expenseDAO;

import java.sql.SQLException;

import service.ExpenseService;

public class Expense {
	
	public boolean insert(int monthyear,double amount,double expense)
	{
		
		if(monthyear==0|| amount==0)
		{
			return false;
		}
	
			int rows=0;
		try {
			rows = ExpenseService.insert(monthyear, amount, expense);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		return rows>0;
	}

}
