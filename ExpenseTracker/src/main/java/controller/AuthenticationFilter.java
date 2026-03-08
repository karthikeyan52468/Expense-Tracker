package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

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
		Logger log = Logger.getLogger(AuthenticationFilter.class.getName());
		FileHandler handler = new FileHandler("E:\\Expense Tracker\\ExpenseTracker\\src\\resources\\logger.log",true);
		handler.setFormatter(new SimpleFormatter());
		log.addHandler(handler);
		
		HttpServletRequest req= (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		PrintWriter out = response.getWriter();
		if(session!=null && session.getAttribute("role")!=null)
		{
			if(session.getAttribute("role").equals("admin"))
			{
				log.info("admin login successfully");
				chain.doFilter(request, response);
			}
			
			
			else {
				if(req.getServletPath().equals("/auth/viewExpense")||req.getServletPath().equals("/auth/viewMonthly"))
				{
					log.info("user login to successfully");
					chain.doFilter(request, response);
				}
				else {
					out.print("401");
					log.warning("user 401 ");
				}
			}
		}
		else {
		
			out.print("please login");
			log.warning("please login");
					
		}

}
}
