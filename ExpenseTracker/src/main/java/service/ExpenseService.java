package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import expenseDAO.MyConnectionDB;

public class ExpenseService {

	static int rows;
	static Connection con;
	static PreparedStatement ps;
	public static int insert(int monthyear,double amount,double expense) throws SQLException
	{
		rows=0;
		try {
			con=MyConnectionDB.getConnection();
			ps = con.prepareStatement("insert into expense (monthyear,amount,expense) values(?,?,?)");
			ps.setInt(1, monthyear);
			ps.setDouble(2, amount);
			ps.setDouble(3, expense);
			rows=ps.executeUpdate();
			
	
		
		} catch (SQLException e) {
		
			return rows;
		} 
		finally {
			con.close();
			ps.close();
		}
		return rows;
	}
}
