package config;

import java.util.Date;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.crypto.SecretKey;
import javax.management.RuntimeErrorException;

import org.apache.commons.collections4.map.HashedMap;

import Model.Details;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class Jwt {

	
	
	private static String token=null;
	private static String role =null;
	private  SecretKey key=null;
	private static Jwt obj;
	
	public static String getToken()
	{
		
		return token;
	}
	
	public static String role()
	{
		return role;
	}
	private Jwt() {
		 String secret = "mySuperSecretKeyForJWTs123456789012"; // 32+ chars
		    key = Keys.hmacShaKeyFor(secret.getBytes());
	}
	
	
	
	public static Jwt getInstance()
	{
		if(obj==null)
			obj= new Jwt();
		return obj;
	}
	public String generate()
	{
		String role=Details.getInstance().getRole();
		 return Jwts.builder()
		            .setIssuedAt(new Date(System.currentTimeMillis()))                       // iat - issued at
		            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))  // exp - 1 hour from now
		            .claim("role", role)                                                   // custom claim
		            .signWith(key)                                                         // sign with your SecretKey
		            .compact();
	}
	
	public boolean validate(String s) 
	{
	
		token=null;
		role=null;
	
		System.out.print(s);
		try {
			Claims claims=	Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(s).getBody();
			if(new Date(System.currentTimeMillis()).before(claims.getExpiration()))
			{
				
			
				token=s;
				role= claims.get("role",String.class);
				return true;
				
			}
			else {
				
				return false;
			}
		
	
	
}
		catch(Exception e)
		{
			return false;
		}
}
}

