package dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import expenseDAO.Expense;

public class ExpenseTest {

	
	@Test
	public void expense_Insert_Test() {
		
		Expense obj= new Expense();
		assertNotEquals(0,obj.insert(5, 100, 50));
	}
	
	@Test
	public void expense_Insert_Test_fail() {
		
		Expense obj= new Expense();
		assertFalse(obj.insert(0, 0, 50));
	}
}
