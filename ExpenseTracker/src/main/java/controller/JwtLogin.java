package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Jwt;
import expenseDAO.AuthenticationDAO;

public class JwtLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String email= req.getParameter("email");
		String password=req.getParameter("password");
		if(email==null || email.isEmpty()|| password== null ||password.isEmpty())
			throw new RuntimeException("Enter username or password");
		
		AuthenticationDAO obj = AuthenticationDAO.getInstance();
		if(obj.check(email, password))
		{
			Jwt jwt = Jwt.getInstance();
			String token =jwt.generate();
			PrintWriter out = resp.getWriter();
			out.print(token);
		}
		else {
			throw new RuntimeException("invalid email or password");
		}
				
	}
}
