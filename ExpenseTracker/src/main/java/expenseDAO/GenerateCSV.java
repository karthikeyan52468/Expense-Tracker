package expenseDAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		try {
			BufferedWriter bw= new BufferedWriter(new FileWriter("E:\\Expense Tracker\\ExpenseTracker\\src\\resources\\report.csv"));
			Connection con = MyConnectionDB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from monthly where monthyear=?");
			ps.setInt(1, monthyear);
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				String expenseName=rs.getString(2);
				double amount=rs.getDouble(3);
				int date=rs.getInt(4);
				bw.write(id+","+","+expenseName+","+amount+","+date);
				bw.newLine();
			}
			System.out.println("done");
			bw.close();
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
