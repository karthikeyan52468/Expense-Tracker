package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import expenseDAO.ViewMonthlyeDAO;

public class MonthlyViewTest {

	
	@Test
	public void getMonthlyViewTest()
	{
		ViewMonthlyeDAO obj= ViewMonthlyeDAO.getInstance();
		assertNotEquals(0,obj.display(32026).size());
	}
	
	@Test
	public void getMonthlyViewTest_failCase()
	{
		ViewMonthlyeDAO obj= ViewMonthlyeDAO.getInstance();
		assertEquals(0,obj.display(32026788).size());
	}
}
