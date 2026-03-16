package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import expenseDAO.MyConnectionDB;

public class GenerateCSV {

	static GenerateCSV obj=null;
	
	public static GenerateCSV getInstance()
	{
		if(obj==null)
		{
			obj= new GenerateCSV();
			return obj;
		}
		return obj;
		
	}
	
	public void generateReport(int monthyear) 
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			BufferedWriter bw= new BufferedWriter(new FileWriter("E:\\Expense Tracker\\ExpenseTracker\\src\\resources\\report.csv"));
			con = MyConnectionDB.getConnection();
		    ps = con.prepareStatement("select * from monthly where monthyear=?");
			ps.setInt(1, monthyear);
			 rs =ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				String expenseName=rs.getString(2);
				double amount=rs.getDouble(3);
				int date=rs.getInt(4);
				bw.write(id+","+","+expenseName+","+amount+","+date);
				bw.newLine();
			}
			
			bw.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}
