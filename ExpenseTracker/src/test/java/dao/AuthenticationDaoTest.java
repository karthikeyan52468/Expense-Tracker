package dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import expenseDAO.AuthenticationDAO;

public class AuthenticationDaoTest {

	
	@Test
	public void authenticationDaoTest_check_true()
	{
		AuthenticationDAO obj= AuthenticationDAO.getInstance();
		assertTrue(obj.check("abc@gmail.com","pass"));
	}
	

	@Test
	public void authenticationDaoTest_check_false()
	{
		AuthenticationDAO obj= AuthenticationDAO.getInstance();
		assertFalse(obj.check("abc@gmail.com","PASS"));
	}
}
