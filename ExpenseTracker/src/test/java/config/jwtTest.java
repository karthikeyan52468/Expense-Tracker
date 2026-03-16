package config;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;

public class jwtTest {

	public static Jwt jwt;
	
	@BeforeClass
	public static void getInstanceTest()
	{
	jwt=	jwt.getInstance();
	
	}
	

	
	@Test
	public void checkJwtTest_withOutLogin()
	{
		
	
		assertNull(jwt.getToken());
	}
	
	
	@Test
	public void validateFalseTest()
	{
		assertFalse(jwt.validate("abc"));
	}
	

}
