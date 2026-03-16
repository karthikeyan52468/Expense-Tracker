package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import expenseDAO.MyConnectionDB;

public class MonthlyService {

	static int rows;
	static Connection con;
	static PreparedStatement ps;
	public static int  insert(String eName,double amount,int monthyear)
	{
		rows=0;
		
		try
		{
		con=MyConnectionDB.getConnection();
	    ps = con.prepareStatement("insert into monthly (expenseName,amount,monthyear) values(?,?,?)");
		ps.setString(1, eName);
		ps.setDouble(2, amount);
		ps.setInt(3, monthyear);
	    rows= ps.executeUpdate();
	    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				 ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		}
		return rows;
	}
}
