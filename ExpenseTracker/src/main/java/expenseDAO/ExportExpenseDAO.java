package expenseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.ExportModel;

public class ExportExpenseDAO {

	static ExportExpenseDAO obj;
	
	public static ExportExpenseDAO getInstance()
	{
		if(obj==null)
			obj=new ExportExpenseDAO();
		return obj;
	}
	
	public ArrayList<ExportModel> export() 
	{
		ArrayList<ExportModel> al = new ArrayList<ExportModel>();
		
		try {
			Connection con=MyConnectionDB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from expense");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				ExportModel obj= new ExportModel();
				obj.setId(rs.getInt("id"));
				obj.setMonthyear(rs.getInt("monthyear"));
				obj.setAmount(rs.getDouble("amount"));
				obj.setExpense(rs.getDouble("expense"));
				al.add(obj);
			}
			ps.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return al;
	}
	
}
