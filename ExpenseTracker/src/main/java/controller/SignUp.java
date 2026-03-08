package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import expenseDAO.RegisterUserDAO;

public class SignUp extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email =req.getParameter("email");
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
		RegisterUserDAO obj= RegisterUserDAO.getInstance();
		PrintWriter out = resp.getWriter();
		if(obj.insert(name,password,email))
		{
			
			out.print("user created");
		}
		else {
			out.print("user not created");
		}
	}

}
