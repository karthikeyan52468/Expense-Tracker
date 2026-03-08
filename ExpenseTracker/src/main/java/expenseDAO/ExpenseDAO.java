package expenseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.ExpenseModel;

public class ExpenseDAO {

	
	static ExpenseDAO obj=null;
	
	public static ExpenseDAO getInstance()
	{
		if(obj==null)
			obj=new ExpenseDAO();
		return obj;
	}
	public ExpenseModel display(int monthyear)
	{
		ExpenseModel obj=null;
		try {
			Connection con=MyConnectionDB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from expense where monthyear=?");
			ps.setInt(1, monthyear);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
		 obj=new ExpenseModel(rs.getInt("id"), rs.getInt("monthyear"),rs.getDouble("amount"),rs.getDouble("expense"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
