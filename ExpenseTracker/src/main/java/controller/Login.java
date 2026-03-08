package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Details;
import expenseDAO.AuthenticationDAO;

public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	AuthenticationDAO obj=	AuthenticationDAO.getInstance();
	String email=req.getParameter("email");
	String password = req.getParameter("password");
	PrintWriter out = resp.getWriter();
	
	boolean check = obj.check(email, password);
	if(check)
	{
		String role = Details.getInstance().getRole();
		HttpSession session = req.getSession();
		session.setAttribute("role", role);
		out.print("you are login successfully");
	}
	else {
		out.print("invalid username or password");
	}
	
	
		
	}
}
