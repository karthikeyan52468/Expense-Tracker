package expenseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Expense {
	
	public boolean insert(int monthyear,double amount,double expense)
	{
		
		if(monthyear==0|| amount==0)
		{
			return false;
		}
		int rows=0;
		try {
			Connection con=MyConnectionDB.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into expense (monthyear,amount,expense) values(?,?,?)");
			ps.setInt(1, monthyear);
			ps.setDouble(2, amount);
			ps.setDouble(3, expense);
			rows=ps.executeUpdate();
			
			con.close();
			ps.close();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		} 
		
		return rows>0;
	}

}
