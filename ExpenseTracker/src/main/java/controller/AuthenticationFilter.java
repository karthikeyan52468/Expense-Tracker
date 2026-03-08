package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Model.Details;
import expenseDAO.AuthenticationDAO;

public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req= (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		PrintWriter out = response.getWriter();
		if(session!=null && session.getAttribute("role")!=null)
		{
			if(session.getAttribute("role").equals("admin"))
			chain.doFilter(request, response);
			
			else {
				if(req.getServletPath().equals("/viewExpense")||req.getServletPath().equals("/viewMonthly"))
				{
					chain.doFilter(request, response);
				}
				else {
					out.print("401");
				}
			}
		}
		else {
		
			out.print("please login");
					
		}

}
}
