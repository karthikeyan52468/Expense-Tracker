package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import expenseDAO.ExportExpenseDAO;

public class ExportTest {

	@Test
	public void ExportDAOTest()
	{
		ExportExpenseDAO obj = ExportExpenseDAO.getInstance();
		assertNotEquals(0,obj.export().size());
		
	}
}
