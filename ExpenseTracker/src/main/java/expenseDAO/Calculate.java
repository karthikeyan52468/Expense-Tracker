package expenseDAO;

import java.lang.invoke.ConstantBootstraps;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		int len=0;
		Connection con= null;
		try{
		 con= MyConnectionDB.getConnection();
		 con.setAutoCommit(false);
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
		 ps.addBatch();
		int rows[]=ps.executeBatch();
		 con.commit();
		 len=rows.length;
		 }
	 }
	 catch(Exception e)
	 {
		 if(con!=null)
		 {
			 try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 }
		 e.printStackTrace();
	 }
	 return len>0;
	}
}
