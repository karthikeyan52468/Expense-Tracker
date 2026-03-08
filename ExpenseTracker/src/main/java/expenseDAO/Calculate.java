package expenseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Calculate {
	
	public static Calculate obj=null;
	
	public static Calculate getInstance()
	{
		if(obj==null)
		{
			obj=new Calculate();
			return obj;
		}
		return obj;
	}

 public boolean calculate(double amount,int monthyear)
	{
		int rows=0;
	 try {
		 Connection con= MyConnectionDB.getConnection();
		 PreparedStatement ps = con.prepareStatement("Select amount,expense from expense where monthyear =?");
		 ps.setInt(1, monthyear);
		 ResultSet rs= ps.executeQuery();
		 if(rs.next())
		 {
			 
		 
		 double newAmount=rs.getDouble("amount")-amount;
		 double newExpense=rs.getDouble("expense")+amount;
		 
		 ps=con.prepareStatement("update expense set amount=?,expense=? where monthyear=?");
		 ps.setDouble(1, newAmount);
		 ps.setDouble(2, newExpense);
		 ps.setInt(3, monthyear);
		 rows=ps.executeUpdate();
		 }
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 return rows>0;
	}
}
