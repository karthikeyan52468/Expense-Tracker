package dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import expenseDAO.Monthly;

public class MonthTest {

	
	@Test
	public void insertTest()
	{
		Monthly obj= Monthly.getInstance();
		assertTrue(obj.insert("junit", 1000, 32026));
	}
	
	@Test
	public void insert_Test_fail()
	{
		Monthly obj= Monthly.getInstance();
		assertFalse(obj.insert("junit", 0,0));
	}
}
