package dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import expenseDAO.RegisterUserDAO;

public class RegisterTest {

	
	@Test
	public void register()
	{
		
		RegisterUserDAO obj= RegisterUserDAO.getInstance();
		assertTrue(obj.insert("junit","junit","junit"));
	}
	
	@Test
	public void register_false()
	{
		
		RegisterUserDAO obj= RegisterUserDAO.getInstance();
		assertFalse(obj.insert("junit",null,"junit"));
	}
}
