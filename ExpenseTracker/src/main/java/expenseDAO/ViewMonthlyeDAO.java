package expenseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.MonthlyModel;


public class ViewMonthlyeDAO {

 static	ViewMonthlyeDAO obj=null;
 
 public static ViewMonthlyeDAO getInstance()
 {
	 if(obj==null)
	 {
		 obj= new ViewMonthlyeDAO();
		 return obj;
	 }
	 return obj;
 }
	public ArrayList<MonthlyModel> display(int monthyear)
	{
		
		ArrayList<MonthlyModel> al = new ArrayList<MonthlyModel>();
		try {
			Connection con = MyConnectionDB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from monthly where monthyear=?");
			ps.setInt(1, monthyear);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				al.add(new MonthlyModel(rs.getInt("id"), rs.getString("expenseName"),  rs.getDouble("amount"), rs.getInt("monthyear")));
				
			}
			con.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
		
		
	}
}
